package top.ornobug.common;

import org.apache.commons.lang3.StringUtils;

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

    public static String firstUpper(String source) {

        if (StringUtils.isEmpty(source)) {
            return null;
        } else {
            if (source.length() == 1) {
                return source.toUpperCase();
            } else if (source.length() > 1) {
                String first = String.valueOf(source.charAt(0)).toUpperCase();
                return first + source.substring(1);
            }
        }
        return null;
    }

    public static String firstLower(String source) {

        if (StringUtils.isEmpty(source)) {
            return null;
        } else {
            if (source.length() == 1) {
                return source.toLowerCase();
            } else if (source.length() > 1) {
                String first = String.valueOf(source.charAt(0)).toLowerCase();
                return first + source.substring(1);
            }
        }
        return null;
    }

}
