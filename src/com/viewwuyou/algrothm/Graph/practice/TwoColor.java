package com.viewwuyou.algrothm.Graph.practice;

import com.viewwuyou.algrothm.Graph.Graph;

/**
 * 双色问题，即二分图问题，是否能用两种颜色标记整幅图，要求同一条边上的两个节点的颜色不相同
 * 思路：
 * 用两个颜色分别标记并检测
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColor;

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        for (int w : G.adj(s))
        {
            if (!marked[w]) {
                color[w] = !color[s];
                dfs(G, w);
            }
            else if (color[w] == color[s])
                isTwoColor = false;
        }
    }

    public boolean ifIsTwoColor() {
        return isTwoColor;
    }
}
