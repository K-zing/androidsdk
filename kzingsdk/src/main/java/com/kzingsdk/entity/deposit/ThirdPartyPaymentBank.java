package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class ThirdPartyPaymentBank implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ThirdPartyPaymentBank createFromParcel(Parcel in) {
            return new ThirdPartyPaymentBank(in);
        }

        public ThirdPartyPaymentBank[] newArray(int size) {
            return new ThirdPartyPaymentBank[size];
        }
    };
    private ThirdPartyPayment parent;
    private String id;
    private String name;
    private String image;
    private String css;
    private String logoType;
    private String type;
    private String translateKey;

    public ThirdPartyPaymentBank() {

    }

    public ThirdPartyPaymentBank(Parcel in) {
        id = in.readString();
        name = in.readString();
        css = in.readString();
        image = in.readString();
        logoType = in.readString();
        type = in.readString();
        translateKey = in.readString();
        Object[] customObjects = in.readArray(ThirdPartyPaymentBank.class.getClassLoader());
        parent = (ThirdPartyPayment) customObjects[0];
    }

    public static ThirdPartyPaymentBank newInstance(JSONObject rootObject, ThirdPartyPayment thirdPartyPayment) {
        ThirdPartyPaymentBank item = new ThirdPartyPaymentBank();
        item.setId(rootObject.optString("key"));
        item.setName(rootObject.optString("name"));
        item.setCss(rootObject.optString("css"));
        item.setImage(rootObject.optString("bankcss"));
        item.setLogoType(rootObject.optString("logotype"));
        item.setType(rootObject.optString("type"));
        item.setTranslateKey(rootObject.optString("translatekey"));
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

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getLogoType() {
        return logoType;
    }

    public void setLogoType(String logoType) {
        this.logoType = logoType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTranslateKey() {
        return translateKey;
    }

    public void setTranslateKey(String translateKey) {
        this.translateKey = translateKey;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(css);
        dest.writeString(image);
        dest.writeString(logoType);
        dest.writeString(type);
        dest.writeString(translateKey);
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

