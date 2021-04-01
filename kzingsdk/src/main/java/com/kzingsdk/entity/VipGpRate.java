package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VipGpRate implements Parcelable {


    private boolean isStepped = false;
    private Integer rankLevel;
    private String gpid;
    private String groupId;
    private String groupName;
    private BigDecimal fixRate = BigDecimal.ZERO;
    private BigDecimal limit = BigDecimal.ZERO;
    private ArrayList<LadderRate> ladderRateList = new ArrayList<>();

    public VipGpRate() {

    }

    public static VipGpRate newInstance(JSONObject rootObject) {
        VipGpRate vipGpRate = new VipGpRate();
        vipGpRate.gpid = rootObject.optString("gpid");
        vipGpRate.groupId = rootObject.optString("groupId");
        vipGpRate.rankLevel = rootObject.optInt("ranklevel", 0);
        vipGpRate.groupName = rootObject.optString("groupName");
        vipGpRate.isStepped = rootObject.optInt("stepped", 0) == 1;
        vipGpRate.fixRate = BigDecimalUtil.optBigDecimal(rootObject, "rrate", BigDecimal.ZERO);
        vipGpRate.limit = BigDecimalUtil.optBigDecimal(rootObject, "rrlimit", BigDecimal.ZERO);
        JSONArray stepcond = rootObject.optJSONArray("stepcond");
        for (int i = 0; i < stepcond.length(); i++) {
            BigDecimal ladder = BigDecimalUtil.optBigDecimal(stepcond.optJSONObject(i), "ladder", BigDecimal.ZERO);
            BigDecimal rate = BigDecimalUtil.optBigDecimal(stepcond.optJSONObject(i), "rate", BigDecimal.ZERO);
            vipGpRate.ladderRateList.add(new LadderRate(ladder, rate));
        }
        return vipGpRate;
    }

    public boolean isStepped() {
        return isStepped;
    }

    public void setStepped(boolean stepped) {
        isStepped = stepped;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Integer getRankLevel() {
        return rankLevel;
    }

    public void setRankLevel(Integer rankLevel) {
        this.rankLevel = rankLevel;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public BigDecimal getFixRate() {
        return fixRate;
    }

    public void setFixRate(BigDecimal fixRate) {
        this.fixRate = fixRate;
    }

    public ArrayList<LadderRate> getLadderRateList() {
        return ladderRateList;
    }

    public void setLadderRateList(ArrayList<LadderRate> ladderRateList) {
        this.ladderRateList = ladderRateList;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VipGpRate> CREATOR = new Creator<VipGpRate>() {
        @Override
        public VipGpRate createFromParcel(Parcel in) {
            return new VipGpRate(in);
        }

        @Override
        public VipGpRate[] newArray(int size) {
            return new VipGpRate[size];
        }
    };

    protected VipGpRate(Parcel in) {
        isStepped = in.readByte() != 0;
        gpid = in.readString();
        groupId = in.readString();
        rankLevel = in.readInt();
        groupName = in.readString();
        fixRate = new BigDecimal(in.readString());
        limit = new BigDecimal(in.readString());
        Object[] objectArray = in.readArray(VipGpRate.class.getClassLoader());
        ladderRateList = (ArrayList<LadderRate>) objectArray[0];
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (isStepped ? 1 : 0));
        parcel.writeString(gpid);
        parcel.writeString(groupId);
        parcel.writeInt(rankLevel);
        parcel.writeString(groupName);
        parcel.writeString(fixRate.toString());
        parcel.writeString(limit.toString());
        Object[] customObjects = new Object[1];
        customObjects[0] = ladderRateList;
        parcel.writeArray(customObjects);
    }


    public static class LadderRate implements Parcelable {

        private BigDecimal ladder = BigDecimal.ZERO;
        private BigDecimal rate = BigDecimal.ZERO;

        public LadderRate(BigDecimal ladder, BigDecimal rate) {
            this.ladder = ladder;
            this.rate = rate;
        }

        protected LadderRate(Parcel in) {
            ladder = new BigDecimal(in.readString());
            rate = new BigDecimal(in.readString());
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(ladder.toString());
            dest.writeString(rate.toString());
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<LadderRate> CREATOR = new Creator<LadderRate>() {
            @Override
            public LadderRate createFromParcel(Parcel in) {
                return new LadderRate(in);
            }

            @Override
            public LadderRate[] newArray(int size) {
                return new LadderRate[size];
            }
        };

        public BigDecimal getLadder() {
            return ladder;
        }

        public void setLadder(BigDecimal ladder) {
            this.ladder = ladder;
        }

        public BigDecimal getRate() {
            return rate;
        }

        public void setRate(BigDecimal rate) {
            this.rate = rate;
        }
    }


}
