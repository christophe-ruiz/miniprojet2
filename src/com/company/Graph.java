package com.company;

import com.company.draw.Triangle;

import java.io.FileWriter;
import java.io.IOException;
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
    public void displayVertexes(FileWriter fw, int i) throws IOException {
            if (vertex.get(i).getColor()==Color.RED){
                fw.write("<body>&#x1F534;</body>");
            }
            else{
                fw.write("<body>&#x1F535;</body>");
            }
    }
    public void displayEdges(FileWriter fw, int i) throws IOException {

            if (edges.get(i)==null){return;}
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
        @Override
        public String toString() {
        FileWriter fw = null;
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
        edges.add(null);
        for (int i =0 ; i<100 ; i++ ){
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

        return ("Number of red vertex : " + getNbColoredVertex(Color.RED) + '\n' +
                "Number of blue vertex : " + getNbColoredVertex(Color.BLUE) + '\n');
    }


}
