package com.company;

public class Edge {


    private Color color;
    private boolean deleted;
    public void setGoingTo(Vertex goingTo) {
        this.goingTo = goingTo;
    }

    private Vertex goingTo;
    private boolean left;



    public Edge(Color color, Vertex vertex){
        this.color=color;
        this.goingTo=vertex;
    }

    public Edge(){

    }


    public void setLeft(boolean side){
        left=side;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isLeft() {
        return left;
    }

    public Vertex getGoingTo() {
        return goingTo;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
