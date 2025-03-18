import java.util.*;

public class detectCycle {
    public static void main(String[] args) {
        // Number of vertices (V) and edges (E)
        int V = 5; 
        int E = 5; 
        
        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (Undirected graph)
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        Solution obj = new Solution();
        boolean ans = obj.isCycle(adj);

        // Output result: 1 if cycle exists, 0 if no cycle
        System.out.println(ans ? "1 (Cycle detected)" : "0 (No cycle)");
    }

    // Helper method to add edges to the adjacency list
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Since the graph is undirected
    }
}

class Solution {
    // BFS function to check for cycles
    public boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        
        // Mark the starting node as visited and add it to the queue
        visited[start] = true;
        q.add(new int[]{start, -1}); // {current node, parent node}
        
        while (!q.isEmpty()) {
            int[] details = q.poll();
            int node = details[0];
            int parent = details[1];
            
            // Traverse through all adjacent nodes
            for (int adjacentNode : adj.get(node)) {
                // If the node is not visited, mark and push to queue
                if (!visited[adjacentNode]) {
                    visited[adjacentNode] = true;
                    q.add(new int[]{adjacentNode, node});
                }
                // If the node is already visited and it's not the parent, cycle is detected
                else if (parent != adjacentNode) {
                    return true; // Cycle found
                }
            }
        }
        
        return false; // No cycle found
    }

    // Main function to check if a cycle exists in the graph
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        
        // Perform BFS for each component (handle disconnected graphs)
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                if (bfs(v, adj, visited)) {
                    return true; // Cycle found
                }
            }
        }
        
        return false; // No cycle found in any component
    }
}
