package com.ifanzero.mailreciever.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ifanzero.mailreciever.dao.domain.EmployeeForTrans;
import com.ifanzero.mailreciever.service.AnalyzeContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Slf4j
@Service
public class AnalyzeMailContentImpl implements AnalyzeContent {
    @Override
    public EmployeeForTrans analyze51Mail(String content) {
        EmployeeForTrans employee = new EmployeeForTrans();

        String subContent;
        String lastMailSep = "主题: (51job.com";
        if (content.contains(lastMailSep)) {
            subContent = StrUtil.removeAll(StrUtil.subAfter(content, "主题: (51job.com", true), ">");
        } else {
            subContent = content;
        }

        /**
         * 姓名 生日  手机号  邮箱
         */
        String[] strs = StrUtil.split(subContent, "\r\n");
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (String col : strs) {
            if (col.contains("|") && (col.contains("男") || col.contains("女"))) {
                String[] details = col.split("\\|");
                employee.setF_name(details[0].trim());
                employee.setF_birthday(StrUtil.subBetween(details[2], "(", ")"));
            }
            if (col.contains("手机")) {
                employee.setF_mobile(col.split("：")[1].trim());
            }
            if (col.contains("邮箱")) {
                employee.setF_email(col.split("：")[1].trim().split(" ")[0]);
            }
            if (col.contains("求职状态")) {
                sb.append(col).append(";");
            }
            if (flag){
                if (StrUtil.isBlank(col)){
                    flag = false;
                    continue;
                }
                sb.append(col).append(" ");
            }
            if (col.contains("求职意向")) {
                sb.append(col).append(":");
                flag=true;
            }
        }
        employee.setF_memo(sb.toString());
        return employee;
    }

    @Override
    public EmployeeForTrans analyzeZhaoPinMail(String content,String html) {
        EmployeeForTrans employeeForTrans = new EmployeeForTrans();
        String subContent = StrUtil.subAfter(content, "主题: (Zhaopin.com)", true);
        String telsUrl = StrUtil.subBetween(StrUtil.subAfter(StrUtil.subBefore(html,"我要联系TA",true),"<a",true),"href=\"","\">");
        String params = StrUtil.subAfter(telsUrl,"param=",true);
        String telsJson=HttpUtil.get("https://ihr.zhaopin.com/resumemanage/emailim.do?s="+params);
        JSONObject object = JSONUtil.parseObj(telsJson);
        JSONObject dataObj= (JSONObject) object.get("data");
        employeeForTrans.setF_mobile(dataObj.getStr("phone"));
        employeeForTrans.setF_email(dataObj.getStr("email"));
        employeeForTrans.setF_name(dataObj.getStr("username"));
        String aim = StrUtil.subBetween(subContent,"求职意向","工作经历");
        employeeForTrans.setF_memo(aim.replaceAll("\r\n\r\n","").replaceAll("\r\n","; "));
        return employeeForTrans;
    }

    @Override
    public EmployeeForTrans LoadCusServ53Info(String content) {
        return null;
    }

    @Override
    public EmployeeForTrans analyze58Mail(String content) {
        EmployeeForTrans employeeForTrans = new EmployeeForTrans();
        String subContent = StrUtil.subAfter(content, "主题: (58.com)", true);
        String[] strs = StrUtil.split(subContent, "\r\n");
        if (StrUtil.isBlank(strs[1]) && StrUtil.startWith(strs[2], "应聘职位")) {
            employeeForTrans.setF_name(StrUtil.subBefore(strs[3], "（", false));
        }
        String mobile  = StrUtil.subBetween(subContent,"手机号码：","电子邮箱");
        employeeForTrans.setF_mobile(mobile.trim());
        String email = StrUtil.subBetween(subContent,"电子邮箱：","求职意向");
        employeeForTrans.setF_email(email);
        String aim = StrUtil.subBetween(subContent,"求职意向","工作经验");
        employeeForTrans.setF_memo(aim.replaceAll("\r\n\r\n","").replaceAll("\r\n","; "));
        return employeeForTrans;
    }

    public static void main(String[] args) {
        ReadMailSeviceImpl2 readMailService = new ReadMailSeviceImpl2();
       /* String content = readMailService.readMailFromLocalEml("E:\\Ifan\\mail\\hpop3MailReceiver2730.eml");
        AnalyzeMailContentImpl analyzeMailContent = new AnalyzeMailContentImpl();
        EmployeeForTrans employee = analyzeMailContent.analyze51Mail(content);*/
       /* Map<String,StringBuilder> content = readMailService.readMailFromLocalEml("E:\\Ifan\\mail\\zhaoping.eml");
        AnalyzeMailContentImpl analyzeMailContent = new AnalyzeMailContentImpl();
        EmployeeForTrans employee=analyzeMailContent.analyzeZhaoPinMail(content.get("content").toString(),content.get("html").toString());*/
//        Map<String,StringBuilder> maps = readMailService.readMailFromLocalEml("E:\\Ifan\\mail\\58.eml");
//        String content = maps.get("content").toString();
//        AnalyzeMailContentImpl analyzeMailContent = new AnalyzeMailContentImpl();
//        EmployeeForTrans employee=analyzeMailContent.analyze58Mail(content);
//        System.out.println(employee
//        );
    }
}
