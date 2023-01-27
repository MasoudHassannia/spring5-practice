package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.config.JavaAnnotationConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("guess Number game");

        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(JavaAnnotationConfig.class);

        applicationContext.close();
    }

    // private final static String  BEAN_CONFIG_FILE_LOCATION = "beans.xml";

}
