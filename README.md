# Data Structures and Algorithms Assignment 2

## Introduction
This project contains the implementation of fundamental data structures and algorithms for Assignment 2. It is capable of handling complex data operations through a menu-driven interface.

The project is divided into two main parts:
- **Part A**: Binary Search Tree (BST) implementation.
- **Part B**: Graph data structure implementation (Weighted & Directed/Undirected).

## Project Structure

- `src/`
  - `Main.java`: The main entry point containing the interactive menu system.
  - `BinarySearchTree.java`: Implementation of BST logic.
  - `Graph.java`: Implementation of Graph logic including traversals and advanced algorithms.
- `input.txt`: A sequence of predefined inputs for automated testing.
- `Assignment.md`: The original assignment requirements.

## Features

### Part A: Binary Search Tree (BST)
- **Core Operations**: 
  - Insert a value
  - Delete a value
  - Search for a value
- **Traversals**: 
  - Inorder, Preorder, and Postorder display.
- **Properties**: 
  - Calculate Tree Height
  - Count Total Nodes
  - Count Leaf Nodes
- **Utilities**: 
  - Find Minimum and Maximum values.

### Part B: Graph Operations
- **Representation**: 
  - Add Vertices
  - Add Directed Edges
  - Add Undirected Edges (specifically for MST)
- **Traversals**: 
  - Breadth-First Search (BFS)
  - Depth-First Search (DFS)
- **Algorithms**: 
  - **Dijkstra's Algorithm**: For finding the shortest path from a source node.
  - **Prim's Algorithm**: For finding the Minimum Spanning Tree (MST).

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher.

### Compilation
Open a terminal/command prompt in the project root directory and execute:

```bash
# Create a directory for compiled classes (optional but recommended)
mkdir bin

# Compile the source code
javac -d bin src/*.java
```

### Running the Program (Interactive Mode)
To run the program manually and interact with the menu:

```bash
java -cp bin Main
```

### Running Automated Tests
An `input.txt` file is provided to automatically demonstrate all features without manual typing. To use it:

**Windows (Command Prompt / PowerShell):**
```powershell
java -cp bin Main < input.txt
```

**Linux / macOS:**
```bash
java -cp bin Main < input.txt
```

This command will feed the inputs from `input.txt` into the program, executing a full test suite of BST and Graph operations.

## Assignment Checklist

| Component | Status |
|-----------|:------:|
| **Part A: BST** ||
| Core Operations (Insert, Search, Delete, Min/Max) | ✅ |
| Traversals (Inorder, Preorder, Postorder) | ✅ |
| Properties (Height, Node counts) | ✅ |
| **Part B: Graph** ||
| Representation (Add Vertex/Edge) | ✅ |
| Traversals (BFS & DFS) | ✅ |
| Shortest Path (Dijkstra) | ✅ |
| Minimum Spanning Tree (Prim) | ✅ |
