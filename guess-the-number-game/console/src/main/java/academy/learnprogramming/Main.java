package academy.learnprogramming;

import academy.learnprogramming.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author Roberto Affonso, created on 7/11/18
 **/

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // Creating the context (Container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the game bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // Call method next() to get a random number
        int number = numberGenerator.next();

        // Log the generated number
        log.info("Number = {}", number);

        // Get the message generator bean from context (Container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        // Calling both methods
        log.info("getMainMessage = {}", messageGenerator.getMainMessage());

        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        // Close the context (container)
        context.close();

    }
}
