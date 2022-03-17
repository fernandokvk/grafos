package com.company;

import java.util.ArrayList;
import java.util.List;

public class Buscas {

    List<Vertice> Q;

    public Buscas() {
        Q = new ArrayList<>();
    }
    //DFS e BFS

    public void dfs(Grafo grafo){

        int tempo = 0;

        for (Vertice v: grafo.vertices){
            v.cor = Cor.BRANCO;
        }

        for (Vertice v: grafo.vertices) {
            if (v.cor == Cor.BRANCO){
                dfsVisit(v, tempo);
            }
        }
    }

    private void dfsVisit(Vertice v, int tempo){
        tempo++;
        v.cor = Cor.CINZA;
        System.out.println(v.num+1);
        v.depth = tempo;

        for (Vertice u : v.listaAdj.keySet()) {
            if(u.cor == Cor.BRANCO){
                u.pai = v;
                dfsVisit(u,tempo);
            }
        }

        v.cor = Cor.PRETO;
        tempo++;
        v.fim = tempo;
    }

    public void bfs(Grafo grafo, Vertice origem){

        for (Vertice v: grafo.vertices){
            if (v !=  origem){
                v.depth = -1;
                v.cor = Cor.BRANCO;
            }
        }

        origem.depth = 0;
        origem.cor = Cor.CINZA;
        Q.add(origem);
        Vertice u = new Vertice();

        while (!Q.isEmpty()){

            u = Q.remove(0);

            for (Vertice v: u.listaAdj.keySet()){
                if (v.cor == Cor.BRANCO){
                    v.depth = u.depth +1;
                    v.pai = u;
                    v.cor = Cor.CINZA;
                    Q.add(v);
                }
            }
            u.cor = Cor.PRETO;
            System.out.println(u.num);
        }
    }
}
