package com.grafos;

import com.grafos.implementacoes.Graph;
import com.grafos.implementacoes.GraphsLoader;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Graph> graphs = new ArrayList<>();


    public static void main(String[] args) {

        graphs = GraphsLoader.loadAllFiles();
        System.out.println("oi");

    }

}
