package com.qunar.des.algorithm.leetcode.graph.undirect;

import java.util.*;

/**
 * Created by abin on 2018/6/29.
 * 第一种实现方法是BFS的，就是先将头节点入queue，每一次queue出列一个node，然后检查这个node的所有的neighbors，如果没visited过，就入队，并更新neighbor。
 * 然后更新新的neighbor列表。
 * https://www.cnblogs.com/springfor/p/3874591.html
 * https://leetcode.com/problems/clone-graph/description/
 * https://leetcode.com/problems/clone-graph/discuss/42309/Depth-First-Simple-Java-Solution
 * https://leetcode.com/problems/clone-graph/discuss/42319/Simple-Java-iterative-BFS-solution-with-HashMap-and-queue
 */
public class CloneGraph {
    public static void main(String[] args) {

    }


    public UndirectedGraphNode cloneGraphBfs(UndirectedGraphNode node) {
        if (null == node)
            return null;
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        map.put(result.label, result);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.remove();
            for (int i = 0; i < temp.neighbors.size(); i++) {
                if (!map.containsKey(temp.neighbors.get(i).label)) {
                    map.put(temp.neighbors.get(i).label, new UndirectedGraphNode(temp.neighbors.get(i).label));
                    queue.push(temp.neighbors.get(i));
                }
                map.get(temp.label).neighbors.add(map.get(temp.neighbors.get(i).label));
            }
        }
        return result;
    }

    public UndirectedGraphNode cloneGraphDfs(UndirectedGraphNode node) {
        if (null == node)
            return null;
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        map.put(result.label, result);
        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            UndirectedGraphNode temp = stack.pop();
            for (int i = 0; i < temp.neighbors.size(); i++) {
                if (!map.containsKey(temp.neighbors.get(i).label)) {
                    map.put(temp.neighbors.get(i).label, new UndirectedGraphNode(temp.neighbors.get(i).label));
                    stack.push(temp.neighbors.get(i));
                }
                map.get(temp.label).neighbors.add(map.get(temp.neighbors.get(i).label));
            }
        }
        return result;
    }

    public UndirectedGraphNode cloneGraphDfsRecvrite1(UndirectedGraphNode node) {
        if (null == node)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        cloneDfs(node,  map);
        return map.get(node);
    }

    public void cloneDfs(UndirectedGraphNode node,  Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        map.put(result, result);
        for (UndirectedGraphNode curNode : node.neighbors) {
            if (!map.containsKey(curNode)) {
                cloneDfs(result, map) ;
            }else{
                UndirectedGraphNode copyNode = map.get(curNode);
                result.neighbors.add(map.get(copyNode)) ;
            }
        }
    }

    public UndirectedGraphNode cloneGraphDfsRecvrite2(UndirectedGraphNode node) {
        return clone(node, new HashMap<>());
    }

    UndirectedGraphNode clone(UndirectedGraphNode src, HashMap<UndirectedGraphNode, UndirectedGraphNode> visitedBag){
        if (src == null){
            return null;
        }
        if (visitedBag.containsKey(src)){
            return visitedBag.get(src);
        }

        UndirectedGraphNode result = new UndirectedGraphNode(src.label);
        visitedBag.put(src, result);
        for (UndirectedGraphNode child : src.neighbors){
            if (visitedBag.containsKey(child)){
                result.neighbors.add(visitedBag.get(child));
            } else {
                UndirectedGraphNode childCopy = clone(child, visitedBag);
                result.neighbors.add(childCopy);
            }
        }
        return result;
    }


    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    ;
}
