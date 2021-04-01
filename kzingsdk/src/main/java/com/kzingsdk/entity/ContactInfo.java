package com.kzingsdk.entity;

import org.json.JSONObject;

public class ContactInfo {

    private String qq = "";
    private String whatsapp = "";
    private String youtube = "";
    private String line = "";
    private String facebook = "";
    private String wechat = "";
    private String telegram = "";
    private String instagram = "";
    private String skype = "";
    private String twitter = "";
    private String zalo = "";
    private String csUrl = "";
    private String email = "";
    private String phone = "";


    public static ContactInfo newInstance(JSONObject rootObject) {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.qq = rootObject.optString("qq", "");
        contactInfo.whatsapp = rootObject.optString("whatsapp", "");
        contactInfo.youtube = rootObject.optString("youtube", "");
        contactInfo.line = rootObject.optString("line", "");
        contactInfo.facebook = rootObject.optString("facebook", "");
        contactInfo.wechat = rootObject.optString("wechat", "");
        contactInfo.telegram = rootObject.optString("telegram", "");
        contactInfo.instagram = rootObject.optString("instagram", "");
        contactInfo.skype = rootObject.optString("skype", "");
        contactInfo.twitter = rootObject.optString("twitter", "");
        contactInfo.zalo = rootObject.optString("zalo", "");
        contactInfo.csUrl = rootObject.optString("csUrl", "");
        contactInfo.email = rootObject.optString("email", "");
        contactInfo.phone = rootObject.optString("phone", "");
        return contactInfo;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getZalo() {
        return zalo;
    }

    public void setZalo(String zalo) {
        this.zalo = zalo;
    }

    public String getCsUrl() {
        return csUrl;
    }

    public void setCsUrl(String csUrl) {
        this.csUrl = csUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
