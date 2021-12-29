package com.company;

import java.util.ArrayList;
import java.util.List;

public class Vertex {


    private Color color;
    private final List<Edge> outGoingEdges;

    public Vertex(Color color) {
        this.color=color;
        this.outGoingEdges = new ArrayList<>();
    }
    public Vertex() {
        this.outGoingEdges = new ArrayList<>();
    }

    private void addEdge(Edge edge){
        this.outGoingEdges.add(edge);
    }

    public Color getColor() {
        return color;
    }

    public void addEdge(Color color, Vertex goTo){
        this.addEdge(new Edge(color,goTo));
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
