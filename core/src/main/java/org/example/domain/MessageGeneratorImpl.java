package org.example.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Slf4j
public class MessageGeneratorImpl implements MessageGenerator{

    @Autowired
    private Game game;

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
        else if(game.getRemainingGuesses() == game.getGuessCount())
            return "Enter Number:";
        else {
            String temp = "LOWER";
            if(game.getGuess() < game.getNumber())
                temp = "HIGHER";

            return temp + "! You Have " + game.getRemainingGuesses() + " Chance Left";
        }

    }
}
