package org.example.domain;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator{

    private final Random _RANDOM = new Random();

    private int maxNumber = 100;

    @Override
    public int next() {
        return _RANDOM.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
