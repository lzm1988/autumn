package top.ornobug.core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HelperLoader.init();
        ServletRegistration defaultServletRegistration = sce.getServletContext()
                .getServletRegistration("default");
        defaultServletRegistration.addMapping("/favicon.ico", "/static/*", "/index.html");

        // ServletRegistration jspServletRegistration = sce.getServletContext().getServletRegistration("jsp");
        // jspServletRegistration.addMapping("/view/*");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed!");
    }
}
