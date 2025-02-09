package com.karan.ludofx;

import com.karan.ludofx.model.GameManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class App extends Application {
    public static Stage stage;
    private static GameManager gameManager;

    public static void setGameManager(int numberOfPlayers, List<String> names) {
        App.gameManager = new GameManager(numberOfPlayers,names);
    }

    public static GameManager getGameManager() {
        return gameManager;
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(fxmlLoader("menu"));
        setStageIconAndTitle(stage);
        stage.setScene(scene);
        stage.show();
        App.stage = stage;
    }

    public static Parent fxmlLoader(String filename) {
        try {
            return FXMLLoader.load(Objects.requireNonNull(App.class.getResource("fxmlFiles/" + filename + ".fxml")));
        } catch (IOException e) {
            System.out.println("unable to load fxml file");
            throw new RuntimeException();
        }
    }

    public void setStageIconAndTitle(Stage stage){
        stage.setTitle("LUDO GAME");
        stage.getIcons().add(imageLoader("assets/icons/icon.png"));
    }

    public static void changeSceneToGame() {
        Scene scene = new Scene(fxmlLoader("ludoBoard"));
        // Force entire scene to be clickable
        scene.setOnMouseClicked(e -> {
            System.out.println("Scene Clicked at X=" + e.getSceneX() + " Y=" + e.getSceneY());
        });
        // Make sure the root node can receive clicks
        scene.getRoot().setPickOnBounds(true);
        scene.getRoot().setMouseTransparent(false);
        scene.getRoot().setDisable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static Image imageLoader(String path){
        return new Image(Objects.requireNonNull(App.class.getResourceAsStream(path)));
    }
}