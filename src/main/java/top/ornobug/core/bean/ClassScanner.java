package top.ornobug.core.bean;

import org.apache.commons.lang3.StringUtils;
import top.ornobug.annotation.Component;
import top.ornobug.annotation.Controller;
import top.ornobug.annotation.Service;
import top.ornobug.common.ClassUtil;
import top.ornobug.common.StringUtil;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 持有从基础包下加载的类
 */
public class ClassScanner {

    private static final Set<Class<?>> CLASS_SET = new HashSet<>();

    public static void init() {
        CLASS_SET.addAll(ClassUtil.getClassSet(AutumnConfig.getBasePackage()));
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                Annotation service = cls.getAnnotation(Service.class);
                ((Service) service).name();
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Map<String, Class<?>> getServiceNameMap() {
        Map<String, Class<?>> map = new HashMap<String, Class<?>>();
        for (Class cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                Annotation service = cls.getAnnotation(Service.class);
                String name = ((Service) service).name();
                if (StringUtils.isEmpty(name)) {
                    name = StringUtil.firstLower(cls.getSimpleName());
                }
                map.put(name, cls);
            }
        }
        return map;
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
