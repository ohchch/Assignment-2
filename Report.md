# Assignment 2: Trees and Graphs Implementation Report

**Name:** [Your Name]
**Student ID:** [Your ID]
**Date:** [Current Date]

---

## 1. Introduction

This assignment focuses on the implementation and application of two fundamental data structures: Binary Search Trees (BST) and Graphs. The objective is to understand their core operations, traversal mechanisms, and associated algorithms such as Dijkstra's Shortest Path and Prim's Minimum Spanning Tree (MST). This report documents the design, implementation, and testing of these structures using Java.

## 2. Explanation of BST Implementation

### Core Operations
The Binary Search Tree is implemented in the `BinarySearchTree.java` class. It uses an inner `Node` class to store integer values and references to left and right children.

*   **Insertion**: Implemented recursively. New values smaller than the current node go left; larger values go right.
*   **Search**: Also recursive. It traverses down the tree comparing values until the target is found or a null leaf is reached.
*   **Deletion**: Handles three cases: deleting a leaf node, a node with one child, and a node with two children (using the inorder successor replacement strategy).

### Traversals
Three depth-first traversal methods were implemented recursively:
*   **Inorder**: Left -> Root -> Right (Produces sorted output)
*   **Preorder**: Root -> Left -> Right
*   **Postorder**: Left -> Right -> Root

### Properties
Helper methods calculate the tree's characteristics:
*   **Height**: The number of edges on the longest path from root to leaf.
*   **Total Nodes**: A count of all nodes in the tree.
*   **Leaf Nodes**: A count of nodes with no children.

## 3. Explanation of Graph Implementation

### Graph Representation
The Graph is implemented in `Graph.java` using an **Adjacency List**. 
*   A `Map<String, List<Edge>>` is used to store vertices and their connections.
*   An inner `Edge` class stores the destination vertex and the weight of the edge.
*   This representation is space-efficient for sparse graphs and allows for O(1) access to a vertex's neighbors.

### Graph Traversals
*   **BFS (Breadth-First Search)**: Implemented using a `Queue`. It explores neighbor nodes first before moving to the next level neighbors.
*   **DFS (Depth-First Search)**: Implemented using recursion (System Stack). It explores as far as possible along each branch before backtracking.

### Algorithms
*   **Dijkstra's Algorithm**: Finds the shortest path from a source vertex to all others. It uses a `PriorityQueue` to greedily select the unvisited vertex with the smallest known distance.
*   **Prim's Algorithm**: Constructs a Minimum Spanning Tree (MST). It also uses a `PriorityQueue` to select the minimum weight edge that connects a vertex in the MST to one outside of it.

## 4. Program Output Screenshots

> **Note**: Please run the program `Main.java` and take screenshots of the console output for the following scenarios. Insert your images below.

### 4.1 BST Operations
*(Insert screenshot of inserting values, searching, and deleting)*

### 4.2 BST Traversals & Properties
*(Insert screenshot of Inorder, Preorder, Postorder traversals and tree properties)*

### 4.3 Graph Traversals (BFS & DFS)
*(Insert screenshot of adding vertices/edges and running BFS/DFS)*

### 4.4 Shortest Path & MST
*(Insert screenshot of Dijkstra's algorithm output and Prim's MST output)*

## 5. Conclusion

Through this assignment, I have successfully implemented a functional Binary Search Tree and a weighted Graph in Java. The BST implementation demonstrated the efficiency of recursive logic for hierarchical data. The Graph implementation highlighted the importance of adjacency lists for representing connections and the power of greedy algorithms like Dijkstra and Prim for solving optimization problems. This project reinforced my understanding of how data structures are designed and how algorithms manipulate them to solve complex problems.
