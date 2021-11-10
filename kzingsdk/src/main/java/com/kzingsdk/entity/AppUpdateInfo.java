package com.kzingsdk.entity;

import org.json.JSONObject;

public class AppUpdateInfo {

    private String version = "";
    private String downloadUrl = "";
    private boolean canUpdate = false;
    private boolean mustUpdate = false;
    private String title = "";
    private String content = "";

    public static AppUpdateInfo newInstance(JSONObject jsonResponse) {
        AppUpdateInfo appUpdateInfo = new AppUpdateInfo();
        if (jsonResponse == null)
            return appUpdateInfo;
        appUpdateInfo.setVersion(jsonResponse.optString("target_version_before"));
        appUpdateInfo.setDownloadUrl(jsonResponse.optString("url"));
        appUpdateInfo.setCanUpdate(jsonResponse.optBoolean("need_update", false));
        appUpdateInfo.setMustUpdate(jsonResponse.optBoolean("force_update", false));
        appUpdateInfo.setTitle(jsonResponse.optString("title"));
        appUpdateInfo.setContent(jsonResponse.optString("message"));
        return appUpdateInfo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public boolean isCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public boolean isMustUpdate() {
        return mustUpdate;
    }

    public void setMustUpdate(boolean mustUpdate) {
        this.mustUpdate = mustUpdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
