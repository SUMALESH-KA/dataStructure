import java.util.*;

public class floodFill {

      void dfs(int[][] gridd, int sr, int sc, int originalColor, int color, boolean[][] visited) {
            int n = gridd.length;
            int m = gridd[0].length;
            visited[sr][sc] = true;
    
            Queue<int[]> q = new LinkedList<>();
    
            q.add(new int[]{sr, sc});
    
            int[] drow = {-1, 0, 1, 0};
            int[] dcol = {0, 1, 0, -1};
    
            while (!q.isEmpty()) {
                int[] details = q.poll();
                int row = details[0];
                int col = details[1];
    
                for (int i = 0; i < 4; i++) {
                    int newrow = row + drow[i];
                    int newcol = col + dcol[i];
    
                    if (newrow >= 0 && newcol >= 0 && newrow < n && newcol < m &&
                            !visited[newrow][newcol] && gridd[newrow][newcol] == originalColor) {
                        q.add(new int[]{newrow, newcol});
                        visited[newrow][newcol] = true;
                        gridd[newrow][newcol] = color;
                    }
                }
            }
        }
    
        public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
            int[][] gridd = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                gridd[i] = grid[i].clone(); // Copies each row separately
            }
            int n = gridd.length;
            int m = gridd[0].length;
            boolean[][] visited = new boolean[n][m];
    
            // Store the original color
            int originalColor = gridd[sr][sc];
    
            // Only perform flood fill if the starting pixel is not already the target color
            if (originalColor != color) {
                gridd[sr][sc] = color;
                dfs(gridd, sr, sc, originalColor, color, visited);
            }
    
            return gridd;
        }
}
