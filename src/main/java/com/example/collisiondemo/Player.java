package com.example.collisiondemo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Player {
    private double x;
    private double y;
    private double width;
    private double height;
    private Paint color;
    private Paint defaultColor;
    private GraphicsContext gc;

    public Player(GraphicsContext gc, double x, double y, double width, double height, Paint color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.defaultColor = color;
        this.gc = gc;
    }


    // make show function
    public void show() {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    public void resetColor() {
        this.color = defaultColor;
    }
}
