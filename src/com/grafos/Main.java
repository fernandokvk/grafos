package com.grafos;

import com.grafos.implementacoes.*;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Graph> graphs = new ArrayList<>();


    public static void main(String[] args) {

        graphs = GraphsLoader.loadAllFiles();

        for (Graph g:
             graphs) {
            Util.calcularGraus(g);
            System.out.println(g.toString());
        }
    }

}
