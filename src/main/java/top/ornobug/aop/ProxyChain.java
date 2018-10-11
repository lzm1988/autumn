package top.ornobug.aop;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ProxyChain {

    private final Class<?> targetClass;
    private final Object targetObj;
    private final Method targetMethod;
    private final MethodProxy methodProxy;
    private final Object[] methodParameters;

    private List<Proxy> proxyList = new ArrayList<Proxy>();
    private int proxyIndex = 0;

    public ProxyChain(Class<?> targetClass, Object targetObj, Method targetMethod,
                      MethodProxy methodProxy, Object[] methodParameters, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObj = targetObj;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.methodParameters = methodParameters;
        this.proxyList.addAll(proxyList);
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTargetObj() {
        return targetObj;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Object[] getMethodParameters() {
        return methodParameters;
    }

    public Object doProxyChain() throws Throwable {
        Object result = null;
        if (proxyIndex < proxyList.size()) {
            result = proxyList.get(proxyIndex).doProxy(this);
        } else {
            result = methodProxy.invokeSuper(targetObj, methodParameters);
        }
        return result;
    }
}
