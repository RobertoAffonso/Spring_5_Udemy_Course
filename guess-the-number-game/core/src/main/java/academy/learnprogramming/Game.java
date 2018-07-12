package academy.learnprogramming;

/**
 * @author Roberto Affonso, created on 7/12/18
 **/

public interface Game {

    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

    void reset();

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();
}
