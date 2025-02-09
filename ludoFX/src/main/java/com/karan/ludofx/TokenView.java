package com.karan.ludofx;

import com.karan.ludofx.model.Color;
import com.karan.ludofx.model.Token;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TokenView {
    private final ImageView imageView;

    public TokenView(Token token) {
        this.imageView = new ImageView(App.imageLoader(getImagePathByColor(token.getColor())));
        imageView.setPreserveRatio(false);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        imageView.setPickOnBounds(true);
        imageView.setMouseTransparent(false);
        imageView.setDisable(false);
        imageView.setOpacity(1);
        System.out.println("TokenView created for token: " + token);
        // Debugging: Ensure clicks on the token always print
        imageView.setOnMouseClicked(e -> {
            System.out.println("TokenView Clicked: " + token);
            e.consume();
        });

        // Force event bubbling up to parent
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("Filtered Click on TokenView: " + token);
            e.consume();
        });

        System.out.println("TokenView created for token: " + token);
    }
    public ImageView getNode(){
        return imageView;
    }

    private String getImagePathByColor(Color color) {
        return switch (color) {
            case GREEN -> getDirectoryForImagePath() + "green.png";
            case RED -> getDirectoryForImagePath() + "red.png";
            case BLUE -> getDirectoryForImagePath() + "blue.png";
            case YELLOW -> getDirectoryForImagePath() + "yellow.png";
        };
    }
    private String getDirectoryForImagePath(){
        return "assets/tokenImages/";
    }
}
