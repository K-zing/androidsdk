package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class ThirdPartyPaymentBank implements Parcelable {

    private ThirdPartyPayment parent;
    private String id;
    private String name;
    private String image;

    public ThirdPartyPaymentBank() {

    }

    public static ThirdPartyPaymentBank newInstance(JSONObject rootObject, ThirdPartyPayment thirdPartyPayment) {
        ThirdPartyPaymentBank item = new ThirdPartyPaymentBank();
        item.setId(rootObject.optString("key"));
        item.setName(rootObject.optString("name"));
        item.setImage(rootObject.optString("css"));
        try {
            item.parent = thirdPartyPayment.clone();
        } catch (CloneNotSupportedException e) {
        }
        return item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ThirdPartyPayment getParent() {
        return parent;
    }

    public void setParent(ThirdPartyPayment parent) {
        this.parent = parent;
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ThirdPartyPaymentBank createFromParcel(Parcel in) {
            return new ThirdPartyPaymentBank(in);
        }

        public ThirdPartyPaymentBank[] newArray(int size) {
            return new ThirdPartyPaymentBank[size];
        }
    };

    public ThirdPartyPaymentBank(Parcel in) {
        id = in.readString();
        name = in.readString();
        image = in.readString();
        Object[] customObjects = in.readArray(ThirdPartyPaymentBank.class.getClassLoader());
        parent = (ThirdPartyPayment) customObjects[0];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(image);
        Object[] customObjects = new Object[1];
        customObjects[0] = parent;
        dest.writeArray(customObjects);
    }

    @Override
    public String toString() {
        return "ThirdPartyPaymentBank{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

