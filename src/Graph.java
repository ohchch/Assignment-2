import java.util.*;

public class Graph {

    // Inner class to represent a weighted edge
    private class Edge implements Comparable<Edge> {
        String source;
        String destination;
        int weight;

        public Edge(String source, String destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return destination + "(" + weight + ")";
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    // Adjacency List: Map<Vertex, List<Edge>>
    // Using String for vertex labels for simplicity and user-friendliness
    private Map<String, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // --- Task B1: Graph Representation ---

    // Adds a vertex to the graph
    public void addVertex(String label) {
        adjacencyList.putIfAbsent(label, new ArrayList<>());
    }

    // Adds a directed weighted edge to the graph
    public void addEdge(String source, String destination, int weight) {
        // Ensure vertices exist
        addVertex(source);
        addVertex(destination);

        // Add edge source -> destination
        List<Edge> edges = adjacencyList.get(source);
        edges.add(new Edge(source, destination, weight));
    }

    // Adds an undirected weighted edge (adds both directions)
    // Useful for MST algorithms which typically work on undirected graphs
    public void addUndirectedEdge(String source, String destination, int weight) {
        addEdge(source, destination, weight);
        addEdge(destination, source, weight);
    }

    // Displays the graph (Adjacency List)
    public void display() {
        System.out.println("\n--- Graph Adjacency List ---");
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        for (String vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");
            List<Edge> edges = adjacencyList.get(vertex);
            for (Edge edge : edges) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    // --- Task B2: Graph Traversal ---

    public void bfs(String startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Start vertex not found in the graph.");
            return;
        }

        System.out.print("BFS Traversal: ");
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            List<Edge> neighbors = adjacencyList.get(current);
            if (neighbors != null) {
                for (Edge edge : neighbors) {
                    if (!visited.contains(edge.destination)) {
                        visited.add(edge.destination);
                        queue.add(edge.destination);
                    }
                }
            }
        }
        System.out.println();
    }

    public void dfs(String startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Start vertex not found in the graph.");
            return;
        }

        System.out.print("DFS Traversal: ");
        Set<String> visited = new HashSet<>();
        dfsRec(startVertex, visited);
        System.out.println();
    }

    private void dfsRec(String current, Set<String> visited) {
        visited.add(current);
        System.out.print(current + " ");

        List<Edge> neighbors = adjacencyList.get(current);
        if (neighbors != null) {
            for (Edge edge : neighbors) {
                if (!visited.contains(edge.destination)) {
                    dfsRec(edge.destination, visited);
                }
            }
        }
    }

    // --- Task B3: Shortest Path Algorithm ---

    public void dijkstra(String startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Start vertex not found in the graph.");
            return;
        }

        // Initialize distances to infinity
        Map<String, Integer> distances = new HashMap<>();
        for (String vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(startVertex, 0);

        // Priority Queue to select vertex with minimum distance
        // Pair: <Vertex, Distance>
        PriorityQueue<AbstractMap.SimpleEntry<String, Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(AbstractMap.SimpleEntry::getValue)
        );
        pq.add(new AbstractMap.SimpleEntry<>(startVertex, 0));

        Set<String> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            String current = pq.poll().getKey();

            if (visited.contains(current)) continue;
            visited.add(current);

            List<Edge> neighbors = adjacencyList.get(current);
            if (neighbors != null) {
                for (Edge edge : neighbors) {
                    if (!visited.contains(edge.destination)) {
                        int newDist = distances.get(current) + edge.weight;
                        if (newDist < distances.get(edge.destination)) {
                            distances.put(edge.destination, newDist);
                            pq.add(new AbstractMap.SimpleEntry<>(edge.destination, newDist));
                        }
                    }
                }
            }
        }

        // Display results
        System.out.println("\n--- Dijkstra's Shortest Path from " + startVertex + " ---");
        System.out.println("Vertex\tDistance");
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println(entry.getKey() + "\t" + (entry.getValue() == Integer.MAX_VALUE ? "INF" : entry.getValue()));
        }
    }

    // --- Task B4: Minimum Spanning Tree ---

    public void primMST() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\n--- Prim's Minimum Spanning Tree ---");
        
        // Start from the first vertex found in the keySet (arbitrary start)
        String startVertex = adjacencyList.keySet().iterator().next();
        
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        // MST result storage
        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;

        // Initialize with the start vertex
        visited.add(startVertex);
        if (adjacencyList.get(startVertex) != null) {
            pq.addAll(adjacencyList.get(startVertex));
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited.contains(edge.destination)) {
                continue; // Skip if destination is already included in MST
            }

            // Include this edge in MST
            visited.add(edge.destination);
            mstEdges.add(edge);
            totalCost += edge.weight;

            // Add all edges from the newly added vertex to the PQ
            List<Edge> neighbors = adjacencyList.get(edge.destination);
            if (neighbors != null) {
                for (Edge neighbor : neighbors) {
                    if (!visited.contains(neighbor.destination)) {
                        pq.add(neighbor);
                    }
                }
            }
        }

        // Display results
        System.out.println("Edges in MST:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
        System.out.println("Total Cost of MST: " + totalCost);
    }
}
