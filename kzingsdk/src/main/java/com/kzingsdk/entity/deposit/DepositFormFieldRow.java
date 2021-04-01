package com.kzingsdk.entity.deposit;

import org.json.JSONObject;

import java.util.ArrayList;

public class DepositFormFieldRow {

    private int rowId;
    private String rowName;
    private ArrayList<DepositFormField> fieldArrayList = new ArrayList<>();

    public static DepositFormFieldRow newInstance(JSONObject rootObject) {
        DepositFormFieldRow item = new DepositFormFieldRow();
        item.setRowId(rootObject.optInt("rowid"));
        item.setRowName(rootObject.optString("rowname"));
        return item;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public ArrayList<DepositFormField> getFieldArrayList() {
        return fieldArrayList;
    }

    public void setFieldArrayList(ArrayList<DepositFormField> fieldArrayList) {
        this.fieldArrayList = fieldArrayList;
    }
}
