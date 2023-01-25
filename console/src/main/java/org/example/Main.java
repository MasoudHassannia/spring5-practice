package org.example;

import org.example.config.JavaAnnotationConfig;
import org.example.domain.Game;
import org.example.domain.MessageGenerator;
import org.example.domain.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    // private final static String  BEAN_CONFIG_FILE_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("guess Number game");

        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(JavaAnnotationConfig.class);

        NumberGenerator numberGenerator = applicationContext.getBean(NumberGenerator.class);

        int number = numberGenerator.next();

        log.info("Number : {}",number);

        // another bean definition base on type(class)
        Game game = applicationContext.getBean(Game.class);

        MessageGenerator messageGenerator = applicationContext.getBean(MessageGenerator.class);

        log.info("org.example.Main message = {} && result message = {} ",
                 messageGenerator.getMainMessage(),messageGenerator.getResultMessage());

        applicationContext.close();
    }
}
