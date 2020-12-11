package com.viewwuyou.algrothm.Graph;

import java.util.ArrayList;

public class AdjGraph extends AbstractGraph {

    private final int V;
    private int E;
    private final
    ArrayList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public AdjGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }


    @Override
    public int V() {
        return this.V;
    }

    @Override
    public int E() {
        return this.E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
