package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;


public class AgentHistoryResult {

    private Integer next;
    private Integer totalItems;
    private Integer pageCount;
    private Integer pre;
    private Integer totalPages;
    private Integer curIndex;
    private BigDecimal totalDptAmt;
    private BigDecimal totalWtdAmt;
    private BigDecimal totalValidBetAmt;
    private BigDecimal totalWinloss;
    private ArrayList<AgentHistory> agentHistoryList = new ArrayList<>();

    public static AgentHistoryResult newInstance(JSONObject rootObject) {
        AgentHistoryResult agentHistoryResult = new AgentHistoryResult();
        JSONObject pageObject = rootObject.optJSONObject("page");
        agentHistoryResult.setNext(pageObject.optInt("next"));
        agentHistoryResult.setTotalItems(pageObject.optInt("totalItems"));
        agentHistoryResult.setPageCount(pageObject.optInt("pageCount"));
        agentHistoryResult.setPre(pageObject.optInt("pre"));
        agentHistoryResult.setTotalPages(pageObject.optInt("totalPages"));
        agentHistoryResult.setCurIndex(pageObject.optInt("curIndex"));
        agentHistoryResult.setTotalDptAmt(BigDecimalUtil.optBigDecimal(pageObject, "total_dpt_amt"));
        agentHistoryResult.setTotalWtdAmt(BigDecimalUtil.optBigDecimal(pageObject, "total_wtd_amt"));
        agentHistoryResult.setTotalValidBetAmt(BigDecimalUtil.optBigDecimal(pageObject, "total_validbetamt"));
        agentHistoryResult.setTotalWinloss(BigDecimalUtil.optBigDecimal(pageObject, "total_winloss"));

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

    public BigDecimal getTotalDptAmt() {
        return totalDptAmt;
    }

    public void setTotalDptAmt(BigDecimal totalDptAmt) {
        this.totalDptAmt = totalDptAmt;
    }

    public BigDecimal getTotalWtdAmt() {
        return totalWtdAmt;
    }

    public void setTotalWtdAmt(BigDecimal totalWtdAmt) {
        this.totalWtdAmt = totalWtdAmt;
    }

    public BigDecimal getTotalValidBetAmt() {
        return totalValidBetAmt;
    }

    public void setTotalValidBetAmt(BigDecimal totalValidBetAmt) {
        this.totalValidBetAmt = totalValidBetAmt;
    }

    public BigDecimal getTotalWinloss() {
        return totalWinloss;
    }

    public void setTotalWinloss(BigDecimal totalWinloss) {
        this.totalWinloss = totalWinloss;
    }
}

