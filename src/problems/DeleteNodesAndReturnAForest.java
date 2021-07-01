package problems;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnAForest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        if (traverse(forest, to_delete, root) != null) {
            forest.add(traverse(forest, to_delete, root));
        }

        return prune(forest, to_delete);
    }

    public static TreeNode traverse(List<TreeNode> forest, int[] to_delete, TreeNode workingRoot) {

        if (workingRoot == null) {
            return null;
        }

        for (int nodeValue : to_delete) {
            if (workingRoot.left != null && workingRoot.left.val == nodeValue) {
                TreeNode disjointLeftSubTree = workingRoot.left;
                workingRoot.left = null;
                add(forest, to_delete, workingRoot, disjointLeftSubTree);
            }
            if (workingRoot.right != null && workingRoot.right.val == nodeValue) {
                TreeNode disjointRightSubTree = workingRoot.right;
                workingRoot.right = null;
                add(forest, to_delete, workingRoot, disjointRightSubTree);
            }
        }

        traverse(forest, to_delete, workingRoot.left);
        traverse(forest, to_delete, workingRoot.right);

        return workingRoot;
    }

    private static void add(List<TreeNode> forest, int[] to_delete, TreeNode workingRoot, TreeNode disjointRightSubTree) {
        if (traverse(forest, to_delete, disjointRightSubTree.left) != null) {
            forest.add(traverse(forest, to_delete, disjointRightSubTree.left));
        }
        if (traverse(forest, to_delete, disjointRightSubTree.right) != null) {
            forest.add(traverse(forest, to_delete, disjointRightSubTree.right));
        }
        traverse(forest, to_delete, workingRoot);
    }

    public static List<TreeNode> prune(List<TreeNode> forest, int[] to_delete) {

        for (int i = 0; i < forest.size(); i++) {
            if (i >= 0) {
                for (int nodeValue : to_delete) {
                    if (i >= 0) {
                        if (forest.get(i).val == nodeValue) {
                            if (forest.get(i).left != null && forest.get(i).right != null) {
                                forest.add(forest.get(i).left);
                                forest.add(forest.get(i).right);
                                forest.remove(forest.get(i));
                                i--;
                            } else if (forest.get(i).left != null) {
                                forest.add(forest.get(i).left);
                                forest.remove(forest.get(i));
                                i--;
                            } else if (forest.get(i).right != null) {
                                forest.add(forest.get(i).right);
                                forest.remove(forest.get(i));
                                i--;
                            } else {
                                forest.remove(forest.get(i));
                                i--;
                            }
                        }
                    }
                }
            }
        }
        return forest;
    }

    public static void main(String[] args) {

        /*
        Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
        Output: [[1,2,null,4],[6],[7]]
         */

        /*
        Input
        [1,null,2,null,3,null,4]
        [3]
        Output
        [[1,null,2,null,3,null,4]]
        Expected
        [[1,null,2],[4]]

        Input
        [1,2,null,4,3]
        [2,3]
        Output
        [[4],[3],[1]]
        Expected
        [[1],[4]]


        Input
        [1,2,3,null,null,null,4]
        [2,1]
        Output
        [[]]
        Expected
        [[3,null,4]]


        [1,5,2,null,null,null,3,4]
        [1,5]

        Input
        [1,3,2,null,null,5,4,6,8,null,null,7]
        [8,1,6]
        Output
        [[7],[2,5,4]]
        Expected
        [[3],[2,5,4],[7]]
         */

//        TreeNode root = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        TreeNode five = new TreeNode(5);
//        TreeNode six = new TreeNode(6);
//        TreeNode seven = new TreeNode(7);
//        TreeNode eight = new TreeNode(8);
//
//        root.left = three;
//        root.right = two;
//        two.right = five;
//        two.left = four;
//        five.left = six;
//        five.right = eight;
//        six.left = seven;
//
//        int[] to_delete = {8, 1, 6};

//        TreeNode root = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        TreeNode five = new TreeNode(5);
//
//
//        root.left = five;
//        root.right = two;
//        two.left = three;
//        three.right = four;
//
//        int[] to_delete = {1, 5};

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        root.left = two;
        root.right = three;
        three.right = four;

        int[] to_delete = {2, 1};

        /*
        Input
        [1,null,2,3,5,null,4,null,null,null,6]
        [5,1,2]
        Output
        [[3,null,4,null,6],[1]]
        Expected
        [[3,null,4,null,6]]
         */

//        TreeNode root = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        TreeNode five = new TreeNode(5);
//        TreeNode six = new TreeNode(6);
//
//
//        root.right = two;
//        two.left = three;
//        two.right = five;
//        three.right = four;
//        four.left = six;
//
//        int[] to_delete = {5, 1, 2};

//        TreeNode root = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//
//        root.left = two;
//        two.left = four;
//        two.right = three;
//
//        int[] to_delete = {2, 3};
//
//        TreeNode root = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//
//        root.right = two;
//        two.right = three;
//        three.right = four;
//
//        int[] to_delete = {3};

//        TreeNode root = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        TreeNode five = new TreeNode(5);
//        TreeNode six = new TreeNode(6);
//        TreeNode seven = new TreeNode(7);
//
//        root.left = two;
//        root.right = three;
//        two.left = four;
//        two.right = five;
//        three.left = six;
//        three.right = seven;
//
//        int[] to_delete = {3, 5};

        System.out.println(delNodes(root, to_delete));
    }
}



/*
class Solution {
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        if (traverse(forest, to_delete, root) != null) {
            forest.add(traverse(forest, to_delete, root));
        }
        return forest;
    }

    public static TreeNode traverse(List<TreeNode> forest, int[] to_delete, TreeNode workingRoot) {
        if (workingRoot != null) {
            for (int nodeValue : to_delete) {
                if (workingRoot.left != null) {
                    if (workingRoot.left.val == nodeValue) {
                        TreeNode temp = workingRoot.left;
                        workingRoot.left = null;
                        if (traverse(forest, to_delete, temp.left) != null) {
                            forest.add(traverse(forest, to_delete, temp.left));
                        }
                        if (traverse(forest, to_delete, temp.right) != null) {
                            forest.add(traverse(forest, to_delete, temp.right));
                        }
                    }
                }
                if (workingRoot.right != null) {
                    if (workingRoot.right.val == nodeValue) {
                        TreeNode temp = workingRoot.right;
                        workingRoot.right = null;
                        if (traverse(forest, to_delete, temp.left) != null) {
                            forest.add(traverse(forest, to_delete, temp.left));
                        }
                        if (traverse(forest, to_delete, temp.right) != null) {
                            forest.add(traverse(forest, to_delete, temp.right));
                        }
                    }
                }
                traverse(forest, to_delete, workingRoot.left);
                traverse(forest, to_delete, workingRoot.right);
                if (workingRoot.val == nodeValue) {
                    TreeNode temp = workingRoot;
                    workingRoot = null;
                    if (traverse(forest, to_delete, temp.left) != null) {
                        forest.add(traverse(forest, to_delete, temp.left));
                    }
                    if (traverse(forest, to_delete, temp.right) != null) {
                        forest.add(traverse(forest, to_delete, temp.right));
                    }
                }
            }
            return workingRoot;
        }
        return null;
    }
}
 */
