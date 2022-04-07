package com.grafos;

import com.grafos.implementacoes.*;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Graph> graphs = new ArrayList<>();


    public static void main(String[] args) {

        graphs = GraphsLoader.loadAllFiles();

        for (Graph g :
                graphs) {
            if (g.name.equals("grafo-5")) {
                MinimalPathAlgorithms mpa = new MinimalPathAlgorithms(g);
//                mpa.bellman_ford(g, g.vertexesArray.get(0));
                Util.bfs(g, g.vertexesArray.get(0));
//                System.out.println(g);

            }
        }
    }

}


