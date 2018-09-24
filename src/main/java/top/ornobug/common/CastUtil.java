package top.ornobug.common;


/**
 * 类型转换工具类
 */
public class CastUtil {

    public static Integer string2Integer(String source) {
        return string2Integer(source, 0);
    }

    public static Integer string2Integer(String source, Integer defaultValue) {
        if (StringUtil.isInteger(source)) {
            return Integer.valueOf(source);
        } else {
            return defaultValue;
        }
    }

    public static Long string2Long(String source) {
        return string2Long(source, 0L);
    }

    public static Long string2Long(String source, Long defaultValue) {
        if (StringUtil.isInteger(source)) {
            return Long.valueOf(source);
        } else {
            return defaultValue;
        }
    }

    public static Double string2Double(String source) {
        return string2Double(source, 0.00D);
    }

    public static Double string2Double(String source, Double defaultValue) {
        if (StringUtil.isDouble(source)) {
            return Double.valueOf(source);
        } else {
            return defaultValue;
        }
    }

    public static Boolean string2Boolean(String source) {
        return string2Boolean(source, false);
    }

    public static Boolean string2Boolean(String source, Boolean defaultValue) {
        if (StringUtil.isBoolean(source)) {
            return Boolean.parseBoolean(source);
        }
        return defaultValue;
    }

}
