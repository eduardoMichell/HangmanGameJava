package br.univali.edu.game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {
   private Hangman hangman = new Hangman();
   private String imageFile = "file:hangManImages/7.png";


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label outputWords;

    @FXML
    private Label outputMessages;

    @FXML
    private TextField txtLetter;

    @FXML
    private Button sendButton;

    @FXML
    private Button reloadButton;

    @FXML
    private Label labelWord;

    @FXML
    private ImageView imageView;

    public Controller() throws IOException {
    }

    /**
     * Button Send
     * @param event action of press send button
     */
    @FXML
    void buttonAction(ActionEvent event) {
        cleanMessages();
        String letter = txtLetter.getCharacters().toString().toUpperCase();
        txtLetter.setText("");
        if(!hangman.getDoll().isDeath()){
           if(validateWrittenLetter(letter)){
             if(hangman.getWord().isCompleted()) {
                hangman.game(letter);
                hangman.getPlayer().addLetter(" " + letter);
                printUsedWords(letter);
             }
           }
           setImage();
           printHiddenWord();
        }
    }

    /**
     * Button send released
     * @param event action of released button
     */
    @FXML
    void released(MouseEvent event) {
        if (!hangman.getWord().isCompleted()) {
            printMessages("You Win");
        }
        if(hangman.getDoll().isDeath()) {
            printMessages("The Word is " + hangman.getWord().getWord() + ", You Lose");
        }
    }

    /**
     * Button reload
     * @param event  action of press reload button
     * @throws IOException if file dont exist
     */
    @FXML
    void reloadButton(ActionEvent event) throws IOException {
        if(!hangman.getWord().isCompleted() || hangman.getDoll().isDeath()){
           reloadUsedWords();
           hangman = new Hangman();
           printHiddenWord();
           cleanMessages();
           setImage();
       //     System.out.println(hangman.getWord().getWord());
        } else {
            printMessages("You need finish this word first");
        }
    }

    /**
     * start of screen
     */
    @FXML
    void initialize() {
     //   System.out.println(hangman.getWord().getWord());
        setImage();
        printHiddenWord();
        assert outputWords != null : "fx:id=\"outputWords\" was not injected: check your FXML file 'screen.fxml'.";
        assert outputMessages != null : "fx:id=\"outputMessages\" was not injected: check your FXML file 'screen.fxml'.";
        assert txtLetter != null : "fx:id=\"txtLetter\" was not injected: check your FXML file 'screen.fxml'.";
        assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'screen.fxml'.";

    }

    /**
     * Checks if the letter is a number or if it contains the letter played and print on the screen
     * @param letter the letter that will be checked
     * @return false if the letter has already been played or dont are a letter, otherwise true
     */
    public boolean validateWrittenLetter(String letter){
        if(hangman.validateLetter(letter)){
            printMessages("You need to type one and only one letter");
            return false;
        }
        if (hangman.messageWrittenLetter(letter)) {
            printMessages("You already wrote that letter");
            return false;
        }
        return true;
    }

    /**
     * print the hidden word on screen
     */
    public void printHiddenWord(){
        labelWord.setLayoutY(232);
        labelWord.setLayoutX(325);
        labelWord.setText(hangman.getWord().getHiddenWord());
    }

    /**
     * Clean the messages on messagebox
     */
    public void cleanMessages(){
        outputMessages.setLayoutY(368);
        outputMessages.setText("");
    }

    /**
     * print the letters on the screen
     * @param letter the last played letter
     */
    public void printUsedWords(String letter){
        outputWords.setLayoutY(85);
        String aux = outputWords.getText();
        aux += " " + letter;
        outputWords.setText(aux);
    }

    /**
     * Clean the used words box
     */
    public void reloadUsedWords(){
       outputWords.setLayoutY(85);
       outputWords.setText("");
    }

    /**
     * print a message on message box
     * @param message the message
     */
    public void printMessages(String message){
        outputMessages.setLayoutY(368);
        outputMessages.setText(message);
    }

    /**
     * Set the number of image file
     * @param number number of image file
     */
    public void setImageFile(Integer number){
        char numberChar = number.toString().charAt(0);
        StringBuilder help = new StringBuilder(imageFile);
        help.setCharAt(19, numberChar);

        imageFile = help.toString();
    }

    /**
     * Sett the image on the screen
     */
    public void setImage(){
        setImageFile(hangman.getDoll().getParts());
        Image image = new Image(imageFile);
        imageView.setImage(image);
    }
}


