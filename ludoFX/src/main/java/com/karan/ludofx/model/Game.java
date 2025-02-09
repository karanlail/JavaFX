package com.karan.ludofx.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private final Set<Integer> SAFE_CELLS = new HashSet<>(Set.of(0,8,13,21,26,34,39,47));
    private final List<Player> players;
    private Player currentPlayer;

    public Game(int numberOfPlayers, List<String> playerNames) {
        this.players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(Color.colorToBoardPositioning(i+1),playerNames.get(i)));
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void nextPlayer(){
        currentPlayer = players.removeFirst();
        players.addLast(currentPlayer);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player winnerCheck(){
        for (Player player:players){
            if(player.hasWon()) return player;
        }
        return null;
    }

    public void currentPlayerTurn(Token chosenToken, int steps){
        chosenToken.move(steps);
    }

    public void capture(Token chosenToken){
        /*check for captures, players should technically get another turn if they capture a token, but here not implemented*/
        players.stream()
                .filter(player -> player!=currentPlayer)
                .forEach(player -> player.getTokens().stream()
                        .filter(token -> token.isActive() && token.getPosition()==chosenToken.getPosition())
                        .filter(token -> !SAFE_CELLS.contains(token.getPosition()))
                        .forEach(Token::captured));

    }

    public void printPlayerState(){
        for (Player player:players){
            System.out.println(player.toString());
        }
    }
}
