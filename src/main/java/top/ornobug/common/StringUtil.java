package top.ornobug.common;

public class StringUtil {

    public static boolean isEmpty(String str) {
        return null == str || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isInteger(String source) {
        if (StringUtil.isEmpty(source)) {
            return false;
        }
        try {
            Integer.parseInt(source);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isLong(String source) {
        if (StringUtil.isEmpty(source)) {
            return false;
        }
        try {
            Long.parseLong(source);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String source) {
        if (StringUtil.isEmpty(source)) {
            return false;
        }
        try {
            Double.parseDouble(source);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isBoolean(String source) {
        if (StringUtil.isEmpty(source)) {
            return false;
        }
        try {
            Boolean.parseBoolean(source);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
