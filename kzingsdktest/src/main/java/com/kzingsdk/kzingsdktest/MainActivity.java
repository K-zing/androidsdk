package com.kzingsdk.kzingsdktest;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kzingsdk.core.BaseAppGame;
import com.kzingsdk.core.KzingException;
import com.kzingsdk.core.KzingSDK;
import com.kzingsdk.entity.ActivityItem;
import com.kzingsdk.entity.ClientInfo;
import com.kzingsdk.entity.GiftHistory;
import com.kzingsdk.entity.HistoryListItem;
import com.kzingsdk.entity.HistoryListSummary;
import com.kzingsdk.entity.LangCode;
import com.kzingsdk.entity.MemberInfo;
import com.kzingsdk.entity.SocialRegisterPlatform;
import com.kzingsdk.entity.WithdrawRecord;
import com.kzingsdk.entity.deposit.AtmPayment;
import com.kzingsdk.entity.deposit.BasePaymentMethod;
import com.kzingsdk.entity.deposit.PaymentGroup;
import com.kzingsdk.entity.deposit.PaymentType;
import com.kzingsdk.entity.deposit.ThirdPartyPayment;
import com.kzingsdk.entity.deposit.ThirdPartyPaymentBank;
import com.kzingsdk.entity.gameplatform.GamePlatform;
import com.kzingsdk.entity.gameplatform.GamePlatformChild;
import com.kzingsdk.entity.gameplatform.GamePlatformContainer;
import com.kzingsdk.entity.gameplatform.GamePlatformCustom;
import com.kzingsdk.entity.gameplatform.GamePlatformGroup;
import com.kzingsdk.entity.gameplatform.GamePlatformType;
import com.kzingsdk.entity.gameplatform.Playable;
import com.kzingsdk.entity.gameplatform.gameapps.GameAppHelper;
import com.kzingsdk.requests.FinishDepositAPI;
import com.kzingsdk.requests.GetActivityListAPI;
import com.kzingsdk.requests.GetBasicEncryptKeyAPI;
import com.kzingsdk.requests.GetBetHistoryListAPI;
import com.kzingsdk.requests.GetEncryptKeyAPI;
import com.kzingsdk.requests.GetGameListAPI;
import com.kzingsdk.requests.GetWithdrawRecordAPI;
import com.kzingsdk.requests.KzingAPI;
import com.kzingsdk.requests.LoginAPI;
import com.kzingsdk.requests.LogoutAPI;
import com.kzingsdk.requests.TransferToGameAPI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;


@SuppressWarnings("ResultOfMethodCallIgnored")
@SuppressLint({"CheckResult", "SetTextI18n"})
public class MainActivity extends Activity {

    final String TAG = "MainActivity";
    String testKey = "kz";
    static final HashMap<String, String> aidKeyMap = new HashMap<>();

    static {
        aidKeyMap.put("kz", "20870Y14CN012892C984MU14098NC20C");
        aidKeyMap.put("tes", "JPIZ8ORKO7Z6RYPX1S4N2XYSI71LD93FZ");

        aidKeyMap.put("i41", "DC6ADA01332FFF88548826D2D299E75F");
        aidKeyMap.put("h36", "71B5E08797DFB06A5DEEF4F91DDE28A4");
        aidKeyMap.put("i26", "837B0A1E2A61F66379165CE28EBDE11A");
        aidKeyMap.put("tf", "114D6A415B3D04DB792CA7C0DA0C7A55");
        aidKeyMap.put("tfvip", "E884CA34C7C102802DFE06D885CCD6E2");
        aidKeyMap.put("f45", "A4DBD8C75D709FE2C0D94C3EB7817F48");
        aidKeyMap.put("k10", "F1F928H89CVNP9C12NP9MCP912NCP912");
        aidKeyMap.put("cp", "1C28741C2NO4871YN2O847CYN182O7NC");
//        aidKeyMap.put("k18", "C93FMMTNYOOLBNRK7H18EVC3ZG9FDOG1E");
        aidKeyMap.put("k36", "9KZZJ8T9JJSM276XI2M129I5758CEPZ28");
        aidKeyMap.put("l23", "DM83R2HH8M4HZ7C2092PSHLDBITGOM4MI");
        aidKeyMap.put("vt1", "BMPJ6PYDU0PNKD3WI8N8JFK3AUI0OCPBO");
        aidKeyMap.put("id1", "ZRZ9V3OK4Z82BVQSK88WIVNGQOM7XGII3");

    }

    static final HashMap<String, String> md5KeyMap = new HashMap<>();

    static {
        md5KeyMap.put("kz", "MFK8UPH4RV2PYBUA3RN4XPSQGCQKYKLB");
        md5KeyMap.put("tes", "VEZ6ZBSXBTPAWRVHXF1B7XJLQ2Q6ME2K1");

        md5KeyMap.put("i41", "BD001B550D829BCE529A47CB4F8D9AF4");
        md5KeyMap.put("h36", "FAC19B6744E369F6C8A5E336F4387F2E");
        md5KeyMap.put("i26", "3A12741A59DAB5A5212D7EDE71361F25");
        md5KeyMap.put("tf", "A2E3BBE70740627DB8E425643F6184D0");
        md5KeyMap.put("tfvip", "CD805D5892EFA5DD39D3C0B48FAC09AA");
        md5KeyMap.put("f45", "64C25AA14AB0B1AE7B2B97635788D21A");
        md5KeyMap.put("k10", "NCNUHJ3RTN10C7RM130U91C308DX018A");
        md5KeyMap.put("cp", "NKAUECTQ238ORMCQ32CFHQLCNF8Q8C82");
//        md5KeyMap.put("k18", "ALBE7JO4KK1LATWL9CW7KBNSXDOZWMUAL");
        md5KeyMap.put("k36", "PA19SIFCFJ4HPWKGG2915H51XWPSIRY2I");
        md5KeyMap.put("l23", "FWYMO4B01NK5RWMN1KPJHYLGFV57P4RKB");
        md5KeyMap.put("vt1", "2I13W9WM6QWT37YY6W6QSQHTRZ9Q93VD2");
        md5KeyMap.put("id1", "3MB021AVLJO50SMOQ9ACX16SSVWDRO5JK");
    }

    private final String GetBasicKey = "GetBasicKey";
    private final String GetDataKey = "GetDataKey";
    private final String Login = "Login";
    private final String LoginAllInOne = "LoginAllInOne";
    private final String ResumeAllInOne = "ResumeAllInOne";

    private final String Logout = "Logout";
    private final String GetMemberInfo = "GetMemberInfo";
    private final String GetActivityList = "GetActivityList";
    private final String GetActivityContent = "GetActivityContent";
    private final String GetActivityBonusPoint = "GetActivityBonusPoint";
    private final String CheckGiftRedeemable = "CheckGiftRedeemable";
    private final String ApplyActivity = "ApplyActivity";
    private final String GetRedPocketInfo = "GetRedPocketInfo";
    private final String GetMemberReferral = "GetMemberReferral";
    private final String RedeemRedPocket = "RedeemRedPocket";
    private final String GetGiftHistory = "GetGiftHistory";
    private final String CheckUserNameExist = "CheckUserNameExist";
    private final String CheckAgentNameExist = "CheckAgentNameExist";
    private final String GetHistoryList = "GetHistoryList";
    private final String GetMessageList = "GetMessageList";
    private final String GetSiteInfo = "GetSiteInfo";
    private final String GetGameAccountList = "GetGameAccountList";
    private final String GetGameListSimple = "GetGameListSimple";
    private final String GetGameListWithSubGamesGZIP = "GetGameListWithSubGamesGZIP";
    private final String GetGameListWithSubGames = "GetGameListWithSubGames";
    private final String GetAllGpBalance = "GetAllGpBalance";
    private final String GetGpsBalance = "GetGpsBalance";
    private final String RegAccount = "RegAccount";
    private final String RegAgentAccount = "RegAgentAccount";
    private final String TransferToGame = "TransferToGame (AG)";
    private final String TransferBack = "TransferBack";
    private final String GetDepositRecord = "GetDepositRecord";
    private final String GetWithdrawRecord = "GetWithdrawRecord";
    private final String GetTransferRecord = "GetTransferRecord";
    private final String CancelWithdrawal = "CancelWithdrawal";
    private final String DownloadAPPList = "DownloadAPPList";
    private final String getBankDictionary = "GetBankDictionary";
    private final String getWithdrawBankList = "GetWithdrawBankList";
    private final String getPlayerEWalletCard = "GetPlayerEWalletCard";
    private final String addBankCard = "AddBankCard";
    private final String editBankCard = "EditBankCard";
    private final String submitWithdraw = "SubmitWithdraw";
    private final String submitWithdrawSport = "SubmitWithdrawSport";
    private final String getAllWithdrawEWallets = "GetAllWithdrawEWallets";
    private final String getWithdrawFields = "GetWithdrawFields";
    private final String addEWalletBankCard = "AddEWalletBankCard";
    private final String submitEWalletWithdraw = "SubmitEWalletWithdraw";
    private final String GetBounsList = "GetBounsList";
    private final String playGame = "PlayGame";
    private final String playappgame = "Playappgame";
    private final String loadGameFromCache = "LoadGameFromCache";
    private final String changePassword = "ChangePassword";
    private final String changeWithdrawPassword = "ChangeWithdrawPassword";
    private final String editMemberInfo = "EditMemberInfo";
    private final String editMemberAvatar = "EditMemberAvatar";
    private final String deleteMessage = "DeleteMessage";
    private final String readMessage = "ReadMessage";

    private final String getDepositOption = "GetDepositOption";
    private final String getDepositFormFields = "GetDepositFormFields";
    private final String getThirdPartySetting = "GetThirdPartySetting";
    private final String submitThirdPartyDeposit = "SubmitThirdPartyDeposit";
    private final String submitAtmDeposit = "SubmitAtmDeposit";
    private final String submitPrepaidCardDeposit = "SubmitPrepaidCardDeposit";
    private final String getVipDetail = "getVipDetail";
    private final String getPlayerRecentStat = "getPlayerRecentStat";
    private final String getFriendRefLogs = "GetFriendRefLogs";
    private final String requestUsernameByEmail = "requestUsernameByEmail";

    private final String finishDeposit = "finishDeposit";
    private final String requestUsernameByEmailSendCode = "requestUsernameByEmailSendCode";

    private final String IsAccountEmailMatch = "IsAccountEmailMatch";
    private final String RequestResetPasswordByEmail = "RequestResetPasswordByEmail";
    private final String VerifyEmailCode = "VerifyEmailCode";
    private final String ResetPasswordByEmail = "ResetPasswordByEmail";
    private final String IsAccountPhoneMatch = "IsAccountPhoneMatch";
    private final String RequestResetPasswordByPhone = "RequestResetPasswordByPhone";
    private final String VerifySmsCode = "VerifySmsCode";
    private final String ResetPasswordByPhone = "ResetPasswordByPhone";
    private final String RequestVerifyPlayerEmail = "RequestVerifyPlayerEmail";
    private final String VerifyPlayerEmail = "VerifyPlayerEmail";
    private final String RequestVerifyPlayerPhone = "RequestVerifyPlayerPhone";
    private final String VerifyPlayerPhone = "VerifyPlayerPhone";
    private final String getWebsiteConfig = "getWebsiteConfig";
    private final String getSmsCode = "getSmsCode";
    private final String getEmailCode = "getEmailCode";
    private final String getRecommendGames = "getRecommendGames";
    private final String connectionSpeedTest = "connectionSpeedTest";
    private final String connectionSpeedTest100 = "connectionSpeedTest100";
    private final String socialRegister = "socialRegister";
    private final String socialAccountBindingStatus = "socialAccountBindingStatus";
    private final String getWaterWager = "getWaterWager";

    private String[] allAIDs = new String[]{
            "c33", "d11", "h10", "i31", "i30", "h12", "i32", "h14", "i37", "j14", "i36", "ui3", "ui2", "a44", "ui5", "c41", "ui4", "f21", "im", "g41", "i42", "c47", "i41", "j21", "h22", "i45", "g49", "j24", "i49", "j28", "j30", "e12", "i11", "j32", "h36", "k11", "j33", "e19", "j35", "k12", "j38", "k15", "k14", "i19", "k17", "i18", "k19", "k18", "d81", "ss", "h40", "uix", "f45", "h45", "j43", "j42", "uat", "k22", "c29", "j44", "k21", "i26", "cp", "i25", "j46", "k23", "j49", "j48", "kz", "a1", "tf"
    };

    private static ClientInfo clientInfo = null;
    private static MemberInfo memberInfo = null;

    final String[] apiListItems = new String[]{
            GetBasicKey,
            GetDataKey,
            Login,
            LoginAllInOne,
            ResumeAllInOne,
            Logout,
            GetSiteInfo,
            GetMemberInfo,
            GetActivityList,
            GetActivityContent,
            GetActivityBonusPoint,
            CheckGiftRedeemable,
            ApplyActivity,
            GetRedPocketInfo,
            GetMemberReferral,
            RedeemRedPocket,
            GetGiftHistory,
            CheckUserNameExist,
            CheckAgentNameExist,
            GetHistoryList,
            GetMessageList,
            GetBounsList,
            GetGameAccountList,
            GetGameListSimple,
            GetGameListWithSubGamesGZIP,
//            GetGameListWithSubGames,
            GetAllGpBalance,
            GetGpsBalance,
            RegAccount,
            RegAgentAccount,
            TransferToGame,
            TransferBack,
            GetDepositRecord,
            GetWithdrawRecord,
            GetTransferRecord,
            CancelWithdrawal,
            DownloadAPPList,
            getBankDictionary,
            getWithdrawBankList,
            getPlayerEWalletCard,
            addBankCard,
            editBankCard,
            submitWithdraw,
            submitWithdrawSport,
            getAllWithdrawEWallets,
            getWithdrawFields,
            addEWalletBankCard,
            submitEWalletWithdraw,
            playGame,
            playappgame,
            loadGameFromCache,
            changePassword,
            changeWithdrawPassword,
            editMemberInfo,
            editMemberAvatar,
            deleteMessage,
            readMessage,
            getDepositOption,
            getDepositFormFields,
            getThirdPartySetting,
            finishDeposit,
            submitThirdPartyDeposit,
            submitAtmDeposit,
            submitPrepaidCardDeposit,
            getVipDetail,
            getPlayerRecentStat,
            getFriendRefLogs,
            requestUsernameByEmail,
            requestUsernameByEmailSendCode,
            IsAccountEmailMatch,
            RequestResetPasswordByEmail,
            VerifyEmailCode,
            ResetPasswordByEmail,
            IsAccountPhoneMatch,
            RequestResetPasswordByPhone,
            VerifySmsCode,
            ResetPasswordByPhone,
            RequestVerifyPlayerEmail,
            VerifyPlayerEmail,
            RequestVerifyPlayerPhone,
            VerifyPlayerPhone,
            getWebsiteConfig,
            getSmsCode,
            getEmailCode,
            getRecommendGames,
            connectionSpeedTest,
            connectionSpeedTest100,
            socialRegister,
            socialAccountBindingStatus,
            getWaterWager,


    };
    TextView tv;
    EditText et0, et1, et2;

    private void initSDK() {
        testKey = testKey.toLowerCase();
        KzingSDK.getInstance().init(aidKeyMap.get(testKey));
        KzingSDK.getInstance().setMd5Key(md5KeyMap.get(testKey));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("getid", "id = " + Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID));
        setContentView(R.layout.activity_main);

        Spinner langSpinner = findViewById(R.id.langSpinner);
        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(this,
                R.array.lang_array, android.R.layout.simple_spinner_item);
        adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSpinner.setAdapter(adapterLang);
        langSpinner.setSelection(0);
        langSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                KzingSDK.getInstance().setLangCode(LangCode.valueOfName(langSpinner.getAdapter().getItem(i) + ""));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final ListView listView = findViewById(R.id.listview);

        et0 = findViewById(R.id.editText0);
        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText2);
        et0.setText("k66");
//        et1.setText("testsp01");
//        et2.setText("q1w2e3");

//        et1.setText("terry88");
//        et2.setText("abc123");
        et1.setText("china");
        et2.setText("q1w2e3r4t5");
        tv = findViewById(R.id.textview);
        tv.setText("Logouted");
        initSDK();
//        KzingSDK.getInstance().setCustomTokensWithCache(
//                "lxwmWaCN2BZvRmknBBaWtWDRHyBd/glptEBdNLEE4INJI15WAKZJS3wMtpljjwjFnluU8j23KXh2Uk50eCTRVInyg07iG_",
//                "93dda5f4c50cb8357aaff43feaddde6d554869cc0a44",
//                this
//        );
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, apiListItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) (parent, view, position, id) -> {
            for (int i = 0; i < 1; i++) {
                if (et0.getText().toString().length() > 0) {
                    KzingSDK.getInstance().setAid(et0.getText().toString());
                }
                hideSoftKeyboard(MainActivity.this);
//                updateAPIKey();

                Calendar start = Calendar.getInstance();
                start.set(2020, start.get(Calendar.MONTH), start.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
//                    start.set(start.get(Calendar.YEAR), start.get(Calendar.MONTH), start.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
//                start.add(Calendar.DAY_OF_YEAR, -1);
                Calendar end = Calendar.getInstance();
                end.set(end.get(Calendar.YEAR), end.get(Calendar.MONTH), end.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
//                end.add(Calendar.DAY_OF_YEAR, -1);
//                Calendar start = Calendar.getInstance();
//                start.set(2018, 8, 13, 0, 0, 0);
//                Calendar end = Calendar.getInstance();
//                end.set(2021, 8, 13, 23, 59, 59);
                GetGameListAPI.GetGameListCallBack getGameListCallBack = new GetGameListAPI.GetGameListCallBack() {
                    @Override
                    public void onSuccess(ArrayList<GamePlatformContainer> gamePlatformContainerList) {
                        logGameList(gamePlatformContainerList);
                    }

                    @Override
                    public void onFailure(KzingException kzingException) {
                        Log.d(TAG, kzingException.getMessage());
                    }
                };
                switch (apiListItems[position]) {
                    case GetBasicKey:
                        KzingAPI.getBasicEncryptKey()
                                .addGetBasicEncryptKeyCallBack(new GetBasicEncryptKeyAPI.GetBasicEncryptKeyCallBack() {
                                    @Override
                                    public void onSuccess(String response) {
                                        KzingSDK.getInstance().setBasicRsaKey(response);
                                    }

                                    @Override
                                    public void onFailure(KzingException kzingException) {
                                        kzingException.printStackTrace();
                                    }
                                })
                                .request(MainActivity.this);
                        break;
                    case GetDataKey:
                        KzingAPI.getEncryptKey()
                                .addEncryptKeyCallBack(new GetEncryptKeyAPI.GetEncryptKeyCallBack() {
                                    @Override
                                    public void onSuccess(String response) {
                                        KzingSDK.getInstance().setDataRsaKey(response);
                                    }

                                    @Override
                                    public void onFailure(KzingException kzingException) {

                                    }
                                })
                                .request(MainActivity.this);
                        break;
                    case Login:
                        login();
                        break;
                    case LoginAllInOne:
                        loginAllInOne();
                        break;
                    case ResumeAllInOne:
                        resumeAllInOne();
                        break;

                    case Logout:
                        logout();
                        break;
                    case GetMemberInfo:
                        getMemberInfo();
                        break;
                    case GetActivityList:
                        getActivityList();
                        break;
                    case GetActivityContent:
                        getActivityContent();
                        break;
                    case GetActivityBonusPoint:
                        KzingAPI
                                .getActivityBonusPoint()
                                .request(MainActivity.this);
                        break;
                    case CheckGiftRedeemable:
                        KzingAPI
                                .checkGiftRedeemable()
                                .setParamActid("746153377645617152")
                                .setParamGiftId("746153377628839936")
                                .request(MainActivity.this);
                        break;
                    case ApplyActivity:
                        KzingAPI
                                .applyActivity()
                                .setParamActid("682885765113729024")
//                                    .setParamGiftId("746153377628839936")
//                                    .setParamAddress("ailuvb")
//                                    .setParamArea("awevuiba")
//                                    .setParamPhone("18200000090")
//                                    .setParamReceipient("awevliubaw")
                                .request(MainActivity.this);
                        break;
                    case GetRedPocketInfo:
                        KzingAPI.getRedPocketInfo()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case GetMemberReferral:
                        KzingAPI.getMemberReferral()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case RedeemRedPocket:
                        KzingAPI.redeemRedPocket()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case GetGiftHistory:
                        KzingAPI.getGiftHistory()
                                .setParamStartDateCalendar(start)
                                .setParamEndDateCalendar(end)
                                .requestRx(MainActivity.this)
                                .subscribe(giftList -> {
                                    for (GiftHistory giftHistory : giftList) {
                                        Log.d(TAG, giftHistory.toString());
                                    }
                                }, Throwable::printStackTrace);
                        break;

                    case CheckUserNameExist:
                        KzingAPI.checkUserNameExist()
                                .setParamUserName("china")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case CheckAgentNameExist:
                        KzingAPI.checkAgentNameExist()
                                .setParamAgentName("china")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;

                    case GetHistoryList:
                        getHistoryList();
                        break;
                    case GetMessageList:
                        getMessageList();
                        break;
                    case GetSiteInfo:
                        getSiteInfo();
                        break;
                    case GetGameAccountList:
                        KzingAPI.getGameAccountList()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case GetGameListSimple:
                        KzingAPI.getGameList()
                                .addGetGameListCallBack(getGameListCallBack)
                                .request(MainActivity.this);
                        break;
                    case GetGameListWithSubGamesGZIP:
                        backPressTimer = System.currentTimeMillis();
                        KzingAPI.getGameList()
                                .setRequestSubGame(true)
//                                    .addGetGameListCallBack(getGameListCallBack)
                                .addGetGameListCallBack(new GetGameListAPI.GetGameListCallBack() {
                                    @Override
                                    public void onSuccess(ArrayList<GamePlatformContainer> gamePlatformContainerList) {
                                        for (GamePlatformContainer gamePlatformContainer : gamePlatformContainerList) {
                                            for (GamePlatform gamePlatform : gamePlatformContainer.getGamePlatformList()) {
                                                if (gamePlatform.getGamePlatformType() == GamePlatformType.FISHING) {
                                                    Log.d("SubGamesGZIP", gamePlatform.getGpid() + ":" + gamePlatform.getGpname());
                                                }
                                                if (gamePlatform instanceof GamePlatformCustom) {
                                                    Log.d("SubGamesGZIP", ((GamePlatformCustom) gamePlatform).getCustomgpid() + ":" + ((GamePlatformCustom) gamePlatform).getCustomgpname());
                                                    GamePlatformCustom gamePlatformCustom = ((GamePlatformCustom) gamePlatform);
                                                    for (Playable playable : gamePlatformCustom.getPlayableArrayList()) {
                                                        if (playable instanceof GamePlatform) {
                                                            Log.d("SubGamesGZIP", gamePlatformCustom.getGpname() + ":" + playable.getGpid() + "(" + ((GamePlatform) playable).getChildArrayList().size() + ")");
                                                        }
                                                        if (playable instanceof GamePlatformChild) {
                                                            GamePlatformChild child = (GamePlatformChild) playable;
                                                            Log.d("SubGamesGZIP", gamePlatformCustom.getGpname() + ":" + child.getChildName());
                                                        }
                                                    }
                                                }
                                            }

                                        }
                                    }

                                    @Override
                                    public void onFailure(KzingException kzingException) {

                                    }
                                })
                                .request(MainActivity.this);
                        break;
                    case GetGameListWithSubGames:
                        backPressTimer = System.currentTimeMillis();
                        KzingAPI.getGameList()
                                .setRequestSubGame(true)
//                                    .addGetGameListCallBack(getGameListCallBack)
                                .addGetGameListCallBack(new GetGameListAPI.GetGameListCallBack() {
                                    @Override
                                    public void onSuccess(ArrayList<GamePlatformContainer> gamePlatformContainerList) {
                                        Log.d(TAG, "load time = " + (System.currentTimeMillis() - backPressTimer));
                                    }

                                    @Override
                                    public void onFailure(KzingException kzingException) {

                                    }
                                })
                                .request(MainActivity.this);
                        break;
                    case GetAllGpBalance:
                        KzingAPI.getAllGpBalance()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case GetGpsBalance:
                        KzingAPI.getGpsBalance()
                                .addGpAccountId("38712217599873024")
                                .addGpAccountId("350808494186201")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case RegAccount:
                        Intent intent = new Intent(MainActivity.this, RegActivity.class);
                        startActivity(intent);
                        break;
                    case RegAgentAccount:
                        Intent intentRegAgentAccount = new Intent(MainActivity.this, RegAgentActivity.class);
                        startActivity(intentRegAgentAccount);
                        break;
                    case TransferToGame:
                        KzingAPI.transferToGame()
                                .setParamTransferAmount(10.0d)
//                                    .setParamGpAccountId("350808494186201")// AG
//                                    .setParamGpAccountId("649971834000")//sport im
                                .setParamGpAccountId("202002190000")// IND poker
//                                    .setParamGpAccountId("202003201000")// in1 EXCHANGE
                                .request(MainActivity.this);
                        break;
                    case TransferBack:
                        KzingAPI.transferToGame()
                                .setParamGpAccountId(TransferToGameAPI.TRANSFER_BACK)
                                .request(MainActivity.this);
                        break;
                    case GetDepositRecord:
                        KzingAPI.getDepositRecord()
                                .setParamStartDateCalendar(start)
                                .setParamEndDateCalendar(end)
                                .request(MainActivity.this);
                        break;
                    case GetWithdrawRecord:
                        KzingAPI.getWithdrawRecord()
                                .setParamStartDateCalendar(start)
                                .setParamEndDateCalendar(end)
                                .addGetWithdrawRecordCallBack(new GetWithdrawRecordAPI.GetWithdrawRecordCallBack() {
                                    @Override
                                    public void onSuccess(ArrayList<WithdrawRecord> withdrawRecordList) {
                                        for (WithdrawRecord withdrawRecord : withdrawRecordList) {
                                            Log.d("", withdrawRecord.toString());
                                        }
                                    }

                                    @Override
                                    public void onFailure(KzingException kzingException) {

                                    }
                                })
                                .request(MainActivity.this);
                        break;
                    case GetTransferRecord:
                        KzingAPI.getTransferRecord()
                                .setParamStartDateCalendar(start)
                                .setParamEndDateCalendar(end)
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case CancelWithdrawal:
                        KzingAPI.cancelWithdrawal()
                                .setParamDno("751609026173100032")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case DownloadAPPList:
                        KzingAPI.getDownloadAppList()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getWithdrawBankList:
                        KzingAPI.getWithdrawBankList()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getPlayerEWalletCard:
                        KzingAPI.getPlayerEWalletCard()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case addBankCard:
                        String randomCardNumber = ((long) (Math.random() * Math.pow(10, 14))) + "";
                        Log.d(TAG, "Add RandomCardNumber = " + randomCardNumber);
                        KzingAPI.addBankCard()
                                //k66
//                            testappcard
//                            16550198273
                                //測銀行
                                .setParamBankCode("ceb")
                                .setParamAccountRealName("測銀行") // 橇留言者 testip01
                                .setParamCardNumber(randomCardNumber)
                                .setParamAccountBankName("中国光大银行中国光大银行")
                                .setParamVerifyCode(null)
                                .setNeedSMS(true)
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case editBankCard:
                        KzingAPI.editBankCard()
                                .addWdBankId("3")
                                .setIfsccode("test")
                                .setNote("testnote")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case submitWithdraw:
                        KzingAPI.submitWithdraw()
                                .setParamPlayerBankId("144")
                                .setParamAmount(200d)
                                .setParamWithdrawPassword("a12345")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case submitWithdrawSport:
                        KzingAPI.submitWithdrawSport()
                                .setParamPlayerBankId("245")
                                .setParamAmount(26d)
                                .setParamWithdrawPassword("a123456")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getAllWithdrawEWallets:
                        KzingAPI.getAllWithdrawEWallets()
                                .setCurrency("INR")
                                .requestRx(MainActivity.this)
                                .subscribe(s -> {
                                }, Throwable::printStackTrace);
                        break;
                    case getWithdrawFields:
                        KzingAPI.getWithdrawFields()
                                .requestRx(MainActivity.this);
                        break;
                    case addEWalletBankCard:
                        KzingAPI.addEWalletBankCard()
                                .requestRx(MainActivity.this);
                        break;
                    case submitEWalletWithdraw:
                        KzingAPI.submitEWalletWithdraw()
                                .requestRx(MainActivity.this);
                        break;
                    case GetBounsList:
                        KzingAPI.getBounsList()
                                .setParamStartDateCalendar(start)
                                .setParamEndDateCalendar(end)
                                .setParamOffset(14)
                                .setParamPageCount(7)
                                .request(MainActivity.this);
                        break;
                    case playGame:
                        playGame();
                        break;
                    case playappgame:
                        if (clientInfo == null || memberInfo == null) {
                            return;
                        }
                        BaseAppGame baseAppGame = GameAppHelper.getInstance(null);
                        if (baseAppGame != null) {
                            playGameApp(baseAppGame);
                        } else {// no APP for the game, go webview instead
                            playGame();
                        }
                        break;

                    case loadGameFromCache:
                        ArrayList<GamePlatformContainer> gamePlatformContainerList = KzingSDK.getInstance()
                                .loadGamePlatformFromCache(MainActivity.this, true);
                        logGameList(gamePlatformContainerList);
                        break;
                    case changePassword:
                        Intent intentChangePasswordActivity = new Intent(MainActivity.this, ChangePasswordActivity.class);
                        startActivity(intentChangePasswordActivity);
                        break;
                    case changeWithdrawPassword:
                        Intent intentChangeWithdrawPasswordActivity = new Intent(MainActivity.this, ChangeWithdrawPasswordActivity.class);
                        startActivity(intentChangeWithdrawPasswordActivity);
                        break;
                    case editMemberInfo:
                        KzingAPI.editMemberInfo()
                                .setRealName("hahaha")
                                .request(MainActivity.this);
                        break;
                    case editMemberAvatar:
                        KzingAPI.editMemberAvatar()
                                .setParamAvatarId("4")
                                .request(MainActivity.this);
                        break;

                    case deleteMessage:
                        KzingAPI.deleteMessage()
                                .addParamIds("872753005")
                                .request(MainActivity.this);
                        break;
                    case readMessage:
                        KzingAPI.readMessage()
                                .setReadAll(true)
                                .request(MainActivity.this);
                        break;
                    case getDepositOption:
                        KzingAPI.getDepositOption()
                                .requestRx(MainActivity.this)
                                .subscribe(deO -> {

//                                                    Intent intentPlay = new Intent(MainActivity.this, ParcelableActivity.class);
//                                                    intentPlay.putParcelableArrayListExtra("test", vip.getVipGpRateList());
//                                                    startActivity(intentPlay);
//                                                    return;

//                                                System.out.println(deO);
//                                                deO.getPaymentGroupList();
                                            Log.d("MainActivity", "testing depo");
                                            Log.d("MainActivity", deO.getPaymentGroupList().toString());
//                                                int avieb = 0;
                                            for (PaymentGroup pg : deO.getPaymentGroupList()) {
                                                if (pg.getPaymentType() == PaymentType.THIRD_PARTY) {
                                                    for (BasePaymentMethod bpm : pg.getPaymentList()) {
                                                        Log.d("MainActivity", "payment debug :" + ((ThirdPartyPayment) bpm).getOptionId() + " , " + bpm.getPaymentName());
//                                                            avieb++;
                                                    }
                                                }
                                                if (pg.getPaymentType() == PaymentType.ATM) {
                                                    for (BasePaymentMethod bpm : pg.getPaymentList()) {
                                                        Log.d("MainActivity", "payment debug :" + ((AtmPayment) bpm).getId() + " , " + ((AtmPayment) bpm).getName() + " , " + bpm.getPaymentName() + " , " + ((AtmPayment) bpm).isQrcode());
//                                                            avieb++;
                                                    }
                                                }
                                            }
                                            ArrayList<ThirdPartyPayment> thirdPartyPaymentList = new ArrayList<>();
//                                                Log.d("MainActivity", avieb + "");
//                                                Observable.fromIterable(deO.getPaymentGroupList())
//                                                        .filter(paymentGroup -> paymentGroup.getPaymentType() == PaymentType.THIRD_PARTY)//先找出三方的
//                                                        .filter(paymentGroup -> paymentGroup.getId().equals("45"))
//                                                        .flatMap(paymentGroup -> Observable.fromIterable(paymentGroup.getPaymentList()))//把Observable每個emit的object變成payment
//                                                        .toFlowable(BackpressureStrategy.BUFFER)//轉換成flowable
//                                                        .parallel(5)//來支持multi thread, int = thread數量
//                                                        .flatMap(payment -> // 每個payment都call一次getThirdPartySetting
//                                                                KzingAPI.getThirdPartySetting()
//                                                                        .setParamThirdPartyPayment((ThirdPartyPayment) payment)
//                                                                        .requestRx(MainActivity.this)
//                                                                        .toFlowable(BackpressureStrategy.BUFFER)
//                                                        )
//                                                        .sequential()//把各thread的資料匯合回去同一個thread
//                                                        .collectInto(thirdPartyPaymentList, ArrayList::add)
//                                                        .subscribe(finishedList -> {
//                                                            for (ThirdPartyPayment tpp : finishedList) {
//                                                                Log.d("", tpp.toString());
//                                                            }
//                                                        }, Throwable::printStackTrace);
//                                                Log.d("MainActivity", thirdPartyPaymentList.toString());
                                        }
                                        , Throwable::printStackTrace);
                        break;
                    case getDepositFormFields:
                        ThirdPartyPayment thirdPartyPaymentFields = new ThirdPartyPayment();
                        thirdPartyPaymentFields.setFormType("ecobanqpay");
                        KzingAPI.getDepositFormFields()
                                .setThirdPartyPayment(thirdPartyPaymentFields)
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getThirdPartySetting:
                        ThirdPartyPayment thirdPartyPayment = new ThirdPartyPayment();
                        thirdPartyPayment.setOptionId("2");
                        thirdPartyPayment.setId("2291");
                        KzingAPI.getThirdPartySetting()
                                .setParamThirdPartyPayment(thirdPartyPayment)
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case submitThirdPartyDeposit:
                        ThirdPartyPayment thirdPartyPayment2 = new ThirdPartyPayment();
                        thirdPartyPayment2.setOptionId("2");
                        thirdPartyPayment2.setId("2571");
                        ThirdPartyPaymentBank thirdPartyPaymentBank = new ThirdPartyPaymentBank();
                        thirdPartyPaymentBank.setId("alipay_scan");
                        thirdPartyPaymentBank.setParent(thirdPartyPayment2);
                        KzingAPI.submitThirdPartyDeposit()
                                .setParamAmount(100d)
                                .setParamThirdPartyPaymentBank(thirdPartyPaymentBank)
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case submitAtmDeposit:
                        AtmPayment atmPayment = new AtmPayment();
                        atmPayment.setId("45");
                        KzingAPI.submitAtmDeposit()
                                .setParamAmount(10d)
                                .setParamDepositorName("test")
                                .setParamThirdPartyPayment(atmPayment)
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case submitPrepaidCardDeposit:
                        KzingAPI.submitPrepaidCardDeposit()
                                .setParamSerialId("8RJNL7V3BAXykox42G")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getVipDetail:
                        KzingAPI.getVipDetail()
                                .requestRx(MainActivity.this)
                                .subscribe(vip -> {
                                    if (vip.getVipGpRateList().size() > 0) {
                                        Intent intentPlay = new Intent(MainActivity.this, ParcelableActivity.class);
                                        intentPlay.putParcelableArrayListExtra("test", vip.getVipGpRateList());
                                        startActivity(intentPlay);
//                                            for(VipGpRate vipGpRate : vip.getVipGpRateList()){
//                                                if(vipGpRate.getLadderRatePairList().size()>0){
//                                                    Intent intentPlay = new Intent(MainActivity.this, ParcelableActivity.class);
//                                                    intentPlay.putParcelableArrayListExtra("test", vip.getVipGpRateList());
//                                                    startActivity(intentPlay);
//                                                    return;
//                                                }
//                                            }
                                    }
                                }, Throwable::printStackTrace);

                        break;
                    case getPlayerRecentStat:
                        KzingAPI.getPlayerRecentStat()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getFriendRefLogs:
                        KzingAPI.getFriendRefLogs()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case requestUsernameByEmail:
                        KzingAPI.requestUsernameByEmail()
//                                    .setEmail("testy@testy.com")
//                                    .setValidateCode("123456")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;

                    case finishDeposit:
                        KzingAPI.finishDeposit()
                                .setParamStatus(FinishDepositAPI.FINISH)
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case requestUsernameByEmailSendCode:
                        KzingAPI.requestUsernameByEmailSendCode()
                                .setEmail("aliwuevb@ileavlb.com")
                                .setValidateOnly(true)
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;

                    case IsAccountEmailMatch:
                        KzingAPI.isAccountEmailMatch()
                                .setParamEmail("test1@gmail.ccc")
                                .setParamLoginName("china")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case RequestResetPasswordByEmail:
                        KzingAPI.requestResetPasswordByEmail()
                                .setParamEmail("test@gmail.ccc")
                                .setParamLoginName("china")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;

                    case VerifyEmailCode:
                        KzingAPI.verifyEmailCode()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case ResetPasswordByEmail:
                        KzingAPI.resetPasswordByEmail()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case IsAccountPhoneMatch:
                        KzingAPI.isAccountPhoneMatch()
                                .setParamPhone("18546321561")
                                .setParamLoginName("testphone1")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case RequestResetPasswordByPhone:
                        KzingAPI.requestResetPasswordByPhone()
                                .setParamPhone("18546321561")
                                .setParamLoginName("testphone1")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case VerifySmsCode:
                        KzingAPI.verifySmsCode()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case ResetPasswordByPhone:
                        KzingAPI.resetPasswordByPhone()
                                .setParamLoginName("testsms01")
                                .setParamPassword("testsms02")
                                .setParamValidateCode("917822")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case RequestVerifyPlayerEmail:
                        KzingAPI.requestVerifyPlayerEmail()
                                .setParamEmail("test@gmail.ccc")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case VerifyPlayerEmail:
                        KzingAPI.verifyPlayerEmail()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case RequestVerifyPlayerPhone:
                        KzingAPI.requestVerifyPlayerPhone()
                                .setParamPhone("15000111222")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case VerifyPlayerPhone:
                        KzingAPI.verifyPlayerPhone()
                                .setParamPhone("15000111222")
                                .setParamValidateCode("314228")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getWebsiteConfig:
                        KzingAPI.getWebsiteConfig()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getSmsCode:
                        KzingAPI.getSmsCode()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getEmailCode:
                        KzingAPI.getEmailCode()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getRecommendGames:
                        KzingAPI.getRecommendGames()
                                .requestRx(MainActivity.this)
                                .subscribe(list -> {
                                    Log.d("getRecommendGames", list.toString());
                                }, Throwable::printStackTrace);

                        break;
                    case connectionSpeedTest:
                        KzingAPI.connectionSpeedTest()
                                .requestRx(MainActivity.this)
                                .subscribe(time -> {
                                    Log.d("connectionSpeedTest", "Time = " + time);
                                }, Throwable::printStackTrace);

                        break;
                    case connectionSpeedTest100:
                        final int times = 15;
                        Flowable.range(0, times)
                                .flatMap(count -> {
                                    Log.d("connectionSpeedTest", "count = " + count);
                                    return KzingAPI.connectionSpeedTest()
                                            .requestRx(MainActivity.this)
                                            .toFlowable(BackpressureStrategy.BUFFER)
                                            .doOnNext(time -> {
                                                Log.d("connectionSpeedTest", "count " + count + " = " + time);
                                            })
                                            .doOnError(th -> {
                                                Log.d("connectionSpeedTest", "count failed = " + count);
                                            })
                                            ;
                                })
                                .onBackpressureBuffer(100)
                                .observeOn(Schedulers.trampoline())
                                .reduce(Long::sum)
                                .map(time -> time / times)
                                .subscribeOn(Schedulers.io())
                                .subscribe(time -> {
                                    Log.d("connectionSpeedTest", "Avg Time = " + time);
                                }, Throwable::printStackTrace);

                        break;
                    case socialRegister:
                        KzingAPI.socialRegister()
                                .setPlatform(SocialRegisterPlatform.google)
                                .setSocialId("103102418124869637904")
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case socialAccountBindingStatus:
                        KzingAPI.socialAccountBindingStatus()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;
                    case getWaterWager:
                        KzingAPI.getWaterWager()
                                .requestRx(MainActivity.this)
                                .subscribe(System.out::println, Throwable::printStackTrace);
                        break;

                }
            }
        });
    }

    private void updateAPIKey() {
        String apikey = aidKeyMap.get(et0.getText().toString());
        if (apikey == null) {
            Toast.makeText(this, "Key not found", Toast.LENGTH_SHORT).show();
            return;
        }
        KzingSDK.getInstance().replaceApiKey(apikey);
    }

    long backPressTimer = 0L;

    private void login() {
        backPressTimer = System.currentTimeMillis();
        KzingAPI.login()
                .setParamLoginName(et1.getText().toString())
                .setParamPassword(et2.getText().toString())
                .addLoginCallBack(new LoginAPI.LoginCallBack() {
                    @Override
                    public void onSuccess(MemberInfo memberInfo) {
                        tv.setText("Logined");
                        MainActivity.memberInfo = memberInfo;
                        Log.d(TAG, "load time = " + (System.currentTimeMillis() - backPressTimer));
                    }

                    @Override
                    public void onFailure(KzingException kzingException) {
                        Log.d(TAG, "load time = " + (System.currentTimeMillis() - backPressTimer));
                    }
                })
                .request(MainActivity.this);
    }

    private void loginAllInOne() {
        long a = System.currentTimeMillis();
        KzingAPI.loginAllInOne()
                .setParamLoginName(et1.getText().toString())
                .setParamPassword(et2.getText().toString())
                .requestRx(MainActivity.this)
                .subscribe(result -> {
                    Log.d("loginAllInOne", "result.getClientInfo() = " + result.getClientInfo().toString());

                    Log.d("loginAllInOne", "used = " + (System.currentTimeMillis() - a));
                }, Throwable::printStackTrace);
    }

    private void resumeAllInOne() {
        long a = System.currentTimeMillis();
        KzingAPI.resumeAllInOne()
                .requestRx(MainActivity.this)
                .subscribe(result -> {
                    Log.d("resumeAllInOne", "used = " + (System.currentTimeMillis() - a));
                }, Throwable::printStackTrace);
    }

    private void logout() {
//        KzingSDK.getInstance().clearTokenCache(this);
        KzingAPI.logout()
                .addLogoutCallBack(new LogoutAPI.LogoutCallBack() {
                    @Override
                    public void onSuccess() {
                        tv.setText("Logouted");
                    }

                    @Override
                    public void onFailure(KzingException kzingException) {
                        Log.e("TAG", kzingException.toString());
                    }
                })
                .request(MainActivity.this);
    }

    private void getMemberInfo() {
        KzingAPI.getMemberInfo()
                .requestRx(this)
                .subscribe(s -> {
                }, th -> {
                    System.out.println("onFailure : " + th.getMessage());
                });
    }

    private void getActivityList() {
        KzingAPI.getActivityList()
                .addGetActivityListCallBack(new GetActivityListAPI.GetActivityListCallBack() {
                    @Override
                    public void onSuccess(ArrayList<ActivityItem> activityItemList) {
                        for (ActivityItem activityItem : activityItemList) {
                            Log.d("ActivityType", activityItem.getActivityFrontType().toString());
//                            Log.d("ActivityType", activityItem.getActName());
                        }
                    }

                    @Override
                    public void onFailure(KzingException kzingException) {
                        kzingException.printStackTrace();
                    }
                })
                .request(MainActivity.this);
//                .subscribe(new Consumer<ArrayList<ActivityItem>>() {
//                    @Override
//                    public void accept(ArrayList<ActivityItem> activityItems) throws Exception {
//                        for (ActivityItem activityItem : activityItems) {
//                            Log.d("", activityItem.toString());
//                        }
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Log.d("", throwable.toString());
//                    }
//                });
    }

    private void getSiteInfo() {
        KzingAPI.getSiteInfo()
                .requestRx(this)
                .subscribe(clientInfo -> {
                    MainActivity.clientInfo = clientInfo;
                    Log.d(TAG, clientInfo.toString());
                }, throwable -> {
                    Log.d(TAG, throwable.toString());
                });
    }

    private void getMessageList() {
        Calendar start = Calendar.getInstance();
        start.set(2017, 1, 1, 0, 0, 0);
        Calendar end = Calendar.getInstance();
        end.set(2023, 6, 1, 0, 0, 0);
        KzingAPI.getMessageList()
                .setParamStartDateCalendar(start)
                .setParamEndDateCalendar(end)
                .requestRx(MainActivity.this)
                .subscribe(content -> {
                    Log.d(TAG, content.toString());
                }, throwable -> {
                    Log.d(TAG, throwable.toString());
                });
    }

    private void getHistoryList() {
        Calendar today = Calendar.getInstance();
        Calendar start = Calendar.getInstance();
        start.set(2021, 1, 1, 0, 0, 0);
        Calendar end = Calendar.getInstance();
//        end.set(2018, 10, 21, 23, 59, 59);
        end.set(2021, 1, 31, 23, 59, 59);
//        start.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH) - 1, 0, 0, 0);
//        end.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH) - 1, 23, 59, 59);
        KzingAPI.getHistoryList()
                .setParamStartDateCalendar(start)
                .setParamEndDateCalendar(end)
                .setParamPage(1)
//                .setParamGpId("649971834001")
                .addGetBetHistoryListCallBack(new GetBetHistoryListAPI.GetBetHistoryListCallBack() {
                    @Override
                    public void onSuccess(HistoryListSummary historyListSummary) {
                        for (HistoryListItem item : historyListSummary.getBetItems())
                            Log.d("GetBetHistory", item.toString());
                    }

                    @Override
                    public void onFailure(KzingException kzingException) {

                    }
                })
                .request(MainActivity.this)


        ;
    }

    private void getActivityContent() {

        KzingAPI.getActivityContent()
                .setParamActid("793981944651468800")
                .requestRx(MainActivity.this)
                .subscribe(act -> {
                    Log.d("getActivityContent", act);
                }, th -> {

                });

    }

    public void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    private void logGameList(ArrayList<GamePlatformContainer> gamePlatformContainerList) {
        for (GamePlatformContainer c : gamePlatformContainerList) {
            Log.d(TAG, c.getType().getId() + c.getType().getName() + " : " + c.getGamePlatformList().size());
            for (GamePlatform gp : c.getGamePlatformList()) {
                Log.d(TAG, gp.toString());
//                if (c.getType() == GamePlatformType.GAME) {
                if (gp instanceof GamePlatformCustom) {
                    GamePlatformCustom gpC = (GamePlatformCustom) gp;
                    for (Playable gpCc : gpC.getPlayableArrayList()) {
                        Log.d(TAG, "---" + gpCc.toString());
                    }
                } else {
                    if (gp.getChildArrayList().size() > 0) {
                        Log.d(TAG, "---" + gp.getGpname() + "(" + gp.getCategoryArrayList().size() + ")" + gp.getCategoryArrayList().toString());
                        Log.d(TAG, "---(" + gp.getChildArrayList().size() + ")" + gp.getChildArrayList().get(0).toString());
                    } else {
                        for (GamePlatformGroup gamePlatformGroup : gp.getGroupArrayList()) {
                            Log.d(TAG, "---" + gp.getGpname() + "(" + gamePlatformGroup.getCategoryArrayList().size() + ")" + gamePlatformGroup.toString() + " : " + gamePlatformGroup.getCategoryArrayList().toString());
//                                Log.d(TAG, "---(" + gamePlatformGroup.getChildGroupName() + ")" + gamePlatformGroup.getChildArrayList().get(0).toString());
                        }
                    }
                }
//                }
            }

        }
    }

    private void playGame() {
        KzingSDK.getInstance().setRequestTimeoutMs(400 * 1000);
        Intent intentPlay = new Intent(MainActivity.this, WebviewActivity.class);
        startActivity(intentPlay);
    }

    private void playGameApp(BaseAppGame baseAppGame) {
        baseAppGame.setClientInfo(clientInfo);
        baseAppGame.setMemberInfo(memberInfo);
        baseAppGame
                .addGameAppCallBack(new BaseAppGame.GameAppCallBack() {
                    @Override
                    public void onSuccess(Intent intent) {
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(KzingException kzingException) {
                        Log.d(TAG, kzingException.toString());
                    }
                })
                .launchApp(this);
//                .launchAppRx(MainActivity.this)
//                .subscribe(new Consumer<Intent>() {
//                    @Override
//                    public void accept(Intent intent) throws Exception {
//                        startActivity(intent);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Log.d(TAG, throwable.toString());
//                    }
//                });
    }
}
