package problems;

import java.util.*;
import java.util.LinkedList;

public class BinaryTreeRightViewSide {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> returnList = new ArrayList<>();
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        returnList.add(root.val);
        nodeQueue.add(root);
        int previousQueueSize = nodeQueue.size();
        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            if (currentNode.right != null && currentNode.left != null) {
                nodeQueue.add(currentNode.right);
                nodeQueue.add(currentNode.left);
            }
            if (currentNode.right != null && currentNode.left == null) {
                nodeQueue.add(currentNode.right);
                nodeQueue.add(new TreeNode(Integer.MAX_VALUE));
            }
            if (currentNode.left != null && currentNode.right == null) {
                nodeQueue.add(new TreeNode(Integer.MAX_VALUE));
                nodeQueue.add(currentNode.left);
            }
            if (currentNode.left == null && currentNode.right == null) {
                nodeQueue.add(new TreeNode(Integer.MAX_VALUE));
                nodeQueue.add(new TreeNode(Integer.MAX_VALUE));
            }
            if (nodeQueue.size() == previousQueueSize * 2) {
                ListIterator<TreeNode> itr = (ListIterator<TreeNode>) nodeQueue.iterator();
                while (itr.hasNext()) {
                    int i = itr.next().val;
                    if (i != Integer.MAX_VALUE) {
                        returnList.add(i);
                        itr.forEachRemaining((n) -> {
                            n.val = Integer.MAX_VALUE;
                        });
                    }
                }
                int counter = 0;
                for (TreeNode tn : nodeQueue) {
                    if (tn.left == null && tn.right == null && tn.val == Integer.MAX_VALUE) {
                        counter++;
                    }
                }
                if (counter == nodeQueue.size()) {
                    break;
                }
                previousQueueSize = nodeQueue.size();
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
//[1,2,3,null,5,null,4]
//        one.left = two;
//        one.right = three;
//        two.left = null;
//        two.right = five;
//        three.left = null;
//        three.right = four;

        /*
          1
       2    3
      n 5  n 4


         */

//        one.left = two;
//        one.right = three;
//        two.left = null;
//        two.right = four;


        //[4,3,5,2,null,null,null,1]

                /*
          4
       3     5
      2 n   n n
     1n nn nn nn

         */


        four.left = three;
        four.right = five;
        three.left = two;
        three.right = null;
        five.left = null;
        five.right = null;
        two.left = one;

        System.out.println(rightSideView(four));
    }
}
