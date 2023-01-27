package org.example.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@PropertySource("classpath:game.properties")
public class GameImpl implements Game{

    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    @Autowired
    private NumberGenerator numberGenerator;

    @Value("${game.guessCount}")
    private int guessCount;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuess;
    private boolean validNumberRange = true;

//   public GameImpl(NumberGenerator numberGenerator) {
//       this.numberGenerator = numberGenerator;
//   }

    // init
    @PostConstruct
    @Override
    public void rest() {
        smallest = 0;
        guess = 0;
        remainingGuess = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();

    }

    @PreDestroy
    public void preDestroy() {
        log.info(" destroy method call");
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuess;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }


    @Override
    public void check() {

        checkValidNumberRange();

        if(guess > number)
            biggest = guess-1;

        if(guess < number)
            smallest = guess+1;

        remainingGuess--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuess <= 0;
    }

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }


    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
}
