package com.company;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Vertex> vertex;
    List<Edge> edges;
    FileWriter fw = null;


    public Graph(){
        vertex = new ArrayList<>();
        edges = new ArrayList<>();


        try {
            fw = new FileWriter("output.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write("<html>");
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public ArrayList<Vertex> getAllRedVertexes(){
        ArrayList<Vertex> list = new ArrayList<>();
        for (Vertex v : vertex){
            if (v.getColor()==Color.RED) {
                v.updateScore();
                list.add(v);
            }
        }
        return list;
    }

    public ArrayList<Vertex> getAllRedActiveVertex(){
        ArrayList<Vertex> list = new ArrayList<>();
        for (Vertex v : vertex){
            if (!v.isDeleted() && v.getColor()==Color.RED) {
                list.add(v);
            }
        }
        return list;
    }

    public void jumpLine() throws IOException {
        fw.write("<br/><br/>");
    }
    public void displayVertexes(FileWriter fw, int i) throws IOException {

        if(vertex.get(i).isDeleted()){
            fw.write("<a style=\"padding-right:8px;\">   </a>");
        }
        else if (vertex.get(i).getColor()==Color.RED){
            fw.write("<body>&#x1F534;</body>");
        }
        else{
            fw.write("<body>&#x1F535;</body>");
        }
    }
    public void displayEdges(FileWriter fw, int i) throws IOException {

            if (edges.get(i)==null){
            }
            else if(edges.get(i).isDeleted()){
                fw.write("<a style=\"padding-right:8px;\">   </a>");
            }
            else if (edges.get(i).isLeft()) {

                if (edges.get(i).getColor() == Color.RED) {
                    fw.write("<a style=\"color:red;\"> &#x2190 </a>");
                } else {
                    fw.write("<a style=\"color:blue;\"> &#x2190 </a>");
                }
            }
            else {

                if (edges.get(i).getColor() == Color.RED) {
                    fw.write("<a style=\"color:red;\"> &#x2192 </a>");
                } else {
                    fw.write("<a style=\"color:blue;\"> &#x2192 </a>");
                }
            }


    }

    public void display(){
        for (int i =0 ; i<vertex.size() ; i++ ){
            try {
                displayVertexes(fw,i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                displayEdges(fw,i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void endDisplay(){
        try {
            fw.write("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @Override
        public String toString() {
        this.display();
        this.endDisplay();
        return ("Number of red vertex : " + getNbColoredVertex(Color.RED) + '\n' +
                "Number of blue vertex : " + getNbColoredVertex(Color.BLUE) + '\n');
    }


}
