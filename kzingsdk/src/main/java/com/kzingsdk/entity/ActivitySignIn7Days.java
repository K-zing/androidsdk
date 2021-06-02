package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;


public class ActivitySignIn7Days implements Parcelable {


    public static final Creator CREATOR = new Creator() {
        public ActivitySignIn7Days createFromParcel(Parcel in) {
            return new ActivitySignIn7Days(in);
        }

        public ActivitySignIn7Days[] newArray(int size) {
            return new ActivitySignIn7Days[size];
        }
    };

    private boolean isUniqueBankCard = false;
    private boolean isUniqueRealName = false;
    private boolean isUniqueRegIp = false;
    private boolean isUniqueUuid = false;
    private Integer applyMethod = 0;
    private Integer maxJoin = 0;
    private HashSet<String> gpidSet = new HashSet<>();
    private ArrayList<ActivitySignIn7DaysRequirement> signIn7DaysRequirementList = new ArrayList<>();


    public ActivitySignIn7Days() {
    }

    public static ActivitySignIn7Days newInstance(JSONObject rootObject) {
        ActivitySignIn7Days item = new ActivitySignIn7Days();
        item.setUniqueBankCard(rootObject.optBoolean("is_unique_bankcard"));
        item.setUniqueRealName(rootObject.optBoolean("is_unique_realname"));
        item.setUniqueRegIp(rootObject.optBoolean("is_unique_regip"));
        item.setUniqueUuid(rootObject.optBoolean("is_unique_uuid"));
        item.setApplyMethod(rootObject.optInt("apply_method"));
        item.setMaxJoin(rootObject.optInt("max_join"));
        JSONArray gpidArray = rootObject.optJSONArray("gpid");
        if (gpidArray != null && gpidArray.length() > 0) {
            for (int i = 0; i < gpidArray.length(); i++) {
                item.gpidSet.add(gpidArray.optString(i));
            }
        }
        JSONArray signin7daysRequirementArray = rootObject.optJSONArray("signin7days_requirement");
        if (signin7daysRequirementArray != null && signin7daysRequirementArray.length() > 0) {
            for (int i = 0; i < signin7daysRequirementArray.length(); i++) {
                item.signIn7DaysRequirementList.add(ActivitySignIn7DaysRequirement.newInstance(signin7daysRequirementArray.optJSONObject(i)));
            }
        }
        return item;
    }


    public ActivitySignIn7Days(Parcel in) {
        isUniqueBankCard = in.readInt() == 1;
        isUniqueRealName = in.readInt() == 1;
        isUniqueRegIp = in.readInt() == 1;
        isUniqueUuid = in.readInt() == 1;
        applyMethod = in.readInt();
        maxJoin = in.readInt();
        Object[] objectArray = in.readArray(ActivitySignIn7Days.class.getClassLoader());
        gpidSet = (HashSet<String>) objectArray[0];
        signIn7DaysRequirementList = (ArrayList<ActivitySignIn7DaysRequirement>) objectArray[1];
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(isUniqueBankCard ? 1 : 0);
        dest.writeInt(isUniqueRealName ? 1 : 0);
        dest.writeInt(isUniqueRegIp ? 1 : 0);
        dest.writeInt(isUniqueUuid ? 1 : 0);
        dest.writeInt(applyMethod);
        dest.writeInt(maxJoin);
        dest.writeArray(new Object[]{
                gpidSet,
                signIn7DaysRequirementList
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public boolean isUniqueBankCard() {
        return isUniqueBankCard;
    }

    public void setUniqueBankCard(boolean uniqueBankCard) {
        isUniqueBankCard = uniqueBankCard;
    }

    public boolean isUniqueRealName() {
        return isUniqueRealName;
    }

    public void setUniqueRealName(boolean uniqueRealName) {
        isUniqueRealName = uniqueRealName;
    }

    public boolean isUniqueRegIp() {
        return isUniqueRegIp;
    }

    public void setUniqueRegIp(boolean uniqueRegIp) {
        isUniqueRegIp = uniqueRegIp;
    }

    public boolean isUniqueUuid() {
        return isUniqueUuid;
    }

    public void setUniqueUuid(boolean uniqueUuid) {
        isUniqueUuid = uniqueUuid;
    }

    public Integer getApplyMethod() {
        return applyMethod;
    }

    public void setApplyMethod(Integer applyMethod) {
        this.applyMethod = applyMethod;
    }

    public Integer getMaxJoin() {
        return maxJoin;
    }

    public void setMaxJoin(Integer maxJoin) {
        this.maxJoin = maxJoin;
    }

    public HashSet<String> getGpidSet() {
        return gpidSet;
    }

    public void setGpidSet(HashSet<String> gpidSet) {
        this.gpidSet = gpidSet;
    }

    public ArrayList<ActivitySignIn7DaysRequirement> getSignIn7DaysRequirementList() {
        return signIn7DaysRequirementList;
    }

    public void setSignIn7DaysRequirementList(ArrayList<ActivitySignIn7DaysRequirement> signIn7DaysRequirementList) {
        this.signIn7DaysRequirementList = signIn7DaysRequirementList;
    }
}