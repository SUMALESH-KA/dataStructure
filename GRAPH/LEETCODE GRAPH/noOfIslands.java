import java.util.*;

public class noOfIslands {
    public void dfs(int row, int col, boolean[][] visited, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        visited[row][col] = true;
        q.add(new int[]{row, col});

        // Direction array to move in 4 directions (up, down, left, right)
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] details = q.poll(); 
            int r = details[0];
            int c = details[1];

            for (int i = 0; i < 4; i++) {
                int newRow = r + delRow[i];
                int newCol = c + delCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                        !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                    visited[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }
}