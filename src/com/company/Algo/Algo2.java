package com.company.Algo;

import com.company.Color;
import com.company.Edge;
import com.company.Graph;
import com.company.Vertex;

import java.io.IOException;
import java.util.Stack;

public class Algo2 {

    private Graph graph;
    private Stack<Vertex> redStack;
    private int count = 0;

    public Algo2(Graph graph){
        this.graph=graph;
        initializeStack();
    }

    public void traiter(Vertex v){
        for (Edge e : v.getOutGoingEdges()){

            //Pour chaque arcs sortant BLEU ebi de vi
            if (e.getColor().equals(Color.BLUE)){
                //Si ebi pointe vers un sommet rouge wi
                if (e.getGoingTo().getColor().equals(Color.RED)){
                    //empiler vi
                    //redStack.push(v);

                    //traiter wi
                    traiter(e.getGoingTo());

                    //retirer wi de S
                    //redStack.remove(e.getGoingTo());
                }
                //Modifier la couleur du sommet associé en bleu
                e.getGoingTo().setColor(Color.BLUE);
                redStack.remove(e);
            }

            //Pour chaque arcs sortant ROUGE eri de vi
            if (e.getColor().equals(Color.RED)){
                //Modifier la couleur du sommet associé en rouge
                e.getGoingTo().setColor(Color.RED);
                //Empiler le nouveau sommet rouge dans S ( il sera le prochain à être dépilé)
                redStack.push(e.getGoingTo());
            }
            e.setDeleted(true);
        }
        v.setDeleted(true);
        graph.display();
        this.count+=1;
    }

    public int run()  {
        //Tant que la pile n'est pas vide
        graph.display();
        while(!redStack.isEmpty()){
            //Dépiler le sommet vi de S
            Vertex v = redStack.pop();
            traiter(v);
        }
        graph.endDisplay();
        return count;
    }

    private void initializeStack(){
        this.redStack=new Stack<>();
        for (Vertex v : graph.getAllRedVertexes()){
            redStack.push(v);
        }
    }

}
