package com.kzingsdk.entity;

import org.json.JSONObject;

public class GetCaptchaResult extends SimpleApiResult {

    private String captchaMode;
    private String puzzleCaptcha;
    private String image;
    private String sessionId;

    public static GetCaptchaResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetCaptchaResult result = new GetCaptchaResult();
        result.status = simpleApiResult.status;
        result.message = simpleApiResult.message;
        result.setCaptchaMode(rootObject.optString("captchaMode"));
        result.setPuzzleCaptcha(rootObject.optString("puzzleCaptcha"));
        JSONObject dataObject = rootObject.optJSONObject("imageCaptcha");
        if (dataObject != null) {
            result.setImage(dataObject.optString("image"));
            result.setSessionId(dataObject.optString("sessionId"));
        }
        return result;
    }

    public String getCaptchaMode() {
        return captchaMode;
    }

    public void setCaptchaMode(String captchaMode) {
        this.captchaMode = captchaMode;
    }

    public String getPuzzleCaptcha() {
        return puzzleCaptcha;
    }

    public void setPuzzleCaptcha(String puzzleCaptcha) {
        this.puzzleCaptcha = puzzleCaptcha;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
