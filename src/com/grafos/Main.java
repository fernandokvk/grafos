package com.grafos;

import com.grafos.implementacoes.*;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Graph> graphs = new ArrayList<>();


    public static void main(String[] args) {

        graphs = GraphsLoader.loadAllFiles();

        for (Graph g :
                graphs) {
            if (g.name.equals("grafo-3")) {
                MinimalPathAlgorithms mpa = new MinimalPathAlgorithms(g);
                String name = "t";
                Graph.Vertex vertice = g.vertexesArray.stream().filter(t -> t.name.equals(name)).findFirst().orElse(null);
                mpa.bellman_ford(g, vertice);
//                Util.bfs(g, g.vertexesArray.get(0));
//                Util.dfs(g);
                System.out.println(g);
            }
        }
    }

}


