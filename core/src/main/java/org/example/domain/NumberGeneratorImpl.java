package org.example.domain;

import java.util.Random;

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
