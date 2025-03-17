import java.util.*;
// Node.java
class Node {
    int data;

    Node(int data) {
        this.data = data;
    }
}

class Graph {
    ArrayList<ArrayList<Integer>> adj;
    int N;

    public Graph(int N) {
        this.N = N;
        adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void displayGraph() {
        for (int i = 1; i <= N; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }
    public ArrayList<ArrayList<Integer>> getAdj() {
        return adj;
    }
}

// Main.java
public class main {
    public static void main(String[] args) {
        int N = 5;
        Graph graph = new Graph(N);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);

        System.out.println("Graph Representation:");
        graph.displayGraph();
        
        Bfs bredthFirstSearch = new Bfs();
        dfs depthFirstSearch = new dfs();
        ArrayList<Integer> bfsResult = bredthFirstSearch.bfsOfGraph(N, graph.getAdj());
        ArrayList<Integer> dfsResult = depthFirstSearch.dfsOfGraph(graph.getAdj());

        System.out.println("BFS Traversal:");
        for (int node : bfsResult) {
            System.out.print(node + " ");
        }
        System.out.println();
        System.out.println("DFS Traversal:");
        for (int node : dfsResult) {
            System.out.print(node + " ");
        }
    }
}
