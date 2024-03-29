package com.kzingsdk.entity.gameplatform;

import com.kzingsdk.requests.KzingAPI;
import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

import static com.kzingsdk.entity.gameplatform.GameOrientation.PORTRAIT;

/**
 * Except when {@link GamePlatformType} is {@link GamePlatformType#GAME} or the object is {@link GamePlatformCustom} class,
 * all {@link GamePlatform} can be played directly by passing the object to {@link KzingAPI#enterGame()} when it is available.
 * <p>
 * For {@link GamePlatformType#GAME}, a sub game must be chosen and pass to {@link KzingAPI#enterGame()}
 * <p>
 * Please check if the object is {@link GamePlatformCustom}. You need to handle it differently to get the actual {@link GamePlatform} or sub game.
 */
public class GamePlatform extends SimpleGamePlatform implements Playable {

    public static final int MAINTAIN = 0;
    public static final int NOT_MAINTAIN = 1;
    protected String image = "";
    protected HashMap<String, Integer> currencyDisplayOrderMap = new HashMap<>();
    private String gpaccountid = "";
    private String gpename = "";
    private String frameIcons = "0";
    private long maintainStart = 0L;
    private long maintainEnd = 0L;
    private String url = "";
    private GamePlatformType gamePlatformType;
    private EnumSet<PlayStatus> playStatus = EnumSet.noneOf(PlayStatus.class);
    private int statusCode = NOT_MAINTAIN;
    private int clientStatusCode = NOT_MAINTAIN;
    private int conversion = 0;
    private BigDecimal highestRebate = BigDecimal.ZERO;
    private boolean isDummy = false;
    private boolean hasChild = false;
    private ArrayList<GamePlatformChild> childArrayList = new ArrayList<>();
    private ArrayList<GamePlatformCategory> categoryArrayList = new ArrayList<>();
    private ArrayList<GamePlatformGroup> groupArrayList = new ArrayList<>();
    private GameOrientation gameOrientation = PORTRAIT;

    public GamePlatform() {
        currencyDisplayOrderMap.put("default", 0);
    }

    public static GamePlatform createDummyInstance() {
        GamePlatform item = new GamePlatform();
        item.isDummy = true;
        return item;
    }

    protected static GamePlatform newInstance(JSONObject rootObject, boolean handleByCustom) {
        GamePlatform item = new GamePlatform();
        item.setUrl(rootObject.optString("app_url"));
        item.setGpAccountid(rootObject.optString("gpaccountid"));
        item.setGpid(rootObject.optString("gpid"));
        item.setGpname(rootObject.optString("gpnameCN"));
        item.setGpename(rootObject.optString("gpnameEN"));
        item.setMaintainStart(rootObject.optLong("maintain_start", 0L));
        item.setMaintainEnd(rootObject.optLong("maintain_end", 0L));
        item.setStatusCode(rootObject.optInt("status", NOT_MAINTAIN));
        item.setClientStatusCode(rootObject.optInt("client_status", NOT_MAINTAIN));
        item.setFrameIcons(rootObject.optString("frame_icons"));
        item.setGamePlatformType(GamePlatformType.valueOfTypeId(rootObject.optInt("gptype")));
        int statusFlag = rootObject.optInt("enable_an_app", 0) << 1 | rootObject.optInt("enable_an_h5", 0);
        item.setPlayStatus(PlayStatus.getPlayStatus(statusFlag));
        item.setImage(rootObject.optString("image_an"));
        item.setGameOrientation(GameOrientation.values()[rootObject.optInt("orientation", 0)]);
        Integer defaultCurrency = rootObject.optInt("displayorder");
        item.currencyDisplayOrderMap.put("default", defaultCurrency);
        JSONArray currenciesArray = rootObject.optJSONArray("currencies");
        JSONObject displayOrdersObject = rootObject.optJSONObject("displayorders");
        if (currenciesArray != null) {
            for (int i = 0; i < currenciesArray.length(); i++) {
                String currency = currenciesArray.optString(i);
                Integer displayOrder = displayOrdersObject != null ? displayOrdersObject.optInt(currency) : defaultCurrency;
                item.currencyDisplayOrderMap.put(currenciesArray.optString(i), displayOrder);
            }
        }
        return item;
    }

    public static GamePlatform newInstanceFromEp(JSONObject rootObject, GamePlatformType type) {
        GamePlatform item = new GamePlatform();
        item.setGpAccountid(rootObject.optString("gpaccountid"));
        item.setGpid(rootObject.optString("gpid"));
        item.setGpname(rootObject.optString("gpname"));
        item.setMaintainStart(rootObject.optLong("maintain_start", 0L));
        item.setMaintainEnd(rootObject.optLong("maintain_end", 0L));
        item.setStatusCode(rootObject.optInt("status", NOT_MAINTAIN));
        item.setClientStatusCode(rootObject.optInt("client_status", NOT_MAINTAIN));
        item.setFrameIcons(rootObject.optString("frame_icons"));
        item.setGamePlatformType(type);
        item.setImage(rootObject.optString("logo"));
        item.setConversion(rootObject.optInt("conversion"));
        item.setHighestRebate(BigDecimalUtil.optBigDecimal(rootObject, "highest_rebate"));
        item.setGameOrientation(GameOrientation.values()[rootObject.optInt("orientation", 0)]);
        item.setHasChild(rootObject.optInt("haschild") == 1);
        Integer defaultCurrency = rootObject.optInt("displayorder");
        item.currencyDisplayOrderMap.put("default", defaultCurrency);

        ArrayList<GamePlatformCategory> categoryList = new ArrayList<>();
        JSONArray categorysArray = rootObject.optJSONArray("categories");
        if (categorysArray != null) {
            for (int j = 0; j < categorysArray.length(); j++) {
                categoryList.add(GamePlatformCategory.newInstance(categorysArray.optJSONObject(j), item.getGpid()));
            }
        }
        item.setCategoryArrayList(categoryList);
        JSONArray childGroupsArray = rootObject.optJSONArray("childgroups");
        if (childGroupsArray != null) {
            for (int i = 0; i < childGroupsArray.length(); i++) {
                JSONObject childGroup = childGroupsArray.optJSONObject(i);
                JSONArray childArray = childGroup.optJSONArray("childs");
                String childgroupid = childGroup.optString("childgroupid");
                String childgroupname = childGroup.optString("childgroupname");
                if (childArray != null) {
                    for (int j = 0; j < childArray.length(); j++) {
                        item.childArrayList.add(GamePlatformChild.newInstance(childArray.optJSONObject(j), item, childgroupid, childgroupname));
                    }
                }
                item.groupArrayList.add(GamePlatformGroup.newInstance(childGroup, item));
            }
        }

        JSONArray currenciesArray = rootObject.optJSONArray("currencies");
        JSONObject displayOrdersObject = rootObject.optJSONObject("displayorders");
        if (currenciesArray != null) {
            for (int i = 0; i < currenciesArray.length(); i++) {
                String currency = currenciesArray.optString(i);
                Integer displayOrder = displayOrdersObject != null ? displayOrdersObject.optInt(currency) : defaultCurrency;
                item.currencyDisplayOrderMap.put(currenciesArray.optString(i), displayOrder);
            }
        }
        return item;
    }

    public static GamePlatform newInstance(JSONObject rootObject) {
        return newInstance(rootObject, false);
    }

    public static GamePlatform newChildInstance() {
        return newChildInstance();
    }

    public GamePlatform clone() {
        GamePlatform gp = new GamePlatform();
        gp.gpid = gpid;
        gp.gpaccountid = gpaccountid;
        gp.gpname = gpname;
        gp.gpename = gpename;
        gp.url = url;
        gp.image = image;
        gp.conversion = conversion;
        gp.highestRebate = highestRebate;
        gp.gamePlatformType = gamePlatformType;
        gp.playStatus = playStatus;
        gp.statusCode = statusCode;
        gp.clientStatusCode = clientStatusCode;
        gp.frameIcons = frameIcons;
        gp.isDummy = isDummy;
        gp.childArrayList = (ArrayList<GamePlatformChild>) childArrayList.clone();
        gp.categoryArrayList = (ArrayList<GamePlatformCategory>) categoryArrayList.clone();
        gp.groupArrayList = (ArrayList<GamePlatformGroup>) groupArrayList.clone();
        gp.currencyDisplayOrderMap = (HashMap<String, Integer>) currencyDisplayOrderMap.clone();
        gp.gameOrientation = gameOrientation;
        return gp;
    }

    public ArrayList<GamePlatformChild> getChildListByCategory(GamePlatformCategory gamePlatformCategory) {
        ArrayList<GamePlatformChild> resultList = new ArrayList<>();
        for (GamePlatformChild child : childArrayList) {
            if (child.getCategorysSet().contains(Integer.parseInt(gamePlatformCategory.getChildCategoryId()))) {
                resultList.add(child);
            }
        }
        return resultList;
    }

    @Override
    public String getGpAccountId() {
        return gpaccountid;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public void setGpAccountid(String gpaccountid) {
        this.gpaccountid = gpaccountid;
    }

    public String getGpname() {
        return gpname;
    }

    public void setGpname(String gpname) {
        this.gpname = gpname;
    }

    public String getGpename() {
        return gpename;
    }

    public void setGpename(String gpename) {
        this.gpename = gpename;
    }

    public long getMaintainStart() {
        return maintainStart;
    }

    public void setMaintainStart(long maintainStart) {
        this.maintainStart = maintainStart;
    }

    public long getMaintainEnd() {
        return maintainEnd;
    }

    public void setMaintainEnd(long maintainEnd) {
        this.maintainEnd = maintainEnd;
    }

    public int getDisplayorder() {
        return currencyDisplayOrderMap.get("default");
    }

    public int getDisplayorder(String currency) {
        return currencyDisplayOrderMap.get(currency);
    }

    public HashMap<String, Integer> getCurrencyDisplayOrderMap() {
        return currencyDisplayOrderMap;
    }

    public void setCurrencyDisplayOrderMap(HashMap<String, Integer> currencyDisplayOrderMap) {
        this.currencyDisplayOrderMap = currencyDisplayOrderMap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getConversion() {
        return conversion;
    }

    public GamePlatform setConversion(int conversion) {
        this.conversion = conversion;
        return this;
    }

    public BigDecimal getHighestRebate() {
        return highestRebate;
    }

    public void setHighestRebate(BigDecimal highestRebate) {
        this.highestRebate = highestRebate;
    }

    public String getFrameIcons() {
        return frameIcons;
    }

    public void setFrameIcons(String frameIcons) {
        this.frameIcons = frameIcons;
    }

    public EnumSet<PlayStatus> getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(EnumSet<PlayStatus> playStatus) {
        this.playStatus = playStatus;
    }

    public ArrayList<GamePlatformCategory> getCategoryArrayList() {
        return categoryArrayList;
    }

    public void setCategoryArrayList(ArrayList<GamePlatformCategory> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
    }

    public ArrayList<GamePlatformChild> getChildArrayList() {
        return childArrayList;
    }

    public void setChildArrayList(ArrayList<GamePlatformChild> childArrayList) {
        this.childArrayList = childArrayList;
    }

    public GamePlatformType getGamePlatformType() {
        return gamePlatformType;
    }

    public void setGamePlatformType(GamePlatformType gamePlatformType) {
        this.gamePlatformType = gamePlatformType;
    }

    public boolean isAppOnly() {
        return getPlayStatus().contains(GamePlatform.PlayStatus.ENABLE_APP) &&
                !getPlayStatus().contains(GamePlatform.PlayStatus.ENABLE_H5);
    }

    public boolean isDummy() {
        return isDummy;
    }

    public void setDummy(boolean dummy) {
        isDummy = dummy;
    }

    public ArrayList<GamePlatformGroup> getGroupArrayList() {
        return groupArrayList;
    }

    public void setGroupArrayList(ArrayList<GamePlatformGroup> groupArrayList) {
        this.groupArrayList = groupArrayList;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getClientStatusCode() {
        return clientStatusCode;
    }

    public void setClientStatusCode(int clientStatusCode) {
        this.clientStatusCode = clientStatusCode;
    }

    public GameOrientation getGameOrientation() {
        return gameOrientation;
    }

    public void setGameOrientation(GameOrientation gameOrientation) {
        this.gameOrientation = gameOrientation;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public GamePlatform setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
        return this;
    }

    @Override
    public String toString() {
        return "GamePlatform{" +
                "gpid='" + gpid + '\'' +
                ", gpaccountid='" + gpaccountid + '\'' +
                ", gpname='" + gpname + '\'' +
                ", maintainStart=" + maintainStart +
                ", maintainEnd=" + maintainEnd +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", gamePlatformType=" + gamePlatformType +
                ", playStatus=" + playStatus +
                ", frameIcons=" + frameIcons +
                ", statusCode=" + statusCode +
                ", gameOrientation=" + gameOrientation +
                ", isDummy=" + isDummy +
                ", childArrayList=" + childArrayList +
                ", categoryArrayList=" + categoryArrayList +
                ", groupArrayList=" + groupArrayList +
                '}';
    }

    public enum PlayStatus {
        ENABLE_H5(1 << 0),
        ENABLE_APP(1 << 1);

        private final int playStatusValue;

        PlayStatus(int playStatusValue) {
            this.playStatusValue = playStatusValue;
        }

        public static EnumSet<PlayStatus> getPlayStatus(int statusValue) {
            EnumSet statusFlags = EnumSet.noneOf(PlayStatus.class);
            for (PlayStatus playStatus : PlayStatus.values()) {
                if ((playStatus.getPlayStatusValue() & statusValue) == playStatus.getPlayStatusValue()) {
                    statusFlags.add(playStatus);
                }
            }
            return statusFlags;
        }

        public int getPlayStatusValue() {
            return playStatusValue;
        }
    }

}
