package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class WithdrawInfo {

    private Boolean needWithdrawPassword;
    private Boolean showWithdrawRate;
    private Integer processingCount;
    private Integer pendingLimit;
    private Integer limitWithdrawalBankCard;
    private String info = "";
    private Double minAmount;
    private Double maxAmount;
    private Double playerTodayAmount;
    private Double playerTodayCount;
    private Double dayMaxAmount;
    private Double dayMaxCount;
    private boolean allowPlayerDeleteCard = false;
    private boolean waterCheckBeforeWithdraw = false;
    private boolean waterCheckOnOff = false;
    private boolean bankCardCityProvince = false;
    private String mobileBetCheckDesc;
    private BigDecimal withdrawRate = BigDecimal.ONE;
    private ArrayList<BankCard> bankCardList = new ArrayList<>();
    private ArrayList<PlayerBankCard> playerBankCardList = new ArrayList<>();

    public static WithdrawInfo newInstance(JSONObject rootObject) {
        WithdrawInfo withdrawInfo = new WithdrawInfo();
        withdrawInfo.setNeedWithdrawPassword(rootObject.optString("wdpassword").equals("true"));
        withdrawInfo.setProcessingCount(rootObject.optInt("process", 0));
        withdrawInfo.setPendingLimit(rootObject.optInt("withdraw_pending_limit", 1));
        withdrawInfo.setLimitWithdrawalBankCard(rootObject.optInt("limitWithdrawalBankCard", 0));
        withdrawInfo.setInfo(rootObject.optString("winfo"));
        withdrawInfo.setMinAmount(rootObject.optDouble("withdraw_min"));
        withdrawInfo.setMaxAmount(rootObject.optDouble("withdraw_max"));
        withdrawInfo.setShowWithdrawRate(rootObject.optBoolean("withdraw_show_rate", false));
        withdrawInfo.setPlayerTodayAmount(rootObject.optDouble("player_today_withdraw_amount"));
        withdrawInfo.setPlayerTodayCount(rootObject.optDouble("player_today_withdraw_count"));
        withdrawInfo.setDayMaxCount(rootObject.optDouble("withdraw_day_max_count"));
        withdrawInfo.setDayMaxAmount(rootObject.optDouble("withdraw_day_max_amount"));
        withdrawInfo.setWithdrawRate(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_rate", BigDecimal.ONE));
        withdrawInfo.setMobileBetCheckDesc(rootObject.optString("mobileBetCheckDesc"));
        withdrawInfo.setAllowPlayerDeleteCard(rootObject.optString("allowPlayerDeleteCard", "OFF").equalsIgnoreCase("ON"));
        withdrawInfo.setWaterCheckBeforeWithdraw(rootObject.optString("waterCheckBeforeWithdraw", "OFF").equalsIgnoreCase("ON"));
        withdrawInfo.setWaterCheckOnOff(rootObject.optBoolean("watercheckonoff", false));
        withdrawInfo.setBankCardCityProvince(rootObject.optString("bankCardCityProvince", "OFF").equalsIgnoreCase("ON"));


        JSONArray playerBanksArray = rootObject.optJSONArray("wd_banks");
        for (int i = 0; i < playerBanksArray.length(); i++) {
            withdrawInfo.playerBankCardList.add(PlayerBankCard.newInstance(playerBanksArray.optJSONObject(i)));
        }
        JSONArray banksArray = rootObject.optJSONArray("banks");
        for (int i = 0; i < banksArray.length(); i++) {
            withdrawInfo.bankCardList.add(BankCard.newInstance(banksArray.optJSONObject(i)));
        }
        return withdrawInfo;
    }

    public Boolean getNeedWithdrawPassword() {
        return needWithdrawPassword;
    }

    public void setNeedWithdrawPassword(Boolean needWithdrawPassword) {
        this.needWithdrawPassword = needWithdrawPassword;
    }

    public Integer getProcessingCount() {
        return processingCount;
    }

    public void setProcessingCount(Integer processingCount) {
        this.processingCount = processingCount;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Boolean getShowWithdrawRate() {
        return showWithdrawRate;
    }

    public void setShowWithdrawRate(Boolean showWithdrawRate) {
        this.showWithdrawRate = showWithdrawRate;
    }

    public ArrayList<PlayerBankCard> getPlayerBankCardList() {
        return playerBankCardList;
    }

    public void setPlayerBankCardList(ArrayList<PlayerBankCard> playerBankCardList) {
        this.playerBankCardList = playerBankCardList;
    }

    public ArrayList<BankCard> getBankCardList() {
        return bankCardList;
    }

    public void setBankCardList(ArrayList<BankCard> bankCardList) {
        this.bankCardList = bankCardList;
    }

    public Integer getPendingLimit() {
        return pendingLimit;
    }

    public void setPendingLimit(Integer pendingLimit) {
        this.pendingLimit = pendingLimit;
    }

    public Integer getLimitWithdrawalBankCard() {
        return limitWithdrawalBankCard;
    }

    public void setLimitWithdrawalBankCard(Integer limitWithdrawalBankCard) {
        this.limitWithdrawalBankCard = limitWithdrawalBankCard;
    }

    public Double getPlayerTodayAmount() {
        return playerTodayAmount;
    }

    public void setPlayerTodayAmount(Double playerTodayAmount) {
        this.playerTodayAmount = playerTodayAmount;
    }

    public Double getPlayerTodayCount() {
        return playerTodayCount;
    }

    public void setPlayerTodayCount(Double playerTodayCount) {
        this.playerTodayCount = playerTodayCount;
    }

    public Double getDayMaxAmount() {
        return dayMaxAmount;
    }

    public void setDayMaxAmount(Double dayMaxAmount) {
        this.dayMaxAmount = dayMaxAmount;
    }

    public Double getDayMaxCount() {
        return dayMaxCount;
    }

    public void setDayMaxCount(Double dayMaxCount) {
        this.dayMaxCount = dayMaxCount;
    }


    public BigDecimal getWithdrawRate() {
        return withdrawRate;
    }

    public void setWithdrawRate(BigDecimal withdrawRate) {
        this.withdrawRate = withdrawRate;
    }

    public String getMobileBetCheckDesc() {
        return mobileBetCheckDesc;
    }

    public void setMobileBetCheckDesc(String mobileBetCheckDesc) {
        this.mobileBetCheckDesc = mobileBetCheckDesc;
    }

    public boolean isAllowPlayerDeleteCard() {
        return allowPlayerDeleteCard;
    }

    public void setAllowPlayerDeleteCard(boolean allowPlayerDeleteCard) {
        this.allowPlayerDeleteCard = allowPlayerDeleteCard;
    }

    public boolean isWaterCheckBeforeWithdraw() {
        return waterCheckBeforeWithdraw;
    }

    public void setWaterCheckBeforeWithdraw(boolean waterCheckBeforeWithdraw) {
        this.waterCheckBeforeWithdraw = waterCheckBeforeWithdraw;
    }

    public boolean isWaterCheckOnOff() {
        return waterCheckOnOff;
    }

    public void setWaterCheckOnOff(boolean waterCheckOnOff) {
        this.waterCheckOnOff = waterCheckOnOff;
    }

    public boolean isBankCardCityProvince() {
        return bankCardCityProvince;
    }

    public void setBankCardCityProvince(boolean bankCardCityProvince) {
        this.bankCardCityProvince = bankCardCityProvince;
    }

    @Override
    public String toString() {
        return "WithdrawInfo{" +
                "needWithdrawPassword=" + needWithdrawPassword +
                ", processingCount=" + processingCount +
                ", pendingLimit=" + pendingLimit +
                ", info='" + info + '\'' +
                ", minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                ", playerTodayAmount=" + playerTodayAmount +
                ", playerTodayCount=" + playerTodayCount +
                ", dayMaxAmount=" + dayMaxAmount +
                ", dayMaxCount=" + dayMaxCount +
                ", bankCardList=" + bankCardList +
                ", playerBankCardList=" + playerBankCardList +
                '}';
    }
}
