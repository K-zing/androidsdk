package com.kzingsdk.requests;

import com.kzingsdk.entity.RegAgentParam;

/**
 * Interface to consolidate all public APIs.
 */
public final class KzingAPI {
    public static GetEncryptKeyAPI getEncryptKey() {
        return new GetEncryptKeyAPI();
    }

    public static GetBasicEncryptKeyAPI getBasicEncryptKey() {
        return new GetBasicEncryptKeyAPI();
    }

    public static GetActivityListAPI getActivityList() {
        return new GetActivityListAPI();
    }

    public static GetActivityContentAPI getActivityContent() {
        return new GetActivityContentAPI();
    }

    public static CheckGiftRedeemableAPI checkGiftRedeemable() {
        return new CheckGiftRedeemableAPI();
    }

    public static CheckActivityRedeemableAPI checkActivityRedeemable() {
        return new CheckActivityRedeemableAPI();
    }

    public static ApplyActivityAPI applyActivity() {
        return new ApplyActivityAPI();
    }

    public static GetBannersAPI getBanners() {
        return new GetBannersAPI();
    }

    public static ActivityCanSignInAPI activityCanSignIn() {
        return new ActivityCanSignInAPI();
    }

    public static HasWaterGateAPI hasWaterGate() {
        return new HasWaterGateAPI();
    }

    public static ActivitySignInAPI activitySignIn() {
        return new ActivitySignInAPI();
    }

    public static GetBonusWalletAPI getBonusWallet() {
        return new GetBonusWalletAPI();
    }

    public static GetNewComerActivityAPI getNewComerActivity() {
        return new GetNewComerActivityAPI();
    }

    public static GetRedPocketInfoAPI getRedPocketInfo() {
        return new GetRedPocketInfoAPI();
    }

    public static GetSpecRedPacketInfoAPI getSpecRedPacketInfo() {
        return new GetSpecRedPacketInfoAPI();
    }

    public static RedeemSpecRedPacketAPI redeemSpecRedPacket() {
        return new RedeemSpecRedPacketAPI();
    }

    public static GetMemberReferralAPI getMemberReferral() {
        return new GetMemberReferralAPI();
    }

    public static RedeemRedPocketAPI redeemRedPocket() {
        return new RedeemRedPocketAPI();
    }

    public static GetGiftHistoryAPI getGiftHistory() {
        return new GetGiftHistoryAPI();
    }

    public static CheckUserNameExistAPI checkUserNameExist() {
        return new CheckUserNameExistAPI();
    }

    public static CheckAgentNameExistAPI checkAgentNameExist() {
        return new CheckAgentNameExistAPI();
    }

    public static GetPhoneSupportedCountriesAPI getPhoneSupportedCountries() {
        return new GetPhoneSupportedCountriesAPI();
    }

    public static GetVipDetailAPI getVipDetail() {
        return new GetVipDetailAPI();
    }

    public static GetSiteDomainAPI getSiteDomain() {
        return new GetSiteDomainAPI();
    }

    public static CheckPlayerRealNameAndEmailAPI checkPlayerRealNameAndEmail() {
        return new CheckPlayerRealNameAndEmailAPI();
    }

    public static GetPlayerRecentStatAPI getPlayerRecentStat() {
        return new GetPlayerRecentStatAPI();
    }

    public static GetFriendRefLogsAPI getFriendRefLogs() {
        return new GetFriendRefLogsAPI();
    }

    public static GetBounsListAPI getBounsList() {
        return new GetBounsListAPI();
    }

    @Deprecated
    public static LoginAPI login() {
        return new LoginAPI();
    }

    public static LoginWebApiAPI loginWebApi() {
        return new LoginWebApiAPI();
    }

    public static LoginAllInOneAPI loginAllInOne() {
        return new LoginAllInOneAPI();
    }

    public static ResumeAllInOneAPI resumeAllInOne() {
        return new ResumeAllInOneAPI();
    }

    public static MobileLoginAPI mobileLogin() {
        return new MobileLoginAPI();
    }

    public static MobileLoginBindAPI mobileLoginBind() {
        return new MobileLoginBindAPI();
    }

    public static MobileLoginGetCodeAPI mobileLoginGetCode() {
        return new MobileLoginGetCodeAPI();
    }

    public static LogoutAPI logout() {
        return new LogoutAPI();
    }

    public static GetMemberInfoAPI getMemberInfo() {
        return new GetMemberInfoAPI();
    }

    public static GetBetHistoryListAPI getHistoryList() {
        return new GetBetHistoryListAPI();
    }

    public static GetTransferRecordAPI getTransferRecord() {
        return new GetTransferRecordAPI();
    }

    public static GetWithdrawRecordAPI getWithdrawRecord() {
        return new GetWithdrawRecordAPI();
    }

    public static GetDepositRecordAPI getDepositRecord() {
        return new GetDepositRecordAPI();
    }

    public static GetPanDepositListAPI getPanDepositList() {
        return new GetPanDepositListAPI();
    }

    public static GetPGLiveConversionRateAPI getPGLiveConversionRate() {
        return new GetPGLiveConversionRateAPI();
    }

    public static UpdatePanAPI updatePan() {
        return new UpdatePanAPI();
    }

    public static CancelWithdrawalAPI cancelWithdrawal() {
        return new CancelWithdrawalAPI();
    }

    public static GetTgLinkAPI getTgLink() {
        return new GetTgLinkAPI();
    }

    public static SetDefaultCryptoWithdrawAddressAPI setDefaultCryptoWithdrawAddress() {
        return new SetDefaultCryptoWithdrawAddressAPI();
    }

    public static SetDefaultWtdCardAPI setDefaultWtdCard() {
        return new SetDefaultWtdCardAPI();
    }

    public static CopyCryptoAddressAPI copyCryptoAddress() {
        return new CopyCryptoAddressAPI();
    }

    public static GetTWDHistoryAPI getTWDHistory() {
        return new GetTWDHistoryAPI();
    }

    public static GetCopyWritingContentByCategoryAPI getCopyWritingContentByCategory() {
        return new GetCopyWritingContentByCategoryAPI();
    }

    public static GetGameAccountListAPI getGameAccountList() {
        return new GetGameAccountListAPI();
    }

    public static GetAllGpBalanceAPI getAllGpBalance() {
        return new GetAllGpBalanceAPI();
    }

    public static GetAllCurrencyRateAPI getAllCurrencyRate() {
        return new GetAllCurrencyRateAPI();
    }

    public static GetAutoRankInfoAPI getAutoRankInfo() {
        return new GetAutoRankInfoAPI();
    }

    public static GetRankTierListAPI getRankTierList() {
        return new GetRankTierListAPI();
    }

    public static SwitchCurrencyAPI switchCurrency() {
        return new SwitchCurrencyAPI();
    }


    public static GetGpsBalanceAPI getGpsBalance() {
        return new GetGpsBalanceAPI();
    }

    public static GetRebateSummaryAPI getRebateSummary() {
        return new GetRebateSummaryAPI();
    }

    public static GetBetHistorySummaryAPI getBetHistorySummary() {
        return new GetBetHistorySummaryAPI();
    }

    public static GetRebateDetailAPI getRebateDetail() {
        return new GetRebateDetailAPI();
    }

    public static CheckDptTransInfoAPI checkDptTransInfo() {
        return new CheckDptTransInfoAPI();
    }

    public static GetSingleGamePlatformBalanceAPI getSingleGamePlatformBalance() {
        return new GetSingleGamePlatformBalanceAPI();
    }


    public static GetMessageListAPI getMessageList() {
        return new GetMessageListAPI();
    }

    public static GetSportOddsDataAPI getSportOddsData() {
        return new GetSportOddsDataAPI();
    }


    @Deprecated
    public static GetClientInfoAPI getSiteInfo() {
        return new GetClientInfoAPI();
    }

    public static GetClientInstantInfoAPI getClientInstantInfo() {
        return new GetClientInstantInfoAPI();
    }

    public static OneClickRedeemRakebackAPI oneClickRedeemRakeback() {
        return new OneClickRedeemRakebackAPI();
    }

    public static GetRakebackRedeemHistoryAPI getRakebackRedeemHistory() {
        return new GetRakebackRedeemHistoryAPI();
    }

    public static GetCsExtraInfoAPI getCsExtraInfo() {
        return new GetCsExtraInfoAPI();
    }

    public static UpdatePreferContactMethodAPI updatePreferContactMethod() {
        return new UpdatePreferContactMethodAPI();
    }

    public static GetMemberJoinableActivityListAPI getMemberJoinableActivityList() {
        return new GetMemberJoinableActivityListAPI();
    }

    public static UpdateDptPGStatusAPI updateDptPGStatus() {
        return new UpdateDptPGStatusAPI();
    }

    public static UpdateWtdPGStatusAPI updateWtdPGStatus() {
        return new UpdateWtdPGStatusAPI();
    }

    public static UploadDepositProofAPI uploadDepositProof() {
        return new UploadDepositProofAPI();
    }

    public static SubmitBankTransferAPI submitBankTransfer() {
        return new SubmitBankTransferAPI();
    }

    public static GetFixAmountRangeAPI getFixAmountRange() {
        return new GetFixAmountRangeAPI();
    }

    public static GetMemberRewardVipAPI getMemberRewardVip() {
        return new GetMemberRewardVipAPI();
    }

    public static GetRewardVipAutoBonusAPI getRewardVipAutoBonus() {
        return new GetRewardVipAutoBonusAPI();
    }

    public static GetRewardVipTurnoverAPI getRewardVipTurnover() {
        return new GetRewardVipTurnoverAPI();
    }

    public static GetPlayerReferralReportAPI getPlayerReferralReport() {
        return new GetPlayerReferralReportAPI();
    }

    public static GetAllRewardVipAPI getAllRewardVip() {
        return new GetAllRewardVipAPI();
    }

    public static GetProfileImagesAPI getProfileImages() {
        return new GetProfileImagesAPI();
    }

    public static GetPlayerProfileImagesAPI getPlayerProfileImages() {
        return new GetPlayerProfileImagesAPI();
    }

    public static UploadProfileImagesAPI uploadProfileImages() {
        return new UploadProfileImagesAPI();
    }

    public static UpdateProfileImagesAPI updateProfileImages() {
        return new UpdateProfileImagesAPI();
    }


    public static GetWithdrawAmountRangeAPI getWithdrawAmountRange() {
        return new GetWithdrawAmountRangeAPI();
    }


    public static GetRewardTransHistoryAPI getRewardTransHistory() {
        return new GetRewardTransHistoryAPI();
    }

    public static GetFeMaintenanceStatusAPI getFeMaintenanceStatus() {
        return new GetFeMaintenanceStatusAPI();
    }

    public static SecurityCodeVerificationAPI securityCodeVerification() {
        return new SecurityCodeVerificationAPI();
    }

    public static GetSuperdoorDomainAPI getSuperdoorDomain() {
        return new GetSuperdoorDomainAPI();
    }

    public static GetReferralDataAPI getReferralData() {
        return new GetReferralDataAPI();
    }

    public static RegParamAPI getRegParam() {
        return new RegParamAPI();
    }

    public static RegAccountAPI regAccount() {
        return new RegAccountAPI();
    }

    public static RegSendSmsAPI regSendSms() {
        return new RegSendSmsAPI();
    }

    public static RegAgentParamAPI getRegAgentParam() {
        return new RegAgentParamAPI();
    }

    /**
     * {@link RegAgentParamAPI} Must be requested before {@link RegAccountAPI}.
     * <]>
     * And  {@link RegAgentParamAPI} Must be requested again everytime to update {@link RegAgentParam#getVerifyCodeBitmap()} if request is failed.
     */
    public static RegAgentAccountAPI regAgentAccount() {
        return new RegAgentAccountAPI();
    }

    public static ChangePasswordAPI changePassword() {
        return new ChangePasswordAPI();
    }

    public static GetNewMobilePopupAPI getNewMobilePopup() {
        return new GetNewMobilePopupAPI();
    }

    public static GetMobilePopupV2API getMobilePopupV2() {
        return new GetMobilePopupV2API();
    }

    public static CrossPlayerChangePasswordAPI crossPlayerChangePassword() {
        return new CrossPlayerChangePasswordAPI();
    }

    public static ChangeWithdrawPasswordAPI changeWithdrawPasswordAPI() {
        return new ChangeWithdrawPasswordAPI();
    }

    public static TransferAllBalanceToGameAPI transferAllBalanceToGame() {
        return new TransferAllBalanceToGameAPI();
    }

    public static ChangeUserLanguageAPI changeUserLanguage() {
        return new ChangeUserLanguageAPI();
    }

    public static GetMobileFloatingWindowAPI getMobileFloatingWindow() {
        return new GetMobileFloatingWindowAPI();
    }

    public static GetMobileFloatingWindowV2API getMobileFloatingWindowV2() {
        return new GetMobileFloatingWindowV2API();
    }

    public static TransferToGameAPI transferToGame() {
        return new TransferToGameAPI();
    }

    public static TransferGameToGameAPI transferGameToGame() {
        return new TransferGameToGameAPI();
    }

    public static IplSendWhatsappAPI iplSendWhatsapp() {
        return new IplSendWhatsappAPI();
    }

    public static SubmitWithdrawAPI submitWithdraw() {
        return new SubmitWithdrawAPI();
    }

    public static SubmitWithdrawEpAPI submitWithdrawEp() {
        return new SubmitWithdrawEpAPI();
    }

    public static SubmitWithdrawSportAPI submitWithdrawSport() {
        return new SubmitWithdrawSportAPI();
    }

    public static GetPlayerEWalletCardAPI getPlayerEWalletCard() {
        return new GetPlayerEWalletCardAPI();
    }

    public static VerifyWdPasswordAPI verifyWdPassword() {
        return new VerifyWdPasswordAPI();
    }

    public static ChangePwdbyWithdrawalAPI changePwdbyWithdrawal() {
        return new ChangePwdbyWithdrawalAPI();
    }

    public static Fun88UpdatePreferredLangAPI fun88UpdatePreferredLang() {
        return new Fun88UpdatePreferredLangAPI();
    }

    public static ForgotPwdVerifyUsernameAPI forgotPwdVerifyUsername() {
        return new ForgotPwdVerifyUsernameAPI();
    }

    public static GetSendRegCodeDurationAPI getSendRegCodeDuration() {
        return new GetSendRegCodeDurationAPI();
    }

    public static GetAllWithdrawEWalletsAPI getAllWithdrawEWallets() {
        return new GetAllWithdrawEWalletsAPI();
    }

    public static GetWithdrawFieldsAPI getWithdrawFields() {
        return new GetWithdrawFieldsAPI();
    }

    public static SubmitEWalletWithdrawAPI submitEWalletWithdraw() {
        return new SubmitEWalletWithdrawAPI();
    }

    public static AddEWalletBankCardAPI addEWalletBankCard() {
        return new AddEWalletBankCardAPI();
    }

    public static DeleteEWalletBankCardAPI deleteEWalletBankCard() {
        return new DeleteEWalletBankCardAPI();
    }

    public static AddBankCardAPI addBankCard() {
        return new AddBankCardAPI();
    }

    public static EditBankCardAPI editBankCard() {
        return new EditBankCardAPI();
    }

    public static RemoveBankCardAPI removeBankCard() {
        return new RemoveBankCardAPI();
    }

    public static GetWithdrawBankListAPI getWithdrawBankList() {
        return new GetWithdrawBankListAPI();
    }

    public static EnterGameAPI enterGame() {
        return new EnterGameAPI();
    }

    public static GetHotGamesAPI getHotGames() {
        return new GetHotGamesAPI();
    }


    public static DeleteMessageAPI deleteMessage() {
        return new DeleteMessageAPI();
    }

    public static ReadMessageAPI readMessage() {
        return new ReadMessageAPI();
    }

    public static EditMemberInfoAPI editMemberInfo() {
        return new EditMemberInfoAPI();
    }

    public static EditMemberAvatarAPI editMemberAvatar() {
        return new EditMemberAvatarAPI();
    }

    public static GetWaterWagerAPI getWaterWager() {
        return new GetWaterWagerAPI();
    }

    public static GetDepositOptionAPI getDepositOption() {
        return new GetDepositOptionAPI();
    }

    public static GetDepositOptionRawJsonAPI getDepositOptionRawJson() {
        return new GetDepositOptionRawJsonAPI();
    }

    public static GetDepositFormFieldsAPI getDepositFormFields() {
        return new GetDepositFormFieldsAPI();
    }

    public static GetThirdPartySettingAPI getThirdPartySetting() {
        return new GetThirdPartySettingAPI();
    }

    public static SubmitThirdPartyDepositAPI submitThirdPartyDeposit() {
        return new SubmitThirdPartyDepositAPI();
    }

    public static SubmitJarvisUTRAPI submitJarvisUTR() {
        return new SubmitJarvisUTRAPI();
    }

    public static AtmOldBankGetBankCardAPI atmOldBankGetBankCard() {
        return new AtmOldBankGetBankCardAPI();
    }

    public static SubmitAtmOldBankDepositAPI submitAtmOldBankDeposit() {
        return new SubmitAtmOldBankDepositAPI();
    }

    public static SubmitAtmDepositAPI submitAtmDeposit() {
        return new SubmitAtmDepositAPI();
    }

    public static SubmitPhoneDepositAPI submitPhoneDeposit() {
        return new SubmitPhoneDepositAPI();
    }

    public static GetKycStatusAPI getKycStatus() {
        return new GetKycStatusAPI();
    }

    public static SubmitKycAPI submitKyc() {
        return new SubmitKycAPI();
    }


    public static SubmitPrepaidCardDepositAPI submitPrepaidCardDeposit() {
        return new SubmitPrepaidCardDepositAPI();
    }

    public static FinishDepositAPI finishDeposit() {
        return new FinishDepositAPI();
    }

    public static GetActivityBonusPointAPI getActivityBonusPoint() {
        return new GetActivityBonusPointAPI();
    }

    public static IsAccountEmailMatchAPI isAccountEmailMatch() {
        return new IsAccountEmailMatchAPI();
    }

    public static SendWithdrawSmsAPI sendWithdrawSms() {
        return new SendWithdrawSmsAPI();
    }

    public static RequestResetPasswordByEmailAPI requestResetPasswordByEmail() {
        return new RequestResetPasswordByEmailAPI();
    }

    public static GetRewardMemberDetailsAPI getRewardMemberDetails() {
        return new GetRewardMemberDetailsAPI();
    }

    public static RetrieveUsrWithoutCodeAPI retrieveUsrWithoutCode() {
        return new RetrieveUsrWithoutCodeAPI();
    }

    public static VerifyEmailCodeAPI verifyEmailCode() {
        return new VerifyEmailCodeAPI();
    }

    public static ResetPasswordByEmailAPI resetPasswordByEmail() {
        return new ResetPasswordByEmailAPI();
    }

    public static IsAccountPhoneMatchAPI isAccountPhoneMatch() {
        return new IsAccountPhoneMatchAPI();
    }

    public static RequestResetPasswordByPhoneAPI requestResetPasswordByPhone() {
        return new RequestResetPasswordByPhoneAPI();
    }

    public static VerifySmsCodeAPI verifySmsCode() {
        return new VerifySmsCodeAPI();
    }

    public static ResetPasswordByPhoneAPI resetPasswordByPhone() {
        return new ResetPasswordByPhoneAPI();
    }

    public static RequestVerifyPlayerEmailAPI requestVerifyPlayerEmail() {
        return new RequestVerifyPlayerEmailAPI();
    }

    public static VerifyPlayerEmailAPI verifyPlayerEmail() {
        return new VerifyPlayerEmailAPI();
    }

    public static RequestVerifyPlayerPhoneAPI requestVerifyPlayerPhone() {
        return new RequestVerifyPlayerPhoneAPI();
    }

    public static VerifyPlayerPhoneAPI verifyPlayerPhone() {
        return new VerifyPlayerPhoneAPI();
    }


    public static RequestUsernameByEmailSendCodeAPI requestUsernameByEmailSendCode() {
        return new RequestUsernameByEmailSendCodeAPI();
    }

    public static RequestUsernameByPhoneSendCodeAPI requestUsernameByPhoneSendCode() {
        return new RequestUsernameByPhoneSendCodeAPI();
    }

    public static RequestUsernameByEmailAPI requestUsernameByEmail() {
        return new RequestUsernameByEmailAPI();
    }

    public static RequestUsernameByPhoneAPI requestUsernameByPhone() {
        return new RequestUsernameByPhoneAPI();
    }

    public static GetWebsiteConfigAPI getWebsiteConfig() {
        return new GetWebsiteConfigAPI();
    }

    public static GetWebsiteContentConfigAPI getWebsiteContentConfig() {
        return new GetWebsiteContentConfigAPI();
    }

    public static GetSmsCodeAPI getSmsCode() {
        return new GetSmsCodeAPI();
    }

    public static GetEmailCodeAPI getEmailCode() {
        return new GetEmailCodeAPI();
    }

    public static GetRecommendGamesAPI getRecommendGames() {
        return new GetRecommendGamesAPI();
    }

    public static GetIplMatchesDataAPI getIplMatchesData() {
        return new GetIplMatchesDataAPI();
    }

    public static ConnectionSpeedTestAPI connectionSpeedTest() {
        return new ConnectionSpeedTestAPI();
    }

    public static GetWithdrawCryptoListAPI getWithdrawCryptoList() {
        return new GetWithdrawCryptoListAPI();
    }

    public static GetEpGamePlatformAPI getEpGamePlatform() {
        return new GetEpGamePlatformAPI();
    }

    public static GetGamePlatformByIconAPI getGamePlatformByIcon() {
        return new GetGamePlatformByIconAPI();
    }

    public static EditWithdrawCryptoAPI editWithdrawCrypto() {
        return new EditWithdrawCryptoAPI();
    }

    public static ResetReferralShortenLinkAPI resetReferralShortenLink() {
        return new ResetReferralShortenLinkAPI();
    }

    public static GetVipSettingsV2API getVipSettingsV2() {
        return new GetVipSettingsV2API();
    }

    public static AddWithdrawalCryptoAPI addWithdrawalCrypto() {
        return new AddWithdrawalCryptoAPI();
    }

    public static SubmitWithdrawCryptoAPI submitWithdrawCrypto() {
        return new SubmitWithdrawCryptoAPI();
    }

    public static ManageWithdrawCryptoAPI manageWithdrawCrypto() {
        return new ManageWithdrawCryptoAPI();
    }


    public static SubmitAtmDepositV2API submitAtmDepositV2() {
        return new SubmitAtmDepositV2API();
    }

    public static GetIpBlockSettingAPI getIpBlockSetting() {
        return new GetIpBlockSettingAPI();
    }

    public static GetPostpaidBonusAPI getPostpaidBonus() {
        return new GetPostpaidBonusAPI();
    }

    public static RedeemPostpaidBonusAPI redeemPostpaidBonus() {
        return new RedeemPostpaidBonusAPI();
    }

    public static BonusPromotionAPI bonusPromotion() {
        return new BonusPromotionAPI();
    }

    public static GetCryptoBetWinAmountAPI getCryptoBetWinAmount() {
        return new GetCryptoBetWinAmountAPI();
    }

    public static GetDividendPoolsAPI getDividendPools() {
        return new GetDividendPoolsAPI();
    }

    public static CryptoRedeemTokenAPI cryptoRedeemToken() {
        return new CryptoRedeemTokenAPI();
    }

    public static CryptoGetTransactionAPI cryptoGetTransaction() {
        return new CryptoGetTransactionAPI();
    }

    public static GetCryptoDepositOptionAPI getCryptoDepositOption() {
        return new GetCryptoDepositOptionAPI();
    }

    public static GetCryptoDepositAddrAPI getCryptoDepositAddr() {
        return new GetCryptoDepositAddrAPI();
    }

    public static GetCryptoDepositAddr2API getCryptoDepositAddr2() {
        return new GetCryptoDepositAddr2API();
    }

    public static GetActivityHistoryAPI getActivityHistory() {
        return new GetActivityHistoryAPI();
    }

    public static PasswordVerifyAPI passwordVerify() {
        return new PasswordVerifyAPI();
    }

    public static CancelPostpaidBonusAPI cancelPostpaidBonus() {
        return new CancelPostpaidBonusAPI();
    }

    public static AnnouncementDeleteStatusAPI announcementDeleteStatus() {
        return new AnnouncementDeleteStatusAPI();
    }

    public static AnnouncementReadStatusAPI announcementReadStatus() {
        return new AnnouncementReadStatusAPI();
    }

    public static GetProvinceInfoAPI getProvinceInfo() {
        return new GetProvinceInfoAPI();
    }

    public static SocialRegisterAPI socialRegister() {
        return new SocialRegisterAPI();
    }

    public static BindSocialAccountAPI bindSocialAccount() {
        return new BindSocialAccountAPI();
    }

    public static SocialAccountBindingStatusAPI socialAccountBindingStatus() {
        return new SocialAccountBindingStatusAPI();
    }

    public static GetMemberAgentAPI getMemberAgent() {
        return new GetMemberAgentAPI();
    }

    public static GetCommissionDetailsAPI getCommissionDetails() {
        return new GetCommissionDetailsAPI();
    }

    public static GetCommissionAPI getCommission() {
        return new GetCommissionAPI();
    }

    public static RequestSendEmailRegCodeAPI requestSendEmailRegCode() {
        return new RequestSendEmailRegCodeAPI();
    }

    public static GetMemberAgentAllDownLineAPI getMemberAgentAllDownLine() {
        return new GetMemberAgentAllDownLineAPI();
    }

    public static GetMemberAgentSalesHistoryAPI getMemberAgentSalesHistory() {
        return new GetMemberAgentSalesHistoryAPI();
    }

    public static GetMemberAgentWithdrawalAPI getMemberAgentWithdrawal() {
        return new GetMemberAgentWithdrawalAPI();
    }

    public static MemberAgentWithdrawAPI memberAgentWithdraw() {
        return new MemberAgentWithdrawAPI();
    }

    public static GetAgentTeamHistoryAPI getAgentTeamHistory() {
        return new GetAgentTeamHistoryAPI();
    }

    public static GetAgentPlayerHistoryAPI getAgentPlayerHistory() {
        return new GetAgentPlayerHistoryAPI();
    }


}
