package top.ornobug.web.parser;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import top.ornobug.core.bean.AutumnConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * freemarker 视图解析器
 * @author liuzhimeng
 */

public class FreemarkerParser {

    public static void parse(String fileName, Map<String, Object> data, HttpServletResponse response) {
        Reader reader = null;
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
            path = path.replace("file:", "")
                    .replace("classes/", "")
                    .replace("WEB-INF/", "")
                    .substring(1);
            reader = new FileReader(new File(path + AutumnConfig.getViewPrefix() + fileName + AutumnConfig.getViewSuffix()));
            Template template = new Template(fileName, reader, null, "utf-8");
            Writer writer = new PrintWriter(response.getOutputStream());
            template.process(data, writer);
            writer.flush();
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
