package top.ornobug.web;

import top.ornobug.common.JsonUtil;
import top.ornobug.common.ReflectionUtil;
import top.ornobug.common.WebUtil;
import top.ornobug.core.bean.BeanHelper;
import top.ornobug.core.bean.ControllerHelper;
import top.ornobug.web.view.JsonView;
import top.ornobug.web.view.View;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatchServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestMethod = req.getMethod().toUpperCase();
        String requestPath = req.getPathInfo();

        if ("/".equals(requestPath)) {
            WebUtil.redirectRequest("/index", req, resp);
        }

        RequestHandler requestHandler = ControllerHelper.getRequestHandler(requestPath, requestMethod);
        Class<?> controllerClass = requestHandler.getControllerClass();
        Object controllerBean = BeanHelper.getBean(controllerClass);

        RequestParam requestParam = new RequestParam(readParam(req));
        Method requestMappingMethod = requestHandler.getMethod();
        Object result = ReflectionUtil.invokeMethod(controllerBean, requestMappingMethod, requestParam);
        if (result instanceof View) {

        } else if (result instanceof JsonView) {
            JsonView jsonView = (JsonView) result;
            Object data = jsonView.getData();
            if (null != data) {
                resp.setContentType("application/json; charset=utf-8");
                WebUtil.writeDataToResponse(JsonUtil.obj2Json(data), resp);
            }
        }
    }

    private Map<String, Object> readParam(HttpServletRequest request) {
        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            // 获取普通表单参数
            String paramValue = request.getParameter(paramName);
            paramMap.put(paramName, paramValue);
        }
        // todo 获取文件

        return paramMap;
    }
}
