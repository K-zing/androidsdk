package com.kzingsdk.entity.D11;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class GetCsHistoryResult {

    private Integer curIndex;
    private Integer totalItems;
    private Integer totalPages;
    private Integer pageCount;
    private Integer pre;
    private Integer next;
    private String start;
    private String end;
    private ArrayList<CsHistory> csHistoryList = new ArrayList<>();

    public GetCsHistoryResult() {

    }

    public static GetCsHistoryResult newInstance(JSONObject rootObject) {
        GetCsHistoryResult getCsHistoryResult = new GetCsHistoryResult();
        JSONObject page = rootObject.optJSONObject("page");
        if (page != null) {
            getCsHistoryResult.setCurIndex(page.optInt("curIndex"));
            getCsHistoryResult.setTotalItems(page.optInt("totalItems"));
            getCsHistoryResult.setTotalPages(page.optInt("totalPages"));
            getCsHistoryResult.setPageCount(page.optInt("pageCount"));
            getCsHistoryResult.setPre(page.optInt("pre"));
            getCsHistoryResult.setNext(page.optInt("next"));
        }
        getCsHistoryResult.setStart(rootObject.optString("start"));
        getCsHistoryResult.setEnd(rootObject.optString("end"));
        JSONArray historyArray = rootObject.optJSONArray("history");
        if (historyArray != null) {
            for (int i = 0; i < historyArray.length(); i++) {
                getCsHistoryResult.csHistoryList.add(CsHistory.newInstance(historyArray.optJSONObject(i)));
            }
        }
        return getCsHistoryResult;
    }

    public Integer getCurIndex() {
        return curIndex;
    }

    public void setCurIndex(Integer curIndex) {
        this.curIndex = curIndex;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPre() {
        return pre;
    }

    public void setPre(Integer pre) {
        this.pre = pre;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
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

    public ArrayList<CsHistory> getCsHistoryList() {
        return csHistoryList;
    }

    public void setCsHistoryList(ArrayList<CsHistory> csHistoryList) {
        this.csHistoryList = csHistoryList;
    }
}

