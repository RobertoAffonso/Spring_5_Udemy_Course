package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author Roberto Affonso, created on 7/13/18
 **/

public class MessageGeneratorImpl implements MessageGenerator {

    // == Constants ==
    public static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == Fields ==
    @Autowired
    private Game game;
    private int guessCount = 10;

    // == Init ==
    @PostConstruct
    public void init(){
        log.info("MessageGenerator is not null");
        log.info("Game = {}", game);
    }

    // == Public Methods ==
    @Override
    public String getMainMessage() {
        StringBuilder sb = new StringBuilder("Welcome to the challenge!");
        return sb.toString();
    }

    @Override
    public String getResultMessage() {
        StringBuilder sb = new StringBuilder("And this is the result message");
        return sb.toString();
    }
}
