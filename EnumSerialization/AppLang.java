package com.ua.sng.fourthdimension;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sopilko on 14.09.2016.
 */
public enum AppLang {

    RU(0, "ru"),
    EN(1, "en"),
    DE(2, "de");



    public static AppLang defaultValue = AppLang.RU;

    private final int position;
    private final String code;
    private static final Map<String, AppLang> langByCode;

    static {
        langByCode = new HashMap<>();
        for (AppLang vehicleType : AppLang.values()) {
            langByCode.put(vehicleType.code, vehicleType);
        }
    }

    AppLang(int position, String code) {
        this.position = position;
        this.code = code;
    }

    public static AppLang lookupByCode(String code) {
        AppLang result = langByCode.get(code);
        return result == null ? defaultValue : result;
    }

    public int getPosition() {
        return position;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}
