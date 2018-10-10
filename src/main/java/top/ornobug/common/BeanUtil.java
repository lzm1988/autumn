package top.ornobug.common;

import top.ornobug.core.bean.BeanHolder;

public class BeanUtil {

    public static Object getBeanByClass(Class<?> cls) {
        Object result = BeanHolder.getClassBeanMap().get(cls);
        if (null == result) {
            throw new RuntimeException("no bean is " + cls.getName());
        }
        return result;
    }

    public static Object getBeanByName(String beanName) {
        Object result = BeanHolder.getNameBeanMap().get(beanName);
        if (null == result) {
            throw new RuntimeException("no bean name is " + beanName);
        }
        return result;
    }

}
