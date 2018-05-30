package com.ifanzero.mailreciever.dao.domain;

import cn.hutool.core.util.ReflectUtil;
import org.springframework.util.StringUtils;

public class EmployeeForTrans {
    private String employId;

    private String f_name;
    private String f_birthday;
    private String f_mobile;
    private String f_phone;
    private String f_fax;
    /**
     * 职位字段的长度在10个字以内
     */
    private String f_title;
    /**
     * QQ字段的长度在5~11位以内，首位不能为0。
     */
    private String f_qq;
    /**
     * 邮箱字段长度80个汉字以内，可输入数字、英文，“-”和“_”，必须包含“@”和“.”。(会效验是否有重复)
     */
    private String f_email;
    /**
     * 客户公司字段的长度在80个字以内
     */
    private String f_company;
    /**
     * 公司地址字段的长度在80个字以内
     */
    private String f_company_addr;
    /**
     * 公司网址,建议按照此格式输入：https://www.workec.com/html/support.html
     */
    private String f_company_url;
    /**
     * 称呼字段的长度在15个字以内
     */
    private String f_call;
    /**
     * 备注字段的长度在500个字以内
     */
    private String f_memo;
    /**
     * 客户性别0无/1/男/2女
     */
    private String f_gender;
    /**
     * 公司所在国家，内容必须是该字段的有效选项名称，
     * 该字段在导入时，区分“国家”、“省份”、“城市”和“区县”四个子字段。
     * “国家”字段例子：“中国”，
     * “省份”字段例子：“广东省”或“广东”，
     * “城市”字段例子：“深圳市”或“深圳”，
     * “区县”字段例子：“南山区”或“南山”
     * 子级的内容必须隶属于父级，
     * 比如，城市是深圳，区县是南山，则可以顺利导入，但如果城市是“深圳”，区县是“惠城区”，由于“惠城区”不属于“深圳市”，会导致导入失败
     */
    private String f_company_country;
    /**
     * 公司所在省份，内容必须是该字段的有效选项名称，
     * 该字段在导入时，区分“国家”、“省份”、“城市”和“区县”四个子字段。
     * “国家”字段例子：“中国”，“省份”字段例子：“广东省”或“广东”，“城市”
     * 字段例子：“深圳市”或“深圳”，
     * “区县”字段例子：“南山区”或“南山”子级的内容必须隶属于父级，
     * 比如，城市是深圳，区县是南山，则可以顺利导入，
     * 但如果城市是“深圳”，区县是“惠城区”，由于“惠城区”不属于“深圳市”，会导致导入失败
     */
    private String f_company_province;
    private String f_company_city;
    private String f_company_region;
    private String f_vocation_group;
    private String f_vocation;
    private String f_channel;

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_birthday() {
        return f_birthday;
    }

    public void setF_birthday(String f_birthday) {
        this.f_birthday = f_birthday;
    }

    public String getF_mobile() {
        return f_mobile;
    }

    public void setF_mobile(String f_mobile) {
        this.f_mobile = f_mobile;
    }

    public String getF_phone() {
        return f_phone;
    }

    public void setF_phone(String f_phone) {
        this.f_phone = f_phone;
    }

    public String getF_fax() {
        return f_fax;
    }

    public void setF_fax(String f_fax) {
        this.f_fax = f_fax;
    }

    public String getF_title() {
        return f_title;
    }

    public void setF_title(String f_title) {
        this.f_title = f_title;
    }

    public String getF_qq() {
        return f_qq;
    }

    public void setF_qq(String f_qq) {
        this.f_qq = f_qq;
    }

    public String getF_email() {
        return f_email;
    }

    public void setF_email(String f_email) {
        this.f_email = f_email;
    }

    public String getF_company() {
        return f_company;
    }

    public void setF_company(String f_company) {
        this.f_company = f_company;
    }

    public String getF_company_addr() {
        return f_company_addr;
    }

    public void setF_company_addr(String f_company_addr) {
        this.f_company_addr = f_company_addr;
    }

    public String getF_company_url() {
        return f_company_url;
    }

    public void setF_company_url(String f_company_url) {
        this.f_company_url = f_company_url;
    }

    public String getF_call() {
        return f_call;
    }

    public void setF_call(String f_call) {
        this.f_call = f_call;
    }

    public String getF_memo() {
        return f_memo;
    }

    public void setF_memo(String f_memo) {
        this.f_memo = f_memo;
    }

    public String getF_gender() {
        return f_gender;
    }

    public void setF_gender(String f_gender) {
        this.f_gender = f_gender;
    }

    public String getF_company_country() {
        return f_company_country;
    }

    public void setF_company_country(String f_company_country) {
        this.f_company_country = f_company_country;
    }

    public String getF_company_province() {
        return f_company_province;
    }

    public void setF_company_province(String f_company_province) {
        this.f_company_province = f_company_province;
    }

    public String getF_company_city() {
        return f_company_city;
    }

    public void setF_company_city(String f_company_city) {
        this.f_company_city = f_company_city;
    }

    public String getF_company_region() {
        return f_company_region;
    }

    public void setF_company_region(String f_company_region) {
        this.f_company_region = f_company_region;
    }

    public String getF_vocation_group() {
        return f_vocation_group;
    }

    public void setF_vocation_group(String f_vocation_group) {
        this.f_vocation_group = f_vocation_group;
    }

    public String getF_vocation() {
        return f_vocation;
    }

    public void setF_vocation(String f_vocation) {
        this.f_vocation = f_vocation;
    }

    public String getF_channel() {
        return f_channel;
    }

    public void setF_channel(String f_channel) {
        this.f_channel = f_channel;
    }
    public String[] getJsonArray(String[] fields){
        String[] strs = new String[fields.length];
        Class cls = this.getClass();
        for (int i=0;i<fields.length;i++){
            strs[i]=ReflectUtil.invoke(cls,"get"+ StringUtils.capitalize(fields[i]));
        }
        return strs;
    }

    @Override
    public String toString() {
        return "EmployeeForTrans{" +
                "f_name='" + f_name + '\'' +
                ", f_birthday='" + f_birthday + '\'' +
                ", f_mobile='" + f_mobile + '\'' +
                ", f_phone='" + f_phone + '\'' +
                ", f_fax='" + f_fax + '\'' +
                ", f_title='" + f_title + '\'' +
                ", f_qq='" + f_qq + '\'' +
                ", f_email='" + f_email + '\'' +
                ", f_company='" + f_company + '\'' +
                ", f_company_addr='" + f_company_addr + '\'' +
                ", f_company_url='" + f_company_url + '\'' +
                ", f_call='" + f_call + '\'' +
                ", f_memo='" + f_memo + '\'' +
                ", f_gender='" + f_gender + '\'' +
                ", f_company_country='" + f_company_country + '\'' +
                ", f_company_province='" + f_company_province + '\'' +
                ", f_company_city='" + f_company_city + '\'' +
                ", f_company_region='" + f_company_region + '\'' +
                ", f_vocation_group='" + f_vocation_group + '\'' +
                ", f_vocation='" + f_vocation + '\'' +
                ", f_channel='" + f_channel + '\'' +
                '}';
    }
}
