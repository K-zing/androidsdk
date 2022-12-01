package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class ActivityGift implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public ActivityGift createFromParcel(Parcel in) {
            return new ActivityGift(in);
        }

        public ActivityGift[] newArray(int size) {
            return new ActivityGift[size];
        }
    };
    public static String FIRST_DEPOSIT = "FIRST_DEPOSIT";
    public static String MONTHLY_BET = "MONTHLY_BET";
    private String isRequiredVerifyMobile;
    private String calcTotalDepositHour;
    private String calcMethod;
    private String depositValidHours;
    private String maxJoin;
    private boolean isCalcTotalDeposit;
    private ArrayList<ActivityGiftRequirement> giftRequirementList = new ArrayList<>();

    public ActivityGift() {
    }

    public ActivityGift(Parcel in) {
        isRequiredVerifyMobile = in.readString();
        calcTotalDepositHour = in.readString();
        calcMethod = in.readString();
        depositValidHours = in.readString();
        maxJoin = in.readString();
        isCalcTotalDeposit = in.readInt() == 1;
        Object[] objectArray = in.readArray(ActivityGift.class.getClassLoader());
        giftRequirementList = (ArrayList<ActivityGiftRequirement>) objectArray[0];
    }

    public static ActivityGift newInstance(JSONObject rootObject) {
        ActivityGift item = new ActivityGift();
        item.setIsRequiredVerifyMobile(rootObject.optString("is_required_verify_mobile"));
        item.setCalcTotalDepositHour(rootObject.optString("calc_total_deposit_hour"));
        item.setCalcMethod(rootObject.optString("calc_method"));
        item.setDepositValidHours(rootObject.optString("deposit_valid_hours"));
        item.setMaxJoin(rootObject.optString("max_join"));
        item.setCalcTotalDeposit(rootObject.optString("is_calc_total_deposit").equalsIgnoreCase("true"));
        JSONArray giftRequirementArray = rootObject.optJSONArray("gift_requirement");
        if (giftRequirementArray != null && giftRequirementArray.length() > 0) {
            ArrayList<ActivityGiftRequirement> giftRequirementList = new ArrayList<>();
            for (int i = 0; i < giftRequirementArray.length(); i++) {
                giftRequirementList.add(ActivityGiftRequirement.newInstance(giftRequirementArray.optJSONObject(i)));
            }
            item.setGiftRequirementList(giftRequirementList);
        }
        return item;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(isRequiredVerifyMobile);
        dest.writeString(calcTotalDepositHour);
        dest.writeString(calcMethod);
        dest.writeString(depositValidHours);
        dest.writeString(maxJoin);
        dest.writeInt(isCalcTotalDeposit ? 1 : 0);
        dest.writeArray(new Object[]{
                giftRequirementList,
        });
    }

    public String getIsRequiredVerifyMobile() {
        return isRequiredVerifyMobile;
    }

    public void setIsRequiredVerifyMobile(String isRequiredVerifyMobile) {
        this.isRequiredVerifyMobile = isRequiredVerifyMobile;
    }

    public String getCalcTotalDepositHour() {
        return calcTotalDepositHour;
    }

    public void setCalcTotalDepositHour(String calcTotalDepositHour) {
        this.calcTotalDepositHour = calcTotalDepositHour;
    }

    public String getCalcMethod() {
        return calcMethod;
    }

    public void setCalcMethod(String calcMethod) {
        this.calcMethod = calcMethod;
    }

    public String getDepositValidHours() {
        return depositValidHours;
    }

    public void setDepositValidHours(String depositValidHours) {
        this.depositValidHours = depositValidHours;
    }

    public String getMaxJoin() {
        return maxJoin;
    }

    public void setMaxJoin(String maxJoin) {
        this.maxJoin = maxJoin;
    }

    public boolean isCalcTotalDeposit() {
        return isCalcTotalDeposit;
    }

    public void setCalcTotalDeposit(boolean calcTotalDeposit) {
        isCalcTotalDeposit = calcTotalDeposit;
    }

    public ArrayList<ActivityGiftRequirement> getGiftRequirementList() {
        return giftRequirementList;
    }

    public void setGiftRequirementList(ArrayList<ActivityGiftRequirement> giftRequirementList) {
        this.giftRequirementList = giftRequirementList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

}