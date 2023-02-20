package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.entity.gameplatform.GamePlatformType;

import org.json.JSONObject;

import java.util.HashMap;

public class VipSettingWater implements Parcelable {

    public VipSettingWater(){}

    public static final Creator<VipSettingWater> CREATOR = new Creator<VipSettingWater>() {
        @Override
        public VipSettingWater createFromParcel(Parcel in) {
            return new VipSettingWater(in);
        }

        @Override
        public VipSettingWater[] newArray(int size) {
            return new VipSettingWater[size];
        }
    };

    private String name;
    private String rank;
    private String maxWater;
    private HashMap<Integer, String> vipWaterMap = new HashMap<>();

    public static VipSettingWater newInstance(JSONObject rootObject) {
        VipSettingWater vipSettingWater = new VipSettingWater();
        vipSettingWater.name = rootObject.optString("name");
        vipSettingWater.rank = rootObject.optString("rank");
        JSONObject vipWaterJSONObject = rootObject.optJSONObject("water");
        if (vipWaterJSONObject != null) {
            vipSettingWater.maxWater = vipWaterJSONObject.optString("maxwater");
            for (GamePlatformType type : GamePlatformType.values()) {
                if (!vipWaterJSONObject.has(type.getId() + "")) {
                    continue;
                }
                vipSettingWater.vipWaterMap.put(type.getId(), vipWaterJSONObject.optString(type.getId() + ""));
            }
        }
        return vipSettingWater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMaxWater() {
        return maxWater;
    }

    public void setMaxWater(String maxWater) {
        this.maxWater = maxWater;
    }

    public HashMap<Integer, String> getVipWaterMap() {
        return vipWaterMap;
    }

    public void setVipWaterMap(HashMap<Integer, String> vipWaterMap) {
        this.vipWaterMap = vipWaterMap;
    }

    protected VipSettingWater(Parcel in) {
        name = in.readString();
        rank = in.readString();
        maxWater = in.readString();
        Object[] objectArray = in.readArray(VipSettingWater.class.getClassLoader());
        vipWaterMap = (HashMap<Integer, String>) objectArray[0];
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(rank);
        dest.writeString(maxWater);
        dest.writeArray(new Object[]{
                vipWaterMap,
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
