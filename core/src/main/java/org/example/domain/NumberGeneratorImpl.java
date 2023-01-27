package org.example.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@PropertySource("classpath:game.properties")
public class NumberGeneratorImpl implements NumberGenerator{

    private final Random _RANDOM = new Random();

    @Value("${game.maxNumber}")
    private int maxNumber;

    @Override
    public int next() {
        return _RANDOM.nextInt(maxNumber)+1;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
