//package com.company;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//}
//
//public class PopulatingNextRightPointersInEachNode {
//
//    public static Node connect(Node root) {
//        if (root == null) {
//            return null;
//        }
//        Queue<Node> nodeQueue = new LinkedList<>();
//        nodeQueue.add(root);
//        int previousQueueSize = nodeQueue.size();
//        while (!nodeQueue.isEmpty()) {
//            Node currentNode = nodeQueue.poll();
//            if (currentNode.left != null && currentNode.right != null) {
//                currentNode.left.next = currentNode.right;
//                nodeQueue.add(currentNode.left);
//                nodeQueue.add(currentNode.right);
//                if (nodeQueue.size() != previousQueueSize*2 && nodeQueue.peek() != null) {
//                    currentNode.right.next = nodeQueue.peek().left;
//                }
//            } else {
//                if (currentNode.next == null) {
//                    currentNode.next = nodeQueue.peek();
//                }
//            }
//            if (nodeQueue.size() == previousQueueSize*2) {
//                previousQueueSize = nodeQueue.size();
//            }
//        }
//        return root;
//    }
//
//    public static void main(String[] args) {
//        Node ze = new Node(29, null, null, null);
//        Node zd = new Node(14, null, null, null);
//        Node zc = new Node(40, null, null, null);
//        Node zb = new Node(38, null, null, null);
//        Node za = new Node(28, null, null, null);
//        Node z = new Node(15, null, null, null);
//        Node y = new Node(26, null, null, null);
//        Node x = new Node(15, null, null, null);
//        Node w = new Node(9, null, null, null);
//        Node v = new Node(27, null, null, null);
//        Node u = new Node(47, null, null, null);
//        Node t = new Node(31, null, null, null);
//        Node s = new Node(34, null, null, null);
//        Node r = new Node(16, null, null, null);
//        Node q = new Node(14, null, null, null);
//        Node p = new Node(42, null, null, null);
//        Node o = new Node(25, zd, ze, null);
//        Node n = new Node(6, zb, zc, null);
//        Node m = new Node(29, z, za, null);
//        Node l = new Node(2, x, y, null);
//        Node k = new Node(29, v, w, null);
//        Node j = new Node(29, t, u, null);
//        Node i = new Node(27, r, s, null);
//        Node h = new Node(15, p, q, null);
//        Node g = new Node(50, n, o, null);
//        Node f = new Node(19, l, m, null);
//        Node e = new Node(23, j, k, null);
//        Node d = new Node(16, h, i, null);
//        Node c = new Node(18, f, g, null);
//        Node b = new Node(30, d, e, null);
//        Node a = new Node(26, b, c, null);
//
//        System.out.println(connect(a));
//    }
//}
