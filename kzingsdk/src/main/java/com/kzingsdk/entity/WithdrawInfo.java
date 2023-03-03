package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class WithdrawInfo {

    private Boolean needWithdrawPassword;
    private Boolean showWithdrawRate;
    private Integer processingCount;
    private Integer pendingLimit;
    private Integer limitWithdrawalBankCard;
    private String info = "";
    private Double minAmount;
    private Double maxAmount;
    private BigDecimal minAmountUsdt;
    private BigDecimal maxAmountUsdt;
    private Double playerTodayAmount;
    private Double playerTodayCount;
    private Double dayMaxAmount;
    private Double dayMaxCount;
    private boolean allowPlayerDeleteCard = false;
    private boolean waterCheckBeforeWithdraw = false;
    private boolean waterCheckOnOff = false;
    private boolean bankCardCityProvince = false;
    private boolean playerWithdrawEnterOtp = false;
    private String mobileBetCheckDesc;
    private String withdrawBindNetwork;
    private String limitWithdrawalCryptoAddress;
    private String withdrawAllowBindOtherName;
    private boolean withdrawBindUsdt;
    private boolean allowWithdrawCfg;
    private boolean allowCryptoWithdrawCfg;
    private boolean allowIFSCCode;
    private boolean cfQuickPay;
    private boolean addCryptoAddressEnterOtp;
    private boolean allowUploadBankPassbookPhoto;


    private BigDecimal withdrawRate = BigDecimal.ONE;
    private ArrayList<BankCard> bankCardList = new ArrayList<>();
    private ArrayList<PlayerBankCard> playerBankCardList = new ArrayList<>();
    private HashMap<String, ArrayList<String>> cryptoMap = new HashMap<>();
    private ArrayList<QpWallet> qpWalletList = new ArrayList<>();

    public static WithdrawInfo newInstance(JSONObject rootObject) {
        WithdrawInfo withdrawInfo = new WithdrawInfo();
        withdrawInfo.setNeedWithdrawPassword(rootObject.optString("wdpassword").equals("true"));
        withdrawInfo.setProcessingCount(rootObject.optInt("process", 0));
        withdrawInfo.setPendingLimit(rootObject.optInt("withdraw_pending_limit", 1));
        withdrawInfo.setLimitWithdrawalBankCard(rootObject.optInt("limitWithdrawalBankCard", 0));
        withdrawInfo.setInfo(rootObject.optString("winfo"));
        withdrawInfo.setMinAmount(rootObject.optDouble("withdraw_min"));
        withdrawInfo.setMaxAmount(rootObject.optDouble("withdraw_max"));
        withdrawInfo.setMinAmountUsdt(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_min_usdt", BigDecimal.ZERO));
        withdrawInfo.setMaxAmountUsdt(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_max_usdt", BigDecimal.ZERO));
        withdrawInfo.setShowWithdrawRate(rootObject.optBoolean("withdraw_show_rate", false));
        withdrawInfo.setPlayerTodayAmount(rootObject.optDouble("player_today_withdraw_amount"));
        withdrawInfo.setPlayerTodayCount(rootObject.optDouble("player_today_withdraw_count"));
        withdrawInfo.setDayMaxCount(rootObject.optDouble("withdraw_day_max_count"));
        withdrawInfo.setDayMaxAmount(rootObject.optDouble("withdraw_day_max_amount"));
        withdrawInfo.setWithdrawRate(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_rate", BigDecimal.ONE));
        withdrawInfo.setMobileBetCheckDesc(rootObject.optString("mobileBetCheckDesc"));
        withdrawInfo.setWithdrawBindNetwork(rootObject.optString("withdrawbindnetwork"));
        withdrawInfo.setLimitWithdrawalCryptoAddress(rootObject.optString("limitWithdrawalCryptoAddress"));
        withdrawInfo.setWithdrawAllowBindOtherName(rootObject.optString("withdrawallowbindothername"));
        withdrawInfo.setAllowPlayerDeleteCard(rootObject.optString("allowPlayerDeleteCard", "OFF").equalsIgnoreCase("ON"));
        withdrawInfo.setWaterCheckBeforeWithdraw(rootObject.optString("waterCheckBeforeWithdraw", "OFF").equalsIgnoreCase("ON"));
        withdrawInfo.setWaterCheckOnOff(rootObject.optBoolean("watercheckonoff", false));
        withdrawInfo.setBankCardCityProvince(rootObject.optString("bankCardCityProvince", "OFF").equalsIgnoreCase("ON"));
        withdrawInfo.setPlayerWithdrawEnterOtp(rootObject.optString("playerWithdrawEnterOtp", "OFF").equalsIgnoreCase("ON"));
        withdrawInfo.setWithdrawBindUsdt(rootObject.optBoolean("withdrawbindusdt", false));
        withdrawInfo.setAllowWithdrawCfg(rootObject.optBoolean("allow_withdraw_cfg", false));
        withdrawInfo.setAllowCryptoWithdrawCfg(rootObject.optBoolean("allow_crypto_withdraw_cfg", false));
        withdrawInfo.setAllowIFSCCode(rootObject.optBoolean("allowIFSCCode", false));
        withdrawInfo.setCfQuickPay(rootObject.optString("cfquickpay", "OFF").equalsIgnoreCase("ON"));
        withdrawInfo.setAddCryptoAddressEnterOtp(rootObject.optBoolean("addCryptoAddressEnterOtp"));
        withdrawInfo.setAllowUploadBankPassbookPhoto(rootObject.optBoolean("allowUploadBankPassbookPhoto"));

        JSONArray cryptoArray = rootObject.optJSONArray("crypto");
        for (int i = 0; i < cryptoArray.length(); i++) {
            JSONObject cryptoObject = cryptoArray.optJSONObject(i);
            String currency = cryptoObject.optString("currency");
            ArrayList<String> networkList = withdrawInfo.cryptoMap.get(currency);
            if (networkList == null) {
                networkList = new ArrayList<>();
            }
            networkList.add(cryptoObject.optString("network"));
            withdrawInfo.cryptoMap.put(currency, networkList);
        }
        JSONArray playerBanksArray = rootObject.optJSONArray("wd_banks");
        if (playerBanksArray != null)
            for (int i = 0; i < playerBanksArray.length(); i++) {
                withdrawInfo.playerBankCardList.add(PlayerBankCard.newInstance(playerBanksArray.optJSONObject(i)));
            }
        JSONArray banksArray = rootObject.optJSONArray("banks");
        if (banksArray != null)
            for (int i = 0; i < banksArray.length(); i++) {
                withdrawInfo.bankCardList.add(BankCard.newInstance(banksArray.optJSONObject(i)));
            }

        JSONArray qpwalletArray = rootObject.optJSONArray("qpwallet");
        if (qpwalletArray != null)
            for (int i = 0; i < qpwalletArray.length(); i++) {
                withdrawInfo.qpWalletList.add(QpWallet.newInstance(qpwalletArray.optJSONObject(i)));
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

    public BigDecimal getMinAmountUsdt() {
        return minAmountUsdt;
    }

    public void setMinAmountUsdt(BigDecimal minAmountUsdt) {
        this.minAmountUsdt = minAmountUsdt;
    }

    public BigDecimal getMaxAmountUsdt() {
        return maxAmountUsdt;
    }

    public void setMaxAmountUsdt(BigDecimal maxAmountUsdt) {
        this.maxAmountUsdt = maxAmountUsdt;
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

    public boolean isPlayerWithdrawEnterOtp() {
        return playerWithdrawEnterOtp;
    }

    public void setPlayerWithdrawEnterOtp(boolean playerWithdrawEnterOtp) {
        this.playerWithdrawEnterOtp = playerWithdrawEnterOtp;
    }

    public String getWithdrawBindNetwork() {
        return withdrawBindNetwork;
    }

    public void setWithdrawBindNetwork(String withdrawBindNetwork) {
        this.withdrawBindNetwork = withdrawBindNetwork;
    }

    public String getLimitWithdrawalCryptoAddress() {
        return limitWithdrawalCryptoAddress;
    }

    public WithdrawInfo setLimitWithdrawalCryptoAddress(String limitWithdrawalCryptoAddress) {
        this.limitWithdrawalCryptoAddress = limitWithdrawalCryptoAddress;
        return this;
    }

    public String getWithdrawAllowBindOtherName() {
        return withdrawAllowBindOtherName;
    }

    public void setWithdrawAllowBindOtherName(String withdrawAllowBindOtherName) {
        this.withdrawAllowBindOtherName = withdrawAllowBindOtherName;
    }

    public boolean isWithdrawBindUsdt() {
        return withdrawBindUsdt;
    }

    public void setWithdrawBindUsdt(boolean withdrawBindUsdt) {
        this.withdrawBindUsdt = withdrawBindUsdt;
    }

    public boolean isAllowWithdrawCfg() {
        return allowWithdrawCfg;
    }

    public void setAllowWithdrawCfg(boolean allowWithdrawCfg) {
        this.allowWithdrawCfg = allowWithdrawCfg;
    }

    public boolean isAllowCryptoWithdrawCfg() {
        return allowCryptoWithdrawCfg;
    }

    public void setAllowCryptoWithdrawCfg(boolean allowCryptoWithdrawCfg) {
        this.allowCryptoWithdrawCfg = allowCryptoWithdrawCfg;
    }

    public boolean isAllowIFSCCode() {
        return allowIFSCCode;
    }

    public void setAllowIFSCCode(boolean allowIFSCCode) {
        this.allowIFSCCode = allowIFSCCode;
    }

    public HashMap<String, ArrayList<String>> getCryptoMap() {
        return cryptoMap;
    }

    public void setCryptoMap(HashMap<String, ArrayList<String>> cryptoMap) {
        this.cryptoMap = cryptoMap;
    }

    public boolean isCfQuickPay() {
        return cfQuickPay;
    }

    public WithdrawInfo setCfQuickPay(boolean cfQuickPay) {
        this.cfQuickPay = cfQuickPay;
        return this;
    }

    public boolean isAddCryptoAddressEnterOtp() {
        return addCryptoAddressEnterOtp;
    }

    public void setAddCryptoAddressEnterOtp(boolean addCryptoAddressEnterOtp) {
        this.addCryptoAddressEnterOtp = addCryptoAddressEnterOtp;
    }

    public boolean isAllowUploadBankPassbookPhoto() {
        return allowUploadBankPassbookPhoto;
    }

    public void setAllowUploadBankPassbookPhoto(boolean allowUploadBankPassbookPhoto) {
        this.allowUploadBankPassbookPhoto = allowUploadBankPassbookPhoto;
    }

    public ArrayList<QpWallet> getQpWalletList() {
        return qpWalletList;
    }

    public WithdrawInfo setQpWalletList(ArrayList<QpWallet> qpWalletList) {
        this.qpWalletList = qpWalletList;
        return this;
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
