package com.ifanzero.mailreciever.dao.dto;

import com.ifanzero.mailreciever.dao.domain.EmployeeForTrans;

import java.util.ArrayList;
import java.util.List;

public class BatchAddCus {
    private String optUserId;
    /**
     * 可选
     */
    private String followUserId;

    private String[] fieldNameMapping;

    private List<EmployeeForTrans> fieldValueList;

    public String getOptUserId() {
        return optUserId;
    }

    public void setOptUserId(String optUserId) {
        this.optUserId = optUserId;
    }

    public String getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(String followUserId) {
        this.followUserId = followUserId;
    }

    public String[] getFieldNameMapping() {
        return fieldNameMapping;
    }

    public void setFieldNameMapping(String[] fieldNameMapping) {
        this.fieldNameMapping = fieldNameMapping;
    }

    public List<String[]> getFieldValueList() {
        List<String[]> strings = new ArrayList<>();
        for (EmployeeForTrans e:fieldValueList){
            strings.add(e.getJsonArray(fieldNameMapping));
        }
        return strings;
    }

    public void setFieldValueList(List<EmployeeForTrans> fieldValueList) {
        this.fieldValueList = fieldValueList;
    }
}
