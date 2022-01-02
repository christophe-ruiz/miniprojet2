package com.company;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{

    private Color color;
    private final List<Edge> outGoingEdges;
    private final List<Edge> incomingEdges;
    private int score;
    private boolean deleted = false ;

    public Vertex(Color color) {
        this.color=color;
        this.outGoingEdges = new ArrayList<>();
        this.incomingEdges = new ArrayList<>();
    }
    public Vertex() {
        this.outGoingEdges = new ArrayList<>();
        this.incomingEdges = new ArrayList<>();
    }

    public void addOutGoingEdge(Edge edge){
        this.outGoingEdges.add(edge);
    }

    public List<Edge> getOutGoingEdges() {
        return outGoingEdges;
    }

    public List<Edge> getIncomingEdges() {
        return incomingEdges;
    }

    public void addIncomingEdge(Edge edge){
        this.incomingEdges.add(edge);
    }

    public Color getColor() {
        return color;
    }

    public void updateScore(){
        if (this.color==Color.BLUE){
            this.score=0;
        }
        else{
            for (Edge e: outGoingEdges){
                if (e.getColor()==Color.RED && e.getGoingTo().getColor()==Color.BLUE){
                    addScore(5);
                }
                if (e.getColor()==Color.RED && e.getGoingTo().getColor()==Color.RED){
                    addScore(4);
                    e.getGoingTo().addScore(1);
                }
                if (e.getColor()==Color.BLUE && e.getGoingTo().getColor()==Color.RED){
                    this.addScore(-8);
                    e.getGoingTo().addScore(3);
                }
                if (e.getColor()==Color.BLUE && e.getGoingTo().getColor()==Color.BLUE){
                    this.addScore(2);
                }
            }
        }
    }


    public void addScore(int x){
        this.score+=x;
    }

    public int getScore() {
        return score;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.score - o.getScore() ;
    }

}
