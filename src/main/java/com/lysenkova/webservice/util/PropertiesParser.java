package com.lysenkova.webservice.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesParser {
    private String path;
    private Properties appProps = new Properties();

    public PropertiesParser(String path) {
        this.path = path;
        String rootPath = getClass().getClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + path;
        try {
            appProps.load(new FileInputStream(appConfigPath));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStringProperty(String key) {
        return appProps.getProperty(key);
    }
}
