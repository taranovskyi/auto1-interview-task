package com.autohero.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHelper {

    public static void loadSelenideProperties() throws IOException {
        Properties props = new Properties();
        InputStream inputStream = ConfigHelper.class
                .getClassLoader()
                .getResourceAsStream("selenide.properties");
        props.load(inputStream);

        if (!props.isEmpty()) {
            for (Object propObj : props.keySet()) {
                String prop = String.valueOf(propObj);
                System.setProperty(prop, props.getProperty(prop));
            }
        }
    }
}
