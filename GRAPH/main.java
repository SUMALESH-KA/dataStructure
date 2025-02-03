import java.util.*;
import java.util.List;

public class main {
       static class Node {
        int data;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Bfs bfs = new Bfs();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int N = 5;

        // Initialize adjacency list
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(5);
        
        // Call bfs method
        List<Integer> result = bfs.bfs(N, adj, 1);
        System.out.println(result);
    }
}
