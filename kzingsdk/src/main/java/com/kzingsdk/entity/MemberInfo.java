package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MemberInfo implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public MemberInfo createFromParcel(Parcel in) {
            return new MemberInfo(in);
        }

        public MemberInfo[] newArray(int size) {
            return new MemberInfo[size];
        }
    };
    private String regDate;
    private String joinDays;
    private String playerName;
    private String realName;
    private String birthday;
    private String email;
    private String phone;
    private String weixin;
    private String qq;
    private String playerId;
    private String name;
    private String gpn;
    private Gender gender;
    private String message;
    private String whatsapp;
    private String telegram;
    private String line;
    private String avatarId;
    private String phoneCountry;
    private String balance = "0";
    private String lastBouns = "0";
    private String lastRakeback = "0";
    private String userPreferLanguage = "";
    private boolean hasWithdrawPassword = false;
    private String groupId = "";
    private String groupName = "";
    private String displayGroupName = "";
    private String memberVipLevelNameCn = "";
    private String memberVipLevelNameEn = "";
    private String zalo = "";
    private String facebook = "";
    private String pan = "";
    private String agentCode = "";
    private String skype = "";
    private String tncStatus = "";
    private String rankLevel = "";
    private String preferContactType = "";
    private String redirectLink = "";
    private boolean isDisplayGroupName = false;
    private boolean isMobileVerified = false;
    private boolean isEmailVerified = false;
    private boolean forceChangePw = false;
    private boolean isRealNameSeparated = false;
    private boolean panStatus = false;
    private boolean panDuplicateUUID = false;
    private boolean panDuplicateIP = false;
    private boolean enablePhoneRecall = false;
    private boolean memberPanAgentCode = false;
    private boolean memberPanPlayerGroup = false;
    private boolean memberPanUsername = false;
    private boolean displayAddress = false;
    private boolean withdrawBindAddress = false;
    private boolean preferContactPhone = false;
    private boolean preferContactSms = false;
    private boolean preferContactEmail = false;
    private boolean hasDeposit = false;
    private String playerCurrency = "";
    private String address = "";
    private String shortenLink = "";
    private ArrayList<String> currencyList = new ArrayList<>();
    private ArrayList<CurrencyBalance> currencyBalanceList = new ArrayList<>();
    private String withdrawFrozenAmount = "0";
    private int verifyRemainCountSms = 0;
    private int verifyRemainCountEmail = 0;

    private MemberInfo() {

    }

    public MemberInfo(Parcel in) {

        regDate = in.readString();
        joinDays = in.readString();
        playerName = in.readString();
        realName = in.readString();
        birthday = in.readString();
        email = in.readString();
        phone = in.readString();
        weixin = in.readString();
        qq = in.readString();
        playerId = in.readString();
        name = in.readString();
        gpn = in.readString();
        gender = Gender.values()[in.readInt()];
        message = in.readString();
        avatarId = in.readString();
        phoneCountry = in.readString();
        balance = in.readString();
        lastBouns = in.readString();
        lastRakeback = in.readString();
        userPreferLanguage = in.readString();
        whatsapp = in.readString();
        telegram = in.readString();
        line = in.readString();
        agentCode = in.readString();
        skype = in.readString();
        tncStatus = in.readString();
        rankLevel = in.readString();
        preferContactType = in.readString();
        redirectLink = in.readString();
        hasWithdrawPassword = in.readInt() == 1;
        groupName = in.readString();
        displayGroupName = in.readString();
        memberVipLevelNameCn = in.readString();
        memberVipLevelNameEn = in.readString();
        isDisplayGroupName = in.readInt() == 1;
        isMobileVerified = in.readInt() == 1;
        isEmailVerified = in.readInt() == 1;
        forceChangePw = in.readInt() == 1;
        isRealNameSeparated = in.readInt() == 1;
        panStatus = in.readInt() == 1;
        panDuplicateUUID = in.readInt() == 1;
        panDuplicateIP = in.readInt() == 1;
        groupId = in.readString();
        withdrawFrozenAmount = in.readString();
        zalo = in.readString();
        facebook = in.readString();
        pan = in.readString();
        enablePhoneRecall = in.readInt() == 1;
        memberPanAgentCode = in.readInt() == 1;
        memberPanPlayerGroup = in.readInt() == 1;
        memberPanUsername = in.readInt() == 1;
        displayAddress = in.readInt() == 1;
        withdrawBindAddress = in.readInt() == 1;
        preferContactPhone = in.readInt() == 1;
        preferContactSms = in.readInt() == 1;
        preferContactEmail = in.readInt() == 1;
        hasDeposit = in.readInt() == 1;
        playerCurrency = in.readString();
        address = in.readString();
        shortenLink = in.readString();
        verifyRemainCountSms = in.readInt();
        verifyRemainCountEmail = in.readInt();
        Object[] objectArray = in.readArray(MemberInfo.class.getClassLoader());
        currencyList = (ArrayList<String>) objectArray[0];
        currencyBalanceList = (ArrayList<CurrencyBalance>) objectArray[1];
    }

    public static MemberInfo newInstance(JSONObject rootObject) {
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setRegDate(rootObject.optString("regdate"));
        memberInfo.setJoinDays(rootObject.optString("joindays"));
        memberInfo.setPlayerName(rootObject.optString("playername"));
        memberInfo.setRealName(rootObject.optString("realname"));
        memberInfo.setBirthday(rootObject.optString("birthday"));
        memberInfo.setEmail(rootObject.optString("email"));
        memberInfo.setWeixin(rootObject.optString("weixin"));
        memberInfo.setPhone(rootObject.optString("phone"));
        memberInfo.setQq(rootObject.optString("qq"));
        memberInfo.setPlayerId(rootObject.optString("playerid"));
        memberInfo.setName(rootObject.optString("name"));
        memberInfo.setGpn(rootObject.optString("gpn"));
        memberInfo.setGender(Gender.values()[rootObject.optInt("gender", 0)]);
        memberInfo.setMessage(rootObject.optString("message"));
        memberInfo.setAvatarId(rootObject.optString("avatarid", "0"));
        memberInfo.setPhoneCountry(rootObject.optString("phoneCountry", ""));
        memberInfo.setBalance(rootObject.optString("balance"));
        memberInfo.setLastBouns(rootObject.optString("lastBouns"));
        memberInfo.setLastRakeback(rootObject.optString("lastRakeback"));
        memberInfo.setUserPreferLanguage(rootObject.optString("userpreferlanguage"));
        memberInfo.setWhatsapp(rootObject.optString("whatsapp"));
        memberInfo.setTelegram(rootObject.optString("telegram"));
        memberInfo.setZalo(rootObject.optString("zalo"));
        memberInfo.setFacebook(rootObject.optString("facebook"));
        memberInfo.setPan(rootObject.optString("pan"));
        memberInfo.setLine(rootObject.optString("line"));
        memberInfo.setAgentCode(rootObject.optString("agentcode"));
        memberInfo.setSkype(rootObject.optString("skype"));
        memberInfo.setTncStatus(rootObject.optString("tncStatus"));
        memberInfo.setRankLevel(rootObject.optString("rankLevel"));
        memberInfo.setPreferContactType(rootObject.optString("prefercontact_type"));
        memberInfo.setRedirectLink(rootObject.optString("redirectlink"));
        memberInfo.setHasWithdrawPassword(rootObject.optString("haswithdrawpassword").equalsIgnoreCase("ON"));
        memberInfo.setGroupName(rootObject.optString("group_name"));
        memberInfo.setMemberVipLevelNameCn(rootObject.optString("memberVipLevelNameCn"));
        memberInfo.setMemberVipLevelNameEn(rootObject.optString("memberVipLevelNameEn"));
        memberInfo.setDisplayGroupName(rootObject.optString("display_group_name"));
        memberInfo.setIsDisplayGroupName(rootObject.optString("is_display_group_name").equalsIgnoreCase("1"));
        memberInfo.setMobileVerified(rootObject.optString("mobileverification").equalsIgnoreCase("1"));
        memberInfo.setEmailVerified(rootObject.optString("emailverification").equalsIgnoreCase("1"));
        memberInfo.setForceChangePw(rootObject.optString("forceChangePw").equalsIgnoreCase("1"));
        memberInfo.setRealNameSeparated(rootObject.optBoolean("isRealNameSeparated", false));
        memberInfo.setPanStatus(rootObject.optString("pan_status", "0").equalsIgnoreCase("1"));
        memberInfo.setPanDuplicateUUID(rootObject.optBoolean("panDuplicateUUID", false));
        memberInfo.setPanDuplicateIP(rootObject.optBoolean("panDuplicateIP", false));
        memberInfo.setGroupId(rootObject.optString("groupid"));
        memberInfo.setWithdrawFrozenAmount(rootObject.optString("wtdfrozenamt"));
        memberInfo.setEnablePhoneRecall(rootObject.optBoolean("enablePhoneRecall", false));
        memberInfo.setMemberPanAgentCode(rootObject.optBoolean("memberPanAgentCode", false));
        memberInfo.setMemberPanPlayerGroup(rootObject.optBoolean("memberPanPlayerGroup", false));
        memberInfo.setMemberPanUsername(rootObject.optBoolean("memberPanUsername", false));
        memberInfo.setDisplayAddress(rootObject.optBoolean("displayAddress", false));
        memberInfo.setWithdrawBindAddress(rootObject.optBoolean("withdrawBindAddress", false));
        memberInfo.setHasDeposit(rootObject.optBoolean("hasDeposit", false));
        memberInfo.setPlayerCurrency(rootObject.optString("playerCurrency"));
        memberInfo.setAddress(rootObject.optString("address"));
        memberInfo.setShortenLink(rootObject.optString("shortenlink"));

        JSONObject verifyremaincountJSON = rootObject.optJSONObject("verifyremaincount");
        if (verifyremaincountJSON != null) {
            memberInfo.setVerifyRemainCountSms(verifyremaincountJSON.optInt("sms"));
            memberInfo.setVerifyRemainCountEmail(verifyremaincountJSON.optInt("email"));
        }

        JSONArray currencyJSONArray = rootObject.optJSONArray("currencyList");
        ArrayList<String> currencyList = new ArrayList<>();
        if (currencyJSONArray != null) {
            for (int i = 0; i < currencyJSONArray.length(); i++) {
                currencyList.add(currencyJSONArray.optString(i));
            }
        }
        memberInfo.setCurrencyList(currencyList);

        JSONArray currencyBalancesJSONArray = rootObject.optJSONArray("currencyBalances");
        ArrayList<CurrencyBalance> currencyBalancesList = new ArrayList<>();
        if (currencyBalancesJSONArray != null) {
            for (int i = 0; i < currencyBalancesJSONArray.length(); i++) {
                currencyBalancesList.add(CurrencyBalance.newInstance(currencyBalancesJSONArray.optJSONObject(i)));
            }
        }
        memberInfo.setCurrencyBalanceList(currencyBalancesList);
        return memberInfo;
    }

    public static MemberInfo newInstanceFromWebapi(JSONObject rootObject) {
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setRegDate(rootObject.optString("regDate"));
        memberInfo.setJoinDays(rootObject.optString("joinDays"));
        memberInfo.setPlayerName(rootObject.optString("playerName"));
        memberInfo.setRealName(rootObject.optString("realName"));
        memberInfo.setBirthday(rootObject.optString("birthday"));
        memberInfo.setEmail(rootObject.optString("email"));
        memberInfo.setWeixin(rootObject.optString("weixin"));
        memberInfo.setPhone(rootObject.optString("phone"));
        memberInfo.setQq(rootObject.optString("qq"));
        memberInfo.setPlayerId(rootObject.optString("playerId"));
        memberInfo.setName(rootObject.optString("name"));
        memberInfo.setGpn(rootObject.optString("gpn"));
        memberInfo.setGender(Gender.values()[rootObject.optInt("gender", 0)]);
        memberInfo.setMessage(rootObject.optString("message"));
        memberInfo.setAvatarId(rootObject.optString("avatarId", "0"));
        memberInfo.setPhoneCountry(rootObject.optString("phoneCountry", ""));
        memberInfo.setBalance(rootObject.optString("balance"));
        memberInfo.setLastBouns(rootObject.optString("lastBonus"));
        memberInfo.setLastRakeback(rootObject.optString("lastRakeback"));
        memberInfo.setUserPreferLanguage(rootObject.optString("userPreferLanguage"));
        memberInfo.setWhatsapp(rootObject.optString("whatsapp"));
        memberInfo.setTelegram(rootObject.optString("telegram"));
        memberInfo.setZalo(rootObject.optString("zalo"));
        memberInfo.setFacebook(rootObject.optString("facebook"));
        memberInfo.setPan(rootObject.optString("pan"));
        memberInfo.setLine(rootObject.optString("line"));
        memberInfo.setAgentCode(rootObject.optString("agentCode"));
        memberInfo.setSkype(rootObject.optString("skype"));
        memberInfo.setTncStatus(rootObject.optString("tncStatus"));
        memberInfo.setRankLevel(rootObject.optString("rankLevel"));
        memberInfo.setPreferContactType(rootObject.optString("prefercontact_type"));
        memberInfo.setRedirectLink(rootObject.optString("redirectlink"));
        memberInfo.setHasWithdrawPassword(rootObject.optBoolean("hasWithdrawPassword"));
        memberInfo.setGroupName(rootObject.optString("group_name"));
        memberInfo.setDisplayGroupName(rootObject.optString("displayGroupName"));
        memberInfo.setMemberVipLevelNameCn(rootObject.optString("memberVipLevelNameCn"));
        memberInfo.setMemberVipLevelNameEn(rootObject.optString("memberVipLevelNameEn"));
        memberInfo.setIsDisplayGroupName(rootObject.optBoolean("isDisplayGroupName"));
        memberInfo.setMobileVerified(rootObject.optString("phoneVerification").equalsIgnoreCase("1"));
        memberInfo.setEmailVerified(rootObject.optString("emailVerification").equalsIgnoreCase("1"));
        memberInfo.setForceChangePw(rootObject.optBoolean("forceChangePwd"));
        memberInfo.setRealNameSeparated(rootObject.optBoolean("isRealNameSeparated", false));
        memberInfo.setPanStatus(rootObject.optString("panStatus", "0").equalsIgnoreCase("1"));
        memberInfo.setPanDuplicateUUID(rootObject.optBoolean("panDuplicateUUID", false));
        memberInfo.setPanDuplicateIP(rootObject.optBoolean("panDuplicateIP", false));
        memberInfo.setGroupId(rootObject.optString("groupId"));
        memberInfo.setWithdrawFrozenAmount(rootObject.optString("wtdFrozenAmt"));
        memberInfo.setEnablePhoneRecall(rootObject.optBoolean("enablePhoneRecall", false));
        memberInfo.setMemberPanAgentCode(rootObject.optBoolean("memberPanAgentCode", false));
        memberInfo.setMemberPanPlayerGroup(rootObject.optBoolean("memberPanPlayerGroup", false));
        memberInfo.setMemberPanUsername(rootObject.optBoolean("memberPanUsername", false));
        memberInfo.setDisplayAddress(rootObject.optBoolean("displayAddress", false));
        memberInfo.setWithdrawBindAddress(rootObject.optBoolean("withdrawBindAddress", false));
        memberInfo.setHasDeposit(rootObject.optBoolean("hasDeposit", false));
        memberInfo.setPlayerCurrency(rootObject.optString("playerCurrency"));
        memberInfo.setAddress(rootObject.optString("address"));
        memberInfo.setShortenLink(rootObject.optString("shortenLink"));

        JSONObject prefercontactJSON = rootObject.optJSONObject("prefercontact");
        if (prefercontactJSON != null) {
            memberInfo.setPreferContactPhone(prefercontactJSON.optBoolean("phone"));
            memberInfo.setPreferContactSms(prefercontactJSON.optBoolean("sms"));
            memberInfo.setPreferContactEmail(prefercontactJSON.optBoolean("email"));
        }

        JSONObject verifyremaincountJSON = rootObject.optJSONObject("verifyremaincount");
        if (verifyremaincountJSON != null) {
            memberInfo.setVerifyRemainCountSms(verifyremaincountJSON.optInt("sms"));
            memberInfo.setVerifyRemainCountEmail(verifyremaincountJSON.optInt("email"));
        }

        JSONArray currencyJSONArray = rootObject.optJSONArray("currencyList");
        ArrayList<String> currencyList = new ArrayList<>();
        if (currencyJSONArray != null) {
            for (int i = 0; i < currencyJSONArray.length(); i++) {
                currencyList.add(currencyJSONArray.optString(i));
            }
        }
        memberInfo.setCurrencyList(currencyList);

        JSONArray currencyBalancesJSONArray = rootObject.optJSONArray("currencyBalances");
        ArrayList<CurrencyBalance> currencyBalancesList = new ArrayList<>();
        if (currencyBalancesJSONArray != null) {
            for (int i = 0; i < currencyBalancesJSONArray.length(); i++) {
                currencyBalancesList.add(CurrencyBalance.newInstance(currencyBalancesJSONArray.optJSONObject(i)));
            }
        }
        memberInfo.setCurrencyBalanceList(currencyBalancesList);
        return memberInfo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getJoinDays() {
        return joinDays;
    }

    public void setJoinDays(String joinDays) {
        this.joinDays = joinDays;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public String getPhoneCountry() {
        return phoneCountry;
    }

    public void setPhoneCountry(String phoneCountry) {
        this.phoneCountry = phoneCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGpn() {
        return gpn;
    }

    public void setGpn(String gpn) {
        this.gpn = gpn;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public boolean hasWdPassword() {
        return hasWithdrawPassword;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getLastBouns() {
        return lastBouns;
    }

    public void setLastBouns(String lastBouns) {
        this.lastBouns = lastBouns;
    }

    public String getLastRakeback() {
        return lastRakeback;
    }

    public void setLastRakeback(String lastRakeback) {
        this.lastRakeback = lastRakeback;
    }

    public String getUserPreferLanguage() {
        return userPreferLanguage;
    }

    public void setUserPreferLanguage(String userPreferLanguage) {
        this.userPreferLanguage = userPreferLanguage;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public boolean isHasWithdrawPassword() {
        return hasWithdrawPassword;
    }

    public void setHasWithdrawPassword(boolean hasWithdrawPassword) {
        this.hasWithdrawPassword = hasWithdrawPassword;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMemberVipLevelNameCn() {
        return memberVipLevelNameCn;
    }

    public void setMemberVipLevelNameCn(String memberVipLevelNameCn) {
        this.memberVipLevelNameCn = memberVipLevelNameCn;
    }

    public String getMemberVipLevelNameEn() {
        return memberVipLevelNameEn;
    }

    public void setMemberVipLevelNameEn(String memberVipLevelNameEn) {
        this.memberVipLevelNameEn = memberVipLevelNameEn;
    }

    public String getDisplayGroupName() {
        return displayGroupName;
    }

    public boolean isDisplayGroupName() {
        return isDisplayGroupName;
    }

    public void setDisplayGroupName(String displayGroupName) {
        this.displayGroupName = displayGroupName;
    }

    public void setIsDisplayGroupName(boolean displayGroupName) {
        isDisplayGroupName = displayGroupName;
    }

    public boolean isForceChangePw() {
        return forceChangePw;
    }

    public void setForceChangePw(boolean forceChangePw) {
        this.forceChangePw = forceChangePw;
    }

    public String getWithdrawFrozenAmount() {
        return withdrawFrozenAmount;
    }

    public void setWithdrawFrozenAmount(String withdrawFrozenAmount) {
        this.withdrawFrozenAmount = withdrawFrozenAmount;
    }

    public boolean isMobileVerified() {
        return isMobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        isMobileVerified = mobileVerified;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public boolean isRealNameSeparated() {
        return isRealNameSeparated;
    }

    public void setRealNameSeparated(boolean realNameSeparated) {
        isRealNameSeparated = realNameSeparated;
    }

    public boolean isPanStatus() {
        return panStatus;
    }

    public void setPanStatus(boolean panStatus) {
        this.panStatus = panStatus;
    }

    public boolean isPanDuplicateUUID() {
        return panDuplicateUUID;
    }

    public void setPanDuplicateUUID(boolean panDuplicateUUID) {
        this.panDuplicateUUID = panDuplicateUUID;
    }

    public boolean isPanDuplicateIP() {
        return panDuplicateIP;
    }

    public void setPanDuplicateIP(boolean panDuplicateIP) {
        this.panDuplicateIP = panDuplicateIP;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getZalo() {
        return zalo;
    }

    public void setZalo(String zalo) {
        this.zalo = zalo;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getTncStatus() {
        return tncStatus;
    }

    public void setTncStatus(String tncStatus) {
        this.tncStatus = tncStatus;
    }

    public String getRankLevel() {
        return rankLevel;
    }

    public void setRankLevel(String rankLevel) {
        this.rankLevel = rankLevel;
    }

    public String getPreferContactType() {
        return preferContactType;
    }

    public void setPreferContactType(String preferContactType) {
        this.preferContactType = preferContactType;
    }

    public String getRedirectLink() {
        return redirectLink;
    }

    public void setRedirectLink(String redirectLink) {
        this.redirectLink = redirectLink;
    }

    public boolean isEnablePhoneRecall() {
        return enablePhoneRecall;
    }

    public void setEnablePhoneRecall(boolean enablePhoneRecall) {
        this.enablePhoneRecall = enablePhoneRecall;
    }

    public boolean isMemberPanAgentCode() {
        return memberPanAgentCode;
    }

    public void setMemberPanAgentCode(boolean memberPanAgentCode) {
        this.memberPanAgentCode = memberPanAgentCode;
    }

    public boolean isMemberPanPlayerGroup() {
        return memberPanPlayerGroup;
    }

    public void setMemberPanPlayerGroup(boolean memberPanPlayerGroup) {
        this.memberPanPlayerGroup = memberPanPlayerGroup;
    }

    public boolean isMemberPanUsername() {
        return memberPanUsername;
    }

    public void setMemberPanUsername(boolean memberPanUsername) {
        this.memberPanUsername = memberPanUsername;
    }

    public boolean isDisplayAddress() {
        return displayAddress;
    }

    public MemberInfo setDisplayAddress(boolean displayAddress) {
        this.displayAddress = displayAddress;
        return this;
    }

    public boolean isWithdrawBindAddress() {
        return withdrawBindAddress;
    }

    public MemberInfo setWithdrawBindAddress(boolean withdrawBindAddress) {
        this.withdrawBindAddress = withdrawBindAddress;
        return this;
    }

    public boolean isPreferContactPhone() {
        return preferContactPhone;
    }

    public void setPreferContactPhone(boolean preferContactPhone) {
        this.preferContactPhone = preferContactPhone;
    }

    public boolean isPreferContactSms() {
        return preferContactSms;
    }

    public void setPreferContactSms(boolean preferContactSms) {
        this.preferContactSms = preferContactSms;
    }

    public boolean isPreferContactEmail() {
        return preferContactEmail;
    }

    public void setPreferContactEmail(boolean preferContactEmail) {
        this.preferContactEmail = preferContactEmail;
    }

    public boolean isHasDeposit() {
        return hasDeposit;
    }

    public void setHasDeposit(boolean hasDeposit) {
        this.hasDeposit = hasDeposit;
    }

    public String getPlayerCurrency() {
        return playerCurrency;
    }

    public void setPlayerCurrency(String playerCurrency) {
        this.playerCurrency = playerCurrency;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShortenLink() {
        return shortenLink;
    }

    public void setShortenLink(String shortenLink) {
        this.shortenLink = shortenLink;
    }

    public ArrayList<String> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(ArrayList<String> currencyList) {
        this.currencyList = currencyList;
    }

    public ArrayList<CurrencyBalance> getCurrencyBalanceList() {
        return currencyBalanceList;
    }

    public void setCurrencyBalanceList(ArrayList<CurrencyBalance> currencyBalanceList) {
        this.currencyBalanceList = currencyBalanceList;
    }

    public int getVerifyRemainCountSms() {
        return verifyRemainCountSms;
    }

    public void setVerifyRemainCountSms(int verifyRemainCountSms) {
        this.verifyRemainCountSms = verifyRemainCountSms;
    }

    public int getVerifyRemainCountEmail() {
        return verifyRemainCountEmail;
    }

    public void setVerifyRemainCountEmail(int verifyRemainCountEmail) {
        this.verifyRemainCountEmail = verifyRemainCountEmail;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(regDate);
        dest.writeString(joinDays);
        dest.writeString(playerName);
        dest.writeString(realName);
        dest.writeString(birthday);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(weixin);
        dest.writeString(qq);
        dest.writeString(playerId);
        dest.writeString(name);
        dest.writeString(gpn);
        dest.writeInt(gender.ordinal());
        dest.writeString(message);
        dest.writeString(avatarId);
        dest.writeString(phoneCountry);
        dest.writeString(balance);
        dest.writeString(lastBouns);
        dest.writeString(lastRakeback);
        dest.writeString(userPreferLanguage);
        dest.writeString(whatsapp);
        dest.writeString(telegram);
        dest.writeString(line);
        dest.writeString(agentCode);
        dest.writeString(skype);
        dest.writeString(tncStatus);
        dest.writeString(rankLevel);
        dest.writeString(preferContactType);
        dest.writeString(redirectLink);
        dest.writeInt(hasWithdrawPassword ? 1 : 0);
        dest.writeString(groupName);
        dest.writeString(displayGroupName);
        dest.writeString(memberVipLevelNameCn);
        dest.writeString(memberVipLevelNameEn);
        dest.writeInt(isDisplayGroupName ? 1 : 0);
        dest.writeInt(isMobileVerified ? 1 : 0);
        dest.writeInt(isEmailVerified ? 1 : 0);
        dest.writeInt(forceChangePw ? 1 : 0);
        dest.writeInt(isRealNameSeparated ? 1 : 0);
        dest.writeInt(panStatus ? 1 : 0);
        dest.writeInt(panDuplicateUUID ? 1 : 0);
        dest.writeInt(panDuplicateIP ? 1 : 0);
        dest.writeString(groupId);
        dest.writeString(withdrawFrozenAmount);
        dest.writeString(zalo);
        dest.writeString(facebook);
        dest.writeString(pan);
        dest.writeInt(enablePhoneRecall ? 1 : 0);
        dest.writeInt(memberPanAgentCode ? 1 : 0);
        dest.writeInt(memberPanPlayerGroup ? 1 : 0);
        dest.writeInt(memberPanUsername ? 1 : 0);
        dest.writeInt(displayAddress ? 1 : 0);
        dest.writeInt(withdrawBindAddress ? 1 : 0);
        dest.writeInt(preferContactPhone ? 1 : 0);
        dest.writeInt(preferContactSms ? 1 : 0);
        dest.writeInt(preferContactEmail ? 1 : 0);
        dest.writeInt(hasDeposit ? 1 : 0);
        dest.writeString(playerCurrency);
        dest.writeString(address);
        dest.writeString(shortenLink);
        dest.writeInt(verifyRemainCountSms);
        dest.writeInt(verifyRemainCountEmail);
        dest.writeArray(new Object[]{
                currencyList,
                currencyBalanceList
        });

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "regDate='" + regDate + '\'' +
                ", joinDays='" + joinDays + '\'' +
                ", playerName='" + playerName + '\'' +
                ", realName='" + realName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", weixin='" + weixin + '\'' +
                ", qq='" + qq + '\'' +
                ", playerId='" + playerId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", message='" + message + '\'' +
                ", avatarId='" + avatarId + '\'' +
                ", phoneCountry='" + phoneCountry + '\'' +
                ", balance='" + balance + '\'' +
                ", lastBouns='" + lastBouns + '\'' +
                ", lastRakeback='" + lastRakeback + '\'' +
                ", hasWithdrawPassword=" + hasWithdrawPassword +
                ", displayGroupName='" + displayGroupName + '\'' +
                ", isDisplayGroupName=" + isDisplayGroupName + '\'' +
                ", isMobileVerified=" + isMobileVerified + '\'' +
                ", isEmailVerified=" + isEmailVerified + '\'' +
                ", forceChangePw=" + forceChangePw + '\'' +
                ", withdrawFrozenAmount=" + withdrawFrozenAmount +

                '}';
    }

    public enum Gender {
        PRIVATE, MALE, FEMALE
    }
}
