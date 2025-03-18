import java.util.*;
public class noOfProvines {

    public void dfs(int V, boolean[] visited , int[][] isConnected){
        visited[V] = true;
        for(int j = 0 ; j < isConnected.length; j++){
            if(isConnected[V][j]==1 && !visited[j]){
                dfs(j,visited,isConnected);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int N = isConnected.length;
        // TO CHANGE ADJ MATRIX TO LIST
        // for(int i = 0;i < N; i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int i = 0 ; i < N; i++){
        //     for(int j = 0 ; j < N; j++){
        //         if(isConnected[i][j] == 1 && i != j){
        //             adj.get(i).add(j);
        //             adj.get(i).add(i);
        //         }
        //     }
        // }

        boolean visited[] = new boolean[N + 1];
        int count = 0;
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,isConnected);
            }
        }
        return count;
    }
}