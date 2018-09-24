package top.ornobug.core.bean;

import top.ornobug.common.PropertiesUtil;

import java.util.Properties;

public class AutumnConfig {

    private static final String CONFIG_FILE = "autumn.properties";

    private static final String JDBC_DRIVER = "autumn.jdbc.driver";
    private static final String JDBC_URL = "autumn.jdbc.url";
    private static final String JDBC_USERNAME = "autumn.jdbc.username";
    private static final String JDBC_PASSWORD = "autumn.jdbc.password";
    private static final String BASE_PACKAGE = "autumn.scan.basePackage";
    private static final String VIEW_PREFIX = "autumn.view.prefix";
    private static final String VIEW_SUFFIX = "autumn.view.suffix";
    private static final String STATIC_PATH = "autumn.view.static.path";

    private static final Properties PROPERTIES = PropertiesUtil.loadProperties(CONFIG_FILE);

    public static String getJdbcUrl() {
        return PropertiesUtil.getString(PROPERTIES, JDBC_URL);
    }

    public static String getJdbcUsername() {
        return PropertiesUtil.getString(PROPERTIES, JDBC_USERNAME);
    }

    public static String getJdbcPassword() {
        return PropertiesUtil.getString(PROPERTIES, JDBC_PASSWORD);
    }

    public static String getBasePackage() {
        return PropertiesUtil.getString(PROPERTIES, BASE_PACKAGE);
    }

    public static String getViewPrefix() {
        return PropertiesUtil.getString(PROPERTIES, VIEW_PREFIX);
    }

    public static String getViewSuffix() {
        return PropertiesUtil.getString(PROPERTIES, VIEW_SUFFIX);
    }

    public static String getStaticPath() {
        return PropertiesUtil.getString(PROPERTIES, STATIC_PATH);
    }

    public String getJdbcDriver() {
        return PropertiesUtil.getString(PROPERTIES, JDBC_DRIVER);
    }
}
