package br.univali.edu.game;

import br.univali.edu.game.parts.Doll;
import br.univali.edu.game.parts.Player;
import br.univali.edu.game.parts.Word;

import java.io.IOException;

public class Hangman {
    private Player player;
    private Doll doll;
    private Word word;

    public Hangman() throws IOException {
        this.player = new Player();
        this.doll = new Doll();
        this.word = new Word();
    }

    /**
     * Getter of player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Getter of doll
     * @return doll
     */
    public Doll getDoll() {
        return doll;
    }

    /**
     * Setter of player
     * @param player new player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Setter of doll
      * @param doll new doll
     */
    public void setDoll(Doll doll) {
        this.doll = doll;
    }

    /**
     * Getter of Word
     * @return word
     */
    public Word getWord() {
        return word;
    }

    /**
     * Setter of Word
     * @param word new word
     */
    public void setWord(Word word) {
        this.word = word;
    }

    /**
     * checks if the word has the letter played, and if it is exchanged for
     * the same position as the hidden word
     * @param letter letter that will be checked
     */
    public void game(String letter){
        char[] a = letter.toCharArray();
        char[] aux = getWord().getHiddenWord().toCharArray();

        if(getWord().getWord().contains(letter)) {
            for (int i = 0; i < getWord().getHiddenWord().length(); i++) {
                if ((getWord().getWord().charAt(i) == a[0]) || (getPlayer().verifyLetters(letter))){
                    aux[i] = a[0];
                }
            }
        } else {
            getDoll().missedLetter();
        }
        getWord().setHiddenWord(new String(aux));
    }

    /**
     * checks if the letter has already been played
     * @param letter letter that will be cheked
     * @return true if it has been played or false otherwise.
     */
    public boolean messageWrittenLetter(String letter){
        return getPlayer().getPlayedLetters().contains(letter);
    }

    /**
     * Create a new object Word with other word and hiddenWord
     * @throws IOException if the file of word does not exist
     */
    public void reloadWord() throws IOException {
        setWord(new Word());
    }

    /**
     * validate the played letter
     * @param letter letter that will be cheked
     * @return true if the letter is one letter and dont have number or others characters, false otherwise
     */
    public boolean validateLetter(String letter){
        return (validateStringNoNumbers(letter) || letter.length() != 1 || !letter.matches("^[a-zA-Z]"));
    }

    /**
     * Check if string have numbers
     * @param string string that will be checked
     * @return true if dont have numbers, false otherwise
     */
    private boolean validateStringNoNumbers(String string){
        for(int i = 0 ; i < string.length(); i++){
            if(Character.isDigit(string.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
