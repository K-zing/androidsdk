package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class PayOptionSortData implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public PayOptionSortData createFromParcel(Parcel in) {
            return new PayOptionSortData(in);
        }

        public PayOptionSortData[] newArray(int size) {
            return new PayOptionSortData[size];
        }
    };
    private String id;
    private String categoryId;
    private String opCode;
    private String opName;
    private String displayOrder;
    private String status;
    private String created;
    private String updated;
    private String currency;
    private String brandId;

    public PayOptionSortData() {

    }

    public PayOptionSortData(Parcel in) {
        id = in.readString();
        categoryId = in.readString();
        opCode = in.readString();
        opName = in.readString();
        displayOrder = in.readString();
        status = in.readString();
        created = in.readString();
        updated = in.readString();
        currency = in.readString();
        brandId = in.readString();
    }

    public static PayOptionSortData newInstance(JSONObject rootObject) {
        PayOptionSortData item = new PayOptionSortData();
        item.id = rootObject.optString("id");
        item.categoryId = rootObject.optString("categoryid");
        item.opCode = rootObject.optString("opcode");
        item.opName = rootObject.optString("opname");
        item.displayOrder = rootObject.optString("displayorder");
        item.status = rootObject.optString("status");
        item.created = rootObject.optString("created");
        item.updated = rootObject.optString("updated");
        item.currency = rootObject.optString("currency");
        item.brandId = rootObject.optString("brandid");
        return item;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(categoryId);
        dest.writeString(opCode);
        dest.writeString(opName);
        dest.writeString(displayOrder);
        dest.writeString(status);
        dest.writeString(created);
        dest.writeString(updated);
        dest.writeString(currency);
        dest.writeString(brandId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
}
