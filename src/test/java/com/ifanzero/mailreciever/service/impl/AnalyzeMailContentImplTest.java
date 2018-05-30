package com.ifanzero.mailreciever.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnalyzeMailContentImplTest {


    @Test
    public void analyze51Mail() throws Exception {
        ReadMailSeviceImpl2 readMailService = new ReadMailSeviceImpl2();
        String content = readMailService.readMailFromLocalEml("./");
        AnalyzeMailContentImpl analyzeMailContent = new AnalyzeMailContentImpl();
//        Employee employee=analyzeMailContent.analyze51Mail(content);
    }

}