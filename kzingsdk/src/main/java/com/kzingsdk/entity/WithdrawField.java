package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class WithdrawField implements Parcelable {

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
    private ArrayList<WithdrawFieldOption> withdrawFieldOptionList = new ArrayList<>();

    private WithdrawField() {
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
        Object[] objectArray = in.readArray(WithdrawField.class.getClassLoader());
        withdrawFieldOptionList = (ArrayList<WithdrawFieldOption>) objectArray[0];
    }

    public static Creator getCREATOR() {
        return CREATOR;
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
        JSONArray optionsJSONArray = rootObject.optJSONArray("options");
        if (optionsJSONArray != null) {
            for (int i = 0; i < optionsJSONArray.length(); i++) {
                withdrawField.withdrawFieldOptionList.add(WithdrawFieldOption.newInstance(optionsJSONArray.optJSONObject(i)));
            }
        }
        return withdrawField;
    }

    @Override
    public int describeContents() {
        return 0;
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

    public ArrayList<WithdrawFieldOption> getWithdrawFieldOptionList() {
        return withdrawFieldOptionList;
    }

    public void setWithdrawFieldOptionList(ArrayList<WithdrawFieldOption> withdrawFieldOptionList) {
        this.withdrawFieldOptionList = withdrawFieldOptionList;
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

        dest.writeArray(new Object[]{
                withdrawFieldOptionList
        });

    }
}
