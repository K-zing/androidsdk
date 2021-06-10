package com.kzingsdk.entity.K36;

import com.kzingsdk.entity.gameplatform.SimpleGamePlatform;
import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GetNewComerActivityResult {

    private String actId;
    private Integer status;
    private String msg;
    private String content;
    private Integer applyPeriod;
    private Integer signinPeriod;
    private Integer signinPeriodStart;
    private Integer signinPeriodEnd;
    private Integer achieveMethod;
    private Integer collectDate;
    private Integer requestTimeLimit;
    private BigDecimal dayAccumulateDpt;
    private BigDecimal dayValidBet;
    private boolean checkCollectDate = false;
    private ArrayList<SimpleGamePlatform> simpleGamePlatformArrayList = new ArrayList<>();
    private ArrayList<String> contentList = new ArrayList<>();
    private ArrayList<ActivityRequirement> activityRequirementList = new ArrayList<>();
    private K36ActivityInfo k36ActivityInfo;

    public static GetNewComerActivityResult newInstance(JSONObject rootObject) {
        GetNewComerActivityResult getNewComerActivityResult = new GetNewComerActivityResult();
        getNewComerActivityResult.setActId(rootObject.optString("actid"));
        getNewComerActivityResult.setStatus(rootObject.optInt("status"));
        getNewComerActivityResult.setMsg(rootObject.optString("msg"));
        getNewComerActivityResult.setContent(rootObject.optString("content"));
        getNewComerActivityResult.setApplyPeriod(rootObject.optInt("apply_period"));
        getNewComerActivityResult.setSigninPeriod(rootObject.optInt("signin_period"));
        getNewComerActivityResult.setSigninPeriodStart(rootObject.optInt("signin_period_start"));
        getNewComerActivityResult.setSigninPeriodEnd(rootObject.optInt("signin_period_end"));
        getNewComerActivityResult.setAchieveMethod(rootObject.optInt("achieve_method"));
        getNewComerActivityResult.setCollectDate(rootObject.optInt("collectdate"));
        getNewComerActivityResult.setRequestTimeLimit(rootObject.optInt("requestTimeLimit"));
        getNewComerActivityResult.setDayAccumulateDpt(BigDecimalUtil.optBigDecimal(rootObject, "day_accumulatedpt"));
        getNewComerActivityResult.setDayValidBet(BigDecimalUtil.optBigDecimal(rootObject, "day_validbet"));
        getNewComerActivityResult.setCheckCollectDate(rootObject.optBoolean("check_collectdate"));
        JSONArray platformArray = rootObject.optJSONArray("gpid");
        if (platformArray != null) {
            for (int i = 0; i < platformArray.length(); i++) {
                JSONObject dataObject = platformArray.optJSONObject(i);
                getNewComerActivityResult.simpleGamePlatformArrayList.add(SimpleGamePlatform.newInstance(dataObject));
            }
        }
        JSONArray contentArray = rootObject.optJSONArray("content");
        if (contentArray != null) {
            for (int i = 0; i < contentArray.length(); i++) {
                getNewComerActivityResult.contentList.add(contentArray.optString(i));
            }
        }
        JSONObject resultObject = rootObject.optJSONObject("result");
        if (resultObject != null) {
            getNewComerActivityResult.k36ActivityInfo = K36ActivityInfo.newInstance(resultObject);
        }
        JSONArray requirementArray = getRequirementArray(rootObject);
        if (requirementArray != null) {
            for (int i = 0; i < requirementArray.length(); i++) {
                getNewComerActivityResult.activityRequirementList.add(ActivityRequirement.newInstance(requirementArray.optJSONObject(i)));
            }
        }
        return getNewComerActivityResult;
    }

    private static JSONArray getRequirementArray(JSONObject rootObject) {
        String[] keySet = new String[]{
                "requirement",
                "dpt_requirement",
                "wtd_requirement",
                "signin_requirement"
        };
        for (String key : keySet) {
            JSONArray reqArray = rootObject.optJSONArray(key);
            if (reqArray != null) {
                return reqArray;
            }
        }
        return null;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getApplyPeriod() {
        return applyPeriod;
    }

    public void setApplyPeriod(Integer applyPeriod) {
        this.applyPeriod = applyPeriod;
    }

    public Integer getSigninPeriod() {
        return signinPeriod;
    }

    public void setSigninPeriod(Integer signinPeriod) {
        this.signinPeriod = signinPeriod;
    }

    public Integer getSigninPeriodStart() {
        return signinPeriodStart;
    }

    public void setSigninPeriodStart(Integer signinPeriodStart) {
        this.signinPeriodStart = signinPeriodStart;
    }

    public Integer getSigninPeriodEnd() {
        return signinPeriodEnd;
    }

    public void setSigninPeriodEnd(Integer signinPeriodEnd) {
        this.signinPeriodEnd = signinPeriodEnd;
    }

    public Integer getAchieveMethod() {
        return achieveMethod;
    }

    public void setAchieveMethod(Integer achieveMethod) {
        this.achieveMethod = achieveMethod;
    }

    public Integer getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Integer collectDate) {
        this.collectDate = collectDate;
    }

    public Integer getRequestTimeLimit() {
        return requestTimeLimit;
    }

    public void setRequestTimeLimit(Integer requestTimeLimit) {
        this.requestTimeLimit = requestTimeLimit;
    }

    public ArrayList<ActivityRequirement> getActivityRequirementList() {
        return activityRequirementList;
    }

    public void setActivityRequirementList(ArrayList<ActivityRequirement> activityRequirementList) {
        this.activityRequirementList = activityRequirementList;
    }

    public BigDecimal getDayAccumulateDpt() {
        return dayAccumulateDpt;
    }

    public void setDayAccumulateDpt(BigDecimal dayAccumulateDpt) {
        this.dayAccumulateDpt = dayAccumulateDpt;
    }

    public BigDecimal getDayValidBet() {
        return dayValidBet;
    }

    public void setDayValidBet(BigDecimal dayValidBet) {
        this.dayValidBet = dayValidBet;
    }

    public boolean isCheckCollectDate() {
        return checkCollectDate;
    }

    public void setCheckCollectDate(boolean checkCollectDate) {
        this.checkCollectDate = checkCollectDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<SimpleGamePlatform> getSimpleGamePlatformArrayList() {
        return simpleGamePlatformArrayList;
    }

    public void setSimpleGamePlatformArrayList(ArrayList<SimpleGamePlatform> simpleGamePlatformArrayList) {
        this.simpleGamePlatformArrayList = simpleGamePlatformArrayList;
    }

    public ArrayList<String> getContentList() {
        return contentList;
    }

    public void setContentList(ArrayList<String> contentList) {
        this.contentList = contentList;
    }

    public K36ActivityInfo getK36ActivityInfo() {
        return k36ActivityInfo;
    }

    public void setK36ActivityInfo(K36ActivityInfo k36ActivityInfo) {
        this.k36ActivityInfo = k36ActivityInfo;
    }
}