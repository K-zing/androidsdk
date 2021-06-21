package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class AgentHistoryResult {

    private Integer next;
    private Integer totalItems;
    private Integer pageCount;
    private Integer pre;
    private Integer totalPages;
    private Integer curIndex;
    private ArrayList<AgentHistory> agentHistoryList = new ArrayList<>();

    public static AgentHistoryResult newInstance(JSONObject rootObject) {
        AgentHistoryResult agentHistoryResult = new AgentHistoryResult();
        agentHistoryResult.setNext(rootObject.optInt("next"));
        agentHistoryResult.setTotalItems(rootObject.optInt("totalItems"));
        agentHistoryResult.setPageCount(rootObject.optInt("pageCount"));
        agentHistoryResult.setPre(rootObject.optInt("pre"));
        agentHistoryResult.setTotalPages(rootObject.optInt("totalPages"));
        agentHistoryResult.setCurIndex(rootObject.optInt("curIndex"));
        JSONArray agentHistoryArray = rootObject.optJSONArray("history");
        if (agentHistoryArray != null) {
            for (int i = 0; i < agentHistoryArray.length(); i++) {
                agentHistoryResult.agentHistoryList.add(AgentHistory.newInstance(agentHistoryArray.optJSONObject(i)));
            }
        }
        return agentHistoryResult;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
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

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurIndex() {
        return curIndex;
    }

    public void setCurIndex(Integer curIndex) {
        this.curIndex = curIndex;
    }

    public ArrayList<AgentHistory> getAgentHistoryList() {
        return agentHistoryList;
    }

    public void setAgentHistoryList(ArrayList<AgentHistory> agentHistoryList) {
        this.agentHistoryList = agentHistoryList;
    }
}

