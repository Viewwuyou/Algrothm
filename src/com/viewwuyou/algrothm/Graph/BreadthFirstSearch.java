package com.viewwuyou.algrothm.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    private final boolean[] marked;

    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    /**
     * 这是对广度优先搜索的实现，该和深度优先搜索不同，广度优先搜索用了一个队列来保存搜索过程
     * 其实也很好理解，由于深度优先搜索要求对邻节点优先搜索，因此需要不断遍历到底，再挨个返回，这是满足栈这个数据结构的
     * 但是广度优先搜索要求先搜索相对与一个父节点的所有兄弟节点，因此需要先将搜索过的节点遍历，也就时先进先出，这是满足队列这个数据结构的
     * 由于用了队列，这里不能再使用递归这个隐式栈结构，直接使用循环进行标记。
     * @param G
     * @param s
     */
    public void bfs(Graph G, int s) {
        LinkedList<Integer> queue = new LinkedList<>();

        marked[s] = true;
        queue.add(s);
        System.out.println(s);
        while (!queue.isEmpty())
        {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    queue.add(w);
                    System.out.println(w);
                }
            }
        }
    }
}
