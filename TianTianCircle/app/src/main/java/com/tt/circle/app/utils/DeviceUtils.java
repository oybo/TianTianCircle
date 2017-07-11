package com.tt.circle.app.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.File;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/8/1
 *     desc  : 设备相关工具类
 * </pre>
 */
public final class DeviceUtils {

    private static String DEVICE_ID = "";

    private DeviceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 获取 移动终端设备id号
     */
    public static String getDeviceId() {
        Context context = Utils.getContext();
        String id = DEVICE_ID;
        if (id.length() == 0) {
            try {
                id = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
            } catch (Exception e) {
            }
            if (id == null)
                id = "";
        }
        if (id.length() == 0) {
            try {
                id = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getSimSerialNumber();
            } catch (Exception e) {
            }
            if (id == null)
                id = "";
        }
        if (id.length() == 0) {
            try {
                id = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getLine1Number();
            } catch (Exception e) {
            }
            if (id == null)
                id = "";
        }
        if (id.length() == 0) {
            try {
                Class<?> c = Class.forName("android.os.SystemProperties");
                Method get = c.getMethod("get", String.class, String.class);
                id = (String) (get.invoke(c, "ro.serialno", "unknown"));
            } catch (Exception e) {
            }
        }
        if (id.length() == 0 || "0".equals(id)) {
            // 随机生成
            id = UUID.randomUUID().toString().replaceAll("-", "");
        }
        DEVICE_ID = id;
        return id;
    }

    /**
     * 判断设备是否root
     *
     * @return the boolean{@code true}: 是<br>{@code false}: 否
     */
    public static boolean isDeviceRooted() {
        String su = "su";
        String[] locations = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/",
                "/data/local/xbin/", "/data/local/bin/", "/data/local/"};
        for (String location : locations) {
            if (new File(location + su).exists()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取设备系统版本号
     *
     * @return 设备系统版本号
     */
    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }


    /**
     * 获取设备AndroidID
     *
     * @return AndroidID
     */
    @SuppressLint("HardwareIds")
    public static String getAndroidID() {
        return Settings.Secure.getString(Utils.getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取设备型号
     * <p>如MI2SC</p>
     *
     * @return 设备型号
     */
    public static String getModel() {
        String model = Build.MODEL;
        if (model != null) {
            model = model.trim().replaceAll("\\s*", "");
        } else {
            model = "";
        }
        return model;
    }

}
