package com.company;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Vertex> vertex;
    List<Edge> edges;


    public Graph(){
        vertex = new ArrayList<>();
        edges = new ArrayList<>();
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
    public void displayVertexes(int i){
        if (vertex.get(i).getColor()==Color.RED){
            System.out.print("(R)");
        }
        else if (vertex.get(i).getColor()==Color.BLUE){
            System.out.print("(B)");
        }
    }
    public void displayEdges(int i) {
        Edge e = edges.get(i);
        if (e==null) return;
        if (e.isLeft()){
            System.out.print("<-");
            if (e.getColor()==Color.RED){
                System.out.print("R--");
            }
            else{
                System.out.print("B--");
            }
        }
        else{
            System.out.print("--");
            if (e.getColor()==Color.RED){
                System.out.print("R->");
            }
            else{
                System.out.print("B->");
            }
        }
    }

    @Override

    public String toString(){

        edges.add(null);
        for (int i =0 ; i<100 ; i++ ){
            displayVertexes(i);
            displayEdges(i);

        }
        System.out.print("\n");

        return ("Number of red vertex : " + getNbColoredVertex(Color.RED) + '\n' +
                "Number of blue vertex : " + getNbColoredVertex(Color.BLUE) + '\n');
    }


}
