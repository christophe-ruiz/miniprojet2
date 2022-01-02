package com.company.Algo;

import com.company.Edge;
import com.company.Graph;
import com.company.Vertex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Algo1 implements Algo {

    private Graph graph;
    private ArrayList<Vertex> redListSorted;

    public Algo1(Graph graph){
        setGraph(graph);
    }

    public void updateRedListSorted(){
        this.redListSorted = this.graph.getAllRedActiveVertex();
        Collections.sort(redListSorted);
    }

    public int run() throws IOException {
        int count = 0;
        graph.display();
        graph.jumpLine();
        while (redListSorted.size()!=0){
            deleteVertex(redListSorted.get(0));
            this.updateRedListSorted();
            count+=1;
            graph.display();
            graph.jumpLine();
        }
//        graph.endDisplay();
        return count;
    }

    @Override
    public void setGraph(Graph graph) {
        this.graph = graph;
        updateRedListSorted();
    }

    private void deleteVertex(Vertex v) {
        v.setDeleted(true);
        for (Edge e : v.getOutGoingEdges()){
            e.setDeleted(true);
            if (e.getColor()!=e.getGoingTo().getColor()){
                e.getGoingTo().setColor(e.getColor());
            }

        }
        for (Edge e : v.getIncomingEdges()){
            e.setDeleted(true);
        }
    }

}
