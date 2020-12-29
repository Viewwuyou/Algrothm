package com.viewwuyou.algrothm.Graph.Digraph;

import com.viewwuyou.algrothm.Graph.Graph;

public class DigDFS {

    private final boolean[] marked;

    public DigDFS(Graph G, Integer s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    public void dfs(Graph G, Integer s) {
        System.out.print(s + " ");
        marked[s] = true;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public Boolean marked(int v) {
        return marked[v];
    }
}
