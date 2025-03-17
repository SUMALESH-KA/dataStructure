import java.util.*;

public class Bfs{

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        boolean visited[] = new boolean[V + 1];
        
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            
            for(int itr: adj.get(node)){
                if(!visited[itr]){
                    visited[itr] = true;
                    q.add(itr);
                }
            }
        }
        return bfs;
    }
}