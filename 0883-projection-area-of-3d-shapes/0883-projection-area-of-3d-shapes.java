class Solution {
    public int projectionArea(int[][] grid) {
        
        int n=grid.length;
        
        int a=0;
        int b=0;
        int c=0;
        
        for(int i=0;i<n;i++)
        {
            int r=0;
            int col=0;
            
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]>0) a++;
                
                if(grid[i][j]>r) r=grid[i][j];
                
                if(grid[j][i]>col) col=grid[j][i];
            }
            
            b=b+r;
            c=c+col;
        }
        
        return a+b+c;
    }
}