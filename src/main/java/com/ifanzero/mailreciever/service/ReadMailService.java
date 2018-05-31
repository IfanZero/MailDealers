package com.ifanzero.mailreciever.service;

import java.util.Map;

public interface ReadMailService {
     void readMail();


     Map<String,StringBuilder> readMailFromLocalEml(String path);
}
