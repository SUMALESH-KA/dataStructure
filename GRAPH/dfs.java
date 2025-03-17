import java.util.*;

public class dfs {

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean vis[] = new boolean[adj.size() + 1];
        dfs(1,adj,dfs,vis);
        
        return dfs;
    }
    
    public void dfs(int N ,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> result,boolean[] vis){
        result.add(N);
        vis[N] = true;
        
        for(int itr : adj.get(N)){
            if(!vis[itr])
                dfs(itr,adj,result,vis);
        }
    }
}
