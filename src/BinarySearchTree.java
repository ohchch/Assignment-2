// Implements the Binary Search Tree data structure
public class BinarySearchTree {

    // Inner class to represent a node in the BST
    private static class Node {
        int value;
        Node left;
        Node right;

        // Constructor to create a new node
        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // --- Task A1: BST Core Operations ---

    // Inserts a value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // A recursive function to insert a new value in BST
    private Node insertRec(Node current, int value) {
        // If the tree is empty, return a new node
        if (current == null) {
            return new Node(value);
        }

        // Otherwise, recur down the tree
        if (value < current.value) {
            current.left = insertRec(current.left, value);
        } else if (value > current.value) {
            current.right = insertRec(current.right, value);
        }

        // return the (unchanged) node pointer
        return current;
    }

    // Searches for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    // A recursive function to search for a value in BST
    private boolean searchRec(Node current, int value) {
        // Base case: root is null or value is present at root
        if (current == null) {
            return false;
        }
        if (current.value == value) {
            return true;
        }

        // Value is greater than root's value
        if (value < current.value) {
            return searchRec(current.left, value);
        }

        // Value is less than root's value
        return searchRec(current.right, value);
    }

    // Deletes a value from the BST
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    // A recursive function to delete a value in BST
    private Node deleteRec(Node root, int value) {
        // Base Case: If the tree is empty
        if (root == null) {
            return root;
        }

        // Otherwise, recur down the tree
        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    // Finds the minimum value in the BST
    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    // Finds the maximum value in the BST
    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    // --- Task A2: Tree Traversal ---

    // Displays the inorder traversal of the BST
    public void printInorder() {
        System.out.print("Inorder Traversal: ");
        printInorderRec(root);
        System.out.println();
    }

    private void printInorderRec(Node node) {
        if (node != null) {
            printInorderRec(node.left);
            System.out.print(node.value + " ");
            printInorderRec(node.right);
        }
    }

    // Displays the preorder traversal of the BST
    public void printPreorder() {
        System.out.print("Preorder Traversal: ");
        printPreorderRec(root);
        System.out.println();
    }

    private void printPreorderRec(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPreorderRec(node.left);
            printPreorderRec(node.right);
        }
    }

    // Displays the postorder traversal of the BST
    public void printPostorder() {
        System.out.print("Postorder Traversal: ");
        printPostorderRec(root);
        System.out.println();
    }

    private void printPostorderRec(Node node) {
        if (node != null) {
            printPostorderRec(node.left);
            printPostorderRec(node.right);
            System.out.print(node.value + " ");
        }
    }

    // --- Task A3: Tree Properties ---

    // Calculates the height of the tree
    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) {
            return -1; // Height of empty tree is -1 (or 0 depending on convention, using -1 for edge-count definition)
        }
        int leftHeight = getHeightRec(node.left);
        int rightHeight = getHeightRec(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Counts the total number of nodes in the tree
    public int getTotalNodes() {
        return getTotalNodesRec(root);
    }

    private int getTotalNodesRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getTotalNodesRec(node.left) + getTotalNodesRec(node.right);
    }

    // Counts the number of leaf nodes in the tree
    public int getLeafNodes() {
        return getLeafNodesRec(root);
    }

    private int getLeafNodesRec(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return getLeafNodesRec(node.left) + getLeafNodesRec(node.right);
    }
}
