//package com.company;
//
//import sun.jvm.hotspot.code.ConstantOopReadValue;
//
//import java.util.*;
//
//public class Solution {
//
//    public static int removeObstacle(int numRows, int numColumns, List<List<Integer>> maze) {
//
//        int V = numColumns * numRows;
//        int source = 0;
//
//        // Adjacency list representation of the
//        // connected edges
//        List<List<Node>> adj = new ArrayList<List<Node>>();
//
//        // Initialize list for every node
//        for (int i = 0; i < numRows; i++) {
//            List<Node> item = new ArrayList<Node>();
//            adj.add(item);
//        }
//
//        Node end = null;
//
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < numColumns; j++) {
//                adj.get(i).add(new Node(i, j));
//            }
//        }
//
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < numColumns; j++) {
//                if (maze.get(i).get(j).equals(9)) {
//                    end = new Node(i, j);
//                }
//            }
//        }
//
//        // Calculate the single source shortest path
//        Solution dpq = new Solution(numRows);
//        dpq.dijkstra(adj, source);
//
//        // Print the shortest path to all the nodes
//        // from the source node
//        System.out.println("The shorted path from node :");
//        for (int i = 0; i < dpq.dist.length; i++) {
//            return dpq.dist[i];
//        }
//        return -1;
//    }
//
//
//    // Class to represent a node in the graph
//    class Node implements Comparator<Node> {
//        public int node;
//        public int cost;
//
//        public Node() {
//        }
//
//        public Node(int node, int cost) {
//            this.node = node;
//            this.cost = cost;
//        }
//
//        @Override
//        public int compare(Node node1, Node node2) {
//            if (node1.cost < node2.cost)
//                return -1;
//            if (node1.cost > node2.cost)
//                return 1;
//            return 0;
//        }
//    }
//
//    private int dist[];
//    private Set<Integer> settled;
//    private PriorityQueue<Node> pq;
//    private int V; // Number of vertices
//    List<List<Node>> adj;
//
//    public Solution(int V) {
//        this.V = V;
//        dist = new int[V];
//        settled = new HashSet<Integer>();
//        pq = new PriorityQueue<Node>(V, new Node());
//    }
//
//    // Function for Dijkstra's Algorithm
//    public void dijkstra(List<List<Node>> adj, int src) {
//        this.adj = adj;
//
//        for (int i = 0; i < V; i++)
//            dist[i] = Integer.MAX_VALUE;
//
//        // Add source node to the priority queue
//        pq.add(new Node(src, 0));
//
//        // Distance to the source is 0
//        dist[src] = 0;
//        while (settled.size() != V) {
//
//            // remove the minimum distance node
//            // from the priority queue
//            int u = pq.remove().node;
//
//            // adding the node whose distance is
//            // finalized
//            settled.add(u);
//
//            e_Neighbours(u);
//        }
//    }
//
//    // Function to process all the neighbours
//    // of the passed node
//    private void e_Neighbours(int u) {
//        int edgeDistance = -1;
//        int newDistance = -1;
//
//        // All the neighbors of v
//        for (int i = 0; i < adj.get(u).size(); i++) {
//            Node v = adj.get(u).get(i);
//
//            // If current node hasn't already been processed
//            if (!settled.contains(v.node)) {
//                edgeDistance = v.cost;
//                newDistance = dist[u] + edgeDistance;
//
//                // If new distance is cheaper in cost
//                if (newDistance < dist[v.node])
//                    dist[v.node] = newDistance;
//
//                // Add the current node to the queue
//                pq.add(new Node(v.node, dist[v.node]));
//            }
//        }
//    }
//
//    public static void main(String arg[])
//    {
//        System.out.println(removeObstacle());
//    }
//}
//
