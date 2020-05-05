package br.univali.edu.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane root  = FXMLLoader.load(getClass().getResource("screen.fxml"));
        Scene scene = new Scene(root, 600,550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }




}
