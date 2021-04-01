package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.util.ArrayList;

public class PaymentGroup implements Parcelable {

    private String id;
    private String image;
    private String name;
    private String desc;
    private PaymentType paymentType;
    private Integer displayorder;
    private ArrayList<BasePaymentMethod> paymentList = new ArrayList<>();

    public PaymentGroup() {

    }


    public static PaymentGroup newInstance(JSONObject rootObject) {
        PaymentGroup item = new PaymentGroup();
        item.setId(rootObject.optString("id"));
        item.setName(rootObject.optString("ptalias"));
        item.setDisplayorder(rootObject.optInt("displayorder"));
        item.setImage(rootObject.optString("image"));
        item.setDesc(rootObject.optString("desc"));
        item.setPaymentType(PaymentType.valueOfTypeName(rootObject.optString("type")));
        return item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? "" : image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }


    public ArrayList<BasePaymentMethod> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(ArrayList<BasePaymentMethod> paymentList) {
        this.paymentList = paymentList;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public PaymentGroup createFromParcel(Parcel in) {
            return new PaymentGroup(in);
        }

        public PaymentGroup[] newArray(int size) {
            return new PaymentGroup[size];
        }
    };

    public PaymentGroup(Parcel in) {
        paymentType = PaymentType.valueOfTypeId(in.readInt());
        name = in.readString();
        image = in.readString();
        if (paymentType == PaymentType.PREPAIDCARD) return;
        id = in.readString();
        desc = in.readString();
        displayorder = in.readInt();
        Object[] customObjects = in.readArray(ThirdPartyPaymentBank.class.getClassLoader());
        int i = 0;
        paymentList = (ArrayList<BasePaymentMethod>) customObjects[i++];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(paymentType.getId());
        dest.writeString(name);
        dest.writeString(image);
        if (paymentType == PaymentType.PREPAIDCARD) return;
        dest.writeString(id);
        dest.writeString(desc);
        dest.writeInt(displayorder);
        Object[] customObjects = new Object[1];
        int i = 0;
        customObjects[i++] = paymentList;
        dest.writeArray(customObjects);
    }

    @Override
    public String toString() {
        return "PaymentGroup{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", paymentType=" + paymentType +
                ", displayorder=" + displayorder +
                ", paymentList=" + paymentList +
                '}';
    }
}
