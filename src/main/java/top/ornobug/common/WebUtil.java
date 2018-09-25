package top.ornobug.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class WebUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebUtil.class);

    public static void redirectRequest(String path, HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(request.getContextPath() + path);
        } catch (Exception var4) {
            LOGGER.error("重定向请求出错！", var4);
            throw new RuntimeException(var4);
        }
    }

    public static void writeDataToResponse(String data, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = null;
            writer = response.getWriter();
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LOGGER.error("向response写数据出错！", e);
            throw new RuntimeException(e);
        }
    }

    public static void writeDataToResponse(byte[] data, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("utf-8");
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            LOGGER.error("向response写数据出错！", e);
            throw new RuntimeException(e);
        }
    }

}
