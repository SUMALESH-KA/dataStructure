import java.util.*;

public class rottenOranges {
        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
    
            Queue<int[]> q = new LinkedList<>();
    
            boolean[][] visited = new boolean[n][m];
    
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m; j++){
                    if(grid[i][j] == 2){
                        q.add(new int[]{i,j,0});
                        visited[i][j] = true;
                    }
                }
            }
            int elapsed = 0;
    
            int[] drow = {-1, 0, 1, 0};
            int[] dcol = {0, 1, 0, -1};
            while(!q.isEmpty()){
                int[] current = q.poll();
                int row = current[0];
                int col = current[1];
                int time = current[2];
    
                elapsed = Math.max(time,elapsed);
    
                for(int i = 0; i < 4; i++){
                    int newrow = row + drow[i];
                    int newcol = col + dcol[i];
    
                    if(newrow >= 0 && newcol >=0 && newrow < n && newcol < m && 
                        !visited[newrow][newcol] && grid[newrow][newcol] == 1){
                            q.add(new int[]{newrow,newcol,time + 1});
                            visited[newrow][newcol] = true;
                            grid[newrow][newcol] = 2;
                        }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {  // Fresh orange still exists
                        return -1;  // Impossible to rot all oranges
                    }
                }
            }
            return elapsed;
        }
    }
}
