package top.ornobug.common;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtil {

    public static boolean isEmpty(Object[] objects) {
        return ArrayUtils.isEmpty(objects);
    }

    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

}
