package com.grafos.implementacoes;

import java.util.ArrayList;
import java.util.List;

public class Buscas {

    ArrayList<Grafo.Vertice> Q;

    public Buscas() {
        Q = new ArrayList<>();
    }

    public static void calcularGrausDeSaida(Grafo g) {
        for (Grafo.Vertice v : g.vertices) {
            v.grauSaida = 0;
        }

        for (Grafo.Vertice v : g.vertices) {
            for (Grafo.Vertice u : v.listaAdj.keySet()) {
                v.grauSaida += 1;
            }
        }
    }

    public static void mostrarGrausDeSaida(Grafo g) {
        for (Grafo.Vertice v : g.vertices) {
            System.out.printf("%s.grauSaida = %d\n", v, v.grauSaida);
        }
    }

    public static void mostrarGrausDeEntrada(Grafo g){
        for (Grafo.Vertice v:
             g.vertices) {
            System.out.printf("%s.grauEntrada = %d\n", v, v.grauEntrada);
        }
    }

    public static void calcularGrauDeEntrada(Grafo g){
        for (Grafo.Vertice v : g.vertices) {
            v.grauEntrada = 0;
        }

        for (Grafo.Vertice v : g.vertices) {

        }
    }

    public void dfs(Grafo grafo){

        int tempo = 0;

        for (Grafo.Vertice v: grafo.vertices){
            v.cor = Grafo.Cor.BRANCO;
        }

        for (Grafo.Vertice v: grafo.vertices) {
            if (v.cor == Grafo.Cor.BRANCO){
                dfsVisit(v, tempo);
            }
        }
    }

    private void dfsVisit(Grafo.Vertice v, int tempo){
        tempo++;
        v.cor = Grafo.Cor.CINZA;
        System.out.println(v.num+1);
        v.depth = tempo;

        for (Grafo.Vertice u : v.listaAdj.keySet()) {
            if(u.cor == Grafo.Cor.BRANCO){
                u.pai = v;
                dfsVisit(u,tempo);
            }
        }

        v.cor = Grafo.Cor.PRETO;
        tempo++;
        v.fim = tempo;
    }

    public void bfs(Grafo grafo, Grafo.Vertice origem){

        for (Grafo.Vertice v: grafo.vertices){
            if (v !=  origem){
                v.depth = -1;
                v.cor = Grafo.Cor.BRANCO;
            }
        }

        origem.depth = 0;
        origem.cor = Grafo.Cor.CINZA;
        Q.add(origem);
        Grafo.Vertice u = new Grafo.Vertice();

        while (!Q.isEmpty()){

            u = Q.remove(0);

            for (Grafo.Vertice v: u.listaAdj.keySet()){
                if (v.cor == Grafo.Cor.BRANCO){
                    v.depth = u.depth +1;
                    v.pai = u;
                    v.cor = Grafo.Cor.CINZA;
                    Q.add(v);
                }
            }
            u.cor = Grafo.Cor.PRETO;
            System.out.println(u.num);
        }
    }
}
