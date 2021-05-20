package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class CsLink {

    private String title;
    private String dropdownList;
    private String status;

    public CsLink() {

    }

    public static CsLink newInstance(JSONObject rootObject) {
        CsLink csLink = new CsLink();
        csLink.setTitle(rootObject.optString("title"));
        csLink.setDropdownList(rootObject.optString("dropdownlist"));
        csLink.setStatus(rootObject.optString("status"));
        return csLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDropdownList() {
        return dropdownList;
    }

    public void setDropdownList(String dropdownList) {
        this.dropdownList = dropdownList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

