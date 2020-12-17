package com.viewwuyou.test;

import com.viewwuyou.algrothm.Graph.AdjGraph;
import com.viewwuyou.algrothm.Graph.BreadthFirstSearch;
import com.viewwuyou.algrothm.Graph.DepthFirstSearch;

public class DFStest {
    public static void main(String[] args) {
        AdjGraph graph = new AdjGraph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        //System.out.println(graph.E());
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        System.out.println();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, 0);
    }
}
