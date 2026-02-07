import sys
import os
from BinarySearchTree import BinarySearchTree
from Graph import Graph

# Helper to mimic Java Scanner behavior (reading token by token)
class Scanner:
    def __init__(self, input_source, echo=False):
        self.input_source = input_source
        self.tokens = []
        self.echo = echo

    def has_next(self):
        return True

    def next(self):
        while not self.tokens:
            line = self.input_source.readline()
            if not line: # EOF
                return None
            line = line.replace('\ufeff', '')
            self.tokens = line.split()
        
        token = self.tokens.pop(0)
        if self.echo:
            print(token)
        return token
    
    def next_int(self):
        token = self.next()
        if token is None:
            return None
        try:
            return int(token)
        except ValueError:
            print(f"Warning: Expected integer, got '{token}'")
            return None

# Global variables
scanner = None
bst = BinarySearchTree()
graph = Graph()

def main():
    global scanner
    print("Welcome to the Data Structures Assignment Program!")
    
    # Check if stdin is interactive or redirected
    if not sys.stdin.isatty():
        # Redirected input (e.g., python Main.py < input.txt)
        # Automatically enable echo to mimic manual input behavior
        print("Batch mode detected (input redirected). Echo enabled.")
        scanner = Scanner(sys.stdin, echo=True)
    else:
        # Interactive mode
        print("Do you want to use input.txt? (y/n): ", end="", flush=True)
        user_input = sys.stdin.readline().strip().lower()

        if user_input == 'y':
            if os.path.exists("input.txt"):
                print("Using input.txt...")
                scanner = Scanner(open("input.txt", "r"), echo=True)
            else:
                print("input.txt not found. Falling back to manual input.")
                scanner = Scanner(sys.stdin, echo=False)
        else:
            print("Using manual input.")
            scanner = Scanner(sys.stdin, echo=False)

    while True:
        print("\n=== MAIN MENU ===")
        print("1. Binary Search Tree Operations (Part A)")
        print("2. Graph Operations (Part B)")
        print("3. Exit")
        print("Enter your choice: ", end="", flush=True)
        
        choice = scanner.next_int()
        if choice is None:
            break # End of input

        if choice == 1:
            bst_menu()
        elif choice == 2:
            graph_menu()
        elif choice == 3:
            print("Exiting program. Goodbye!")
            break
        else:
            print("Invalid choice. Please try again.")

def bst_menu():
    while True:
        print("\n--- Part A: Binary Search Tree Menu ---")
        print("1. Insert a value")
        print("2. Delete a value")
        print("3. Search for a value")
        print("4. Display traversals (Inorder, Preorder, Postorder)")
        print("5. Display tree properties (Height, Node count, Leaf count)")
        print("6. Find Minimum and Maximum values")
        print("7. Return to Main Menu")
        print("Enter your choice: ", end="", flush=True)

        choice = scanner.next_int()
        if choice is None: return

        if choice == 1:
            print("Enter value to insert: ", end="", flush=True)
            val = scanner.next_int()
            if val is not None:
                bst.insert(val)
                print(f"Value {val} inserted successfully.")
        elif choice == 2:
            print("Enter value to delete: ", end="", flush=True)
            val = scanner.next_int()
            if val is not None:
                bst.delete(val)
                print(f"Deletion operation completed for value {val}.")
        elif choice == 3:
            print("Enter value to search: ", end="", flush=True)
            val = scanner.next_int()
            if val is not None:
                if bst.search(val):
                    print(f"Value {val} found in the tree.")
                else:
                    print(f"Value {val} NOT found in the tree.")
        elif choice == 4:
            print("--- Tree Traversals ---")
            print("Inorder Traversal: " + " ".join(map(str, bst.inorder_traversal())) + " ")
            print("Preorder Traversal: " + " ".join(map(str, bst.preorder_traversal())) + " ")
            print("Postorder Traversal: " + " ".join(map(str, bst.postorder_traversal())) + " ")
        elif choice == 5:
            print("--- Tree Properties ---")
            print(f"Height of the tree: {bst.height()}")
            print(f"Total number of nodes: {bst.node_count()}")
            print(f"Number of leaf nodes: {bst.leaf_count()}")
        elif choice == 6:
            print("--- Min/Max Values ---")
            try:
                mn = bst.find_min()
                mx = bst.find_max()
                if mn is None or mx is None: 
                    print("Error: Tree is empty")
                else:
                    print(f"Minimum value: {mn}")
                    print(f"Maximum value: {mx}")
            except Exception as e:
                print(f"Error: {e}")
        elif choice == 7:
            print("Returning to Main Menu...")
            break
        else:
            print("Invalid choice. Please select 1-7.")

def graph_menu():
    while True:
        print("\n--- Part B: Graph Operations Menu ---")
        print("1. Add Vertex")
        print("2. Add Edge (Directed)")
        print("3. Add Edge (Undirected - for MST)")
        print("4. Display Graph")
        print("5. BFS Traversal")
        print("6. DFS Traversal")
        print("7. Shortest Path (Dijkstra)")
        print("8. Minimum Spanning Tree (Prim)")
        print("9. Return to Main Menu")
        print("Enter your choice: ", end="", flush=True)

        choice = scanner.next_int()
        if choice is None: return

        if choice == 1:
            print("Enter vertex label: ", end="", flush=True)
            label = scanner.next()
            graph.add_vertex(label)
            print(f"Vertex {label} added.")
        elif choice == 2:
            print("Enter source vertex: ", end="", flush=True)
            src = scanner.next()
            print("Enter destination vertex: ", end="", flush=True)
            dest = scanner.next()
            print("Enter weight: ", end="", flush=True)
            weight = scanner.next_int()
            if weight is not None:
                graph.add_edge(src, dest, weight)
                print(f"Directed edge added: {src} -> {dest} ({weight})")
        elif choice == 3:
            print("Enter source vertex: ", end="", flush=True)
            src = scanner.next()
            print("Enter destination vertex: ", end="", flush=True)
            dest = scanner.next()
            print("Enter weight: ", end="", flush=True)
            weight = scanner.next_int()
            if weight is not None:
                graph.add_undirected_edge(src, dest, weight)
                print(f"Undirected edge added between {src} and {dest} with weight {weight}")
        elif choice == 4:
            graph.display()
        elif choice == 5:
            print("Enter start vertex for BFS: ", end="", flush=True)
            start = scanner.next()
            graph.bfs(start)
        elif choice == 6:
            print("Enter start vertex for DFS: ", end="", flush=True)
            start = scanner.next()
            graph.dfs(start)
        elif choice == 7:
            print("Enter start vertex for Dijkstra: ", end="", flush=True)
            start = scanner.next()
            graph.dijkstra(start)
        elif choice == 8:
            graph.prim_mst()
        elif choice == 9:
            print("Returning to Main Menu...")
            break
        else:
            print("Invalid choice. Please select 1-9.")

if __name__ == "__main__":
    main()
