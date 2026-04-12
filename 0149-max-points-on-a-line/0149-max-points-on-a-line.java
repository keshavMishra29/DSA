class Solution {

    public int maxPoints(int[][] points) {
        int n = points.length - 1, max = 0;
        double[] ratios = new double[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            int xc = 0, yc = 0, r = 0, k;
            for (int j = i + 1; j <= n; j++) {
                if (points[i][0] == points[j][0])
                    xc++;
                else if (points[i][1] == points[j][1])
                    yc++;
                else {
                    double ratio = (double) (points[i][0] - points[j][0]) / (points[i][1] - points[j][1]);
                    for (k = 0; k < r; k++)
                        if (ratios[k] == ratio) {
                            count[k]++;
                            break;
                        }
                    if (k == r) {
                        ratios[k] = ratio;
                        count[k] = 1;
                        r++;
                    }
                    max = Math.max(max, count[k]);
                }
            }
            max = Math.max(max, xc);
            max = Math.max(max, yc);
        }
        return max + 1;
    }
}