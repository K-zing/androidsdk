package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AvailablePaymentGroup implements Parcelable {


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public AvailablePaymentGroup createFromParcel(Parcel in) {
            return new AvailablePaymentGroup(in);
        }

        public AvailablePaymentGroup[] newArray(int size) {
            return new AvailablePaymentGroup[size];
        }
    };
    private String categoryId;
    private String opName;
    private String displayOrder;
    private String depositAmountFormat;
    private String status;
    private String isMain;
    private String ptCss;
    private String created;
    private String updated;
    private String currency;
    private String brandId;
    private ArrayList<String> availableChannel = new ArrayList<>();

    public AvailablePaymentGroup() {

    }

    public AvailablePaymentGroup(Parcel in) {
        categoryId = in.readString();
        opName = in.readString();
        displayOrder = in.readString();
        depositAmountFormat = in.readString();
        status = in.readString();
        isMain = in.readString();
        ptCss = in.readString();
        created = in.readString();
        updated = in.readString();
        currency = in.readString();
        brandId = in.readString();
        int i = 0;
        Object[] customObjects = in.readArray(ThirdPartyPayment.class.getClassLoader());
        availableChannel = (ArrayList<String>) customObjects[i++];
    }

    public static AvailablePaymentGroup newInstance(JSONObject rootObject) {
        AvailablePaymentGroup item = new AvailablePaymentGroup();
        item.categoryId = rootObject.optString("categoryid");
        item.opName = rootObject.optString("opname");
        item.displayOrder = rootObject.optString("displayorder");
        item.depositAmountFormat = rootObject.optString("depositamountformat");
        item.status = rootObject.optString("status");
        item.isMain = rootObject.optString("ismain");
        item.ptCss = rootObject.optString("ptcss");
        item.created = rootObject.optString("created");
        item.updated = rootObject.optString("updated");
        item.currency = rootObject.optString("currency");
        item.brandId = rootObject.optString("brandid");
        JSONArray availableChannelA = rootObject.optJSONArray("availableChannel");
        if (availableChannelA != null) {
            for (int i = 0; i < availableChannelA.length(); i++) {
                item.availableChannel.add(availableChannelA.optString(i));
            }
        }
        return item;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    public String getDepositAmountFormat() {
        return depositAmountFormat;
    }

    public void setDepositAmountFormat(String depositAmountFormat) {
        this.depositAmountFormat = depositAmountFormat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsMain() {
        return isMain;
    }

    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }

    public String getPtCss() {
        return ptCss;
    }

    public void setPtCss(String ptCss) {
        this.ptCss = ptCss;
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

    public ArrayList<String> getAvailableChannel() {
        return availableChannel;
    }

    public void setAvailableChannel(ArrayList<String> availableChannel) {
        this.availableChannel = availableChannel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoryId);
        dest.writeString(opName);
        dest.writeString(displayOrder);
        dest.writeString(depositAmountFormat);
        dest.writeString(status);
        dest.writeString(isMain);
        dest.writeString(ptCss);
        dest.writeString(created);
        dest.writeString(updated);
        dest.writeString(currency);
        dest.writeString(brandId);
        dest.writeArray(new Object[]{
                availableChannel
        });
    }


}
