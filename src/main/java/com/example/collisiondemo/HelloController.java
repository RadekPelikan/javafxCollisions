package com.example.collisiondemo;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Canvas canvas;
    public Pane pane;

    private GraphicsContext gc;
    private ArrayList<KeyCode> input = new ArrayList<>();
    private Player player1;
    private Player player2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        player1 = new Player(gc, 0, 0, 50, 50, Paint.valueOf("RED"));
        player2 = new Player(gc, 100, 0, 50, 50, Paint.valueOf("RED"));
        Platform.runLater(() -> pane.requestFocus());
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameLoop();
            }
        };
        animationTimer.start();
    }

    private void gameLoop() {
        handleMovement();
        handleCollisions(player1, player2);
        render();
    }

    private void render() {
        gc.setFill(Paint.valueOf("WHITE"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        player1.show();
        player2.show();
    }

    private void handleMovement() {
        if (input.contains(KeyCode.W)) {
            player1.setY(player1.getY() - 1);
        }
        if (input.contains(KeyCode.S)) {
            player1.setY(player1.getY() + 1);
        }
        if (input.contains(KeyCode.A)) {
            player1.setX(player1.getX() - 1);
        }
        if (input.contains(KeyCode.D)) {
            player1.setX(player1.getX() + 1);
        }
        if (input.contains(KeyCode.UP)) {
            player2.setY(player2.getY() - 1);
        }
        if (input.contains(KeyCode.DOWN)) {
            player2.setY(player2.getY() + 1);
        }
        if (input.contains(KeyCode.LEFT)) {
            player2.setX(player2.getX() - 1);
        }
        if (input.contains(KeyCode.RIGHT)) {
            player2.setX(player2.getX() + 1);
        }
    }

    // make function witch takes 2 players and handles collision between them, if they collide change color
    // of one of them to blue and the other to green
    // if they don't collide change color of both to red
    private void handleCollisions(Player player1, Player player2) {
        if (
                player1.getX() < player2.getX() + player2.getWidth() &&
                        player1.getX() + player1.getWidth() > player2.getX() &&
                        player1.getY() < player2.getY() + player2.getHeight() &&
                        player1.getY() + player1.getHeight() > player2.getY()
        ) {
            player1.setColor(Paint.valueOf("BLUE"));
            player2.setColor(Paint.valueOf("GREEN"));
        } else {
            player1.resetColor();
            player2.resetColor();
        }

    }


    public void keyPressed(KeyEvent keyEvent) {
        if (input.contains(keyEvent.getCode())) return;
        input.add(keyEvent.getCode());
    }

    public void keyReleased(KeyEvent keyEvent) {
        input.remove(keyEvent.getCode());
    }
}