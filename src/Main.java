import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static boolean echo = false;
    private static BinarySearchTree bst = new BinarySearchTree();
    private static Graph graph = new Graph();

    public static void main(String[] args) {
        System.out.println("Welcome to the Data Structures Assignment Program!");

        initializeScanner();

        int mainChoice;

        do {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Binary Search Tree Operations (Part A)");
            System.out.println("2. Graph Operations (Part B)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            Integer input = getIntInput();
            if (input == null) break; // End of input
            mainChoice = input;

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

        if (scanner != null) scanner.close();
    }

    private static void initializeScanner() {
        // Check if System.console() is null. It is usually null when input is redirected.
        boolean isInteractive = (System.console() != null);

        if (!isInteractive) {
            // Batch mode (redirected input)
            System.out.println("Batch mode detected (input redirected). Echo enabled.");
            scanner = new Scanner(System.in);
            echo = true;
        } else {
            // Interactive mode
            Scanner tmpScanner = new Scanner(System.in);
            System.out.print("Do you want to use input.txt? (y/n): ");
            String choice = "";
            if (tmpScanner.hasNextLine()) {
                choice = tmpScanner.nextLine().trim();
            }
            
            if (choice.equalsIgnoreCase("y")) {
                File file = new File("input.txt");
                if (file.exists()) {
                    System.out.println("Using input.txt...");
                    try {
                        scanner = new Scanner(file);
                        echo = true;
                    } catch (FileNotFoundException e) {
                        System.out.println("Error opening file: " + e.getMessage());
                        System.out.println("Falling back to manual input.");
                        scanner = tmpScanner;
                        echo = false;
                    }
                } else {
                    System.out.println("input.txt not found. Falling back to manual input.");
                    scanner = tmpScanner;
                    echo = false;
                }
            } else {
                System.out.println("Using manual input.");
                scanner = tmpScanner;
                echo = false;
            }
        }
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

            Integer input = getIntInput();
            if (input == null) return;
            choice = input;

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    Integer insertValue = getIntInput();
                    if (insertValue != null) {
                        bst.insert(insertValue);
                        System.out.println("Value " + insertValue + " inserted successfully.");
                    }
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    Integer deleteValue = getIntInput();
                    if (deleteValue != null) {
                        bst.delete(deleteValue);
                        System.out.println("Deletion operation completed for value " + deleteValue + ".");
                    }
                    break;
                case 3:
                    System.out.print("Enter value to search: ");
                    Integer searchValue = getIntInput();
                    if (searchValue != null) {
                        if (bst.search(searchValue)) {
                            System.out.println("Value " + searchValue + " found in the tree.");
                        } else {
                            System.out.println("Value " + searchValue + " NOT found in the tree.");
                        }
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

            Integer input = getIntInput();
            if (input == null) return;
            choice = input;

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex label: ");
                    String vertex = getStringInput();
                    graph.addVertex(vertex);
                    System.out.println("Vertex " + vertex + " added.");
                    break;
                case 2:
                    System.out.print("Enter source vertex: ");
                    String src = getStringInput();
                    System.out.print("Enter destination vertex: ");
                    String dest = getStringInput();
                    System.out.print("Enter weight: ");
                    Integer weight = getIntInput();
                    if (weight != null) {
                        graph.addEdge(src, dest, weight);
                        System.out.println("Directed edge added: " + src + " -> " + dest + " (" + weight + ")");
                    }
                    break;
                case 3:
                    System.out.print("Enter source vertex: ");
                    String uSrc = getStringInput();
                    System.out.print("Enter destination vertex: ");
                    String uDest = getStringInput();
                    System.out.print("Enter weight: ");
                    Integer uWeight = getIntInput();
                    if (uWeight != null) {
                        graph.addUndirectedEdge(uSrc, uDest, uWeight);
                        System.out.println("Undirected edge added between " + uSrc + " and " + uDest + " with weight " + uWeight);
                    }
                    break;
                case 4:
                    graph.display();
                    break;
                case 5:
                    System.out.print("Enter start vertex for BFS: ");
                    String bfsStart = getStringInput();
                    graph.bfs(bfsStart);
                    break;
                case 6:
                    System.out.print("Enter start vertex for DFS: ");
                    String dfsStart = getStringInput();
                    graph.dfs(dfsStart);
                    break;
                case 7:
                    System.out.print("Enter start vertex for Dijkstra: ");
                    String dijkstraStart = getStringInput();
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

    // Reads the next token string, handling BOM if present
    private static String readToken() {
        if (!scanner.hasNext()) return null;
        String token = scanner.next();
        if (token.startsWith("\uFEFF")) {
            token = token.substring(1);
        }
        return token;
    }

    private static Integer getIntInput() {
        while (true) {
            String token = readToken();
            if (token == null) return null;

            try {
                int val = Integer.parseInt(token);
                if (echo) System.out.println(val);
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Enter your choice: ");
                // Loop continues to read next token
            }
        }
    }

    private static String getStringInput() {
        String input = readToken();
        if (echo && input != null) System.out.println(input);
        return input;
    }
}
