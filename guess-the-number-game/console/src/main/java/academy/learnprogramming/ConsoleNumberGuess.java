package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @author Roberto Affonso, created on 7/16/18
 **/
@Component
public class ConsoleNumberGuess {

    // == Constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == Fields ==

    private final Game game;

    private final MessageGenerator messageGenerator;

    // == Constructors ==

    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == Event Listener ==
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() --> Container Initialized");

        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = input.nextInt();
            input.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                messageGenerator.getResultMessage();
                System.out.println("Play again? Y/N");

                String choice = input.nextLine().trim();
                if(!choice.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }
        }
    }

}
