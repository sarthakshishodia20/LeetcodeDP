class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int rowCount[]=new int[n];
        int[] colCount=new int[m];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    rowCount[i]++;
                    colCount[j]++;
                }
                else{
                    rowCount[i]--;
                    colCount[j]--;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=rowCount[i]+colCount[j];
            }
        }
        return grid;
    }
}
