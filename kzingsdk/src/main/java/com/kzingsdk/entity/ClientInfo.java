package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ClientInfo implements Parcelable {

    public static final int USE_ACTIVITYS_BANNER = 1;
    public static final int USE_CLIENTINFO_BANNER = 2;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ClientInfo createFromParcel(Parcel in) {
            return new ClientInfo(in);
        }

        public ClientInfo[] newArray(int size) {
            return new ClientInfo[size];
        }
    };
    private String siteName;
    private String siteDomain;
    private String siteId;
    private String siteLogoBig;
    private String siteLogoSmall;
    private String siteLogoSimple;
    private String support;
    private String announcement;
    private boolean allowUserEditProfile;
    private boolean hasRedPocket;
    private String redPocketImageUrl;
    private int useBanner = USE_ACTIVITYS_BANNER;
    private ArrayList<String> bannerList = new ArrayList<>();
    private ArrayList<String> bannerCountdownList = new ArrayList<>();
    private ArrayList<String> bannerFirstLaunchList = new ArrayList<>();
    private HashMap<String, ThemeInfo> clientThemeMap;
    private String defaultViewMode;
    private boolean allowSendEmail;
    private boolean allowSendSms;
    private boolean shouldCheckMobileVerified;
    private boolean shouldCheckEmailVerified;
    private boolean registerMobileVerify;
    private boolean withdrawalMobileVerify;
    private String mobilePopUp;
    private boolean isWdpasswordOn;
    private boolean allowUploadDepositCredential;
    private boolean hasGameTransferPopup;
    private boolean hasFriendPromo;
    private boolean canCancelWithdrawal;
    private boolean initWdPwdNeedLoginPwd;
    private String rankLevel;

    private HashMap<Integer, String> websiteConfigMap = new HashMap<>();
    private ContactInfo feedbackContactInfo = new ContactInfo();
    private ContactInfo partnershipContactInfo = new ContactInfo();
    private ContactInfo socialMediaContactInfo = new ContactInfo();

    public ClientInfo() {

    }

    public static ClientInfo newInstance(JSONObject rootObject) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setSiteId(rootObject.optString("siteid"));
        clientInfo.setSiteDomain(rootObject.optString("domainname"));
        clientInfo.setSiteLogoBig(rootObject.optString("sitelogob"));
        clientInfo.setSiteLogoSmall(rootObject.optString("sitelogos"));
        clientInfo.setSiteName(rootObject.optString("sitename"));
        clientInfo.setSiteLogoSimple(rootObject.optString("sitelogosimple"));
        clientInfo.setSupport(rootObject.optString("support").trim());
        clientInfo.setAnnouncement(rootObject.optString("announcement"));
        clientInfo.setUseBanner(rootObject.optInt("use_banner", USE_CLIENTINFO_BANNER));
        clientInfo.setAllowUserEditProfile(rootObject.optString("allowUserEditProfile").equals("1"));
        clientInfo.setHasRedPocket(rootObject.optString("hasRedPocket").equals("1"));
        clientInfo.setRedPocketImageUrl(rootObject.optString("redPocketImageUrl"));
        clientInfo.setAllowSendEmail(rootObject.optString("allowSendEmail").equalsIgnoreCase("ON"));
        clientInfo.setAllowSendSms(rootObject.optString("allowSendSms").equalsIgnoreCase("ON"));
        clientInfo.setShouldCheckMobileVerified(rootObject.optString("checkmobileverified").equalsIgnoreCase("ON"));
        clientInfo.setShouldCheckEmailVerified(rootObject.optString("checkemailverified").equalsIgnoreCase("ON"));
        clientInfo.setRegisterMobileVerify(rootObject.optString("registerMobileVerify").equalsIgnoreCase("ON"));
        clientInfo.setWithdrawalMobileVerify(rootObject.optString("withdrawalMobileVerify").equalsIgnoreCase("ON"));
        clientInfo.setAllowUploadDepositCredential(rootObject.optString("allowUploadDepositCredential").equalsIgnoreCase("ON"));
        clientInfo.setMobilePopUp(rootObject.optString("mobilePopUp"));
        clientInfo.setWdpasswordOn(rootObject.optString("isWdpasswordOn").equals("ON"));
        clientInfo.setHasGameTransferPopup(rootObject.optString("gametransferpopup").equals("ON"));
        clientInfo.setHasFriendPromo(rootObject.optBoolean("hasFriendPromo", false));
        clientInfo.setCanCancelWithdrawal(rootObject.optBoolean("canCancelWithdrawal", false));
        clientInfo.setInitWdPwdNeedLoginPwd(rootObject.optBoolean("initWdPwdNeedLoginPwd", false));
        clientInfo.setRankLevel(rootObject.optString("rankLevel"));

        for (int i = 301; i < 400; i++) {
            clientInfo.websiteConfigMap.put(i, rootObject.optString("wc" + i));
        }
        JSONArray bannerJSONArray = rootObject.optJSONArray("bannerList");
        ArrayList<String> bannerList = new ArrayList<>();
        if (bannerJSONArray != null) {
            for (int i = 0; i < bannerJSONArray.length(); i++) {
                bannerList.add(bannerJSONArray.optString(i));
            }
        }
        clientInfo.setBannerList(bannerList);
        JSONArray bannerCountdownJSONArray = rootObject.optJSONArray("bannerCountdown");
        ArrayList<String> bannerCountdownList = new ArrayList<>();
        if (bannerCountdownJSONArray != null) {
            for (int i = 0; i < bannerCountdownJSONArray.length(); i++) {
                bannerCountdownList.add(bannerCountdownJSONArray.optString(i));
            }
        }
        clientInfo.setBannerCountdownList(bannerCountdownList);
        JSONArray bannerFirstLaunchJSONArray = rootObject.optJSONArray("bannerFirstLaunch");
        ArrayList<String> bannerFirstLaunchList = new ArrayList<>();
        if (bannerFirstLaunchJSONArray != null) {
            for (int i = 0; i < bannerFirstLaunchJSONArray.length(); i++) {
                bannerFirstLaunchList.add(bannerFirstLaunchJSONArray.optString(i));
            }
        }
        clientInfo.setBannerFirstLaunchList(bannerFirstLaunchList);
        JSONArray clientThemeJSONArray = rootObject.optJSONArray("clientTheme");
        HashMap<String, ThemeInfo> clientThemeMap = new HashMap<>();
        if (clientThemeJSONArray != null) {
            for (int i = 0; i < clientThemeJSONArray.length(); i++) {
                ThemeInfo themeInfo = ThemeInfo.newInstance(clientThemeJSONArray.optJSONObject(i));
                clientThemeMap.put(themeInfo.getColorId(), themeInfo);
            }
        }
        clientInfo.setClientThemeMap(clientThemeMap);
        clientInfo.setDefaultViewMode(rootObject.optString("viewMode"));

        JSONObject contactInfoJSONObject = rootObject.optJSONObject("contactInfo");
        if (contactInfoJSONObject != null) {
            JSONObject feedbackJSONObject = contactInfoJSONObject.optJSONObject("feedback");
            JSONObject partnershipJSONObject = contactInfoJSONObject.optJSONObject("partnership");
            JSONObject socialMediaJSONObject = contactInfoJSONObject.optJSONObject("socialMedia");
            if (feedbackJSONObject != null) {
                clientInfo.setFeedbackContactInfo(ContactInfo.newInstance(feedbackJSONObject));
            }
            if (partnershipJSONObject != null) {
                clientInfo.setPartnershipContactInfo(ContactInfo.newInstance(partnershipJSONObject));
            }
            if (socialMediaJSONObject != null) {
                clientInfo.setSocialMediaContactInfo(ContactInfo.newInstance(socialMediaJSONObject));
            }
        }

        return clientInfo;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteLogoBig() {
        return siteLogoBig;
    }

    public void setSiteLogoBig(String siteLogoBig) {
        this.siteLogoBig = siteLogoBig;
    }

    public String getSiteLogoSmall() {
        return siteLogoSmall;
    }

    public void setSiteLogoSmall(String siteLogoSmall) {
        this.siteLogoSmall = siteLogoSmall;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getSiteLogoSimple() {
        return siteLogoSimple;
    }

    public void setSiteLogoSimple(String siteLogoSimple) {
        this.siteLogoSimple = siteLogoSimple;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getSiteDomain() {
        return siteDomain;
    }

    public void setSiteDomain(String siteDomain) {
        this.siteDomain = siteDomain;
    }

    public int getUseBanner() {
        return useBanner;
    }

    public void setUseBanner(int useBanner) {
        this.useBanner = useBanner;
    }

    public ArrayList<String> getBannerList() {
        return bannerList;
    }

    public void setBannerList(ArrayList<String> bannerList) {
        this.bannerList = bannerList;
    }

    public boolean isAllowUserEditProfile() {
        return allowUserEditProfile;
    }

    public void setAllowUserEditProfile(boolean allowUserEditProfile) {
        this.allowUserEditProfile = allowUserEditProfile;
    }

    public boolean hasRedPocket() {
        return hasRedPocket;
    }

    public void setHasRedPocket(boolean hasRedPocket) {
        this.hasRedPocket = hasRedPocket;
    }

    public String getRedPocketImageUrl() {
        return redPocketImageUrl;
    }

    public void setRedPocketImageUrl(String redPocketImageUrl) {
        this.redPocketImageUrl = redPocketImageUrl;
    }

    public HashMap<String, ThemeInfo> getClientThemeMap() {
        return clientThemeMap;
    }

    public void setClientThemeMap(HashMap<String, ThemeInfo> clientThemeMap) {
        this.clientThemeMap = clientThemeMap;
    }

    public String getDefaultViewMode() {
        return defaultViewMode;
    }

    public void setDefaultViewMode(String defaultViewMode) {
        this.defaultViewMode = defaultViewMode;
    }

    public String getMobilePopUp() {
        return mobilePopUp;
    }

    public void setMobilePopUp(String mobilePopUp) {
        this.mobilePopUp = mobilePopUp;
    }

    public boolean isWdpasswordOn() {
        return isWdpasswordOn;
    }

    public void setWdpasswordOn(boolean wdpasswordOn) {
        isWdpasswordOn = wdpasswordOn;
    }

    public boolean isHasGameTransferPopup() {
        return hasGameTransferPopup;
    }

    public void setHasGameTransferPopup(boolean hasGameTransferPopup) {
        this.hasGameTransferPopup = hasGameTransferPopup;
    }

    public boolean isAllowSendEmail() {
        return allowSendEmail;
    }

    public void setAllowSendEmail(boolean allowSendEmail) {
        this.allowSendEmail = allowSendEmail;
    }

    public boolean isAllowSendSms() {
        return allowSendSms;
    }

    public void setAllowSendSms(boolean allowSendSms) {
        this.allowSendSms = allowSendSms;
    }

    public boolean isRegisterMobileVerify() {
        return registerMobileVerify;
    }

    public void setRegisterMobileVerify(boolean registerMobileVerify) {
        this.registerMobileVerify = registerMobileVerify;
    }

    public boolean isWithdrawalMobileVerify() {
        return withdrawalMobileVerify;
    }

    public void setWithdrawalMobileVerify(boolean withdrawalMobileVerify) {
        this.withdrawalMobileVerify = withdrawalMobileVerify;
    }


    public boolean hasFriendPromo() {
        return hasFriendPromo;
    }

    public void setHasFriendPromo(boolean hasFriendPromo) {
        this.hasFriendPromo = hasFriendPromo;
    }

    public boolean isShouldCheckMobileVerified() {
        return shouldCheckMobileVerified;
    }

    public void setShouldCheckMobileVerified(boolean shouldCheckMobileVerified) {
        this.shouldCheckMobileVerified = shouldCheckMobileVerified;
    }

    public boolean isShouldCheckEmailVerified() {
        return shouldCheckEmailVerified;
    }

    public void setShouldCheckEmailVerified(boolean shouldCheckEmailVerified) {
        this.shouldCheckEmailVerified = shouldCheckEmailVerified;
    }

    public boolean isAllowUploadDepositCredential() {
        return allowUploadDepositCredential;
    }

    public void setAllowUploadDepositCredential(boolean allowUploadDepositCredential) {
        this.allowUploadDepositCredential = allowUploadDepositCredential;
    }

    public boolean canCancelWithdrawal() {
        return canCancelWithdrawal;
    }

    public void setCanCancelWithdrawal(boolean canCancelWithdrawal) {
        this.canCancelWithdrawal = canCancelWithdrawal;
    }

    public boolean isInitWdPwdNeedLoginPwd() {
        return initWdPwdNeedLoginPwd;
    }

    public void setInitWdPwdNeedLoginPwd(boolean initWdPwdNeedLoginPwd) {
        this.initWdPwdNeedLoginPwd = initWdPwdNeedLoginPwd;
    }

    public ArrayList<String> getBannerCountdownList() {
        return bannerCountdownList;
    }

    public void setBannerCountdownList(ArrayList<String> bannerCountdownList) {
        this.bannerCountdownList = bannerCountdownList;
    }

    public ArrayList<String> getBannerFirstLaunchList() {
        return bannerFirstLaunchList;
    }

    public void setBannerFirstLaunchList(ArrayList<String> bannerFirstLaunchList) {
        this.bannerFirstLaunchList = bannerFirstLaunchList;
    }

    public String getWebsiteConfig(Integer configCode) {
        return websiteConfigMap.get(configCode);
    }

    public String getRankLevel() {
        return rankLevel;
    }

    public void setRankLevel(String rankLevel) {
        this.rankLevel = rankLevel;
    }

    public ContactInfo getFeedbackContactInfo() {
        return feedbackContactInfo;
    }

    public void setFeedbackContactInfo(ContactInfo feedbackContactInfo) {
        this.feedbackContactInfo = feedbackContactInfo;
    }

    public ContactInfo getPartnershipContactInfo() {
        return partnershipContactInfo;
    }

    public void setPartnershipContactInfo(ContactInfo partnershipContactInfo) {
        this.partnershipContactInfo = partnershipContactInfo;
    }

    public ContactInfo getSocialMediaContactInfo() {
        return socialMediaContactInfo;
    }

    public void setSocialMediaContactInfo(ContactInfo socialMediaContactInfo) {
        this.socialMediaContactInfo = socialMediaContactInfo;
    }

    public ClientInfo(Parcel in) {
        siteName = in.readString();
        siteDomain = in.readString();
        siteId = in.readString();
        siteLogoBig = in.readString();
        siteLogoSmall = in.readString();
        siteLogoSimple = in.readString();
        support = in.readString();
        announcement = in.readString();
        useBanner = in.readInt();
        Object[] objectArray = in.readArray(ClientInfo.class.getClassLoader());
        bannerList = (ArrayList<String>) objectArray[0];
        clientThemeMap = (HashMap<String, ThemeInfo>) objectArray[1];
        websiteConfigMap = (HashMap<Integer, String>) objectArray[2];
        bannerCountdownList = (ArrayList<String>) objectArray[3];
        bannerFirstLaunchList = (ArrayList<String>) objectArray[4];
        feedbackContactInfo = (ContactInfo) objectArray[5];
        partnershipContactInfo = (ContactInfo) objectArray[6];
        socialMediaContactInfo = (ContactInfo) objectArray[7];
        hasRedPocket = in.readInt() == 1;
        redPocketImageUrl = in.readString();
        defaultViewMode = in.readString();
        mobilePopUp = in.readString();
        isWdpasswordOn = in.readInt() == 1;
        allowSendEmail = in.readInt() == 1;
        allowSendSms = in.readInt() == 1;
        registerMobileVerify = in.readInt() == 1;
        withdrawalMobileVerify = in.readInt() == 1;
        shouldCheckMobileVerified = in.readInt() == 1;
        shouldCheckEmailVerified = in.readInt() == 1;
        allowUploadDepositCredential = in.readInt() == 1;
        hasGameTransferPopup = in.readInt() == 1;
        hasFriendPromo = in.readInt() == 1;
        canCancelWithdrawal = in.readInt() == 1;
        initWdPwdNeedLoginPwd = in.readInt() == 1;
        rankLevel = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(siteName);
        dest.writeString(siteDomain);
        dest.writeString(siteId);
        dest.writeString(siteLogoBig);
        dest.writeString(siteLogoSmall);
        dest.writeString(siteLogoSimple);
        dest.writeString(support);
        dest.writeString(announcement);
        dest.writeInt(useBanner);
        dest.writeArray(new Object[]{
                bannerList,
                clientThemeMap,
                websiteConfigMap,
                bannerCountdownList,
                bannerFirstLaunchList,
                feedbackContactInfo,
                partnershipContactInfo,
                socialMediaContactInfo
        });
        dest.writeInt(hasRedPocket ? 1 : 0);
        dest.writeString(redPocketImageUrl);
        dest.writeString(defaultViewMode);
        dest.writeString(mobilePopUp);
        dest.writeInt(isWdpasswordOn ? 1 : 0);
        dest.writeInt(allowSendEmail ? 1 : 0);
        dest.writeInt(allowSendSms ? 1 : 0);
        dest.writeInt(registerMobileVerify ? 1 : 0);
        dest.writeInt(withdrawalMobileVerify ? 1 : 0);
        dest.writeInt(shouldCheckMobileVerified ? 1 : 0);
        dest.writeInt(shouldCheckEmailVerified ? 1 : 0);
        dest.writeInt(allowUploadDepositCredential ? 1 : 0);
        dest.writeInt(hasGameTransferPopup ? 1 : 0);
        dest.writeInt(hasFriendPromo ? 1 : 0);
        dest.writeInt(canCancelWithdrawal ? 1 : 0);
        dest.writeInt(initWdPwdNeedLoginPwd ? 1 : 0);
        dest.writeString(rankLevel);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "siteName='" + siteName + '\'' +
                ", siteDomain='" + siteDomain + '\'' +
                ", siteId='" + siteId + '\'' +
                ", siteLogoBig='" + siteLogoBig + '\'' +
                ", siteLogoSmall='" + siteLogoSmall + '\'' +
                ", siteLogoSimple='" + siteLogoSimple + '\'' +
                ", support='" + support + '\'' +
                ", announcement='" + announcement + '\'' +
                ", allowUserEditProfile=" + allowUserEditProfile +
                ", hasRedPocket=" + hasRedPocket +
                ", redPocketImageUrl='" + redPocketImageUrl + '\'' +
                ", useBanner=" + useBanner +
                ", bannerList=" + bannerList +
                ", clientThemeMap=" + clientThemeMap +
                ", defaultViewMode='" + defaultViewMode + '\'' +
                ", allowSendEmail=" + allowSendEmail +
                ", allowSendSms=" + allowSendSms +
                ", registerMobileVerify=" + registerMobileVerify +
                ", withdrawalMobileVerify=" + withdrawalMobileVerify +
                ", shouldCheckMobileVerified=" + shouldCheckMobileVerified +
                ", mobilePopUp='" + mobilePopUp + '\'' +
                ", allowUploadDepositCredential='" + allowUploadDepositCredential + '\'' +
                ", hasGameTransferPopup='" + hasGameTransferPopup + '\'' +
                ", isWdpasswordOn=" + isWdpasswordOn + '\'' +
                ", hasFriendPromo='" + hasFriendPromo + '\'' +

                '}';
    }
}
