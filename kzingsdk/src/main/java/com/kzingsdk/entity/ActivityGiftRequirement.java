package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class ActivityGiftRequirement implements Parcelable {


    public static final Creator CREATOR = new Creator() {
        public ActivityGiftRequirement createFromParcel(Parcel in) {
            return new ActivityGiftRequirement(in);
        }

        public ActivityGiftRequirement[] newArray(int size) {
            return new ActivityGiftRequirement[size];
        }
    };


    private String requirementAmount;
    private String giftId;
    private String giftPicUrl;
    private String giftName;
    private int displayOrder;

    //    gift_requirement
    public ActivityGiftRequirement() {

    }

    public ActivityGiftRequirement(Parcel in) {
        requirementAmount = in.readString();
        giftId = in.readString();
        giftPicUrl = in.readString();
        giftName = in.readString();
        displayOrder = in.readInt();
    }

    public static ActivityGiftRequirement newInstance(JSONObject rootObject) {
        ActivityGiftRequirement item = new ActivityGiftRequirement();
        item.setRequirementAmount(rootObject.optString("requirement_amount"));
        item.setGiftId(rootObject.optString("gift_id"));
        item.setGiftPicUrl(rootObject.optString("gift_pic_url"));
        item.setGiftName(rootObject.optString("gift_name"));
        item.setDisplayOrder(rootObject.optInt("display_order"));
        return item;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(requirementAmount);
        dest.writeString(giftId);
        dest.writeString(giftPicUrl);
        dest.writeString(giftName);
        dest.writeInt(displayOrder);
    }

    public String getRequirementAmount() {
        return requirementAmount;
    }

    public void setRequirementAmount(String requirementAmount) {
        this.requirementAmount = requirementAmount;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getGiftPicUrl() {
        return giftPicUrl;
    }

    public void setGiftPicUrl(String giftPicUrl) {
        this.giftPicUrl = giftPicUrl;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Override
    public int describeContents() {
        return 0;
    }


}