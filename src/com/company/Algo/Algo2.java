package com.company.Algo;

import com.company.Color;
import com.company.Edge;
import com.company.Graph;
import com.company.Vertex;

import java.io.IOException;
import java.util.Stack;

public class Algo2 implements Algo {

    private Graph graph;
    private Stack<Vertex> redStack;
    private int count = 0;

    public Algo2(Graph graph){
        setGraph(graph);
    }

    public void traiter(Vertex v) throws IOException {
        for (Edge e : v.getOutGoingEdges()){
            if (e.isDeleted()) continue;
            //Pour chaque arcs sortant BLEU ebi de vi
            if (e.getColor().equals(Color.BLUE)){
                //Si ebi pointe vers un sommet rouge wi
                if (e.getGoingTo().getColor().equals(Color.RED)){
                    //traiter wi
                    traiter(e.getGoingTo());
                    redStack.remove(e.getGoingTo());
                }
                //Modifier la couleur du sommet associé en bleu
                e.getGoingTo().setColor(Color.BLUE);
            }
            //Pour chaque arcs sortant ROUGE eri de vi
            else if (e.getColor().equals(Color.RED)){
                if (e.getGoingTo().getColor().equals(Color.BLUE))
                    redStack.push(e.getGoingTo());
                //Modifier la couleur du sommet associé en rouge
                e.getGoingTo().setColor(Color.RED);
                //Empiler le nouveau sommet rouge dans S ( il sera le prochain à être dépilé)
            }
            e.setDeleted(true);
        }
        for (Edge e : v.getIncomingEdges()){
            e.setDeleted(true);
        }
        v.setDeleted(true);
        this.count+=1;
        graph.display();
        graph.jumpLine();
    }

    public int run() throws IOException {
        //Tant que la pile n'est pas vide
        graph.display();
        graph.jumpLine();
        while(!redStack.isEmpty()){
            //Dépiler le sommet vi de S
            Vertex v = redStack.pop();
            traiter(v);
        }
        return count;
    }

    @Override
    public void setGraph(Graph graph) {
        this.graph = graph;
        this.count = 0;
        initializeStack();
    }

    private void initializeStack(){
        this.redStack=new Stack<>();
        for (Vertex v : graph.getAllRedVertexes()){
            redStack.push(v);
        }
    }

}
