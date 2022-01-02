package com.company.Benchmark;

import com.company.Algo.Algo1;
import com.company.Graph;
import com.company.GraphCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Benchmark {
    private List<Double> avgList = new ArrayList<>();
    private final List<Double> probList = new ArrayList<>() {{
        add(0.);
        add(.1);
        add(.2);
        add(.3);
        add(.4);
        add(.5);
        add(.6);
        add(.7);
        add(.8);
        add(.9);
        add(1.);
    }};

    public Benchmark() {
    }

    public void bench(double LEFT_PROB, int nb_graph, int NB_VERTEX) throws IOException {
        probList.forEach(RED_VERTEX_PROB -> {
            probList.forEach(RED_EDGE_PROB -> {
                List<Double> line = new ArrayList<>();
                for (int i = 0; i <= nb_graph; ++i) {
                    GraphCreator creator = new GraphCreator(NB_VERTEX, RED_VERTEX_PROB, RED_EDGE_PROB, LEFT_PROB);
                    Graph graph = creator.createInstance();
                    Algo1 algo = new Algo1(graph);
                    try {
                        line.add((double) algo.run());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Double avg = line.stream()
                        .mapToDouble(d -> d)
                        .average()
                        .orElse(0.0);
                System.out.println(avg);
                avgList.add(avg);
            });
            System.out.println(avgList);
        });
    }
}
