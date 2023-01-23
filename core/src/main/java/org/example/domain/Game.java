package org.example.domain;

public interface Game {

    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

    void rest();

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();
}
