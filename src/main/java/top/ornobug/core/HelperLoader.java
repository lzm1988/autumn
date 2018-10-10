package top.ornobug.core;

import top.ornobug.core.bean.BeanHolder;
import top.ornobug.core.bean.ClassScanner;
import top.ornobug.core.bean.ControllerHolder;
import top.ornobug.core.bean.IOCHelper;

public class HelperLoader {

    public static void init() {
        ClassScanner.init();
        BeanHolder.init();
        IOCHelper.init();
        ControllerHolder.init();
    }

}
