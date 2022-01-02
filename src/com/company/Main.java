package com.company;

import com.company.Algo.Algo1;
import com.company.Benchmark.Benchmark;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        final int NB_GRAPH = 100;
        final int NB_VERTEX = 100;
        final double RED_VERTEX_PROB = 0.5;
        final double RED_EDGE_PROB = 0.5;
        final double LEFT_PROB = 0.5;

//        GraphCreator creator = new GraphCreator(NB_VERTEX, RED_VERTEX_PROB, RED_EDGE_PROB, LEFT_PROB);
//
//        Graph graph = creator.createInstance();
//        Algo1 algo = new Algo1(graph);
//        System.out.println("la plus longue chaîne rouge supprimable est : " + algo.run());

        Benchmark b = new Benchmark();
        b.bench(LEFT_PROB, NB_GRAPH, NB_VERTEX);
    }
}
