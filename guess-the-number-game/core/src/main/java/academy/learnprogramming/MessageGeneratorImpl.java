package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Roberto Affonso, created on 7/13/18
 **/

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == Constants ==
    public static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == Fields ==
    private final Game game;

    // == Constructors ==

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == Init ==
    @PostConstruct
    public void init(){
        log.info("MessageGenerator is not null");
        log.info("Game = {}", game);
    }

    // == Public Methods ==
    @Override
    public String getMainMessage() {
        String message = "Number is between: " +
                         game.getSmallest() + " and " +
                         game.getBiggest() +
                         ". Can you guess it?";
        return message;
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "You guessed it! The number was: " + game.getNumber();
        }
        else if(game.isGameLost()){
            return "You lost, the number was: " + game.getNumber();
        }
        else if(!game.isValidNumberRange()){
            return "Invalid number range.";
        }
        else if(game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess? ";
        }
        else{
            String direction = "lower";
            if(game.getGuess() < game.getNumber()){
                direction = "higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + " remaining guesses";
        }
    }
}
