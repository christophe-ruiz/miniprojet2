package com.company.draw;

import java.awt.Polygon;

public class Triangle {
    private int height = 7;
    private int width = 5;
    private int xPosition = 210;
    private int yPosition = 140;
    private int[] xPoints;
    private int[] yPoints;
    private String color = "blue";
    private boolean isVisible = false;

    public Triangle() {
    }

    public void makeVisible() {
        this.isVisible = true;
        this.draw();
    }

    public void setPoints(int[] x, int[] y){
        this.xPoints=x;
        this.yPoints=y;
    }

    void makeInvisible() {
        this.erase();
        this.isVisible = false;
    }

    void moveRight() {
        this.moveHorizontal(20);
    }

    void moveLeft() {
        this.moveHorizontal(-20);
    }

    void moveUp() {
        this.moveVertical(-20);
    }

    void moveDown() {
        this.moveVertical(20);
    }

    void moveHorizontal(int distance) {
        this.erase();
        this.xPosition += distance;
        this.draw();
    }

    void moveVertical(int distance) {
        this.erase();
        this.yPosition += distance;
        this.draw();
    }

    void slowMoveHorizontal(int distance) {
        byte delta;
        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; ++i) {
            this.xPosition += delta;
            this.draw();
        }

    }

    void slowMoveVertical(int distance) {
        byte delta;
        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; ++i) {
            this.yPosition += delta;
            this.draw();
        }

    }

    void changeSize(int newHeight, int newWidth) {
        this.erase();
        this.height = newHeight;
        this.width = newWidth;
        this.draw();
    }

    public void changeColor(String newColor) {
        this.color = newColor;
        this.draw();
    }

    private void draw() {
        if (this.isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, this.color, new Polygon(xPoints, yPoints, 3));
            canvas.wait(10);
        }

    }

    private void erase() {
        if (this.isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }

    }
}
