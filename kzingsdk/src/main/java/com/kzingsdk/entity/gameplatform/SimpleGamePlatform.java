package com.kzingsdk.entity.gameplatform;

import org.json.JSONObject;

public class SimpleGamePlatform {

    protected String gpid = "";
    protected String gpname = "";

    public SimpleGamePlatform() {

    }

    public static SimpleGamePlatform newInstance(JSONObject rootObject) {
        SimpleGamePlatform simpleGamePlatform = new SimpleGamePlatform();
        simpleGamePlatform.setGpid(rootObject.optString("gpid"));
        simpleGamePlatform.setGpname(rootObject.optString("name"));
        return simpleGamePlatform;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getGpname() {
        return gpname;
    }

    public void setGpname(String gpname) {
        this.gpname = gpname;
    }
}
