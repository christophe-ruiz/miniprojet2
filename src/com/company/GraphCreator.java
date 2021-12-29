package com.company;

import java.util.Random;

public class GraphCreator {
    private int maxSommet;
    private double redProb;
    private double leftProb;


    public GraphCreator(int max, double red, double left) {
        this.maxSommet = max;
        this.redProb = red;
        this.leftProb = left;
    }


    public Graph createInstance() {
        Graph created = new Graph();
        addVertexes(created);
        return created;
    }


    private void addVertexes(Graph graph) {
        Random rand = new Random();
        for (int i = 0; i < maxSommet; i++) {
            Vertex v = new Vertex();
            int choice = rand.nextInt(100);
            if (choice < redProb * 100) {
                v.setColor(Color.RED);
            }
            else{
                v.setColor(Color.BLUE);
            }
            graph.addVertex(v);
        }
    }
}
