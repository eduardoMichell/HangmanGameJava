package br.univali.edu.game.parts;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String letter;
    private String playedLetters;

    public Player() {
        this.letter = " ";
        this.playedLetters = " ";
    }

    /**
     * concat the played letter in the string played letters
     * @param playerLetter the played letter
     */
    public void addLetter(String playerLetter){
        if(playerLetter != null){
            playedLetters += playerLetter;
        }
    }

    /**
     * Check if the string playedLetters have the letter
     * @param letter letter that will be checked
     * @return true if contains, false if not contains
     */
    public boolean verifyLetters(String letter){
        return playedLetters.contains(letter);
    }

    /**
     * Getter of letter
     * @return letter
     */
    public String getLetter() {
        return letter;
    }

    /**
     * Setter of letter
     * @param letter new letter
     */
    public void setLetter(String letter) {
        this.letter = letter;
    }

    /**
     * Getter of played letters
     * @return played letters
     */
    public String getPlayedLetters() {
        return playedLetters;
    }

    /**
     * Setter of played letters
     * @param playedLetters new playedLetters
     */
    public void setPlayedLetters(String playedLetters) {
             this.playedLetters = playedLetters;

    }
}
