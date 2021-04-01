package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class ActivityReferDpt implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public ActivityReferDpt createFromParcel(Parcel in) {
            return new ActivityReferDpt(in);
        }

        public ActivityReferDpt[] newArray(int size) {
            return new ActivityReferDpt[size];
        }
    };

    private Integer applyMethod;
    private Integer criteriaType;
    private Integer refereeCriteriaType;
    private Integer refereeBonusType;
    private Integer bonusType;
    private Integer maxJoin;
    private ArrayList<String> gpidList = new ArrayList<>();
    private ArrayList<ActivityReferDptRequirement> referrerDptRequirement = new ArrayList<>();
    private ArrayList<ActivityReferDptRequirement> refereeDptRequirement = new ArrayList<>();

    public ActivityReferDpt() {
    }

    public static ActivityReferDpt newInstance(JSONObject rootObject) {
        ActivityReferDpt item = new ActivityReferDpt();
        item.applyMethod = rootObject.optInt("apply_method");
        item.criteriaType = rootObject.optInt("criteria_type");
        item.refereeCriteriaType = rootObject.optInt("referee_criteria_type");
        item.maxJoin = rootObject.optInt("max_join");
        item.refereeBonusType = rootObject.optInt("referee_bonus_type");
        item.bonusType = rootObject.optInt("bonus_type");
        JSONArray gpidArray = rootObject.optJSONArray("gpid");
        if (gpidArray != null) {
            for (int i = 0; i < gpidArray.length(); i++) {
                item.gpidList.add(gpidArray.optString(i));
            }

        }

        JSONArray referrerArray = rootObject.optJSONArray("referrer_dpt_requirement");
        if (referrerArray != null) {
            for (int i = 0; i < referrerArray.length(); i++) {
                item.referrerDptRequirement.add(ActivityReferDptRequirement.newInstance(referrerArray.optJSONObject(i)));
            }
        }

        JSONArray refereeArray = rootObject.optJSONArray("referee_dpt_requirement");
        if (refereeArray != null) {
            for (int i = 0; i < refereeArray.length(); i++) {
                item.refereeDptRequirement.add(ActivityReferDptRequirement.newInstance(refereeArray.optJSONObject(i)));
            }

        }
        return item;
    }


    public ActivityReferDpt(Parcel in) {
        applyMethod = in.readInt();
        criteriaType = in.readInt();
        refereeCriteriaType = in.readInt();
        refereeBonusType = in.readInt();
        bonusType = in.readInt();
        maxJoin = in.readInt();
        Object[] objectArray = in.readArray(ActivityReferDpt.class.getClassLoader());
        gpidList = (ArrayList<String>) objectArray[0];
        referrerDptRequirement = (ArrayList<ActivityReferDptRequirement>) objectArray[1];
        refereeDptRequirement = (ArrayList<ActivityReferDptRequirement>) objectArray[2];

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(applyMethod);
        dest.writeInt(criteriaType);
        dest.writeInt(refereeCriteriaType);
        dest.writeInt(refereeBonusType);
        dest.writeInt(bonusType);
        dest.writeInt(maxJoin);
        dest.writeArray(new Object[]{
                gpidList,
                referrerDptRequirement,
                refereeDptRequirement,
        });
    }

    public static Creator getCREATOR() {
        return CREATOR;
    }

    public Integer getApplyMethod() {
        return applyMethod;
    }

    public void setApplyMethod(Integer applyMethod) {
        this.applyMethod = applyMethod;
    }

    public Integer getCriteriaType() {
        return criteriaType;
    }

    public void setCriteriaType(Integer criteriaType) {
        this.criteriaType = criteriaType;
    }

    public Integer getRefereeCriteriaType() {
        return refereeCriteriaType;
    }

    public void setRefereeCriteriaType(Integer refereeCriteriaType) {
        this.refereeCriteriaType = refereeCriteriaType;
    }

    public Integer getRefereeBonusType() {
        return refereeBonusType;
    }

    public void setRefereeBonusType(Integer refereeBonusType) {
        this.refereeBonusType = refereeBonusType;
    }

    public Integer getBonusType() {
        return bonusType;
    }

    public void setBonusType(Integer bonusType) {
        this.bonusType = bonusType;
    }

    public Integer getMaxJoin() {
        return maxJoin;
    }

    public void setMaxJoin(Integer maxJoin) {
        this.maxJoin = maxJoin;
    }

    public ArrayList<String> getGpidList() {
        return gpidList;
    }

    public void setGpidList(ArrayList<String> gpidList) {
        this.gpidList = gpidList;
    }

    public ArrayList<ActivityReferDptRequirement> getReferrerDptRequirement() {
        return referrerDptRequirement;
    }

    public void setReferrerDptRequirement(ArrayList<ActivityReferDptRequirement> referrerDptRequirement) {
        this.referrerDptRequirement = referrerDptRequirement;
    }

    public ArrayList<ActivityReferDptRequirement> getRefereeDptRequirement() {
        return refereeDptRequirement;
    }

    public void setRefereeDptRequirement(ArrayList<ActivityReferDptRequirement> refereeDptRequirement) {
        this.refereeDptRequirement = refereeDptRequirement;
    }
}