package com.grafos;

import com.grafos.implementacoes.*;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Graph> graphs = new ArrayList<>();


    public static void main(String[] args) {

        graphs = GraphsLoader.loadAllFiles();
//        testes_1();
        testes_2();
    }
    private static void testes_2(){
        Graph graphA = loadGraph("grafo-6");
//        Graph graphB = loadGraph("grafo-6");

        Kruskal kruskal = new Kruskal(graphA);
        kruskal.run();
    }

    private static void testes_1(){
        Graph graphA = loadGraph("grafo-3");
        Graph graphB = loadGraph("grafo-2");

        test_bfs_dfs_bellman(graphA);
        test_bfs_dfs_bellman(graphB);
    }

    private static void test_bfs_dfs_bellman(Graph g){
        String divider = "---------------------------------------------------";

        MinimalPathAlgorithms mpa = new MinimalPathAlgorithms(g);

        System.out.println(divider.concat(divider));
        System.out.println("Grafo: "+g.name);
        System.out.println("BFS - Partindo de: <"+g.vertexesArray.get(0).name+">");
        Util.bfs(g, g.vertexesArray.get(0));
        System.out.println(divider);
        System.out.println("DFS");
        Util.dfs(g);
        System.out.println(divider);
        System.out.print("Bellman-ford - Partindo de: <"+g.vertexesArray.get(0).name+">");
        mpa.bellman_ford(g, g.vertexesArray.get(0));
        System.out.println(g);


    }

    private static Graph loadGraph(String name){

        for (Graph g : graphs) {
            if (g.name.equals(name)) return g;
        }
        return null;
    }

}


