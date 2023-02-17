package org.example.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Game;
import org.example.domain.MessageGenerator;
import org.example.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class GameServiceImpl implements GameService {

    private final Game game;

    private final MessageGenerator message;

    @Autowired
    public GameServiceImpl(Game game,MessageGenerator message) {
        this.game = game;
        this.message = message;
    }

    @PostConstruct
    public void init() {
        log.info("Number = {}",game.getNumber());
        log.info("main message {}",message.getMainMessage());
    }

    @Override
    public boolean isGameOver() {
        return game.isGameWon() || game.isGameLost();
    }

    @Override
    public String getMainMessage() {
        return message.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return message.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.rest();
    }
}
