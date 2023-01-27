package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Game;
import org.example.domain.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Slf4j
public class ConsoleNumberGuess {

    // private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;

    @EventListener(ContextRefreshedEvent.class)
    public void start(){
        log.info("application event Start");

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guessNumber = input.nextInt();
            input.nextLine();

            game.setGuess(guessNumber);
            game.check();
            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println(" Do You want Play Again?(Y/N)");

                String playAgainAnswer = input.nextLine().trim();

                if(playAgainAnswer.equalsIgnoreCase("n")){
                    log.info("Good Luck");
                    break;
                }
                game.rest();
            }
        }
    }
}
