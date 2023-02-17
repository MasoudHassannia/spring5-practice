package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.GameService;
import org.example.util.AttributeNameConstants;
import org.example.util.GameURLMapping;
import org.example.util.ViewsNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
@Slf4j
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(GameURLMapping.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNameConstants.MAIN_MESSAGE,gameService.getMainMessage());
        model.addAttribute(AttributeNameConstants.RESULT_MESSAGE,gameService.getResultMessage());
        log.info("==== MODEL is {} ====",model);

        if(gameService.isGameOver())
            return ViewsNameConstants.GAME_OVER;

        return ViewsNameConstants.PLAY;
    }

    @PostMapping(GameURLMapping.PLAY)
    public String gameProcess(@RequestParam int guess){
        log.info("**** Guess == {}",guess);
        gameService.checkGuess(guess);
        return GameURLMapping.REDIRECT_PLAY;
    }
}
