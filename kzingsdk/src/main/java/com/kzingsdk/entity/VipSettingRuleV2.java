package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class VipSettingRuleV2 implements Parcelable {

    public VipSettingRuleV2(){}

    public static final Parcelable.Creator<VipSettingRuleV2> CREATOR = new Creator<VipSettingRuleV2>() {
        @Override
        public VipSettingRuleV2 createFromParcel(Parcel in) {
            return new VipSettingRuleV2(in);
        }

        @Override
        public VipSettingRuleV2[] newArray(int size) {
            return new VipSettingRuleV2[size];
        }
    };

    private String id;
    private String lang;
    private String title;
    private String content;
    private Integer order;

    public static VipSettingRuleV2 newInstance(JSONObject rootObject) {
        VipSettingRuleV2 vipSettingRuleV2 = new VipSettingRuleV2();
        vipSettingRuleV2.id = rootObject.optString("id");
        vipSettingRuleV2.lang = rootObject.optString("lang");
        vipSettingRuleV2.title = rootObject.optString("title");
        vipSettingRuleV2.content = rootObject.optString("content");
        vipSettingRuleV2.order = rootObject.optInt("order");
        return vipSettingRuleV2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }


    protected VipSettingRuleV2(Parcel in) {
        id = in.readString();
        lang = in.readString();
        title = in.readString();
        content = in.readString();
        order = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(lang);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeInt(order);
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
