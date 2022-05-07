package com.grafos;

import com.grafos.implementacoes.*;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Graph> graphs = new ArrayList<>();


    public static void main(String[] args) {

        graphs = GraphsLoader.loadAllFiles();
//        testes_bfs_dfs_bellman();
//        testes_kruskal();
//        testes_fordfulkerson();
        test_floydwarshall();
    }

    private static void testes_fordfulkerson() {
        Graph graphA = loadGraph("grafo-fluxo-1");
        Graph graphB = loadGraph("grafo-fluxo-2");

        FordFulkerson fordFulkerson = new FordFulkerson(graphA);
        fordFulkerson.run();

        fordFulkerson = new FordFulkerson(graphB);
        fordFulkerson.run();
    }


    private static void testes_kruskal(){
        Graph graphA = loadGraph("grafo-1");
        Graph graphB = loadGraph("grafo-6");

        Kruskal kruskal = new Kruskal(graphA);
        kruskal.run();

        kruskal = new Kruskal(graphB);
        kruskal.run();
    }

    private static void testes_bfs_dfs_bellman(){
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

    private static void test_floydwarshall(){
        Graph graphA = loadGraph("grafo-floyd-warshall-1");
        Graph graphB = loadGraph("grafo-floyd-warshall-2");
        String divider = "---------------------------------------------------";
        
        FloydWarshall floyd = new FloydWarshall(graphA);
        System.out.println(divider);
        System.out.println("Grafo 1 Floyd-Warshall: ");
        floyd.run();

        floyd = new FloydWarshall(graphB);
        System.out.println(divider);
        System.out.println("Grafo 2 Floyd-Warshall: ");
        floyd.run();

    }

    private static Graph loadGraph(String name){

        for (Graph g : graphs) {
            if (g.name.equals(name)) return g;
        }
        return null;
    }

}


