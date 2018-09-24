package top.ornobug.common;

import com.google.gson.Gson;

public class JsonUtil {

    private static final Gson GSON = new Gson();

    public static String obj2Json(Object object) {
        return GSON.toJson(object);
    }

}
