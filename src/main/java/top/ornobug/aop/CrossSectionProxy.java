package top.ornobug.aop;


import java.lang.reflect.Method;

/**
 * 切面的代理实现类
 *
 * @author lzm
 */
public class CrossSectionProxy implements Proxy {
    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Class<?> targetClass = proxyChain.getTargetClass();
        Method targetMethod = proxyChain.getTargetMethod();
        Object[] parameters = proxyChain.getMethodParameters();
        Object result = null;
        begin();
        try {
            if (isIntercepted(targetClass, targetMethod, parameters)) {
                before(targetClass, targetMethod, parameters);
                result = proxyChain.doProxyChain();
                after(targetClass, targetMethod, parameters);
            } else {
                result = proxyChain.doProxyChain();
            }

        } catch (Exception e) {
            error(targetClass, targetMethod, parameters);
            throw e;
        } finally {
            end();
        }
        return result;
    }

    /**
     * 标记当前类是否被拦截
     *
     * @param cls
     * @param method
     * @param parameters
     * @return
     */
    public boolean isIntercepted(Class<?> cls, Method method, Object[] parameters) {
        return true;
    }

    public void begin() {
        System.out.println("begin");
    }

    public void before(Class<?> cls, Method method, Object[] parameters) {
        System.out.println("before");
        // System.out.println(cls.getSimpleName()+"#"+method.getName()+"[");
        // Arrays.asList(parameters).stream().forEach(System.out::println);
        // System.out.println("]");
    }

    public void after(Class<?> cls, Method method, Object[] parameters) {
        System.out.println("after");
    }

    public void error(Class<?> cls, Method method, Object[] parameters) {
        System.out.println("error");
    }

    public void end() {
        System.out.println("end");
    }
}
