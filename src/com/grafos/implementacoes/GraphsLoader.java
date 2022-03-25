package com.grafos.implementacoes;

import com.grafos.Main;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GraphsLoader {


    public static ArrayList<Graph> loadAllFiles() {

        ArrayList<Graph> graphs = new ArrayList<>();
        URL url = Main.class.getResource("arquivos");
        File folder = new File(url.getFile());

        File[] files = folder.listFiles((dir, name) -> name.toLowerCase(Locale.ROOT).endsWith(".txt"));

        for (File f : files) {

            try {
                Scanner sc = new Scanner(f);
                String name = sc.nextLine().split("[:]")[1].trim();
                int size = Integer.parseInt(sc.nextLine().split("[:]")[1].trim());
                Graph graph = new Graph(name, size);

                addVertexes(graph, sc);
                graphs.add(graph);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return graphs;
    }

    private static void addVertexes(Graph graph, Scanner sc){

        sc.nextLine(); // Pulando <NOME-VERTICE,VERTICE-ADJ,PESO>
        while (sc.hasNextLine()){
            String[] line = sc.nextLine().split("[,]");
            Graph.Vertex u = new Graph.Vertex(line[0]);
            Graph.Vertex v = new Graph.Vertex(line[1]);
            int weight = Integer.parseInt(line[2]);
            graph.addEdge(u, v, weight);
        }

    }
}
