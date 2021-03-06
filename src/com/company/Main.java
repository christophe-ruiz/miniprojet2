package com.company;

import com.company.Algo.Algo1;
import com.company.Algo.Algo2;
import com.company.Benchmark.Benchmark;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        final int NB_GRAPH = 100;
        final int NB_VERTEX = 10;
        final double RED_VERTEX_PROB = 0.5;
        final double RED_EDGE_PROB = 0.5;
        final double LEFT_PROB = 0.5;


        GraphCreator creator = new GraphCreator(NB_VERTEX, RED_VERTEX_PROB, RED_EDGE_PROB, LEFT_PROB);

        Graph graph2 = creator.createInstance();
        Algo2 algo2 = new Algo2(graph2);
//        System.out.println("La plus longue chaine rouge supprimable pour l'algo 2 est : "+algo2.run());

        Benchmark b = new Benchmark(algo2);
        b.bench(LEFT_PROB, NB_GRAPH, NB_VERTEX);
        graph2.endDisplay();
    }
}
