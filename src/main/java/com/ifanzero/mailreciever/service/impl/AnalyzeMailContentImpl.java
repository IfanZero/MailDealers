package com.ifanzero.mailreciever.service.impl;

import cn.hutool.core.util.StrUtil;
import com.ifanzero.mailreciever.dao.domain.EmployeeForTrans;
import com.ifanzero.mailreciever.service.AnalyzeContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnalyzeMailContentImpl implements AnalyzeContent {
    @Override
    public EmployeeForTrans analyze51Mail(String content) {
        EmployeeForTrans employee = new EmployeeForTrans();

        String subContent;
        String lastMailSep = "主题: (51job.com";
        if (content.contains(lastMailSep)){
            subContent= StrUtil.removeAll(StrUtil.subAfter(content,"主题: (51job.com",true),">");
        }else {
            subContent = content;
        }


        String[] strs = StrUtil.split(subContent,"\r\n");
        for (String col:strs){
            if (col.contains("|")&&(col.contains("男")||col.contains("女"))){
                String [] details = col.split("\\|");
                employee.setF_name(details[0].trim());
            }
            if (col.contains("手机")) {
                employee.setF_mobile(col.split("：")[1].trim());
            }
            if (col.contains("邮箱")){
                employee.setF_email(col.split("：")[1].trim().split(" ")[0]);
            }

            if (col.contains("家庭地址")){
//                Employee.setAddr(col.split("：")[1].split(" ")[0]);
            }
            if (col.contains("求职状态")){
//                Employee.setEmployStatus(col.split("：")[1].trim());
            }
            if (col.contains("求职意向")){
//                EmployeeForTrans.setEmployAim(col.split("：")[1].trim());
            }
        }
        return employee;
    }

    @Override
    public EmployeeForTrans analyzeZhaoPinMail(String content) {
        EmployeeForTrans employeeForTrans = new EmployeeForTrans();
        String subContent = StrUtil.subAfter(content,"主题: (Zhaopin.com)",true);

        String[] strs = StrUtil.split(subContent,"\r\n");
        if (StrUtil.isBlank(strs[1])){
            employeeForTrans.setF_name(strs[2]);
        }
        for (String str :strs){

        }
        return null;
    }

    @Override
    public EmployeeForTrans LoadCusServ53Info(String content) {
        return null;
    }

    @Override
    public EmployeeForTrans analyze58Mail(String content) {
        EmployeeForTrans employeeForTrans = new EmployeeForTrans();
        String subContent = StrUtil.subAfter(content,"主题: (58.com)",true);
        String[] strs = StrUtil.split(subContent,"\r\n");
        if (StrUtil.isBlank(strs[1])&&StrUtil.startWith(strs[2],"应聘职位")){
            employeeForTrans.setF_name(StrUtil.subBefore(strs[3],"（",false));
        }
        for (String str :strs){

        }
        return null;
    }

    public static void main(String[] args) {
        ReadMailSeviceImpl2 readMailService = new ReadMailSeviceImpl2();
        String content = readMailService.readMailFromLocalEml("E:\\Ifan\\mail\\hpop3MailReceiver2730.eml");
        AnalyzeMailContentImpl analyzeMailContent = new AnalyzeMailContentImpl();
        EmployeeForTrans employee =analyzeMailContent.analyze51Mail(content);
/*String content = readMailService.readMailFromLocalEml("E:\\Ifan\\mail\\zhaoping.eml");
        AnalyzeMailContentImpl analyzeMailContent = new AnalyzeMailContentImpl();
        EmployeeForTrans Employee=analyzeMailContent.analyzeZhaoPinMail(content);*/
       /* String content = readMailService.readMailFromLocalEml("E:\\Ifan\\mail\\58.eml");
        AnalyzeMailContentImpl analyzeMailContent = new AnalyzeMailContentImpl();
        EmployeeForTrans Employee=analyzeMailContent.analyze58Mail(content);*/        System.out.println(employee
        );
    }
}
