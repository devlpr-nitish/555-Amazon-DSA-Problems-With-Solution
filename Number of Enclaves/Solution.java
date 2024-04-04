class Solution {
    public static void dfs(int row, int col, int vis[][], int mat[][]) {
        vis[row][col] = 1;
        int delrow[] = { -1, 0, 1, 0 };
        int delcol[] = { 0, 1, 0, -1 };
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, mat);
            }
        }
    }

    public int numEnclaves(int[][] mat) {
        // Write your code here.
        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m];

        // traverse first row and last row
        for (int i = 0; i < m; i++) {
            if (vis[0][i] == 0 && mat[0][i] == 1) {
                dfs(0, i, vis, mat);
            }
            if (vis[n - 1][i] == 0 && mat[n - 1][i] == 1) {
                dfs(n - 1, i, vis, mat);
            }
        }

        // traverse first colum and last column
        for (int j = 0; j < n; j++) {
            if (vis[j][0] == 0 && mat[j][0] == 1) {
                dfs(j, 0, vis, mat);
            }
            if (vis[j][m - 1] == 0 && mat[j][m - 1] == 1) {
                dfs(j, m - 1, vis, mat);
            }
        }

        int traps = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 1) {
                    traps++;
                }
            }
        }

        return traps;
    }
}