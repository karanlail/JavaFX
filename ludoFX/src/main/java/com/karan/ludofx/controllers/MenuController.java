package com.karan.ludofx.controllers;

import com.karan.ludofx.App;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private void initiateGame(int numberOfPlayers, List<String> names){
        App.setGameManager(numberOfPlayers,names);
        App.changeSceneToGame();
    }
    @FXML
    private void initiateTwoPlayers(){
        int n=2;
        List<String> names = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            names.add("player"+i);
        }
        initiateGame(n,names);
    }
    @FXML
    private void initiateThreePlayers(){
        int n=3;
        List<String> names = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            names.add("player"+i);
        }
        initiateGame(n,names);
    }
    @FXML
    private void initiateFourPlayers(){
        int n=4;
        List<String> names = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            names.add("player"+i);
        }
        initiateGame(n,names);
    }

}
