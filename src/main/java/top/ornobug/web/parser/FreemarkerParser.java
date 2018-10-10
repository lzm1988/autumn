package top.ornobug.web.parser;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import top.ornobug.core.bean.AutumnConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Locale;
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
            String charset = AutumnConfig.getTemplateEncoding();
            reader = new InputStreamReader(new FileInputStream(new File(path + AutumnConfig.getViewPrefix() + fileName + AutumnConfig.getViewSuffix())), charset);
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding(charset);
            configuration.setNumberFormat("#");
            configuration.setLocale(Locale.CHINA);
            configuration.setEncoding(Locale.CHINA, charset);
            configuration.setURLEscapingCharset(charset);
            Template template = new Template(fileName, reader, configuration, charset);
            response.setContentType("text/html; charset=" + template.getEncoding());
            Writer writer = new OutputStreamWriter(response.getOutputStream(), charset);
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
