package com.company.Algo;

import com.company.Graph;
import com.company.Vertex;

import java.util.Stack;

public class Algo2 {

    private Graph graph;
    private Stack<Vertex> redStack;

    public Algo2(Graph graph){
        this.graph=graph;
        initializeStack();
    }

    private void initializeStack(){
        this.redStack=new Stack<>();
        for (Vertex v : graph.getAllRedVertexes()){
            redStack.push(v);
        }
    }
}
