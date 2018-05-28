package com.ifanzero.mailreciever.service.impl;

import com.ifanzero.mailreciever.dao.dto.Employee;
import com.ifanzero.mailreciever.service.AnalyzeMailContent;

public class AnalyzeMailContentImpl implements AnalyzeMailContent {
    @Override
    public Employee analyze51Mail(String content) {
        Employee employee = new Employee();
        String [] cols = content.replaceAll("\r|\n","").split(">");
        for (String col:cols){
            if (col.contains("|")&&(col.contains("男")||col.contains("女"))){
                String [] details = col.split("\\|");
                employee.setName(details[0].trim());
            }
            if (col.contains("手机")) {
                employee.setTelephone(col.split("：")[1].trim());
            }
            if (col.contains("邮箱")){
                employee.setMail(col.split("：")[1].trim().split(" ")[0]);
            }

            if (col.contains("家庭地址")){
                employee.setAddr(col.split("：")[1].split(" ")[0]);
            }
            if (col.contains("求职状态")){
                employee.setEmployStatus(col.split("：")[1].trim());
            }
            if (col.contains("求职意向")){
//                employee.setEmployAim(col.split("：")[1].trim());
            }
        }
        return employee;
    }

    public static void main(String[] args) {
        ReadMailSeviceImpl2 readMailService = new ReadMailSeviceImpl2();
        String content = readMailService.readMailFromLocalEml("/Users/apple/mail/attachment/hpop3MailReceiver2940.eml");
        AnalyzeMailContentImpl analyzeMailContent = new AnalyzeMailContentImpl();
        Employee employee=analyzeMailContent.analyze51Mail(content);
        System.out.println(employee
        );
    }
}
