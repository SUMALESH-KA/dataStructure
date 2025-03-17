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

    // Directed edge: u -> v
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void displayGraph() {
        for (int i = 1; i <= N; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }
}

// UndirectedGraph.java
class UndirectedGraph extends Graph {
    public UndirectedGraph(int N) {
        super(N);
    }

    // Undirected edge: u <-> v
    @Override
    public void addEdge(int u, int v) {
        super.addEdge(u, v);
        super.addEdge(v, u);
    }
}

// Main.java
public class undir {
    public static void main(String[] args) {
        int N = 5;

        // Directed Graph
        Graph directedGraph = new Graph(N);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(1, 3);
        directedGraph.addEdge(2, 4);
        directedGraph.addEdge(3, 4);
        directedGraph.addEdge(3, 5);
        directedGraph.addEdge(4, 5);

        System.out.println("Directed Graph Representation:");
        directedGraph.displayGraph();

        // Undirected Graph
        UndirectedGraph undirectedGraph = new UndirectedGraph(N);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(1, 3);
        undirectedGraph.addEdge(2, 4);
        undirectedGraph.addEdge(3, 4);
        undirectedGraph.addEdge(3, 5);
        undirectedGraph.addEdge(4, 5);

        System.out.println("\nUndirected Graph Representation:");
        undirectedGraph.displayGraph();
    }
}
