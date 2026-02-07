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

> **Note**: Please run the program `Main.java` and take screenshots of the console output for the following scenarios. Ensure the output clearly demonstrates the correctness of the operations.

### 4.1 BST: Basic Operations (Insert, Search, Delete)
**Scenario Description:**
1.  **Insertion**: Insert a series of values (e.g., 50, 30, 20, 40, 70, 60, 80) to build the tree.
2.  **Search**: Search for an existing value (e.g., 60) and a non-existing value (e.g., 90).
3.  **Deletion**: Delete a node (e.g., a leaf node like 20 or a node with two children like 50).

**Screenshots:**

*(Paste screenshot of Insertion & Search results here)*

<br>

*(Paste screenshot of Deletion confirmation here)*

### 4.2 BST: Traversals & Properties
**Scenario Description:**
1.  **Traversals**: Display Inorder (should be sorted), Preorder, and Postorder sequences.
2.  **Properties**: Show the Tree Height, Total Node Count, and Leaf Node Count.
3.  **Min/Max**: Display the minimum and maximum values in the tree.

**Screenshots:**

*(Paste screenshot of Tree Traversals output here)*

<br>

*(Paste screenshot of Tree Properties and Min/Max values here)*

### 4.3 Graph: Construction & Traversals (BFS/DFS)
**Scenario Description:**
1.  **Setup**: Add vertices (e.g., A, B, C, D, E) and add directed edges between them.
2.  **Display**: Show the adjacency list representation of the graph.
3.  **BFS**: Run Breadth-First Search starting from a specific node (e.g., 'A').
4.  **DFS**: Run Depth-First Search starting from a specific node (e.g., 'A').

**Screenshots:**

*(Paste screenshot of Adding Vertices/Edges and Graph Display here)*

<br>

*(Paste screenshot of BFS and DFS results here)*

### 4.4 Graph: Advanced Algorithms (Dijkstra & Prim)
**Scenario Description:**
1.  **Dijkstra's Algorithm**: Calculate shortest paths from a source node to all other nodes.
2.  **Prim's MST**: Calculate the Minimum Spanning Tree (ensure undirected edges are added if required by the test case).

**Screenshots:**

*(Paste screenshot of Dijkstra's Shortest Path output here)*

<br>

*(Paste screenshot of Prim's MST output here)*

## 5. Conclusion

Through this assignment, I have successfully implemented a functional Binary Search Tree and a weighted Graph in Java. The BST implementation demonstrated the efficiency of recursive logic for hierarchical data. The Graph implementation highlighted the importance of adjacency lists for representing connections and the power of greedy algorithms like Dijkstra and Prim for solving optimization problems. This project reinforced my understanding of how data structures are designed and how algorithms manipulate them to solve complex problems.
