package com.viewwuyou.algrothm.Graph;

import java.util.Iterator;

public class DepthFirstSearch {

    private final boolean[] marked;

    public DepthFirstSearch(AdjGraph G, int s){
        marked = new boolean[G.V()];
        System.out.println("Start to search......");
        dfs(G, s);
    }

    public void dfs(AdjGraph G, int v) {
        marked[v] = true;
        System.out.println(v);
        int s;
        for (Integer integer : G.adj(v)) {
            s = integer;
            if (marked[s]) {
                continue;
            }
            dfs(G, s);
        }
    }
}
