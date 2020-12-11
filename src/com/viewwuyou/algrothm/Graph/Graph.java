package com.viewwuyou.algrothm.Graph;

public interface Graph {
    public int V();
    public int E();

    public void addEdge(int v, int w);

    Iterable<Integer> adj(int v);
}
