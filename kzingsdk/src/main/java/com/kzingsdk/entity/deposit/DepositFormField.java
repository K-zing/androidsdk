package com.kzingsdk.entity.deposit;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DepositFormField {

    private DepositFormFieldType depositFormFieldType;
    private int rowId;
    private int order;
    private String name;
    private String displayName;
    private String placeholder;
    private DepositFormFieldRule depositFormFieldRule;
    private DepositFormFieldMessage depositFormFieldMessage;
    private ArrayList<DepositFormFieldOption> optionList = new ArrayList<>();

    public static DepositFormField newInstance(JSONObject rootObject) {
        DepositFormField item = new DepositFormField();
        item.setRowId(rootObject.optInt("rowid"));
        item.setOrder(rootObject.optInt("order"));
        item.setDepositFormFieldType(DepositFormFieldType.valueOfName(rootObject.optString("type")));
        item.setName(rootObject.optString("name"));
        item.setDisplayName(rootObject.optString("displayName"));
        item.setPlaceholder(rootObject.optString("placeholder"));
        item.setPlaceholder(rootObject.optString("placeholder"));
        item.setDepositFormFieldRule(DepositFormFieldRule.newInstance(rootObject.optJSONObject("rules")));
        item.setDepositFormFieldMessage(DepositFormFieldMessage.newInstance(rootObject.optJSONObject("messages")));
        JSONArray optionArray = rootObject.optJSONArray("options");
        if (optionArray != null) {
            for (int i = 0; i < optionArray.length(); i++) {
                JSONObject optionObject = optionArray.optJSONObject(i);
                item.optionList.add(DepositFormFieldOption.newInstance(optionObject));
            }
        }
        return item;
    }

    public DepositFormFieldType getDepositFormFieldType() {
        return depositFormFieldType;
    }

    public void setDepositFormFieldType(DepositFormFieldType depositFormFieldType) {
        this.depositFormFieldType = depositFormFieldType;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public DepositFormFieldRule getDepositFormFieldRule() {
        return depositFormFieldRule;
    }

    public void setDepositFormFieldRule(DepositFormFieldRule depositFormFieldRule) {
        this.depositFormFieldRule = depositFormFieldRule;
    }

    public DepositFormFieldMessage getDepositFormFieldMessage() {
        return depositFormFieldMessage;
    }

    public void setDepositFormFieldMessage(DepositFormFieldMessage depositFormFieldMessage) {
        this.depositFormFieldMessage = depositFormFieldMessage;
    }

    public ArrayList<DepositFormFieldOption> getOptionList() {
        return optionList;
    }

    public void setOptionList(ArrayList<DepositFormFieldOption> optionList) {
        this.optionList = optionList;
    }

    public enum DepositFormFieldType {
        SELECT, RADIO, TEXT, PASSWORD;

        public static DepositFormFieldType valueOfName(String name) {
            for (DepositFormFieldType type : DepositFormFieldType.values()) {
                if (type.name().equalsIgnoreCase(name)) {
                    return type;
                }
            }
            return SELECT;
        }
    }

    public static class DepositFormFieldRule {

        private boolean required = false;
        private boolean number = false;
        private int min = 0;
        private int max = 0;

        public static DepositFormFieldRule newInstance(JSONObject rootObject) {
            DepositFormFieldRule item = new DepositFormFieldRule();
            item.setRequired(rootObject.optBoolean("required"));
            item.setNumber(rootObject.optBoolean("number"));
            item.setMin(rootObject.optInt("min"));
            item.setMax(rootObject.optInt("max"));
            return item;
        }

        public boolean isRequired() {
            return required;
        }

        public void setRequired(boolean required) {
            this.required = required;
        }

        public boolean isNumber() {
            return number;
        }

        public void setNumber(boolean number) {
            this.number = number;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }

    public static class DepositFormFieldMessage {

        private String required = "";
        private String number = "";
        private String min = "";
        private String max = "";

        public static DepositFormFieldMessage newInstance(JSONObject rootObject) {
            DepositFormFieldMessage item = new DepositFormFieldMessage();
            item.setRequired(rootObject.optString("required"));
            item.setNumber(rootObject.optString("number"));
            item.setMin(rootObject.optString("min"));
            item.setMax(rootObject.optString("max"));
            return item;
        }

        public String getRequired() {
            return required;
        }

        public void setRequired(String required) {
            this.required = required;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }

        public String getMax() {
            return max;
        }

        public void setMax(String max) {
            this.max = max;
        }
    }

    public static class DepositFormFieldOption {

        private String display = "";
        private String value = "";
        private ArrayList<String> extraParamList = new ArrayList<>();

        public static DepositFormFieldOption newInstance(JSONObject rootObject) {
            DepositFormFieldOption item = new DepositFormFieldOption();
            item.setDisplay(rootObject.optString("display"));
            item.setValue(rootObject.optString("value"));
            JSONArray extraArray = rootObject.optJSONArray("extraparam");
            item.extraParamList = new ArrayList<>();
            if (extraArray != null) {
                for (int i = 0; i < extraArray.length(); i++) {
                    item.extraParamList.add(extraArray.optString(i));
                }
            }
            return item;
        }

        public String getDisplay() {
            return display;
        }

        public void setDisplay(String display) {
            this.display = display;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public ArrayList<String> getExtraParamList() {
            return extraParamList;
        }

        public void setExtraParamList(ArrayList<String> extraParamList) {
            this.extraParamList = extraParamList;
        }
    }

}
