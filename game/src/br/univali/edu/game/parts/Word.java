package br.univali.edu.game.parts;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Word {
    private String word;
    private String hiddenWord;

    public Word() throws IOException {
        this.word = generateWord();
        this.hiddenWord = hideWord();
    }

    /**
     * Getter of word
     * @return word
     */
    public String getWord() {
        return word;
    }

    /**
     * Setter of word
     * @param word new word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Getter of hiddenWord
     * @return hiddenWord
     */
    public String getHiddenWord() {

        return hiddenWord;
    }

    /**
     * Setter of hiddenWord
     * @param hiddenWord new hiddenWord
     */
    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    /**
     * Hide the chosen word with "_" w
     * @return hiddenWord
     */
    public String hideWord(){
        hiddenWord = "";
        for(int i = 0; i < word.length(); i++) {
            hiddenWord += "_";
        }
        return hiddenWord;
    }

    /**
     * Chose a random word from the file
     * @return random word
     * @throws IOException if the file does not exist
     */
    public String generateWord()  throws IOException{
        String newWord = " ";
        Random randomLine = new Random();
        File  file = new File("words.txt");

        while(newWord.length() < 3 || newWord.contains("-")) {
            int line = randomLine.nextInt(29832) + 1;
            List<String> words = Files.readAllLines(Paths.get(file.getPath()));
            newWord = words.get(line);
        }
       return newWord;
    }

    /**
     * Check if the hiddenWord have "_" in the string
     * @return true if have, false if dont
     */
    public boolean isCompleted(){
        return  this.hiddenWord.contains("_") ;
    }

    /**
     * Check if the word contains the letter
     * @param letter letter that will be checked
     * @return true if contains, false if dont contains
     */
    public boolean verifyLetter(String letter){
        return word.contains(letter);
    }



}
