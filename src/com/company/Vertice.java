package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Vertice {
    int num, depth, fim, grauSaida, grauEntrada;
    List<Vertice> adj;
    HashMap<Vertice, Integer> listaAdj;
    Vertice pai;
    Cor cor;

    public Vertice(){
    }

    public Vertice(int num) {
        this.num = num;
        this.adj = new LinkedList<Vertice>();
        this.listaAdj = new HashMap<>();
    }


    public String toString() {
        return "Vertice(" + num + ")";
    }
}
