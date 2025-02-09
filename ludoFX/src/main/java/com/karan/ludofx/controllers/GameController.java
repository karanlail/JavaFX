package com.karan.ludofx.controllers;

import com.karan.ludofx.App;
import com.karan.ludofx.TokenView;
import com.karan.ludofx.model.Player;
import com.karan.ludofx.model.Token;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    @FXML private StackPane path0;
    @FXML private StackPane path1;
    @FXML private StackPane path2;
    @FXML private StackPane path3;
    @FXML private StackPane path4;
    @FXML private StackPane path5;
    @FXML private StackPane path6;
    @FXML private StackPane path7;
    @FXML private StackPane path8;
    @FXML private StackPane path9;
    @FXML private StackPane path10;
    @FXML private StackPane path11;
    @FXML private StackPane path12;
    @FXML private StackPane path13;
    @FXML private StackPane path14;
    @FXML private StackPane path15;
    @FXML private StackPane path16;
    @FXML private StackPane path17;
    @FXML private StackPane path18;
    @FXML private StackPane path19;
    @FXML private StackPane path20;
    @FXML private StackPane path21;
    @FXML private StackPane path22;
    @FXML private StackPane path23;
    @FXML private StackPane path24;
    @FXML private StackPane path25;
    @FXML private StackPane path26;
    @FXML private StackPane path27;
    @FXML private StackPane path28;
    @FXML private StackPane path29;
    @FXML private StackPane path30;
    @FXML private StackPane path31;
    @FXML private StackPane path32;
    @FXML private StackPane path33;
    @FXML private StackPane path34;
    @FXML private StackPane path35;
    @FXML private StackPane path36;
    @FXML private StackPane path37;
    @FXML private StackPane path38;
    @FXML private StackPane path39;
    @FXML private StackPane path40;
    @FXML private StackPane path41;
    @FXML private StackPane path42;
    @FXML private StackPane path43;
    @FXML private StackPane path44;
    @FXML private StackPane path45;
    @FXML private StackPane path46;
    @FXML private StackPane path47;
    @FXML private StackPane path48;
    @FXML private StackPane path49;
    @FXML private StackPane path50;
    @FXML private StackPane path51;

    @FXML private StackPane pathBaseGreen0;
    @FXML private StackPane pathBaseGreen1;
    @FXML private StackPane pathBaseGreen2;
    @FXML private StackPane pathBaseGreen3;

    @FXML private StackPane pathBaseBlue0;
    @FXML private StackPane pathBaseBlue1;
    @FXML private StackPane pathBaseBlue2;
    @FXML private StackPane pathBaseBlue3;

    @FXML private StackPane pathBaseYellow0;
    @FXML private StackPane pathBaseYellow1;
    @FXML private StackPane pathBaseYellow2;
    @FXML private StackPane pathBaseYellow3;

    @FXML private StackPane pathBaseRed0;
    @FXML private StackPane pathBaseRed1;
    @FXML private StackPane pathBaseRed2;
    @FXML private StackPane pathBaseRed3;

    @FXML private StackPane pathGreen0;
    @FXML private StackPane pathGreen1;
    @FXML private StackPane pathGreen2;
    @FXML private StackPane pathGreen3;
    @FXML private StackPane pathGreen4;

    @FXML private StackPane pathBlue0;
    @FXML private StackPane pathBlue1;
    @FXML private StackPane pathBlue2;
    @FXML private StackPane pathBlue3;
    @FXML private StackPane pathBlue4;

    @FXML private StackPane pathYellow0;
    @FXML private StackPane pathYellow1;
    @FXML private StackPane pathYellow2;
    @FXML private StackPane pathYellow3;
    @FXML private StackPane pathYellow4;

    @FXML private StackPane pathRed0;
    @FXML private StackPane pathRed1;
    @FXML private StackPane pathRed2;
    @FXML private StackPane pathRed3;
    @FXML private StackPane pathRed4;

    @FXML private Label playerAction;
    @FXML private Label currentPlayer;
    @FXML private Label diceValue;
    @FXML private Button buttonRollDice;

    private Map<Integer, StackPane> pathCells;
    private Map<Integer, StackPane> pathGreenCells;
    private Map<Integer, StackPane> pathBlueCells;
    private Map<Integer, StackPane> pathYellowCells;
    private Map<Integer, StackPane> pathRedCells;
    private Map<Integer, StackPane> pathBaseGreenCells;
    private Map<Integer, StackPane> pathBaseBlueCells;
    private Map<Integer, StackPane> pathBaseYellowCells;
    private Map<Integer, StackPane> pathBaseRedCells;

    private Map<Token, TokenView> tokenTokenViewMap;

    public GameController() {
        this.pathCells=new HashMap<>();
        this.pathGreenCells=new HashMap<>();
        this.pathBlueCells=new HashMap<>();
        this.pathYellowCells=new HashMap<>();
        this.pathRedCells=new HashMap<>();
        this.pathBaseBlueCells=new HashMap<>();
        this.pathBaseGreenCells=new HashMap<>();
        this.pathBaseYellowCells=new HashMap<>();
        this.pathBaseRedCells=new HashMap<>();
        tokenTokenViewMap = new HashMap<>();
    }

    @FXML
    public void initialize(){
        if (path0 == null) {
            System.out.println("FXML elements are NOT injected properly!");
        } else {
            System.out.println("FXML elements injected successfully!");
        }
        System.out.println("GameController initialized");
        boardBuilder();
        setDiceValue(0);
        App.getGameManager().begin(this);
        // Global Mouse Event Debugging
        App.stage.getScene().addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            System.out.println("Mouse pressed at: X=" + e.getSceneX() + " Y=" + e.getSceneY());
            e.consume();
        });
        // Debug: Make every StackPane visible
        pathCells.values().forEach(pane -> pane.setStyle("-fx-background-color: rgba(255,0,0,0.3);"));
        pathBaseGreenCells.values().forEach(pane -> pane.setStyle("-fx-background-color: rgba(0,255,0,0.3);"));
        pathBaseYellowCells.values().forEach(pane -> pane.setStyle("-fx-background-color: rgba(0,0,255,0.3);"));

        // Debug Click Detection for Every StackPane in Board
        pathBaseGreenCells.values().forEach(pane -> {
            pane.setOnMouseClicked(e -> {
                System.out.println("Clicked on StackPane: " + pane);
                e.consume();
            });
        });
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer.setText(player.getName());
    }

    public void setPlayerAction(String s){
        playerAction.setText(s);
    }

    public void rollDice(){
        App.getGameManager().rollDice();
    }

    public void setDiceValue(int Value) {
        diceValue.setText(String.valueOf(Value));
    }

    public void tokenChosen(Token token){
        System.out.println("a token was chosen");
        App.getGameManager().tokenChosen(token);
    }

    public void placeTokenView(Token token, TokenView tokenView){
        /*if (tokenView.getNode().getParent() != null && tokenView.getNode().getParent() instanceof StackPane) {
            StackPane oldCell = (StackPane) tokenView.getNode().getParent();
            oldCell.getChildren().remove(tokenView.getNode());
        }
        if (token.isBase()){
            switch (token.getColor()){
                case GREEN -> pathBaseGreenCells.get(token.getId()).getChildren().add(tokenView.getNode());
                case BLUE -> pathBaseBlueCells.get(token.getId()).getChildren().add(tokenView.getNode());
                case YELLOW -> pathBaseYellowCells.get(token.getId()).getChildren().add(tokenView.getNode());
                case RED -> pathBaseRedCells.get(token.getId()).getChildren().add(tokenView.getNode());
            }
        } else if(token.isHome()){
            switch (token.getColor()){
                case GREEN -> pathGreenCells.get(token.getPosition()).getChildren().add(tokenView.getNode());
                case BLUE -> pathBlueCells.get(token.getPosition()).getChildren().add(tokenView.getNode());
                case YELLOW -> pathYellowCells.get(token.getPosition()).getChildren().add(tokenView.getNode());
                case RED -> pathRedCells.get(token.getPosition()).getChildren().add(tokenView.getNode());
            }
        }else pathCells.get(token.getPosition()).getChildren().add(tokenView.getNode());
        tokenView.getNode().toFront();
        tokenView.getNode().setVisible(true);
        tokenView.getNode().setOpacity(1.0);
        tokenView.getNode().setPickOnBounds(true);
        tokenView.getNode().setMouseTransparent(false);
        tokenView.getNode().setDisable(false);*/

        if (tokenView.getNode().getParent() != null && tokenView.getNode().getParent() instanceof StackPane) {
            StackPane oldCell = (StackPane) tokenView.getNode().getParent();
            oldCell.getChildren().remove(tokenView.getNode());
        }

        StackPane targetCell = null;

        if (token.isBase()){
            switch (token.getColor()){
                case GREEN -> targetCell = pathBaseGreenCells.get(token.getId());
                case BLUE -> targetCell = pathBaseBlueCells.get(token.getId());
                case YELLOW -> targetCell = pathBaseYellowCells.get(token.getId());
                case RED -> targetCell = pathBaseRedCells.get(token.getId());
            }
        } else if(token.isHome()){
            switch (token.getColor()){
                case GREEN -> targetCell = pathGreenCells.get(token.getPosition());
                case BLUE -> targetCell = pathBlueCells.get(token.getPosition());
                case YELLOW -> targetCell = pathYellowCells.get(token.getPosition());
                case RED -> targetCell = pathRedCells.get(token.getPosition());
            }
        } else {
            targetCell = pathCells.get(token.getPosition());
        }

        if (targetCell != null) {
            targetCell.getChildren().add(tokenView.getNode());
            System.out.println("Token placed in GUI: " + token + " at position " + token.getPosition());
        } else {
            System.out.println("ERROR: Could not place token " + token + " in GUI!");
        }
        assert targetCell != null;
        targetCell.setOnMouseClicked(e -> System.out.println("StackPane Clicked!"));


        // Force token to be interactive
        tokenView.getNode().toFront();
        tokenView.getNode().setPickOnBounds(true);
        tokenView.getNode().setMouseTransparent(false);
        tokenView.getNode().setDisable(false);
        tokenView.getNode().setOpacity(1.0);

        System.out.println("TokenView final settings: visible=" + tokenView.getNode().isVisible() +
                ", opacity=" + tokenView.getNode().getOpacity() +
                ", disabled=" + tokenView.getNode().isDisable() +
                ", pickOnBounds=" + tokenView.getNode().isPickOnBounds());
    }

    //BoardBuilding
    public void boardBuilder(){
        try{
            pathBuilder("path");
            List<String> colors = new ArrayList<>();
            colors.add("Blue");
            colors.add("Yellow");
            colors.add("Green");
            colors.add("Red");
            for (String color:colors){
                pathBuilder("pathBase"+color);
                pathBuilder("path"+color);
            }
        }catch (NoSuchFieldException e){
            System.out.println("Error while building paths");
        }
    }

    @SuppressWarnings("unchecked")
    public void pathBuilder(String category) throws NoSuchFieldException {
        // Hard coding every StackPane into the HashMap would have been a long, not very elegant process
        // Solution: use of java reflection, idea found online
        Field pathType = this.getClass().getDeclaredField(category + "Cells");
        if (pathType.getType().equals(Map.class)) {
            try {
                pathType.setAccessible(true);
                HashMap<Integer, StackPane> currentMap = (HashMap<Integer, StackPane>) pathType.get(this);
                Field[] fields = this.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.getName().matches(category + "\\d+") && field.getType().equals(StackPane.class)) {
                        field.setAccessible(true);
                        try {
                            StackPane pane = (StackPane) field.get(this);
                            // Extract the numeric part of the field name, e.g. "path2" -> 2
                            String numPart = field.getName().substring(category.length()); // "path" has 4 characters
                            int index = Integer.parseInt(numPart);
                            currentMap.put(index,(StackPane) field.get(this));
                        } catch (IllegalAccessException | NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error accessing main Field in path Builder");
                throw new RuntimeException(e);
            }
        }
    }

    //TokenBuilding and placing
    public void tokenBuilder(List<Player> players){
        players.forEach(player -> player.getTokens().forEach(token -> tokenTokenViewMap.put(token, new TokenView(token))));
        tokenTokenViewMap.forEach(this::placeTokenView);
        tokenTokenViewMap.forEach(this::associateHandlers);
    }

    public Map<Token, TokenView> getTokenTokenViewMap() {
        return tokenTokenViewMap;
    }

    public void associateHandlers(Token token, TokenView tokenView){
        tokenView.getNode().setOnMouseClicked(e -> {
            System.out.println("Token clicked in GUI: " + token);
            App.getGameManager().tokenChosen(token);
            e.consume();
        });

        System.out.println("Handler attached to: " + token);
    }
}
