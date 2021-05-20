package com.kzingsdk.entity.D11;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class CsHistory {
    private String qhId;
    private String playerId;
    private String playerGroupId;
    private String qgtId;
    private String assignQgtId;
    private String sqtId;
    private String status;
    private String countaction;
    private String distributeDate;
    private String distributeBy;
    private String settledRemark;
    private String csSettledRemark;
    private String verifyDate;
    private String verifyByNo;
    private String verifyBy;
    private String settleDate;
    private String created;
    private String updated;
    private String brandId;
    private String lastUploadDate;
    private String levelId;
    private String qTypeName;
    private String sqTypeName;
    private ArrayList<CsAnswer> csAnswerMainList = new ArrayList<>();
    private ArrayList<CsAnswer> csAnswerExtraList = new ArrayList<>();
    private ArrayList<CsRemark> csRemarkList = new ArrayList<>();

    public CsHistory() {

    }

    public static CsHistory newInstance(JSONObject rootObject) {
        CsHistory csHistory = new CsHistory();
        csHistory.setQhId(rootObject.optString("qhid"));
        csHistory.setPlayerId(rootObject.optString("playerid"));
        csHistory.setPlayerGroupId(rootObject.optString("playergroupid"));
        csHistory.setQgtId(rootObject.optString("qgtid"));
        csHistory.setAssignQgtId(rootObject.optString("assignqgtid"));
        csHistory.setSqtId(rootObject.optString("sqtid"));
        csHistory.setStatus(rootObject.optString("status"));
        csHistory.setCountaction(rootObject.optString("countaction"));
        csHistory.setDistributeDate(rootObject.optString("distributedate"));
        csHistory.setDistributeBy(rootObject.optString("distributeby"));
        csHistory.setSettledRemark(rootObject.optString("settledremark"));
        csHistory.setCsSettledRemark(rootObject.optString("cssettledremark"));
        csHistory.setVerifyDate(rootObject.optString("verifydate"));
        csHistory.setVerifyByNo(rootObject.optString("verifybyno"));
        csHistory.setVerifyBy(rootObject.optString("verifyby"));
        csHistory.setSettleDate(rootObject.optString("settledate"));
        csHistory.setCreated(rootObject.optString("created"));
        csHistory.setUpdated(rootObject.optString("updated"));
        csHistory.setBrandId(rootObject.optString("brandid"));
        csHistory.setLastUploadDate(rootObject.optString("lastuploaddate"));
        csHistory.setLevelId(rootObject.optString("levelid"));
        csHistory.setQTypeName(rootObject.optString("qtypename"));
        csHistory.setSqTypeName(rootObject.optString("sqtypename"));
        JSONObject remarkRootObject = rootObject.optJSONObject("remark");
        if (remarkRootObject != null) {
            JSONArray remarkMainArray = rootObject.optJSONArray("main");
            if (remarkMainArray != null) {
                for (int i = 0; i < remarkMainArray.length(); i++) {
                    csHistory.csAnswerMainList.add(CsAnswer.newInstance(remarkMainArray.optJSONObject(i)));
                }
            }
            JSONArray remarkExtraArray = rootObject.optJSONArray("extra");
            if (remarkExtraArray != null) {
                for (int i = 0; i < remarkExtraArray.length(); i++) {
                    csHistory.csAnswerExtraList.add(CsAnswer.newInstance(remarkExtraArray.optJSONObject(i)));
                }
            }
        }
        JSONArray csRemarkArray = rootObject.optJSONArray("csremark");
        if (csRemarkArray != null) {
            for (int i = 0; i < csRemarkArray.length(); i++) {
                csHistory.csRemarkList.add(CsRemark.newInstance(csRemarkArray.optJSONObject(i)));
            }
        }
        return csHistory;
    }

    public String getQhId() {
        return qhId;
    }

    public void setQhId(String qhId) {
        this.qhId = qhId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerGroupId() {
        return playerGroupId;
    }

    public void setPlayerGroupId(String playerGroupId) {
        this.playerGroupId = playerGroupId;
    }

    public String getQgtId() {
        return qgtId;
    }

    public void setQgtId(String qgtId) {
        this.qgtId = qgtId;
    }

    public String getAssignQgtId() {
        return assignQgtId;
    }

    public void setAssignQgtId(String assignQgtId) {
        this.assignQgtId = assignQgtId;
    }

    public String getSqtId() {
        return sqtId;
    }

    public void setSqtId(String sqtId) {
        this.sqtId = sqtId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountaction() {
        return countaction;
    }

    public void setCountaction(String countaction) {
        this.countaction = countaction;
    }

    public String getDistributeDate() {
        return distributeDate;
    }

    public void setDistributeDate(String distributeDate) {
        this.distributeDate = distributeDate;
    }

    public String getDistributeBy() {
        return distributeBy;
    }

    public void setDistributeBy(String distributeBy) {
        this.distributeBy = distributeBy;
    }

    public String getSettledRemark() {
        return settledRemark;
    }

    public void setSettledRemark(String settledRemark) {
        this.settledRemark = settledRemark;
    }

    public String getCsSettledRemark() {
        return csSettledRemark;
    }

    public void setCsSettledRemark(String csSettledRemark) {
        this.csSettledRemark = csSettledRemark;
    }

    public String getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(String verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getVerifyByNo() {
        return verifyByNo;
    }

    public void setVerifyByNo(String verifyByNo) {
        this.verifyByNo = verifyByNo;
    }

    public String getVerifyBy() {
        return verifyBy;
    }

    public void setVerifyBy(String verifyBy) {
        this.verifyBy = verifyBy;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getLastUploadDate() {
        return lastUploadDate;
    }

    public void setLastUploadDate(String lastUploadDate) {
        this.lastUploadDate = lastUploadDate;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getQTypeName() {
        return qTypeName;
    }

    public void setQTypeName(String qTypeName) {
        this.qTypeName = qTypeName;
    }

    public String getSqTypeName() {
        return sqTypeName;
    }

    public void setSqTypeName(String sqTypeName) {
        this.sqTypeName = sqTypeName;
    }

    public ArrayList<CsAnswer> getCsAnswerMainList() {
        return csAnswerMainList;
    }

    public void setCsAnswerMainList(ArrayList<CsAnswer> csAnswerMainList) {
        this.csAnswerMainList = csAnswerMainList;
    }

    public ArrayList<CsAnswer> getCsAnswerExtraList() {
        return csAnswerExtraList;
    }

    public void setCsAnswerExtraList(ArrayList<CsAnswer> csAnswerExtraList) {
        this.csAnswerExtraList = csAnswerExtraList;
    }

    public ArrayList<CsRemark> getCsRemarkList() {
        return csRemarkList;
    }

    public void setCsRemarkList(ArrayList<CsRemark> csRemarkList) {
        this.csRemarkList = csRemarkList;
    }
}

