import sys
from BinarySearchTree import BinarySearchTree
from Graph import Graph

# Helper to mimic Java Scanner behavior (reading token by token)
class Scanner:
    def __init__(self, input_source):
        self.tokens = input_source.read().split()
        self.iterator = iter(self.tokens)

    def has_next(self):
        # Simplification: if iterator is not exhausted
        # In Python iterators don't easily peek, but we can catch StopIteration
        pass 

    def next(self):
        try:
            return next(self.iterator)
        except StopIteration:
            return None
    
    def next_int(self):
        token = self.next()
        if token is None:
            return None
        return int(token)

scanner = Scanner(sys.stdin)
bst = BinarySearchTree()
graph = Graph()

def main():
    print("Welcome to the Data Structures Assignment Program!")
    
    while True:
        print("\n=== MAIN MENU ===")
        print("1. Binary Search Tree Operations (Part A)")
        print("2. Graph Operations (Part B)")
        print("3. Exit")
        print("Enter your choice: ", end="")
        
        # Simulate input echo if needed, but standard print is fine
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
        print("Enter your choice: ", end="")

        choice = scanner.next_int()
        if choice is None: return

        if choice == 1:
            print("Enter value to insert: ", end="")
            val = scanner.next_int()
            bst.insert(val)
            print(f"Value {val} inserted successfully.")
        elif choice == 2:
            print("Enter value to delete: ", end="")
            val = scanner.next_int()
            bst.delete(val)
            print(f"Deletion operation completed for value {val}.")
        elif choice == 3:
            print("Enter value to search: ", end="")
            val = scanner.next_int()
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
        print("Enter your choice: ", end="")

        choice = scanner.next_int()
        if choice is None: return

        if choice == 1:
            print("Enter vertex label: ", end="")
            label = scanner.next()
            graph.add_vertex(label)
            print(f"Vertex {label} added.")
        elif choice == 2:
            print("Enter source vertex: ", end="")
            src = scanner.next()
            print("Enter destination vertex: ", end="")
            dest = scanner.next()
            print("Enter weight: ", end="")
            weight = scanner.next_int()
            graph.add_edge(src, dest, weight)
            print(f"Directed edge added: {src} -> {dest} ({weight})")
        elif choice == 3:
            print("Enter source vertex: ", end="")
            src = scanner.next()
            print("Enter destination vertex: ", end="")
            dest = scanner.next()
            print("Enter weight: ", end="")
            weight = scanner.next_int()
            graph.add_undirected_edge(src, dest, weight)
            print(f"Undirected edge added between {src} and {dest} with weight {weight}")
        elif choice == 4:
            graph.display()
        elif choice == 5:
            print("Enter start vertex for BFS: ", end="")
            start = scanner.next()
            graph.bfs(start)
        elif choice == 6:
            print("Enter start vertex for DFS: ", end="")
            start = scanner.next()
            graph.dfs(start)
        elif choice == 7:
            print("Enter start vertex for Dijkstra: ", end="")
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
