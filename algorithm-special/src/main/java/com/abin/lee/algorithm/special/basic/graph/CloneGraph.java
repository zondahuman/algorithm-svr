package com.abin.lee.algorithm.special.basic.graph;

import com.google.common.collect.Lists;
import com.qunar.des.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by abin on 2018/6/28.
 * A----B
 * |    |
 * C----D
 */
public class CloneGraph {

    public static void main(String[] args) {
        GraphNode input = new CloneGraph().initGraph();
        GraphNode result = new CloneGraph().cloneSingle(input);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public GraphNode cloneSingle(GraphNode node) {
        GraphNode result = new GraphNode();
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.push(node);
        while (!queue.isEmpty()) {
            GraphNode temp = queue.pop();
            if (temp.label.equals("D")) {
                result.label = new String(temp.label);
                List<GraphNode> list = Lists.newArrayList();
                for (int i = 0; i < temp.neighbors.size(); i++) {
                    GraphNode neiGraph = new GraphNode();
                    neiGraph.label = temp.neighbors.get(i).label;
                    list.add(neiGraph);
                }
                result.neighbors = list;
                return result;
            } else {
                for (int i = 0; i < temp.neighbors.size(); i++) {
                    GraphNode neiGraph = temp.neighbors.get(i);
                    queue.push(neiGraph);
                }
            }
        }
        return null;
    }

    public GraphNode initGraph() {
        String labelA = "A";
        String labelB = "B";
        String labelC = "C";
        String labelD = "D";
        GraphNode nodeA = new GraphNode();
        nodeA.label = labelA;
        GraphNode nodeB = new GraphNode();
        nodeB.label = labelB;
        GraphNode nodeC = new GraphNode();
        nodeC.label = labelC;
        GraphNode nodeD = new GraphNode();
        nodeD.label = labelD;

        List<GraphNode> neighborsA = Lists.newArrayList();
        neighborsA.add(nodeB);
        neighborsA.add(nodeC);
        nodeA.neighbors = neighborsA;

        List<GraphNode> neighborsB = Lists.newArrayList();
        neighborsB.add(nodeA);
        neighborsB.add(nodeD);
        nodeB.neighbors = neighborsB;

        List<GraphNode> neighborsC = Lists.newArrayList();
        neighborsC.add(nodeA);
        neighborsC.add(nodeD);
        nodeC.neighbors = neighborsC;

        List<GraphNode> neighborsD = Lists.newArrayList();
        neighborsD.add(nodeB);
        neighborsD.add(nodeC);
        nodeD.neighbors = neighborsD;

        return nodeA;
    }

    @Setter
    @Getter
    public static class GraphNode {
        private String label;
        private List<GraphNode> neighbors;

    }
}


