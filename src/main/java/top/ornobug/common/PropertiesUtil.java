package top.ornobug.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtil.class);

    public static Properties loadProperties(String fileName) {

        Properties properties = null;
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException(fileName + " file is not found!");
            }
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("load properties file failure!", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.error("close inputStream failure!", e);
                }
            }
        }
        return properties;
    }

    /**
     * 从配置中获得字符串属性，默认值""
     *
     * @param properties
     * @param key
     * @return
     */
    public static String getString(Properties properties, String key) {
        return getString(properties, key, "");
    }

    /**
     * 从配置中获得字符串属性，提供默认值
     *
     * @param properties
     * @param key
     * @param defaultVal
     * @return
     */
    public static String getString(Properties properties, String key, String defaultVal) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        }
        return defaultVal;
    }

    public static Integer getInteger(Properties properties, String key) {
        return getInteger(properties, key, 0);
    }

    public static Integer getInteger(Properties properties, String key, Integer defaultVal) {
        if (properties.containsKey(key)) {
            return CastUtil.string2Integer(properties.getProperty(key));
        }
        return defaultVal;
    }

    public static Double getDouble(Properties properties, String key) {
        return getDouble(properties, key, 0.00D);
    }

    public static Double getDouble(Properties properties, String key, Double defaultVal) {
        if (properties.containsKey(key)) {
            return CastUtil.string2Double(properties.getProperty(key));
        }
        return defaultVal;
    }

    public static Boolean getBoolean(Properties properties, String key) {
        return getBoolean(properties, key, false);
    }

    public static Boolean getBoolean(Properties properties, String key, Boolean defaultVal) {
        if (properties.containsKey(key)) {
            return CastUtil.string2Boolean(properties.getProperty(key));
        }
        return defaultVal;
    }
}
