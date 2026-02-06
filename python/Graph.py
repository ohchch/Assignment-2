import sys
import heapq
from collections import deque

class Graph:
    def __init__(self):
        # Dictionary: string -> list of (destination, weight)
        # Using dict for adjacency list to support string labels easily like Java
        self.adj = {}

    def add_vertex(self, label):
        if label not in self.adj:
            self.adj[label] = []

    def add_edge(self, source, destination, weight):
        self.add_vertex(source)
        self.add_vertex(destination)
        self.adj[source].append((destination, weight))

    def add_undirected_edge(self, source, destination, weight):
        self.add_edge(source, destination, weight)
        self.add_edge(destination, source, weight)

    def display(self):
        print("\n--- Graph Adjacency List ---")
        if not self.adj:
            print("Graph is empty.")
            return
        for vertex in self.adj:
            print(f"{vertex} -> ", end="")
            edges = self.adj[vertex]
            # Java prints: dest(weight)
            print(" ".join([f"{e[0]}({e[1]})" for e in edges]))

    def bfs(self, start_vertex):
        if start_vertex not in self.adj:
            print("Start vertex not found in the graph.")
            return
        
        print("BFS Traversal: ", end="")
        visited = set()
        queue = deque([start_vertex])
        visited.add(start_vertex)

        while queue:
            current = queue.popleft()
            print(f"{current} ", end="")
            
            for neighbor, weight in self.adj[current]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)
        print()

    def dfs(self, start_vertex):
        if start_vertex not in self.adj:
            print("Start vertex not found in the graph.")
            return

        print("DFS Traversal: ", end="")
        visited = set()
        self._dfs_rec(start_vertex, visited)
        print()

    def _dfs_rec(self, current, visited):
        visited.add(current)
        print(f"{current} ", end="")
        for neighbor, weight in self.adj[current]:
            if neighbor not in visited:
                self._dfs_rec(neighbor, visited)

    def dijkstra(self, start_vertex):
        if start_vertex not in self.adj:
            print("Start vertex not found in the graph.")
            return

        # Initialize distances
        distances = {v: float('inf') for v in self.adj}
        distances[start_vertex] = 0
        
        # Priority queue stores (distance, vertex)
        pq = [(0, start_vertex)]
        visited = set()

        while pq:
            current_dist, current_node = heapq.heappop(pq)

            if current_node in visited:
                continue
            visited.add(current_node)

            for neighbor, weight in self.adj[current_node]:
                if neighbor not in visited:
                    new_dist = current_dist + weight
                    if new_dist < distances[neighbor]:
                        distances[neighbor] = new_dist
                        heapq.heappush(pq, (new_dist, neighbor))

        print(f"\n--- Dijkstra's Shortest Path from {start_vertex} ---")
        print("Vertex\tDistance")
        for v, dist in distances.items():
            d_str = "INF" if dist == float('inf') else str(dist)
            print(f"{v}\t{d_str}")

    def prim_mst(self):
        if not self.adj:
            print("Graph is empty.")
            return

        print("\n--- Prim's Minimum Spanning Tree ---")
        # Arbitrary start node (first key)
        start_vertex = next(iter(self.adj))
        
        visited = set([start_vertex])
        mst_edges = []
        total_cost = 0
        
        # Priority Queue: (weight, source, destination)
        pq = []
        for dest, weight in self.adj[start_vertex]:
            heapq.heappush(pq, (weight, start_vertex, dest))

        while pq:
            weight, u, v = heapq.heappop(pq)
            
            if v in visited:
                continue
            
            visited.add(v)
            mst_edges.append((u, v, weight))
            total_cost += weight
            
            for next_dest, next_weight in self.adj[v]:
                if next_dest not in visited:
                    heapq.heappush(pq, (next_weight, v, next_dest))

        print("Edges in MST:")
        for u, v, w in mst_edges:
            print(f"{u} - {v} : {w}")
        print(f"Total Cost of MST: {total_cost}")
