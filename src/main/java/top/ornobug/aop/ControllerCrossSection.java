package top.ornobug.aop;

import top.ornobug.annotation.Controller;
import top.ornobug.annotation.CrossSection;

import java.lang.reflect.Method;

/**
 * 要拦截使用了Controller注解的类
 */
@CrossSection(value = Controller.class)
public class ControllerCrossSection extends CrossSectionProxy {

    private long usedTime;

    /**
     * 使用Controller注解的类的方法在执行前会执行该before方法
     *
     * @param cls
     * @param method
     * @param parameters
     */
    @Override
    public void before(Class<?> cls, Method method, Object[] parameters) {
        System.out.println("---------- before ----------");
        System.out.println("class:" + cls.getName());
        System.out.println("method:" + method.getName());
        usedTime = System.currentTimeMillis();
    }

    /**
     * 使用Controller注解的类的方法在执行后会执行该before方法
     *
     * @param cls
     * @param method
     * @param parameters
     */
    @Override
    public void after(Class<?> cls, Method method, Object[] parameters) {
        System.out.println("---------- after ----------");
        System.out.println("usedTime:" + (System.currentTimeMillis() - usedTime) + "ms");
    }
}
