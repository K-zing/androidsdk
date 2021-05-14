package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class WanBo {

    private String createDate;
    private String imgUrl;
    private String mainTitle;
    private String redirectPath;
    private String settingName;
    private String subTitle;
    private Integer order;
    private Integer sn;

    public WanBo() {

    }

    public static WanBo newInstance(JSONObject rootObject) {
        WanBo activityBonus = new WanBo();
        activityBonus.setCreateDate(rootObject.optString("create_date"));
        activityBonus.setImgUrl(rootObject.optString("img_url"));
        activityBonus.setMainTitle(rootObject.optString("main_title"));
        activityBonus.setRedirectPath(rootObject.optString("redirect_path"));
        activityBonus.setSettingName(rootObject.optString("setting_name"));
        activityBonus.setSubTitle(rootObject.optString("sub_title"));
        activityBonus.setOrder(rootObject.optInt("order"));
        activityBonus.setSn(rootObject.optInt("sn"));
        return activityBonus;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getRedirectPath() {
        return redirectPath;
    }

    public void setRedirectPath(String redirectPath) {
        this.redirectPath = redirectPath;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }
}


