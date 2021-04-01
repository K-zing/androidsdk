package com.kzingsdk.entity;

import org.json.JSONObject;

public class KycStatus {

    private Integer wealthStatus;
    private Integer kycStatus;
    private Boolean hasKyc;
    private String wealthStatusName;
    private String kycStatusName;

    public static KycStatus newInstance(JSONObject rootObject) {
        KycStatus kycStatus = new KycStatus();
        kycStatus.wealthStatus = rootObject.optInt("wealthstatus", 0);
        kycStatus.kycStatus = rootObject.optInt("kycstatus", 0);
        kycStatus.hasKyc = rootObject.optBoolean("has_kyc", false);
        kycStatus.wealthStatusName = rootObject.optString("wealthstatusname", "");
        kycStatus.kycStatusName = rootObject.optString("kycstatusname", "");
        return kycStatus;
    }

    public Integer getWealthStatus() {
        return wealthStatus;
    }

    public void setWealthStatus(Integer wealthStatus) {
        this.wealthStatus = wealthStatus;
    }

    public Integer getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(Integer kycStatus) {
        this.kycStatus = kycStatus;
    }

    public Boolean getHasKyc() {
        return hasKyc;
    }

    public void setHasKyc(Boolean hasKyc) {
        this.hasKyc = hasKyc;
    }

    public String getWealthStatusName() {
        return wealthStatusName;
    }

    public void setWealthStatusName(String wealthStatusName) {
        this.wealthStatusName = wealthStatusName;
    }

    public String getKycStatusName() {
        return kycStatusName;
    }

    public void setKycStatusName(String kycStatusName) {
        this.kycStatusName = kycStatusName;
    }
}
