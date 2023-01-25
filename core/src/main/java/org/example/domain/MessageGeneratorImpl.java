package org.example.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator{

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    private int guessCount = 10;

    @PostConstruct
    public void init() {
        log.info("game remain guess is = {}",game.getRemainingGuesses());
    }

    @Override
    public String getMainMessage() {
        StringBuilder message = new StringBuilder();
        message.append("Number is between ")
                .append(game.getSmallest())
                .append(" and ")
                .append(game.getBiggest())
                .append(" can guess the number?");

        return message.toString();
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon())
            return "You win the game number is " + game.getNumber();
        else if(game.isGameLost())
            return "You lost the game number was " + game.getNumber();
        else if(!game.isValidNumberRange())
            return "Invalid range number";
        else if(game.getRemainingGuesses() == guessCount)
            return "Enter ur first guess number";
        else {
            String temp = "LOWER";
            if(game.getGuess() < game.getNumber())
                temp = "HIGHER";

            return temp + "! You Have " + game.getRemainingGuesses() + " Chance Left";
        }

    }
}
