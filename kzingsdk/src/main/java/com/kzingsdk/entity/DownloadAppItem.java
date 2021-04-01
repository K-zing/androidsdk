package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class DownloadAppItem implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public DownloadAppItem createFromParcel(Parcel in) {
            return new DownloadAppItem(in);
        }

        public DownloadAppItem[] newArray(int size) {
            return new DownloadAppItem[size];
        }
    };
    private String gpid = "";
    private String gpName = "";
    private String url = "";
    private String image = "";

    public DownloadAppItem() {

    }

    public DownloadAppItem(Parcel in) {

        gpid = in.readString();
        gpName = in.readString();
        url = in.readString();
        image = in.readString();

    }

    public static DownloadAppItem newInstance(JSONObject rootObject) {
        DownloadAppItem downloadAppItem = new DownloadAppItem();
        downloadAppItem.setGpid(rootObject.optString("gpid"));
        downloadAppItem.setGpName(rootObject.optString("gpname"));
        downloadAppItem.setUrl(rootObject.optString("url_android"));
        downloadAppItem.setImage(rootObject.optString("image_an"));
        return downloadAppItem;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gpid);
        dest.writeString(gpName);
        dest.writeString(url);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "DownloadAppItem{" +
                "gpid='" + gpid + '\'' +
                ", gpName='" + gpName + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
