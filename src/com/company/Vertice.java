package com.company;

import java.util.List;
import java.util.LinkedList;

public class Vertice {
    int num;
    List<Vertice> adj;
    int grauSaida;
    int grauEntrada;
    int d;
    Vertice pai;
    int cor;

    public Vertice(){

    }

    public Vertice(int num) {
        this.num = num;
        this.adj = new LinkedList<Vertice>();
    }

    public String toString() {
        return "Vertice(" + num + ")";
    }
}
