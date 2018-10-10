package top.ornobug.core;

import top.ornobug.core.bean.BeanHelper;
import top.ornobug.core.bean.ClassHelper;
import top.ornobug.core.bean.ControllerHelper;
import top.ornobug.core.bean.IOCHelper;

public class HelperLoader {

    public static void init() {
        ClassHelper.init();
        BeanHelper.init();
        IOCHelper.init();
        ControllerHelper.init();
    }

}
