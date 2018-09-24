package top.ornobug.core.bean;

import top.ornobug.annotation.Component;
import top.ornobug.annotation.Controller;
import top.ornobug.annotation.Service;
import top.ornobug.common.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 持有从基础包下加载的类
 */
public class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static {
        CLASS_SET = ClassUtil.getClassSet(AutumnConfig.getBasePackage());
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getControllerSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getComponentSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Component.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getBeanSet() {
        Set<Class<?>> classSet = new HashSet<>();
        classSet.addAll(getServiceSet());
        classSet.addAll(getControllerSet());
        classSet.addAll(getComponentSet());
        return classSet;
    }
}
