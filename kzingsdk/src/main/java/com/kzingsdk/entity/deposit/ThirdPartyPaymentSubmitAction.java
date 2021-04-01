package com.kzingsdk.entity.deposit;

import org.json.JSONObject;

public class ThirdPartyPaymentSubmitAction {

    public enum ActionType {
        QRCODE(1),
        URL_DIRECT(2),
        HTML_FORM(3),
        URL_DIRECT_SELF(4),
        CRYPTO(6),
        ;

        private final int id;

        ActionType(int id) {
            this.id = id;
        }

        public ActionType origin() {
            return ActionType.valueOfTypeId(id);
        }

        public static ActionType valueOfTypeId(int typeId) {
            for (ActionType type : ActionType.values()) {
                if (type.id == typeId) {
                    return type;
                }
            }
            return null;
        }

    }

    private String toSubmitData;
    private SubmitDataCrypto submitDataCrypto;
    private ActionType actionType = null;
    private JSONObject resultJSON = new JSONObject();


    public ThirdPartyPaymentSubmitAction() {
    }


    public static ThirdPartyPaymentSubmitAction newInstance(JSONObject rootObject) {
        ThirdPartyPaymentSubmitAction item = new ThirdPartyPaymentSubmitAction();
        int typeId = rootObject.optInt("type", 2);
        item.setResultJSON(rootObject.optJSONObject("result"));
        item.setActionType(ActionType.valueOfTypeId(typeId));
        switch (item.getActionType()) {
            case QRCODE:
                item.setToSubmitData(rootObject.optString("qrcode"));
                break;
            case URL_DIRECT:
            case URL_DIRECT_SELF:
                item.setToSubmitData(rootObject.optString("url"));
                break;
            case HTML_FORM:
                item.setToSubmitData(rootObject.optString("html"));
                break;
            case CRYPTO:
                item.setSubmitDataCrypto(SubmitDataCrypto.newInstance(rootObject.optJSONObject("crypto")));
                break;

        }
        return item;
    }

    public String getToSubmitData() {
        return toSubmitData;
    }

    public void setToSubmitData(String toSubmitData) {
        this.toSubmitData = toSubmitData;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public SubmitDataCrypto getSubmitDataCrypto() {
        return submitDataCrypto;
    }

    public void setSubmitDataCrypto(SubmitDataCrypto submitDataCrypto) {
        this.submitDataCrypto = submitDataCrypto;
    }

    public JSONObject getResultJSON() {
        return resultJSON;
    }

    public void setResultJSON(JSONObject resultJSON) {
        this.resultJSON = resultJSON;
    }

    @Override
    public String toString() {
        return "ThirdPartyPaymentSubmitAction{" +
                "toSubmitData='" + toSubmitData + '\'' +
                ", actionType=" + actionType +
                '}';
    }
}

