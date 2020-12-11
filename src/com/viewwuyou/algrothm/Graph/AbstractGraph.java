package com.viewwuyou.algrothm.Graph;

import java.util.Iterator;

abstract public class AbstractGraph implements Graph {

    /**
     * 计算一个节点的度
     * @param G 给定的图
     * @param v 给定的节点
     * @return 返回该节点的度
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        Iterator<Integer> iterator = G.adj(v).iterator();
        if (iterator.hasNext()) {
            degree++;
            iterator.next();
        }
        return degree;
    }

    /**
     * 计算一个图的最大的度数
     * @param G 给定的图
     * @return 返回该图所有节点的最大度数
     */
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    /**
     * 计算图的平均度数，每条边有两个节点，因此需要乘2
     * @param G 给定的图
     * @return 返回该图的平均度数
     */
    public static double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    /**
     * 计算自环的数量
     * 这里有一个疑惑，就是为什么要除以2，目前认为是每条边都被记了两次
     * 但是事实上也只记了一次，所以就有疑惑
     * @param G 给定的图
     * @return 返回给定图的自环数量
     */
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v))
                if (v == w)
                    count++;
        }
        return count;
    }
}
