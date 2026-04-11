class Solution {
  public void setZeroes(int[][] mtx) {
    int n = mtx.length;
    int m = mtx[0].length;
    int[] r = new int[n];
    int[] c = new int[m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mtx[i][j] == 0) {
          r[i] = 1;
          c[j] = 1;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (r[i] == 1 || c[j] == 1) {
          mtx[i][j] = 0;
        }
      }
    }
  }
}