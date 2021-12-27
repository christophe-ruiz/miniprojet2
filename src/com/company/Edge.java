package com.company;

public class Edge {
    private Color color;
    private Vertex goingTo;



    public Edge(Color color, Vertex vertex){
        this.color=color;
        this.goingTo=vertex;
    }


    public Color getColor() {
        return color;
    }

    public Vertex getGoingTo() {
        return goingTo;
    }
}
