package top.ornobug.core.bean;

import top.ornobug.common.ReflectionUtil;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 持有bean,bean容器
 */

public class BeanHelper {

    /**
     * 存放class与bean的映射
     */
    private static final Map<Class<?>, Object> CLASS_BEAN_MAP = new ConcurrentHashMap<>();
    /**
     * 存放bean名字与bean的映射
     */
    private static final Map<String, Object> NAME_BEAN_MAP = new ConcurrentHashMap<>();

    public static void init() {
        Set<Class<?>> classSet = ClassHelper.getBeanSet();
        for (Class cls : classSet) {
            Object instance = ReflectionUtil.newInstance(cls);
            CLASS_BEAN_MAP.put(cls, instance);
        }
        Map<String, Class<?>> map = ClassHelper.getServiceNameMap();
        NAME_BEAN_MAP.putAll(map);
        XMLBeanDefineLoader.init();
    }

    public static Map<Class<?>, Object> getClassBeanMap() {
        return CLASS_BEAN_MAP;
    }

    public static Map<String, Object> getNameBeanMap() {
        return NAME_BEAN_MAP;
    }

    public static Map<Class<?>, Object> putClassBeanMap(Class<?> key, Object val) {
        CLASS_BEAN_MAP.put(key, val);
        return CLASS_BEAN_MAP;
    }

    public static Map<Class<?>, Object> putNameBeanMap(String key, Object val) {
        NAME_BEAN_MAP.put(key, val);
        return CLASS_BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cls) {
        if (!CLASS_BEAN_MAP.containsKey(cls)) {

            throw new RuntimeException("can not get bean by class:" + cls.getName());
        }
        return (T) CLASS_BEAN_MAP.get(cls);
    }

}
