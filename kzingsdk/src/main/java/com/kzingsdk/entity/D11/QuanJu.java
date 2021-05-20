package com.kzingsdk.entity.D11;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class QuanJu {

    private Integer id;
    private Integer type;
    private Integer timeFlag;
    private Integer carousel;
    private Integer preheat;
    private Integer isShow;
    private Integer isOpenNewPage;
    private boolean isFirstLevel;
    private String name;
    private String pcUrl;
    private String appUrl;
    private String h5Url;
    private String countTimeIcon;
    private String closeIcon;
    private String openIcon;
    private ArrayList<QuanJuTime> quanJuTimeList = new ArrayList<>();

    public QuanJu() {

    }

    public static QuanJu newInstance(JSONObject rootObject) {
        QuanJu quanJu = new QuanJu();
        quanJu.setId(rootObject.optInt("id"));
        quanJu.setType(rootObject.optInt("type"));
        quanJu.setTimeFlag(rootObject.optInt("timeFlag"));
        quanJu.setCarousel(rootObject.optInt("carousel"));
        quanJu.setPreheat(rootObject.optInt("preheat"));
        quanJu.setIsShow(rootObject.optInt("isShow"));
        quanJu.setIsOpenNewPage(rootObject.optInt("isOpenNewPage"));
        quanJu.setFirstLevel(rootObject.optBoolean("isFirstLevel"));
        quanJu.setName(rootObject.optString("name"));
        quanJu.setPcUrl(rootObject.optString("pcUrl"));
        quanJu.setAppUrl(rootObject.optString("appUrl"));
        quanJu.setH5Url(rootObject.optString("h5Url"));
        quanJu.setCountTimeIcon(rootObject.optString("countTimeIcon"));
        quanJu.setCloseIcon(rootObject.optString("closeIcon"));
        quanJu.setOpenIcon(rootObject.optString("openIcon"));
        JSONArray timeArray = rootObject.optJSONArray("time");
        if (timeArray != null) {
            for (int i = 0; i < timeArray.length(); i++) {
                quanJu.quanJuTimeList.add(QuanJuTime.newInstance(timeArray.optJSONObject(i)));
            }
        }
        return quanJu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTimeFlag() {
        return timeFlag;
    }

    public void setTimeFlag(Integer timeFlag) {
        this.timeFlag = timeFlag;
    }

    public Integer getCarousel() {
        return carousel;
    }

    public void setCarousel(Integer carousel) {
        this.carousel = carousel;
    }

    public Integer getPreheat() {
        return preheat;
    }

    public void setPreheat(Integer preheat) {
        this.preheat = preheat;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsOpenNewPage() {
        return isOpenNewPage;
    }

    public void setIsOpenNewPage(Integer isOpenNewPage) {
        this.isOpenNewPage = isOpenNewPage;
    }

    public boolean isFirstLevel() {
        return isFirstLevel;
    }

    public void setFirstLevel(boolean firstLevel) {
        isFirstLevel = firstLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPcUrl() {
        return pcUrl;
    }

    public void setPcUrl(String pcUrl) {
        this.pcUrl = pcUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    public String getCountTimeIcon() {
        return countTimeIcon;
    }

    public void setCountTimeIcon(String countTimeIcon) {
        this.countTimeIcon = countTimeIcon;
    }

    public String getCloseIcon() {
        return closeIcon;
    }

    public void setCloseIcon(String closeIcon) {
        this.closeIcon = closeIcon;
    }

    public String getOpenIcon() {
        return openIcon;
    }

    public void setOpenIcon(String openIcon) {
        this.openIcon = openIcon;
    }


    public static class QuanJuTime {
        private String start;
        private String end;

        public static QuanJuTime newInstance(JSONObject rootObject) {
            QuanJuTime quanJuTime = new QuanJuTime();
            quanJuTime.start = rootObject.optString("start");
            quanJuTime.end = rootObject.optString("end");
            return quanJuTime;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }
    }

}

