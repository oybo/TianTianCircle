package com.tt.circle.app.config;

import com.tt.circle.app.utils.DeviceUtils;

import java.util.HashMap;

/**
 * ================================================
 * author: O
 * created on: 2017/7/11 14:13
 * description:
 * ================================================
 */
public class ApiParamsMap extends HashMap<String, String> {

    public ApiParamsMap() {
        put(CLIENT_ID_KEY, CLIENT_ID);
        put(CLIENT_SECRET_KEY, CLIENT_SECRET);
        put(DEVICE_ID_KEY, DeviceUtils.getDeviceId());
        put(LANGUAGE_KEY, LANGUAGE);
        put(MODEL_KEY, DeviceUtils.getModel());
    }

    //====================key=================================
    //client_secret
    public final static String CLIENT_SECRET_KEY = "client_secret";
    //client_id
    public final static String CLIENT_ID_KEY = "client_id";

    public final static String DEVICE_ID_KEY = "device_id";

    public final static String LANGUAGE_KEY = "language";

    public final static String MODEL_KEY = "model";


    //====================value=================================
    //client_secret
    public final static String CLIENT_SECRET = "38e8c5aet76d5c012e32";
    //client_id
    public final static String CLIENT_ID = "1089857302";

    public final static String LANGUAGE = "zh-Hans";
}
