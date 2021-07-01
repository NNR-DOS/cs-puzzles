package problems;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
        preorder: [1,2,4,3,5,7,8,6]
        inorder: [4,2,1,7,5,8,3,6]

             1
           /   \
          2     3
         /     / \
        4     5   6
             / \
            7   8


        preorder: [1,3,5,7,8,6]
        inorder: [1,7,5,8,3,6]

             1
               \
                3
               / \
              5   6
             / \
            7   8
     */


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return backtrack(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode backtrack(int currentPreorderFirstIndex, int currentInorderFirstIndex, int currentInorderFinalIndex, int[] preorder, int[] inorder) {

        if (currentInorderFirstIndex > currentInorderFinalIndex || currentPreorderFirstIndex > preorder.length-1) {
            return null;
        }

        TreeNode workingRoot = new TreeNode(preorder[currentPreorderFirstIndex]);
        int pivot = 0;

        for (int i = currentInorderFirstIndex; i <= currentInorderFinalIndex; i++) {
            if (inorder[i] == workingRoot.val) {
                pivot = i;
            }
        }

        int leftSubTreeDistance = (pivot - currentInorderFirstIndex + 1);

        workingRoot.left = backtrack(currentPreorderFirstIndex + 1, currentInorderFirstIndex, pivot - 1, preorder, inorder);
        workingRoot.right = backtrack(currentPreorderFirstIndex + leftSubTreeDistance, pivot + 1, currentInorderFinalIndex, preorder, inorder);
        return workingRoot;
    }

    public static void main(String[] args) {

        /*
        preorder: [1,2,4,3,5,7,8,6]
        inorder: [4,2,1,7,5,8,3,6]

             1
           /   \
          2     3
         /     / \
        4     5   6
             / \
            7   8

        preorder = [3,9,20,15,7]
        inorder = [9,3,15,20,7]
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

        int[] preorder = {1,2,4,3,5,7,8,6};
        int[] inorder = {4,2,1,7,5,8,3,6};

        System.out.println(buildTree(preorder, inorder));
    }
}
