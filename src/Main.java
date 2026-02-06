import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BinarySearchTree bst = new BinarySearchTree();
    private static Graph graph = new Graph();

    public static void main(String[] args) {
        int mainChoice;

        System.out.println("Welcome to the Data Structures Assignment Program!");

        do {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Binary Search Tree Operations (Part A)");
            System.out.println("2. Graph Operations (Part B)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            mainChoice = getIntInput();

            switch (mainChoice) {
                case 1:
                    bstMenu();
                    break;
                case 2:
                    graphMenu();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (mainChoice != 3);

        scanner.close();
    }

    private static void bstMenu() {
        int choice;
        do {
            System.out.println("\n--- Part A: Binary Search Tree Menu ---");
            System.out.println("1. Insert a value");
            System.out.println("2. Delete a value");
            System.out.println("3. Search for a value");
            System.out.println("4. Display traversals (Inorder, Preorder, Postorder)");
            System.out.println("5. Display tree properties (Height, Node count, Leaf count)");
            System.out.println("6. Find Minimum and Maximum values");
            System.out.println("7. Return to Main Menu");
            System.out.print("Enter your choice: ");

            choice = getIntInput();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = getIntInput();
                    bst.insert(insertValue);
                    System.out.println("Value " + insertValue + " inserted successfully.");
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = getIntInput();
                    bst.delete(deleteValue);
                    System.out.println("Deletion operation completed for value " + deleteValue + ".");
                    break;
                case 3:
                    System.out.print("Enter value to search: ");
                    int searchValue = getIntInput();
                    if (bst.search(searchValue)) {
                        System.out.println("Value " + searchValue + " found in the tree.");
                    } else {
                        System.out.println("Value " + searchValue + " NOT found in the tree.");
                    }
                    break;
                case 4:
                    System.out.println("--- Tree Traversals ---");
                    bst.printInorder();
                    bst.printPreorder();
                    bst.printPostorder();
                    break;
                case 5:
                    System.out.println("--- Tree Properties ---");
                    System.out.println("Height of the tree: " + bst.getHeight());
                    System.out.println("Total number of nodes: " + bst.getTotalNodes());
                    System.out.println("Number of leaf nodes: " + bst.getLeafNodes());
                    break;
                case 6:
                    System.out.println("--- Min/Max Values ---");
                    try {
                        System.out.println("Minimum value: " + bst.findMin());
                        System.out.println("Maximum value: " + bst.findMax());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-7.");
            }
        } while (choice != 7);
    }

    private static void graphMenu() {
        int choice;
        do {
            System.out.println("\n--- Part B: Graph Operations Menu ---");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge (Directed)");
            System.out.println("3. Add Edge (Undirected - for MST)");
            System.out.println("4. Display Graph");
            System.out.println("5. BFS Traversal");
            System.out.println("6. DFS Traversal");
            System.out.println("7. Shortest Path (Dijkstra)");
            System.out.println("8. Minimum Spanning Tree (Prim)");
            System.out.println("9. Return to Main Menu");
            System.out.print("Enter your choice: ");

            choice = getIntInput();

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex label: ");
                    String vertex = scanner.next();
                    graph.addVertex(vertex);
                    System.out.println("Vertex " + vertex + " added.");
                    break;
                case 2:
                    System.out.print("Enter source vertex: ");
                    String src = scanner.next();
                    System.out.print("Enter destination vertex: ");
                    String dest = scanner.next();
                    System.out.print("Enter weight: ");
                    int weight = getIntInput();
                    graph.addEdge(src, dest, weight);
                    System.out.println("Directed edge added: " + src + " -> " + dest + " (" + weight + ")");
                    break;
                case 3:
                    System.out.print("Enter source vertex: ");
                    String uSrc = scanner.next();
                    System.out.print("Enter destination vertex: ");
                    String uDest = scanner.next();
                    System.out.print("Enter weight: ");
                    int uWeight = getIntInput();
                    graph.addUndirectedEdge(uSrc, uDest, uWeight);
                    System.out.println("Undirected edge added between " + uSrc + " and " + uDest + " with weight " + uWeight);
                    break;
                case 4:
                    graph.display();
                    break;
                case 5:
                    System.out.print("Enter start vertex for BFS: ");
                    String bfsStart = scanner.next();
                    graph.bfs(bfsStart);
                    break;
                case 6:
                    System.out.print("Enter start vertex for DFS: ");
                    String dfsStart = scanner.next();
                    graph.dfs(dfsStart);
                    break;
                case 7:
                    System.out.print("Enter start vertex for Dijkstra: ");
                    String dijkstraStart = scanner.next();
                    graph.dijkstra(dijkstraStart);
                    break;
                case 8:
                    graph.primMST();
                    break;
                case 9:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-9.");
            }
        } while (choice != 9);
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter your choice: ");
        }
        return scanner.nextInt();
    }
}
