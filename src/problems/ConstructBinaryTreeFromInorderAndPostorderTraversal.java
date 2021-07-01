package problems;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 && postorder.length == 0) {
            return null;
        }
        return backtrack(0, inorder.length - 1, 0, postorder.length - 1, postorder, inorder);
    }

    public static TreeNode backtrack(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd, int[] postorder, int[] inorder) {

        if (postorderEnd < 0 || inorderStart > inorderEnd) {
            return null;
        }

        TreeNode workingRoot = new TreeNode(postorder[postorderEnd]);
        int pivot = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == workingRoot.val) {
                pivot = i;
            }
        }

        if (inorderStart == inorderEnd) {
            return  workingRoot;
        }

        int nextLeftSubtreeInorderStart = inorderStart;
        int nextLeftSubtreeInorderEnd = pivot - 1;
        int nextLeftSubtreePostorderStart = postorderStart;
        int nextLeftSubtreePostorderEnd = ((postorderStart + pivot) - (inorderStart + 1));

        int nextRightSubtreeInorderStart = pivot + 1;
        int nextRightSubtreeInorderEnd = inorderEnd;
        int nextRightSubtreePostorderStart = (postorderStart + (pivot - inorderStart));
        int nextRightSubtreePostorderEnd = postorderEnd - 1;


        workingRoot.left = backtrack(nextLeftSubtreeInorderStart, nextLeftSubtreeInorderEnd, nextLeftSubtreePostorderStart, nextLeftSubtreePostorderEnd, postorder, inorder);
        workingRoot.right = backtrack(nextRightSubtreeInorderStart, nextRightSubtreeInorderEnd, nextRightSubtreePostorderStart, nextRightSubtreePostorderEnd, postorder, inorder);

        return workingRoot;
    }

    public static void main(String[] args) {

        /*
        inorder =   [9,3,15,20,7]
        postorder = [9,15,7,20,3]

        int[] inOrder =   { 4, 2, 5, 1, 6, 3, 7 };
        int[] postOrder = { 4, 5, 2, 6, 7, 3, 1 };.



        inorder =   [9,3,15,20,7]
        postorder = [9,15,7,20,3]


        Return the following binary tree:

            3
           / \
          9  20
            /  \
           15   7


           find value of preorder's first index in inorder's and its previous index is the left

           if inorder index == preorderFirstIndex

           for(starting at that index--) root.left = newTreeNode = value, its left = value etc

         */

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

//        int[] inorder = {3, 2, 1};
//        int[] postorder = {3, 2, 1};

//        int[] inorder = {2, 3, 1};
//        int[] postorder = {3, 2, 1};

//        int[] inorder = {1, 3, 2};
//        int[] postorder = {3, 2, 1};

        /*
            [1,2,null,null,3]
         */

        System.out.println(buildTree(inorder, postorder));
    }

}
