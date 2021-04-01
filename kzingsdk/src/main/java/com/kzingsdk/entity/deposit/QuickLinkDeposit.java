package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class QuickLinkDeposit implements Parcelable {

    protected String logo = "";
    protected String name = "";
    protected String url = "";

    public QuickLinkDeposit() {
    }

    public static QuickLinkDeposit newInstance(JSONObject rootObject) {
        QuickLinkDeposit quickLinkDeposit = new QuickLinkDeposit();
        quickLinkDeposit.setLogo(rootObject.optString("logo"));
        quickLinkDeposit.setName(rootObject.optString("name"));
        quickLinkDeposit.setUrl(rootObject.optString("url"));
        return quickLinkDeposit;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public QuickLinkDeposit createFromParcel(Parcel in) {
            return new QuickLinkDeposit(in);
        }

        public QuickLinkDeposit[] newArray(int size) {
            return new QuickLinkDeposit[size];
        }
    };

    public QuickLinkDeposit(Parcel in) {
        logo = in.readString();
        name = in.readString();
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(logo);
        dest.writeString(name);
        dest.writeString(url);
    }

}
