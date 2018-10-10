package top.ornobug.core.bean;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.ornobug.annotation.RequestMapping;
import top.ornobug.common.ArrayUtil;
import top.ornobug.common.CollectionUtil;
import top.ornobug.common.JsonUtil;
import top.ornobug.web.Request;
import top.ornobug.web.RequestHandler;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ControllerHolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerHolder.class);

    private static final Map<Request, RequestHandler> REQUEST_HANDLER_MAP = new ConcurrentHashMap<>();

    public static void init() {
        Set<Class<?>> controllerSet = ClassScanner.getControllerSet();
        if (CollectionUtil.isNotEmpty(controllerSet)) {
            for (Class<?> controller : controllerSet) {
                Method[] methods = controller.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                            String[] path = requestMapping.path();
                            String[] requestMethod = requestMapping.method();
                            Request request = new Request(requestMethod, path);
                            RequestHandler requestHandler = new RequestHandler(controller, method);
                            LOGGER.debug("loading requestMapping:" + JsonUtil.obj2Json(path)
                                    + " , " + JsonUtil.obj2Json(requestMethod)
                                    + " , " + controller.getName() + "#" + method.getName());
                            REQUEST_HANDLER_MAP.put(request, requestHandler);
                        }
                    }
                }
            }
        }
    }

    public static RequestHandler getRequestHandler(String requestPath, String requestMethod) {
        RequestHandler requestHandler = null;
        for (Request request : REQUEST_HANDLER_MAP.keySet()) {
            String[] paths = request.getPath();
            String[] requestMethods = request.getRequestMethods();
            if (ArrayUtils.contains(paths, requestPath)
                    && ArrayUtils.contains(requestMethods, requestMethod.toUpperCase())) {
                requestHandler = REQUEST_HANDLER_MAP.get(request);
                LOGGER.debug("find requestPath[" + requestPath + "] and requestMethod[" + requestMethod + "]");
                break;
            }
        }

        if (null == requestHandler) {
            LOGGER.error("no requestMapping![" + requestPath + "][" + requestMethod + "]");
            throw new RuntimeException("no requestMapping![" + requestPath + "][" + requestMethod + "]");
        }

        return requestHandler;
    }

}
