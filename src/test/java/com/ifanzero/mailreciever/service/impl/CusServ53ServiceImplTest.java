package com.ifanzero.mailreciever.service.impl;

import com.ifanzero.mailreciever.service.CusServ53Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CusServ53ServiceImplTest {
    @Resource
    CusServ53Service cusServ53Service;
    @Test
    public void saveChannal() throws Exception {
    }

}