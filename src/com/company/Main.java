package com.company;

public class Main {

    public static void main(String[] args) {

        final int NB_VERTEX = 10;
        final double RED_VERTEX_PROB = 0.5;
        final double RED_EDGE_PROB = 0.5;
        final double LEFT_PROB = 0.5;

        GraphCreator creator = new GraphCreator(NB_VERTEX, RED_VERTEX_PROB, RED_EDGE_PROB, LEFT_PROB);
        Graph graph = creator.createInstance();
        System.out.println(graph);



    }
}
