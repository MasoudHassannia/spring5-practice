package org.example;

import org.example.domain.Game;
import org.example.domain.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    private final static String  BEAN_CONFIG_FILE_LOCATION = "beans.xml";


    public static void main(String[] args) {
        log.info("guess Number game");

        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(BEAN_CONFIG_FILE_LOCATION);

        NumberGenerator numberGenerator = applicationContext.getBean(NumberGenerator.class);

        int number = numberGenerator.next();

        log.info("Number : {}",number);

        // another bean definition base on type(class)
        Game game = applicationContext.getBean(Game.class);

        applicationContext.close();
    }
}
