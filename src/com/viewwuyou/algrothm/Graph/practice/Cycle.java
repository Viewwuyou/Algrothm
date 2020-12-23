package com.viewwuyou.algrothm.Graph.practice;


import com.viewwuyou.algrothm.Graph.Graph;

/**
 * 编写一个检测图是不是无环图的算法(不包括自环)
 * 思路：
 * 既然要无环，也就是在搜索过程中任何一个顶点都不应该检索到已经标记过的顶点，一旦检索到，即是有环
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    public Cycle(Graph G) {
        marked = new boolean[G.V()];

        for (int s = 0; s < G.V(); s++) {
            if (!marked[s])
                dfs(G, s, s);
        }
    }

    private void dfs(Graph G, int s, int u) {
        marked[s] = true;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                dfs(G, w, s);
            }
            // 这里需要排除掉已经递归查找过的父节点，因为子节点在递归之后调用自己的adj方法也会返回父节点
            // 由于说了没有自环和平行边，因此这个可以直接排除
            else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean isHasCycle(){
        return hasCycle;
    }
}
