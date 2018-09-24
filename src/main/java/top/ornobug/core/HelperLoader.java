package top.ornobug.core;

import top.ornobug.common.ClassUtil;
import top.ornobug.core.bean.BeanHelper;
import top.ornobug.core.bean.ClassHelper;
import top.ornobug.core.bean.ControllerHelper;
import top.ornobug.core.bean.IOCHelper;

public class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IOCHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }

}
