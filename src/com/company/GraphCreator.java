package com.company;

import java.util.Random;

public class GraphCreator {
    private int maxSommet;
    private double redVertexProb;
    private double redEdgeProb;
    private double leftProb;
    Random rand = new Random();


    public GraphCreator(int max, double redV,double redE, double left) {
        this.maxSommet = max;
        this.redVertexProb = redV;
        this.redEdgeProb = redE;
        this.leftProb = left;
    }


    public Graph createInstance() {
        Graph created = new Graph();
        addVertexes(created);
        setEdges(created);

        return created;
    }

    public Color pickColor(double proba){
        int choice = rand.nextInt(maxSommet);
        if (choice < proba * 100) {
            return(Color.RED);
        }
        else{
            return(Color.BLUE);
        }
    }

    public boolean pickSide(){
        int choice = rand.nextInt(maxSommet);
        if (choice < leftProb * 100) {
            return(true);
        }
        else{
            return(false);
        }

    }


    private void addVertexes(Graph graph) {
        for (int i = 0; i < maxSommet; i++) {
            Vertex v = new Vertex();
            v.setColor(this.pickColor(redVertexProb));
            graph.addVertex(v);
        }
    }

    private void setEdges(Graph graph){
        for (int i = 0; i < maxSommet -1; i++) {

                            /* Color */

            Edge e = new Edge();
            e.setColor(pickColor(redEdgeProb));

                        /* Left or Right */

            e.setLeft(this.pickSide());

            graph.edges.add(e);

            if (e.isLeft()){
                e.setGoingTo(graph.vertex.get(i));
                graph.vertex.get(i+1).addEdge(e);
            }
            else {
                e.setGoingTo(graph.vertex.get(i));
                graph.vertex.get(i).addEdge(e);
            }
        }
    }
}
