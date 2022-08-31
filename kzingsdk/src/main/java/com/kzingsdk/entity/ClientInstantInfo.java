package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ClientInstantInfo implements Parcelable {

    private String captchaMode;
    private Boolean memberLoginNeedCaptcha;
    private Boolean addBankCardSmsVerify;
    private Boolean allowSendEmail;
    private Boolean allowSendSms;
    private Boolean allowUploadDepositCredential;
    private Boolean allowUserEditProfile;
    private Boolean allowCryptoCurrencyWithdrawal;
    private Boolean allowDeleteCryptoAddress;
    private Boolean allowCancelWithdrawal;
    private Boolean checkEmailVerified;
    private Boolean checkMobileVerified;
    private Boolean isWdPasswordOn;
    private Boolean allowGameTransferPopup;
    private Boolean initWdPwdNeedLoginPwd;
    private Boolean memberPanDupIP;
    private Boolean memberPanDupUUID;
    private Boolean memberPanVerify;
    private Boolean hasFriendPromo;
    private Boolean playerSelfRedeemRakeback;
    private Boolean showImportantPopup = false;
    private Boolean memberPanUsername2 = false;
    private Boolean memberPanPlayerGroup2 = false;
    private Boolean memberPanAgentCode2 = false;
    private Boolean playerEmailVerifiedWithdraw = false;
    private Boolean playerMobileVerifiedWithdraw = false;
    private Boolean allowPhoneCountry = false;
    private Boolean allowPlayerAddress = false;
    private Boolean isWdBindPlayerAdress = false;
    private Boolean regCaptcha = false;
    private Boolean playerBankcardVerifiedWithdraw = false;
    private Boolean otpSms = false;
    private Boolean otpVoice = false;
    private String siteId;
    private String cryptoFixedExchangeRate;
    private String announcement;
    private String sitenameApp;
    private String sitename;
    private String supportUrl;
    private String supportUrl2;
    private String appDomain;
    private String h5Domain;
    private String androidAppDownloadLink;
    private String iosAppDownloadLink;
    private String resourceDomain;
    private String depositPageFooter;
    private String pageDescription;
    private String pageFooter;
    private String pageKeyword;
    private String appFriendReferralDomain;
    private String depositAnnouncement;
    private String enterDepositPopup;
    private String dptCryptoFixedExchangeRate;
    private CaptchaApiId captchaApiId = new CaptchaApiId();
    private ArrayList<String> memberPanAgentCode = new ArrayList<>();
    private ArrayList<String> memberPanPlayerGroup = new ArrayList<>();
    private ArrayList<String> memberPanUsername = new ArrayList<>();
    private ArrayList<String> bannerCountdown = new ArrayList<>();
    private ArrayList<String> bannerFirstLaunch = new ArrayList<>();
    private ArrayList<MarqueeAnnouncement> marqueeAnnouncementList = new ArrayList<>();
    private ArrayList<MarqueeActivity> marqueeActivityList = new ArrayList<>();
    private ArrayList<ThemeInfo> themeList = new ArrayList<>();
    private ContactInfo feedbackContactInfo = new ContactInfo();
    private ContactInfo partnershipContactInfo = new ContactInfo();
    private ContactInfo socialMediaContactInfo = new ContactInfo();
    private HashMap<Integer, String> websiteConfigMap = new HashMap<>();

    public ClientInstantInfo() {

    }

    public static ClientInstantInfo newInstance(JSONObject rootObject) {
        ClientInstantInfo clientInfo = new ClientInstantInfo();
        clientInfo.setCaptchaMode(rootObject.optString("captchaMode"));
        clientInfo.setMemberLoginNeedCaptcha(rootObject.optBoolean("memberLoginNeedCaptcha", false));
        clientInfo.setAddBankCardSmsVerify(rootObject.optBoolean("addBankCardSmsVerify", false));
        clientInfo.setAllowSendEmail(rootObject.optBoolean("allowSendEmail", false));
        clientInfo.setAllowSendSms(rootObject.optBoolean("allowSendSms", false));
        clientInfo.setAllowUploadDepositCredential(rootObject.optBoolean("allowUploadDepositCredential", false));
        clientInfo.setAllowUserEditProfile(rootObject.optBoolean("allowUserEditProfile", false));
        clientInfo.setAllowCryptoCurrencyWithdrawal(rootObject.optBoolean("allowCryptoCurrencyWithdrawal", false));
        clientInfo.setAllowDeleteCryptoAddress(rootObject.optBoolean("allowDeleteCryptoAddress", false));
        clientInfo.setAllowCancelWithdrawal(rootObject.optBoolean("allowCancelWithdrawal", false));
        clientInfo.setCheckEmailVerified(rootObject.optBoolean("checkEmailVerified", false));
        clientInfo.setCheckMobileVerified(rootObject.optBoolean("checkMobileVerified", false));
        clientInfo.setWdPasswordOn(rootObject.optBoolean("isWdPasswordOn", false));
        clientInfo.setAllowGameTransferPopup(rootObject.optBoolean("allowGameTransferPopup", false));
        clientInfo.setInitWdPwdNeedLoginPwd(rootObject.optBoolean("initWdPwdNeedLoginPwd", false));
        clientInfo.setMemberPanDupIP(rootObject.optBoolean("memberPanDupIP", false));
        clientInfo.setMemberPanDupUUID(rootObject.optBoolean("memberPanDupUUID", false));
        clientInfo.setMemberPanVerify(rootObject.optBoolean("memberPanVerify", false));
        clientInfo.setHasFriendPromo(rootObject.optBoolean("hasFriendPromo", false));
        clientInfo.setPlayerSelfRedeemRakeback(rootObject.optBoolean("playerSelfRedeemRakeback", false));
        clientInfo.setMemberPanUsername2(rootObject.optBoolean("memberPanUsername2", false));
        clientInfo.setMemberPanPlayerGroup2(rootObject.optBoolean("memberPanPlayerGroup2", false));
        clientInfo.setMemberPanAgentCode2(rootObject.optBoolean("memberPanAgentCode2", false));
        clientInfo.setPlayerEmailVerifiedWithdraw(rootObject.optBoolean("playerEmailVerifiedWithdraw", false));
        clientInfo.setPlayerMobileVerifiedWithdraw(rootObject.optBoolean("playerMobileVerifiedWithdraw", false));
        clientInfo.setAllowPhoneCountry(rootObject.optBoolean("allowPhoneCountry", false));
        clientInfo.setAllowPlayerAddress(rootObject.optBoolean("allowPlayerAddress", false));
        clientInfo.setWdBindPlayerAdress(rootObject.optBoolean("isWdBindPlayerAdress", false));
        clientInfo.setRegCaptcha(rootObject.optBoolean("regCaptcha", false));
        clientInfo.setPlayerBankcardVerifiedWithdraw(rootObject.optBoolean("playerBankcardVerifiedWithdraw", false));
        clientInfo.setOtpSms(rootObject.optBoolean("OtpSms", false));
        clientInfo.setOtpVoice(rootObject.optBoolean("OtpVoice", false));
        clientInfo.setCaptchaMode(rootObject.optString("captchaMode"));
        clientInfo.setSiteId(rootObject.optString("siteId"));
        clientInfo.setCryptoFixedExchangeRate(rootObject.optString("cryptoFixedExchangeRate"));
        clientInfo.setAnnouncement(rootObject.optString("announcement"));
        clientInfo.setSitenameApp(rootObject.optString("sitenameApp"));
        clientInfo.setSitename(rootObject.optString("sitename"));
        clientInfo.setSupportUrl(rootObject.optString("supportUrl"));
        clientInfo.setSupportUrl2(rootObject.optString("supportUrl2"));
        clientInfo.setAppDomain(rootObject.optString("appDomain"));
        clientInfo.setH5Domain(rootObject.optString("h5Domain"));
        clientInfo.setAndroidAppDownloadLink(rootObject.optString("androidAppDownloadLink"));
        clientInfo.setIosAppDownloadLink(rootObject.optString("iosAppDownloadLink"));
        clientInfo.setResourceDomain(rootObject.optString("resourceDomain"));
        clientInfo.setDepositPageFooter(rootObject.optString("depositPageFooter"));
        clientInfo.setPageDescription(rootObject.optString("pageDescription"));
        clientInfo.setPageFooter(rootObject.optString("pageFooter"));
        clientInfo.setPageKeyword(rootObject.optString("pageKeyword"));
        clientInfo.setAppFriendReferralDomain(rootObject.optString("appFriendReferralDomain"));
        clientInfo.setDepositAnnouncement(rootObject.optString("depositAnnouncement"));
        clientInfo.setEnterDepositPopup(rootObject.optString("enterdepositpopup"));
        clientInfo.setDptCryptoFixedExchangeRate(rootObject.optString("dptCryptoFixedExchangeRate"));

        JSONObject captchaApiIdJSONObject = rootObject.optJSONObject("captchaApiId");
        if (captchaApiIdJSONObject != null)
            clientInfo.setCaptchaApiId(CaptchaApiId.newInstance(captchaApiIdJSONObject));

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

        clientInfo.memberPanAgentCode = new ArrayList<>();
        clientInfo.memberPanUsername = new ArrayList<>();
        JSONArray memberPanAgentCodeJSONArray = rootObject.optJSONArray("memberPanAgentCode");
        if (memberPanAgentCodeJSONArray != null) {
            for (int i = 0; i < memberPanAgentCodeJSONArray.length(); i++) {
                clientInfo.memberPanAgentCode.add(memberPanAgentCodeJSONArray.optString(i));
            }
        }
        JSONArray memberPanPlayerGroupJSONArray = rootObject.optJSONArray("memberPanPlayerGroup");
        if (memberPanPlayerGroupJSONArray != null) {
            clientInfo.memberPanPlayerGroup.clear();
            for (int i = 0; i < memberPanPlayerGroupJSONArray.length(); i++) {
                clientInfo.memberPanPlayerGroup.add(memberPanPlayerGroupJSONArray.optString(i));
            }
        }
        JSONArray memberPanUsernameJSONArray = rootObject.optJSONArray("memberPanUsername");
        if (memberPanUsernameJSONArray != null) {
            for (int i = 0; i < memberPanUsernameJSONArray.length(); i++) {
                clientInfo.memberPanUsername.add(memberPanUsernameJSONArray.optString(i));
            }
        }
        JSONArray bannerCountdownJSONArray = rootObject.optJSONArray("bannerCountdown");
        ArrayList<String> bannerCountdownList = new ArrayList<>();
        if (bannerCountdownJSONArray != null) {
            for (int i = 0; i < bannerCountdownJSONArray.length(); i++) {
                bannerCountdownList.add(bannerCountdownJSONArray.optString(i));
            }
        }
        clientInfo.setBannerCountdown(bannerCountdownList);
        JSONArray bannerFirstLaunchJSONArray = rootObject.optJSONArray("bannerFirstLaunch");
        ArrayList<String> bannerFirstLaunchList = new ArrayList<>();
        if (bannerFirstLaunchJSONArray != null) {
            for (int i = 0; i < bannerFirstLaunchJSONArray.length(); i++) {
                bannerFirstLaunchList.add(bannerFirstLaunchJSONArray.optString(i));
            }
        }
        clientInfo.setBannerFirstLaunch(bannerFirstLaunchList);

        JSONObject marqueeActivityJSONObject = rootObject.optJSONObject("marqueeActivity");
        ArrayList<MarqueeActivity> marqueeActivityList = new ArrayList<>();
        if (marqueeActivityJSONObject != null) {
            JSONArray activityJSONArray = marqueeActivityJSONObject.optJSONArray("activity");
            if (activityJSONArray != null) {
                for (int i = 0; i < activityJSONArray.length(); i++) {
                    marqueeActivityList.add(MarqueeActivity.newInstance(activityJSONArray.optJSONObject(i)));
                }
            }
        }
        clientInfo.setMarqueeActivityList(marqueeActivityList);


        JSONObject marqueeAnnouncementJSONObject = rootObject.optJSONObject("marqueeAnnouncement");
        ArrayList<MarqueeAnnouncement> marqueeAnnouncementList = new ArrayList<>();
        if (marqueeAnnouncementJSONObject != null) {
            clientInfo.setShowImportantPopup(marqueeAnnouncementJSONObject.optBoolean("showImportantPopup"));

            JSONArray announcementJSONArray = marqueeAnnouncementJSONObject.optJSONArray("announcement");
            if (announcementJSONArray != null) {
                for (int i = 0; i < announcementJSONArray.length(); i++) {
                    marqueeAnnouncementList.add(MarqueeAnnouncement.newInstance(announcementJSONArray.optJSONObject(i)));
                }
            }
        }
        clientInfo.setMarqueeAnnouncementList(marqueeAnnouncementList);

        ArrayList<ThemeInfo> themeList = new ArrayList<>();
        JSONArray themeJSONArray = rootObject.optJSONArray("theme");
        if (themeJSONArray != null) {
            for (int i = 0; i < themeJSONArray.length(); i++) {
                themeList.add(ThemeInfo.newInstance(themeJSONArray.optJSONObject(i)));
            }
        }
        clientInfo.setThemeList(themeList);

        for (int i = 301; i < 400; i++) {
            clientInfo.websiteConfigMap.put(i, rootObject.optString("wc" + i));
        }
        return clientInfo;
    }

    public CaptchaApiId getCaptchaApiId() {
        return captchaApiId;
    }

    public void setCaptchaApiId(CaptchaApiId captchaApiId) {
        this.captchaApiId = captchaApiId;
    }

    public String getCaptchaMode() {
        return captchaMode;
    }

    public void setCaptchaMode(String captchaMode) {
        this.captchaMode = captchaMode;
    }

    public Boolean getMemberLoginNeedCaptcha() {
        return memberLoginNeedCaptcha;
    }

    public void setMemberLoginNeedCaptcha(Boolean memberLoginNeedCaptcha) {
        this.memberLoginNeedCaptcha = memberLoginNeedCaptcha;
    }

    public ClientInstantInfo(Parcel in) {
        captchaMode = in.readString();
        memberLoginNeedCaptcha = in.readInt() == 1;
        addBankCardSmsVerify = in.readInt() == 1;
        allowSendEmail = in.readInt() == 1;
        allowSendSms = in.readInt() == 1;
        allowUploadDepositCredential = in.readInt() == 1;
        allowUserEditProfile = in.readInt() == 1;
        allowCryptoCurrencyWithdrawal = in.readInt() == 1;
        allowDeleteCryptoAddress = in.readInt() == 1;
        allowCancelWithdrawal = in.readInt() == 1;
        checkEmailVerified = in.readInt() == 1;
        checkMobileVerified = in.readInt() == 1;
        isWdPasswordOn = in.readInt() == 1;
        allowGameTransferPopup = in.readInt() == 1;
        initWdPwdNeedLoginPwd = in.readInt() == 1;
        memberPanDupIP = in.readInt() == 1;
        memberPanDupUUID = in.readInt() == 1;
        memberPanVerify = in.readInt() == 1;
        hasFriendPromo = in.readInt() == 1;
        playerSelfRedeemRakeback = in.readInt() == 1;
        memberPanUsername2 = in.readInt() == 1;
        memberPanPlayerGroup2 = in.readInt() == 1;
        memberPanAgentCode2 = in.readInt() == 1;
        playerEmailVerifiedWithdraw = in.readInt() == 1;
        playerMobileVerifiedWithdraw = in.readInt() == 1;
        allowPhoneCountry = in.readInt() == 1;
        allowPlayerAddress = in.readInt() == 1;
        isWdBindPlayerAdress = in.readInt() == 1;
        regCaptcha = in.readInt() == 1;
        playerBankcardVerifiedWithdraw = in.readInt() == 1;
        otpSms = in.readInt() == 1;
        otpVoice = in.readInt() == 1;
        siteId = in.readString();
        cryptoFixedExchangeRate = in.readString();
        announcement = in.readString();
        sitenameApp = in.readString();
        sitename = in.readString();
        supportUrl = in.readString();
        supportUrl2 = in.readString();
        appDomain = in.readString();
        h5Domain = in.readString();
        androidAppDownloadLink = in.readString();
        iosAppDownloadLink = in.readString();
        resourceDomain = in.readString();
        depositPageFooter = in.readString();
        pageDescription = in.readString();
        pageFooter = in.readString();
        pageKeyword = in.readString();
        appFriendReferralDomain = in.readString();
        depositAnnouncement = in.readString();
        enterDepositPopup = in.readString();
        dptCryptoFixedExchangeRate = in.readString();
        Object[] objectArray = in.readArray(ClientInstantInfo.class.getClassLoader());
        int i = 0;
        captchaApiId = (CaptchaApiId) objectArray[i++];
        memberPanAgentCode = (ArrayList<String>) objectArray[i++];
        memberPanPlayerGroup = (ArrayList<String>) objectArray[i++];
        memberPanUsername = (ArrayList<String>) objectArray[i++];
        bannerCountdown = (ArrayList<String>) objectArray[i++];
        bannerFirstLaunch = (ArrayList<String>) objectArray[i++];
        marqueeAnnouncementList = (ArrayList<MarqueeAnnouncement>) objectArray[i++];
        marqueeActivityList = (ArrayList<MarqueeActivity>) objectArray[i++];
        themeList = (ArrayList<ThemeInfo>) objectArray[i++];
        feedbackContactInfo = (ContactInfo) objectArray[i++];
        partnershipContactInfo = (ContactInfo) objectArray[i++];
        socialMediaContactInfo = (ContactInfo) objectArray[i++];
        websiteConfigMap = (HashMap<Integer, String>) objectArray[i++];
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(captchaMode);
        dest.writeInt(memberLoginNeedCaptcha ? 1 : 0);
        dest.writeInt(addBankCardSmsVerify ? 1 : 0);
        dest.writeInt(allowSendEmail ? 1 : 0);
        dest.writeInt(allowSendSms ? 1 : 0);
        dest.writeInt(allowUploadDepositCredential ? 1 : 0);
        dest.writeInt(allowUserEditProfile ? 1 : 0);
        dest.writeInt(allowCryptoCurrencyWithdrawal ? 1 : 0);
        dest.writeInt(allowDeleteCryptoAddress ? 1 : 0);
        dest.writeInt(allowCancelWithdrawal ? 1 : 0);
        dest.writeInt(checkEmailVerified ? 1 : 0);
        dest.writeInt(checkMobileVerified ? 1 : 0);
        dest.writeInt(isWdPasswordOn ? 1 : 0);
        dest.writeInt(allowGameTransferPopup ? 1 : 0);
        dest.writeInt(initWdPwdNeedLoginPwd ? 1 : 0);
        dest.writeInt(memberPanDupIP ? 1 : 0);
        dest.writeInt(memberPanDupUUID ? 1 : 0);
        dest.writeInt(memberPanVerify ? 1 : 0);
        dest.writeInt(hasFriendPromo ? 1 : 0);
        dest.writeInt(playerSelfRedeemRakeback ? 1 : 0);
        dest.writeInt(memberPanUsername2 ? 1 : 0);
        dest.writeInt(memberPanPlayerGroup2 ? 1 : 0);
        dest.writeInt(memberPanAgentCode2 ? 1 : 0);
        dest.writeInt(playerEmailVerifiedWithdraw ? 1 : 0);
        dest.writeInt(playerMobileVerifiedWithdraw ? 1 : 0);
        dest.writeInt(allowPhoneCountry ? 1 : 0);
        dest.writeInt(allowPlayerAddress ? 1 : 0);
        dest.writeInt(isWdBindPlayerAdress ? 1 : 0);
        dest.writeInt(regCaptcha ? 1 : 0);
        dest.writeInt(playerBankcardVerifiedWithdraw ? 1 : 0);
        dest.writeInt(otpSms ? 1 : 0);
        dest.writeInt(otpVoice ? 1 : 0);
        dest.writeString(siteId);
        dest.writeString(cryptoFixedExchangeRate);
        dest.writeString(announcement);
        dest.writeString(sitenameApp);
        dest.writeString(sitename);
        dest.writeString(supportUrl);
        dest.writeString(supportUrl2);
        dest.writeString(appDomain);
        dest.writeString(h5Domain);
        dest.writeString(androidAppDownloadLink);
        dest.writeString(iosAppDownloadLink);
        dest.writeString(resourceDomain);
        dest.writeString(depositPageFooter);
        dest.writeString(pageDescription);
        dest.writeString(pageFooter);
        dest.writeString(pageKeyword);
        dest.writeString(appFriendReferralDomain);
        dest.writeString(depositAnnouncement);
        dest.writeString(enterDepositPopup);
        dest.writeString(dptCryptoFixedExchangeRate);
        dest.writeArray(new Object[]{
                captchaApiId,
                memberPanAgentCode,
                memberPanPlayerGroup,
                memberPanUsername,
                bannerCountdown,
                bannerFirstLaunch,
                marqueeAnnouncementList,
                marqueeActivityList,
                themeList,
                feedbackContactInfo,
                partnershipContactInfo,
                socialMediaContactInfo,
                websiteConfigMap,
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public boolean isMemberLoginNeedCaptcha() {
        return memberLoginNeedCaptcha;
    }

    public void setMemberLoginNeedCaptcha(boolean memberLoginNeedCaptcha) {
        this.memberLoginNeedCaptcha = memberLoginNeedCaptcha;
    }

    public Boolean getAddBankCardSmsVerify() {
        return addBankCardSmsVerify;
    }

    public void setAddBankCardSmsVerify(Boolean addBankCardSmsVerify) {
        this.addBankCardSmsVerify = addBankCardSmsVerify;
    }

    public Boolean getAllowSendEmail() {
        return allowSendEmail;
    }

    public void setAllowSendEmail(Boolean allowSendEmail) {
        this.allowSendEmail = allowSendEmail;
    }

    public Boolean getAllowSendSms() {
        return allowSendSms;
    }

    public void setAllowSendSms(Boolean allowSendSms) {
        this.allowSendSms = allowSendSms;
    }

    public Boolean getAllowUploadDepositCredential() {
        return allowUploadDepositCredential;
    }

    public void setAllowUploadDepositCredential(Boolean allowUploadDepositCredential) {
        this.allowUploadDepositCredential = allowUploadDepositCredential;
    }

    public Boolean getAllowUserEditProfile() {
        return allowUserEditProfile;
    }

    public void setAllowUserEditProfile(Boolean allowUserEditProfile) {
        this.allowUserEditProfile = allowUserEditProfile;
    }

    public Boolean getAllowCryptoCurrencyWithdrawal() {
        return allowCryptoCurrencyWithdrawal;
    }

    public void setAllowCryptoCurrencyWithdrawal(Boolean allowCryptoCurrencyWithdrawal) {
        this.allowCryptoCurrencyWithdrawal = allowCryptoCurrencyWithdrawal;
    }

    public Boolean getAllowDeleteCryptoAddress() {
        return allowDeleteCryptoAddress;
    }

    public void setAllowDeleteCryptoAddress(Boolean allowDeleteCryptoAddress) {
        this.allowDeleteCryptoAddress = allowDeleteCryptoAddress;
    }

    public Boolean getAllowCancelWithdrawal() {
        return allowCancelWithdrawal;
    }

    public void setAllowCancelWithdrawal(Boolean allowCancelWithdrawal) {
        this.allowCancelWithdrawal = allowCancelWithdrawal;
    }

    public Boolean getCheckEmailVerified() {
        return checkEmailVerified;
    }

    public void setCheckEmailVerified(Boolean checkEmailVerified) {
        this.checkEmailVerified = checkEmailVerified;
    }

    public Boolean getCheckMobileVerified() {
        return checkMobileVerified;
    }

    public void setCheckMobileVerified(Boolean checkMobileVerified) {
        this.checkMobileVerified = checkMobileVerified;
    }

    public Boolean getWdPasswordOn() {
        return isWdPasswordOn;
    }

    public void setWdPasswordOn(Boolean wdPasswordOn) {
        isWdPasswordOn = wdPasswordOn;
    }

    public Boolean getAllowGameTransferPopup() {
        return allowGameTransferPopup;
    }

    public void setAllowGameTransferPopup(Boolean allowGameTransferPopup) {
        this.allowGameTransferPopup = allowGameTransferPopup;
    }

    public Boolean getInitWdPwdNeedLoginPwd() {
        return initWdPwdNeedLoginPwd;
    }

    public void setInitWdPwdNeedLoginPwd(Boolean initWdPwdNeedLoginPwd) {
        this.initWdPwdNeedLoginPwd = initWdPwdNeedLoginPwd;
    }

    public Boolean getMemberPanDupIP() {
        return memberPanDupIP;
    }

    public void setMemberPanDupIP(Boolean memberPanDupIP) {
        this.memberPanDupIP = memberPanDupIP;
    }

    public Boolean getMemberPanDupUUID() {
        return memberPanDupUUID;
    }

    public void setMemberPanDupUUID(Boolean memberPanDupUUID) {
        this.memberPanDupUUID = memberPanDupUUID;
    }

    public Boolean getMemberPanVerify() {
        return memberPanVerify;
    }

    public void setMemberPanVerify(Boolean memberPanVerify) {
        this.memberPanVerify = memberPanVerify;
    }

    public Boolean getHasFriendPromo() {
        return hasFriendPromo;
    }

    public void setHasFriendPromo(Boolean hasFriendPromo) {
        this.hasFriendPromo = hasFriendPromo;
    }

    public Boolean getPlayerSelfRedeemRakeback() {
        return playerSelfRedeemRakeback;
    }

    public void setPlayerSelfRedeemRakeback(Boolean playerSelfRedeemRakeback) {
        this.playerSelfRedeemRakeback = playerSelfRedeemRakeback;
    }

    public Boolean getMemberPanUsername2() {
        return memberPanUsername2;
    }

    public void setMemberPanUsername2(Boolean memberPanUsername2) {
        this.memberPanUsername2 = memberPanUsername2;
    }

    public Boolean getMemberPanPlayerGroup2() {
        return memberPanPlayerGroup2;
    }

    public void setMemberPanPlayerGroup2(Boolean memberPanPlayerGroup2) {
        this.memberPanPlayerGroup2 = memberPanPlayerGroup2;
    }

    public Boolean getMemberPanAgentCode2() {
        return memberPanAgentCode2;
    }

    public void setMemberPanAgentCode2(Boolean memberPanAgentCode2) {
        this.memberPanAgentCode2 = memberPanAgentCode2;
    }

    public Boolean getPlayerEmailVerifiedWithdraw() {
        return playerEmailVerifiedWithdraw;
    }

    public void setPlayerEmailVerifiedWithdraw(Boolean playerEmailVerifiedWithdraw) {
        this.playerEmailVerifiedWithdraw = playerEmailVerifiedWithdraw;
    }

    public Boolean getPlayerMobileVerifiedWithdraw() {
        return playerMobileVerifiedWithdraw;
    }

    public void setPlayerMobileVerifiedWithdraw(Boolean playerMobileVerifiedWithdraw) {
        this.playerMobileVerifiedWithdraw = playerMobileVerifiedWithdraw;
    }

    public Boolean getAllowPhoneCountry() {
        return allowPhoneCountry;
    }

    public void setAllowPhoneCountry(Boolean allowPhoneCountry) {
        this.allowPhoneCountry = allowPhoneCountry;
    }

    public Boolean getAllowPlayerAddress() {
        return allowPlayerAddress;
    }

    public void setAllowPlayerAddress(Boolean allowPlayerAddress) {
        this.allowPlayerAddress = allowPlayerAddress;
    }

    public Boolean getWdBindPlayerAdress() {
        return isWdBindPlayerAdress;
    }

    public void setWdBindPlayerAdress(Boolean wdBindPlayerAdress) {
        isWdBindPlayerAdress = wdBindPlayerAdress;
    }

    public Boolean getRegCaptcha() {
        return regCaptcha;
    }

    public void setRegCaptcha(Boolean regCaptcha) {
        this.regCaptcha = regCaptcha;
    }

    public Boolean getPlayerBankcardVerifiedWithdraw() {
        return playerBankcardVerifiedWithdraw;
    }

    public void setPlayerBankcardVerifiedWithdraw(Boolean playerBankcardVerifiedWithdraw) {
        this.playerBankcardVerifiedWithdraw = playerBankcardVerifiedWithdraw;
    }

    public Boolean getOtpSms() {
        return otpSms;
    }

    public ClientInstantInfo setOtpSms(Boolean otpSms) {
        this.otpSms = otpSms;
        return this;
    }

    public Boolean getOtpVoice() {
        return otpVoice;
    }

    public ClientInstantInfo setOtpVoice(Boolean otpVoice) {
        this.otpVoice = otpVoice;
        return this;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getCryptoFixedExchangeRate() {
        return cryptoFixedExchangeRate;
    }

    public void setCryptoFixedExchangeRate(String cryptoFixedExchangeRate) {
        this.cryptoFixedExchangeRate = cryptoFixedExchangeRate;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getSitenameApp() {
        return sitenameApp;
    }

    public void setSitenameApp(String sitenameApp) {
        this.sitenameApp = sitenameApp;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getSupportUrl() {
        return supportUrl;
    }

    public void setSupportUrl(String supportUrl) {
        this.supportUrl = supportUrl;
    }

    public String getSupportUrl2() {
        return supportUrl2;
    }

    public void setSupportUrl2(String supportUrl2) {
        this.supportUrl2 = supportUrl2;
    }

    public String getAppDomain() {
        return appDomain;
    }

    public void setAppDomain(String appDomain) {
        this.appDomain = appDomain;
    }

    public String getH5Domain() {
        return h5Domain;
    }

    public void setH5Domain(String h5Domain) {
        this.h5Domain = h5Domain;
    }

    public String getAndroidAppDownloadLink() {
        return androidAppDownloadLink;
    }

    public void setAndroidAppDownloadLink(String androidAppDownloadLink) {
        this.androidAppDownloadLink = androidAppDownloadLink;
    }

    public String getIosAppDownloadLink() {
        return iosAppDownloadLink;
    }

    public void setIosAppDownloadLink(String iosAppDownloadLink) {
        this.iosAppDownloadLink = iosAppDownloadLink;
    }

    public String getResourceDomain() {
        return resourceDomain;
    }

    public void setResourceDomain(String resourceDomain) {
        this.resourceDomain = resourceDomain;
    }

    public String getDepositPageFooter() {
        return depositPageFooter;
    }

    public void setDepositPageFooter(String depositPageFooter) {
        this.depositPageFooter = depositPageFooter;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    public String getPageFooter() {
        return pageFooter;
    }

    public void setPageFooter(String pageFooter) {
        this.pageFooter = pageFooter;
    }

    public String getPageKeyword() {
        return pageKeyword;
    }

    public void setPageKeyword(String pageKeyword) {
        this.pageKeyword = pageKeyword;
    }

    public String getAppFriendReferralDomain() {
        return appFriendReferralDomain;
    }

    public void setAppFriendReferralDomain(String appFriendReferralDomain) {
        this.appFriendReferralDomain = appFriendReferralDomain;
    }

    public String getDepositAnnouncement() {
        return depositAnnouncement;
    }

    public void setDepositAnnouncement(String depositAnnouncement) {
        this.depositAnnouncement = depositAnnouncement;
    }

    public String getEnterDepositPopup() {
        return enterDepositPopup;
    }

    public ClientInstantInfo setEnterDepositPopup(String enterDepositPopup) {
        this.enterDepositPopup = enterDepositPopup;
        return this;
    }

    public String getDptCryptoFixedExchangeRate() {
        return dptCryptoFixedExchangeRate;
    }

    public void setDptCryptoFixedExchangeRate(String dptCryptoFixedExchangeRate) {
        this.dptCryptoFixedExchangeRate = dptCryptoFixedExchangeRate;
    }

    public ArrayList<String> getMemberPanAgentCode() {
        return memberPanAgentCode;
    }

    public void setMemberPanAgentCode(ArrayList<String> memberPanAgentCode) {
        this.memberPanAgentCode = memberPanAgentCode;
    }

    public ArrayList<String> getMemberPanPlayerGroup() {
        return memberPanPlayerGroup;
    }

    public void setMemberPanPlayerGroup(ArrayList<String> memberPanPlayerGroup) {
        this.memberPanPlayerGroup = memberPanPlayerGroup;
    }

    public ArrayList<String> getMemberPanUsername() {
        return memberPanUsername;
    }

    public void setMemberPanUsername(ArrayList<String> memberPanUsername) {
        this.memberPanUsername = memberPanUsername;
    }

    public ArrayList<String> getBannerCountdown() {
        return bannerCountdown;
    }

    public void setBannerCountdown(ArrayList<String> bannerCountdown) {
        this.bannerCountdown = bannerCountdown;
    }

    public ArrayList<String> getBannerFirstLaunch() {
        return bannerFirstLaunch;
    }

    public void setBannerFirstLaunch(ArrayList<String> bannerFirstLaunch) {
        this.bannerFirstLaunch = bannerFirstLaunch;
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

    public HashMap<Integer, String> getWebsiteConfigMap() {
        return websiteConfigMap;
    }

    public void setWebsiteConfigMap(HashMap<Integer, String> websiteConfigMap) {
        this.websiteConfigMap = websiteConfigMap;
    }

    public Boolean getShowImportantPopup() {
        return showImportantPopup;
    }

    public void setShowImportantPopup(Boolean showImportantPopup) {
        this.showImportantPopup = showImportantPopup;
    }

    public ArrayList<MarqueeAnnouncement> getMarqueeAnnouncementList() {
        return marqueeAnnouncementList;
    }

    public void setMarqueeAnnouncementList(ArrayList<MarqueeAnnouncement> marqueeAnnouncementList) {
        this.marqueeAnnouncementList = marqueeAnnouncementList;
    }

    public ArrayList<MarqueeActivity> getMarqueeActivityList() {
        return marqueeActivityList;
    }

    public ClientInstantInfo setMarqueeActivityList(ArrayList<MarqueeActivity> marqueeActivityList) {
        this.marqueeActivityList = marqueeActivityList;
        return this;
    }

    public ArrayList<ThemeInfo> getThemeList() {
        return themeList;
    }

    public ClientInstantInfo setThemeList(ArrayList<ThemeInfo> themeList) {
        this.themeList = themeList;
        return this;
    }

    public static final Creator CREATOR = new Creator() {
        public ClientInstantInfo createFromParcel(Parcel in) {
            return new ClientInstantInfo(in);
        }

        public ClientInstantInfo[] newArray(int size) {
            return new ClientInstantInfo[size];
        }
    };

    @Override
    public String toString() {
        return "ClientInstantInfo{" +
                "captchaMode='" + captchaMode + '\'' +
                ", memberLoginNeedCaptcha=" + memberLoginNeedCaptcha +
                ", addBankCardSmsVerify=" + addBankCardSmsVerify +
                ", allowSendEmail=" + allowSendEmail +
                ", allowSendSms=" + allowSendSms +
                ", allowUploadDepositCredential=" + allowUploadDepositCredential +
                ", allowUserEditProfile=" + allowUserEditProfile +
                ", allowCryptoCurrencyWithdrawal=" + allowCryptoCurrencyWithdrawal +
                ", allowDeleteCryptoAddress=" + allowDeleteCryptoAddress +
                ", allowCancelWithdrawal=" + allowCancelWithdrawal +
                ", checkEmailVerified=" + checkEmailVerified +
                ", checkMobileVerified=" + checkMobileVerified +
                ", isWdPasswordOn=" + isWdPasswordOn +
                ", allowGameTransferPopup=" + allowGameTransferPopup +
                ", initWdPwdNeedLoginPwd=" + initWdPwdNeedLoginPwd +
                ", memberPanDupIP=" + memberPanDupIP +
                ", memberPanDupUUID=" + memberPanDupUUID +
                ", memberPanVerify=" + memberPanVerify +
                ", hasFriendPromo=" + hasFriendPromo +
                ", playerSelfRedeemRakeback=" + playerSelfRedeemRakeback +
                ", showImportantPopup=" + showImportantPopup +
                ", memberPanUsername2=" + memberPanUsername2 +
                ", memberPanPlayerGroup2=" + memberPanPlayerGroup2 +
                ", memberPanAgentCode2=" + memberPanAgentCode2 +
                ", playerEmailVerifiedWithdraw=" + playerEmailVerifiedWithdraw +
                ", playerMobileVerifiedWithdraw=" + playerMobileVerifiedWithdraw +
                ", allowPhoneCountry=" + allowPhoneCountry +
                ", siteId='" + siteId + '\'' +
                ", cryptoFixedExchangeRate='" + cryptoFixedExchangeRate + '\'' +
                ", announcement='" + announcement + '\'' +
                ", sitenameApp='" + sitenameApp + '\'' +
                ", sitename='" + sitename + '\'' +
                ", supportUrl='" + supportUrl + '\'' +
                ", appDomain='" + appDomain + '\'' +
                ", h5Domain='" + h5Domain + '\'' +
                ", androidAppDownloadLink='" + androidAppDownloadLink + '\'' +
                ", iosAppDownloadLink='" + iosAppDownloadLink + '\'' +
                ", resourceDomain='" + resourceDomain + '\'' +
                ", depositPageFooter='" + depositPageFooter + '\'' +
                ", pageDescription='" + pageDescription + '\'' +
                ", pageFooter='" + pageFooter + '\'' +
                ", pageKeyword='" + pageKeyword + '\'' +
                ", appFriendReferralDomain='" + appFriendReferralDomain + '\'' +
                ", depositAnnouncement='" + depositAnnouncement + '\'' +
                ", enterDepositPopup='" + enterDepositPopup + '\'' +
                ", captchaApiId=" + captchaApiId +
                ", memberPanAgentCode=" + memberPanAgentCode +
                ", memberPanPlayerGroup=" + memberPanPlayerGroup +
                ", memberPanUsername=" + memberPanUsername +
                ", bannerCountdown=" + bannerCountdown +
                ", bannerFirstLaunch=" + bannerFirstLaunch +
                ", marqueeAnnouncementList=" + marqueeAnnouncementList +
                ", feedbackContactInfo=" + feedbackContactInfo +
                ", partnershipContactInfo=" + partnershipContactInfo +
                ", socialMediaContactInfo=" + socialMediaContactInfo +
                ", websiteConfigMap=" + websiteConfigMap +
                '}';
    }
}
