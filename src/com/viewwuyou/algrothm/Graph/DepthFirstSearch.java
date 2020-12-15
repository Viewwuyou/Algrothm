package com.viewwuyou.algrothm.Graph;

import java.util.Iterator;

public class DepthFirstSearch {

    private final boolean[] marked;

    public DepthFirstSearch(AdjGraph G, int s){
        marked = new boolean[G.V()];
        System.out.println("Start to search......");
        dfs(G, s);
    }

    /**
     * 深度优先搜索的实现
     * 本质上来说，深度优先搜索应该维护一个栈
     * 栈用入和出表示遍历的顺序
     * 比如当我遍历第一个节点的时候我将该节点入栈并标记，到第二个节点的时候将第二个节点入栈并标记
     * 但是第二个节点有三个分叉点，分别指向第一个节点，第三个节点，第四个节点
     * 此时遍历第一个节点，但是已经标记因此跳过，便利第三个节点，将第三个节点入栈并标记，第三个节点有两个指向，一个指向第二节点，一个指向第一节点
     * 因此都跳过，此时认为深度达到了最深，因此第三个节点出栈，再次回到第二个节点，如此反复
     * 其实这有一个实现方法，就是用一个栈来保存每一次调用和遍历的顺序，但是事实上我们必须记住另一件事
     * 程序的递归调用实际上就是一个栈调用，递归在某种程度上实现了一个栈结构的存储，并且递归能够很好的保存之前调用的状态，使得在刚才的例子中
     * 当第三个节点调用结束回到第二个节点时无需从第一个节点重新遍历起来
     * 因此这里考虑直接使用递归，而不是自己实现一个栈结构
     * @param G 给定的图
     * @param v 给定的开始节点
     */
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
