package top.ornobug.core.bean;

import top.ornobug.annotation.Inject;
import top.ornobug.common.ArrayUtil;
import top.ornobug.common.CollectionUtil;
import top.ornobug.common.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

public class IOCHelper {

    public static void init() {
        // 获取bean的映射，这些已经初始化好了的bean的实例
        Map<Class<?>, Object> classBeanMap = BeanHelper.getClassBeanMap();
        if (CollectionUtil.isNotEmpty(classBeanMap)) {
            for (Map.Entry<Class<?>, Object> entry : classBeanMap.entrySet()) {
                Class<?> beanClass = entry.getKey();
                Object beanInstance = entry.getValue();
                Field[] fields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(fields)) {
                    for (Field field : fields) {
                        // 如果需要依赖注入
                        if (field.isAnnotationPresent(Inject.class)) {
                            // 获取待注入的变量的类型
                            Class<?> fieldClass = field.getType();
                            // 从beanmap获得bean的实例
                            Object fieldInstance = classBeanMap.get(fieldClass);
                            if (null != fieldInstance) {
                                // 反射赋值
                                ReflectionUtil.setField(beanInstance, field, fieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }

}
