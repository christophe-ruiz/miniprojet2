package com.company.draw;

import java.awt.geom.Ellipse2D.Double;

public class Circle {
    private int diameter = 8;
    private int xPosition = 230;
    private int yPosition = 90;
    private String color = "blue";
    private boolean isVisible;

    public Circle() {
    }

    public void makeVisible() {
        this.isVisible = true;
        this.draw();
    }

    public void setPosition(int x, int y){
        this.xPosition=x;
        this.yPosition=y;
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

    void changeSize(int newDiameter) {
        this.erase();
        this.diameter = newDiameter;
        this.draw();
    }

    public void changeColor(String newColor) {
        this.color = newColor;
        this.draw();
    }

    private void draw() {
        if (this.isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, this.color, new Double((double)this.xPosition, (double)this.yPosition, (double)this.diameter, (double)this.diameter));
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
