package algorithms;

public class BinarySearchTree {
    Node root;

    private static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public boolean search(int value) {
        Node pointer = this.root;
        if (this.root == null) {
            return false;
        } else {
            while (pointer != null) {
                if (value < pointer.value) {
                    pointer = pointer.left;
                } else if (value > pointer.value) {
                    pointer = pointer.right;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public void insert(int value) {
        Node newNode = new Node(value, null, null);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node pointer = this.root;
            while (true) {
                if (newNode.value < pointer.value) {
                    if (pointer.left == null) {
                        pointer.left = newNode;
                        return;
                    }
                    pointer = pointer.left;
                } else {
                    if (pointer.right == null) {
                        pointer.right = newNode;
                        return;
                    }
                    pointer = pointer.right;
                }
            }
        }
    }

    public boolean delete(int value) {
        Node deleteNode = this.root;
        Node parent = null;
        if (this.root == null) {
            return false;
        } else {
            while (deleteNode != null) {
                if (value < deleteNode.value) {
                    parent = deleteNode;
                    deleteNode = deleteNode.left;
                } else if (value > deleteNode.value) {
                    parent = deleteNode;
                    deleteNode = deleteNode.right;
                } else {
                    //we found it, now to rotate shit
                    if (deleteNode.left == null && deleteNode.right == null) {
                        deleteNode = null;
                    } else if (deleteNode.left == null) {
                        parent.right = deleteNode.right;
                    } else if (deleteNode.right == null) {
                        parent.left = deleteNode.left;
                    } else {
                        deleteNode.right.left = deleteNode.left;
                    }
                }
            }
        }
        return true;
        /*
        to remove, you go to the right of node, traverse to its left leaf, and set this

        node's right to the deleted nodes right, and its left to the leaf's parent
         */

    }


//
//    public List<Integer> preOrderTraversal(Node root, List<Integer> traversal) {
//
//    }
//
//    public List<Integer> postOrderTraversal(Node root, List<Integer> traversal) {
//
//    }
//
//    public List<Integer> inOrderTraversal(Node root, List<Integer> traversal) {
//
//    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree(null);

        binarySearchTree.insert(9);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(20);
        binarySearchTree.insert(170);
        binarySearchTree.insert(15);
        binarySearchTree.insert(1);

        System.out.println(binarySearchTree.search(6));
        System.out.println(binarySearchTree.search(10));
        System.out.println(binarySearchTree.search(15));


//        System.out.println(binarySearchTree.preOrderTraversal());
//        System.out.println(binarySearchTree.postOrderTraversal());
//        System.out.println(binarySearchTree.inOrderTraversal());

    }
}
