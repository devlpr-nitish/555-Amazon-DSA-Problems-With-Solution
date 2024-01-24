import java.util.*;

public class java_ro_1 {
    public int orangesRotting(int[][] grid) {

        // In this problem we will be use the bfs traversal because we have to go levelwise for unit time
        // row of the grid
        int n = grid.length;
        //column of the grid
        int m = grid[0].length;


        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[n][m];
        int cntFresh = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                // if cell contains rotten orange
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    // mark as visited (rotten) in visited array
                    vis[i][j] = 2;
                }
                // if not rotten
                else {
                    vis[i][j] = 0;
                }

                // count fresh oranges
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int time = 0;
        // delta row and delta column
        // For all four directions
        int drow[] = { -1, 0, +1, 0 };
        int dcol[] = { 0, 1, 0, -1 };
        int cnt = 0;

        // until the queue becomes empty
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int tm = q.peek().time;
            time = Math.max(time, tm);
            q.remove();

            // exactly 4 neighbours
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                // check for valid directions and unvisited oranges

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {

                    // push in queue with timer increased

                    q.add(new Pair(nrow, ncol, t + 1));

                    // mark as rotten(visited)
                    vis[nrow][ncol] = 2;
                    // Counting how many fresh oranges are rotten
                    cnt++;
                }
            }
        }

        // if all fresh oranges are not rotten then return -1
        if (cnt != cntFresh) {
            return -1;
        }

        // if all fresh oranges are got rotton then return the unit time taken 
        return time;
    }
}

// Pair class for storing the row column and unit time
class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}