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
        JSONObject dataObject = rootObject.optJSONObject("data");
        if (dataObject != null) {
            result.setCaptchaMode(dataObject.optString("captchaMode"));
            result.setPuzzleCaptcha(dataObject.optString("puzzleCaptcha"));
            JSONObject imageCaptchaObject = rootObject.optJSONObject("imageCaptcha");
            if (imageCaptchaObject != null) {
                result.setImage(imageCaptchaObject.optString("image"));
                result.setSessionId(imageCaptchaObject.optString("sessionId"));
            }
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
