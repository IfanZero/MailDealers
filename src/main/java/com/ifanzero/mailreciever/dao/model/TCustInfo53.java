package com.ifanzero.mailreciever.dao.model;

import javax.persistence.*;

@Table(name = "t_cust_info_53")
public class TCustInfo53 {
    @Id
    @Column(name = "guest_id")
    private String guestId;

    @Column(name = "guest_name")
    private String guestName;

    private String phone;

    private String email;

    private String notes;

    private String province;

    private String city;

    /**
     * channal
     */
    private String referer;

    /**
     * @return guest_id
     */
    public String getGuestId() {
        return guestId;
    }

    /**
     * @param guestId
     */
    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    /**
     * @return guest_name
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * @param guestName
     */
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取channal
     *
     * @return referer - channal
     */
    public String getReferer() {
        return referer;
    }

    /**
     * 设置channal
     *
     * @param referer channal
     */
    public void setReferer(String referer) {
        this.referer = referer;
    }
}