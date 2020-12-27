package com.viewwuyou.algrothm.Graph.Digraph;

import com.viewwuyou.algrothm.Graph.Graph;

import java.util.ArrayList;

public class Digraph implements Graph {
    private int V;
    private int E;
    private ArrayList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
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
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int i = 0; i < V; i++) {
            for (Integer w : adj(V)) {
                R.addEdge(w, i);
            }
        }
        return R;
    }
}
