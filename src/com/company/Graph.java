package com.company;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Vertex> vertex;


    public Graph(){
        vertex = new ArrayList<>();
    }

    public void addVertex(Vertex v){
        this.vertex.add(v);
    }

    public int getNbColoredVertex(Color color){
        int count = 0;
        for (Vertex v : vertex){
            if ( v.getColor()==color)
                count++;
        }
        return count;
    }

    @Override

    public String toString(){
        return ("Number of red vertex : " + getNbColoredVertex(Color.RED) + '\n' +
                "Number of blue vertex : " + getNbColoredVertex(Color.BLUE) + '\n');
    }
}
