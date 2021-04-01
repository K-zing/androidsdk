package com.kzingsdk.util;

import java.text.SimpleDateFormat;


public final class Constant {

    private Constant(){

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static class Pref {
        public static final String PREF_FILE_NAME = "com.kzingsdk";
        public static final String VCTOKEN = PREF_FILE_NAME + "." + "VCTOKEN";
        public static final String CCTOKEN = PREF_FILE_NAME + "." + "CCTOKEN";
        public static final String VCID = PREF_FILE_NAME + "." + "VCID";
        public static final String SESSIONID = PREF_FILE_NAME + "." + "SESSIONID";
        public static final String LANGCODE = PREF_FILE_NAME + "." + "LANGCODE";
        public static final String DATAKEY = PREF_FILE_NAME + "." + "DATAKEY";
        public static final String BASICKEY = PREF_FILE_NAME + "." + "BASICKEY";
        public static final String AID = PREF_FILE_NAME + "." + "AID";
        public static final String USE_BETTER_URL = PREF_FILE_NAME + "." + "USE_BETTER_URL";

        public static final String GAMEPLATFORM = PREF_FILE_NAME + "." + "GAMEPLATFORM";
        public static final String GAMEPLATFORMCHILD = PREF_FILE_NAME + "." + "GAMEPLATFORMCHILDARRAY";

    }

    public static final SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");


}
