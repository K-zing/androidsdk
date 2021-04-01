package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class WithdrawField implements Parcelable {

    public static Creator getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator CREATOR = new Creator() {
        public WithdrawField createFromParcel(Parcel in) {
            return new WithdrawField(in);
        }

        public WithdrawField[] newArray(int size) {
            return new WithdrawField[size];
        }
    };
    private String field;
    private String label;
    private String type;
    private String error;
    private String input = "";
    private String placeholder;
    private boolean digits;
    private Integer minLength;
    private Integer maxLength;
    private String prefix;

    private WithdrawField() {
    }

    public static WithdrawField newInstance(JSONObject rootObject) {
        WithdrawField withdrawField = new WithdrawField();
        withdrawField.setField(rootObject.optString("field"));
        withdrawField.setLabel(rootObject.optString("label"));
        withdrawField.setType(rootObject.optString("type"));
        withdrawField.setError(rootObject.optString("error"));
        withdrawField.setPlaceholder(rootObject.optString("placeholder"));
        withdrawField.setDigits(rootObject.optBoolean("digits", false));
        withdrawField.setMinLength(rootObject.optInt("minlength", 0));
        withdrawField.setMaxLength(rootObject.optInt("maxlength", 0));
        withdrawField.setPrefix(rootObject.optString("prefix"));
        return withdrawField;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public boolean isDigits() {
        return digits;
    }

    public void setDigits(boolean digits) {
        this.digits = digits;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public WithdrawField(Parcel in) {

        field = in.readString();
        label = in.readString();
        type = in.readString();
        error = in.readString();
        input = in.readString();
        placeholder = in.readString();
        digits = in.readInt() == 1;
        minLength = in.readInt();
        maxLength = in.readInt();
        prefix = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(field);
        dest.writeString(label);
        dest.writeString(type);
        dest.writeString(error);
        dest.writeString(input);
        dest.writeString(placeholder);
        dest.writeInt(digits ? 1 : 0);
        dest.writeInt(minLength);
        dest.writeInt(maxLength);
        dest.writeString(prefix);


    }
}
