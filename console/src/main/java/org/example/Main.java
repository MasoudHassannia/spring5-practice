package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.config.JavaAnnotationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        log.info("guess Number game");

        SpringApplication.run(Main.class,args);
    }

    // private final static String  BEAN_CONFIG_FILE_LOCATION = "beans.xml";

}
