package org.example.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@PropertySource("classpath:game.properties")
@Getter
@Slf4j
public class GameImpl implements Game{

    // remove getter for this field
    @Getter(AccessLevel.NONE)
    private NumberGenerator numberGenerator;
    @Value("${game.guessCount:5}")
    private int guessCount;
    private int number;
    @Setter
    private int guess;

    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }


    // init
    @PostConstruct
    @Override
    public void rest() {
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
    }

    @PreDestroy
    public void preDestroy() {
        log.info(" destroy method call");
    }

    @Override
    public void check() {

        checkValidNumberRange();

        if(guess > number)
            biggest = guess-1;

        if(guess < number)
            smallest = guess+1;

        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
