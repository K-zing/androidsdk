package com.kzingsdk.requests;

import com.kzingsdk.entity.RegAgentParam;
import com.kzingsdk.entity.RegParam;
import com.kzingsdk.entity.gameplatform.GamePlatformType;

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

    public static ApplyActivityAPI applyActivity() {
        return new ApplyActivityAPI();
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

    public static GetNewComerActivityAPI getNewComerActivity() {
        return new GetNewComerActivityAPI();
    }

    public static GetRedPocketInfoAPI getRedPocketInfo() {
        return new GetRedPocketInfoAPI();
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

    public static GetPlayerRecentStatAPI getPlayerRecentStat() {
        return new GetPlayerRecentStatAPI();
    }

    public static GetFriendRefLogsAPI getFriendRefLogs() {
        return new GetFriendRefLogsAPI();
    }

    public static GetBounsListAPI getBounsList() {
        return new GetBounsListAPI();
    }

    public static LoginAPI login() {
        return new LoginAPI();
    }

    public static LoginAllInOneAPI loginAllInOne() {
        return new LoginAllInOneAPI();
    }

    public static ResumeAllInOneAPI resumeAllInOne() {
        return new ResumeAllInOneAPI();
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

    public static UpdatePanAPI updatePan() {
        return new UpdatePanAPI();
    }

    public static CancelWithdrawalAPI cancelWithdrawal() {
        return new CancelWithdrawalAPI();
    }


    /**
     * Return all GamePlatform without any sub games by default.
     * <p>
     * {@link GetGameListAPI#setRequestSubGame(boolean)} to import sub games to the GamePlatform of {@link GamePlatformType#GAME}.
     */
    public static GetGameListAPI getGameList() {
        return new GetGameListAPI();
    }

    public static GetGameAccountListAPI getGameAccountList() {
        return new GetGameAccountListAPI();
    }

    public static GetAllGpBalanceAPI getAllGpBalance() {
        return new GetAllGpBalanceAPI();
    }

    public static GetGpsBalanceAPI getGpsBalance() {
        return new GetGpsBalanceAPI();
    }

    public static GetMessageListAPI getMessageList() {
        return new GetMessageListAPI();
    }

    public static GetSportOddsDataAPI getSportOddsData() {
        return new GetSportOddsDataAPI();
    }


    public static GetClientInfoAPI getSiteInfo() {
        return new GetClientInfoAPI();
    }
    public static GetClientInstantInfoAPI getClientInstantInfo() {
        return new GetClientInstantInfoAPI();
    }


    public static RegParamAPI getRegParam() {
        return new RegParamAPI();
    }

    /**
     * {@link RegParamAPI} Must be requested before {@link RegAccountAPI}.
     * <]>
     * And  {@link RegParamAPI} Must be requested again everytime to update {@link RegParam#getVerifyCodeBitmap()} if request is failed.
     */
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


    public static ChangeWithdrawPasswordAPI changeWithdrawPasswordAPI() {
        return new ChangeWithdrawPasswordAPI();
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

    public static SubmitWithdrawSportAPI submitWithdrawSport() {
        return new SubmitWithdrawSportAPI();
    }

    public static GetPlayerEWalletCardAPI getPlayerEWalletCard() {
        return new GetPlayerEWalletCardAPI();
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

    static GetSubGameListAPI getSubGameList() {
        return new GetSubGameListAPI();
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

    public static GetDepositFormFieldsAPI getDepositFormFields() {
        return new GetDepositFormFieldsAPI();
    }

    public static GetThirdPartySettingAPI getThirdPartySetting() {
        return new GetThirdPartySettingAPI();
    }

    public static SubmitThirdPartyDepositAPI submitThirdPartyDeposit() {
        return new SubmitThirdPartyDepositAPI();
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

    public static RequestResetPasswordByEmailAPI requestResetPasswordByEmail() {
        return new RequestResetPasswordByEmailAPI();
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

    public static GetIpBlockSettingAPI getIpBlockSetting() {
        return new GetIpBlockSettingAPI();
    }

    public static GetPostpaidBonusAPI getPostpaidBonus() {
        return new GetPostpaidBonusAPI();
    }

    public static RedeemPostpaidBonusAPI redeemPostpaidBonus() {
        return new RedeemPostpaidBonusAPI();
    }

    public static CancelPostpaidBonusAPI cancelPostpaidBonus() {
        return new CancelPostpaidBonusAPI();
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
