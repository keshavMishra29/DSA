class Solution {
  final int INF = Integer.MAX_VALUE;
  final int MOD = (int) 1e9 + 7;

  public int maxProductPath(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    Res[][] dp = new Res[m][n];
    Res res = solve(grid, 0, 0, dp);
    if (res.max < 0)
      return -1;
    return (int)(res.max % MOD);
  }

  private Res solve(int[][] grid, int i, int j, Res[][] dp) {
    int m = grid.length, n = grid[0].length;
    if (i == m - 1 && j == n - 1)
      return new Res(grid[m - 1][n - 1], grid[m - 1][n - 1]);
    if (i >= m || j >= n)
      return new Res(INF, INF);
    if(dp[i][j] != null) return dp[i][j];
    Res down = solve(grid, i + 1, j, dp);
    Res right = solve(grid, i, j + 1, dp);

    Res res = new Res(0, 0);

    if (down.min != INF && right.min != INF) {
      long op1 = (long) grid[i][j] * down.min;
      long op2 = (long) grid[i][j] * right.min;
      long op3 = (long) grid[i][j] * down.max;
      long op4 = (long) grid[i][j] * right.max;
      res.min = Math.min(Math.min(op1, op2), Math.min(op3, op4));
      res.max = Math.max(Math.max(op1, op2), Math.max(op3, op4));
      // res.max = Math.max(grid[i][j] * down.max, grid[i][j] * right.max);
    } else if (down.min == INF) {
      res.min = grid[i][j] * right.min;
      res.max = grid[i][j] * right.max;
    } else if (right.min == INF) {
      res.min = grid[i][j] * down.min;
      res.max = grid[i][j] * down.max;
    }
    dp[i][j] = res;
    return res;
  }

  class Res {
    long min, max;

    Res(long min, long max) {
      this.min = min;
      this.max = max;
    }
  }
}