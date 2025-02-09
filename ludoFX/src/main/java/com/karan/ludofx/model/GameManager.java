package com.karan.ludofx.model;


import com.karan.ludofx.controllers.GameController;

import java.util.List;

public class GameManager {
    private GameController gameController;
    private final Game game;
    int numberOfPlayers;
    List<String> names;
    private final Dice dice;
    private int currentDiceValue=0;
    private boolean dice_used;

    public GameManager(int numberOfPlayers, List<String> names) {
//        if(numberOfPlayers < 2 || numberOfPlayers > 4) throw new IllegalArgumentException();
        this.numberOfPlayers = numberOfPlayers;
        this.names = names;
        this.game = new Game(numberOfPlayers,names);
        this.dice = new Dice();
    }

    public void begin(GameController gameController) {
        this.gameController=gameController;
        setDice_used(true);
        gameController.tokenBuilder(game.getPlayers());
        nextPlayer();
    }

    public void nextPlayer(){
        game.nextPlayer();
        gameController.setCurrentPlayer(game.getCurrentPlayer());
    }
    public void tokenChosen(Token token){
        if(!game.getCurrentPlayer().getTokens().contains(token)) {
            System.out.println("not your token");
            return;
        } else if (!game.getCurrentPlayer().getMovableTokens(getCurrentDiceValue()).contains(token)) {
            System.out.println("cannot move this token");
            return;
        }
        token.move(getCurrentDiceValue());
        gameController.placeTokenView(token, gameController.getTokenTokenViewMap().get(token));
        setDice_used(true);
        if (getCurrentDiceValue() != 6) {
            nextPlayer();
        }
    }

    public int getCurrentDiceValue() {
        return currentDiceValue;
    }
    public void rollDice(){
        if(!dice_used) return;
        currentDiceValue=dice.roll();
        gameController.setDiceValue(currentDiceValue);
        if(game.getCurrentPlayer().getMovableTokens(getCurrentDiceValue()).isEmpty()){
            System.out.println("no tokens to move");
            nextPlayer();
        }else setDice_used(false);
    }

    public boolean isDice_used() {
        return dice_used;
    }

    public void setDice_used(boolean dice_used) {
        this.dice_used = dice_used;
    }
}
