package com.company;

import java.util.ArrayList;
import java.util.List;

public class Buscas {

    List<Vertice> Q;

    public Buscas() {
        Q = new ArrayList<>();
    }
    //DFS e BFS

    public void bfs(Grafo grafo, Vertice origem){

        for (Vertice v: grafo.vertices){
            if (v !=  origem){
                v.d = -1;
                v.cor = 0;
            }
        }

        origem.d = 0;
        origem.cor = 1;

        Q.add(origem);

        Vertice u = new Vertice();

        while (!Q.isEmpty()){

            u = Q.remove(0);

            for (Vertice v: u.adj){
                if (v.cor == 0){
                    v.d = u.d +1;
                    v.pai = u;
                    v.cor = 1;
                    Q.add(v);
                }
            }
            u.cor = 2;
            System.out.println(u.num);

        }


    }


    public void dfs(Grafo grafo, Vertice origem){

    }
}
