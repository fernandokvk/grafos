package com.grafos.implementacoes;

import java.util.ArrayList;
import java.util.Collections;

public class FloydWarshall{
    private final Graph graph;
    private int[][] distance ;
    public static final int INF = 999999;



    public FloydWarshall(Graph graph){
            this.graph = graph;
            initialize();
    }

    private void initialize(){
        this.distance = new int [graph.size][graph.size];
        for (Graph.Vertex u : graph.vertexesArray) {
            int i = Integer.parseInt(u.name)-1;
            for (Graph.Vertex v : u.listaAdj.keySet()) {
                int j = Integer.parseInt(v.name)-1;
                distance[i][j] = u.listaAdj.get(v);
            }
        }
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance.length; j++) {
                if((i != j) && (distance[i][j] ==0)){
                    distance[i][j]= INF;
                }
            }
        }
    }

    public void run(){
        for (int k = 0; k < distance.length; k++) {
            System.out.println();
            System.out.println("Etapa "+(k+1)+":");
            System.out.println();
            for (int i = 0; i < distance.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < distance.length; j++) {
                    if(distance[i][k] + distance[k][j]<distance[i][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                    System.out.printf("%8d",distance[i][j]);
                }
                System.out.println(" |");
                
            }
            System.out.println();
        }
        // for (int i = 0; i < distance.length; i++) {
        //     for (int j = 0; j < distance.length; j++) {
        //         System.out.print(distance[i][j] + " ");
        //     }
        //     System.out.println();
        // }


    }
}