class Solution {
    public int closedIsland(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int countClosedIsland = 0;
    //for border column
    for(int c = 0; c < col - 1; c++){
        if(grid[0][c] == 0){
            sinkIsland(grid, 0 , c);
        }
        if(grid[row-1][c] == 0){
            sinkIsland(grid, row-1, c);
        }
    }
    //for border row
        for(int r = 0; r < row-1; r++){
            if(grid[r][0] == 0){
                sinkIsland(grid, r, 0);
            }
            if(grid[r][col - 1] == 0){
                sinkIsland(grid, r,col - 1);
            }
        }
    //in inner bound
    for(int r = 1; r <= row - 2; r++ ){
        for(int c = 1; c <= col - 2; c++){
            if(grid[r][c] == 0){
                countClosedIsland += 1;
                sinkIsland(grid,r,c);
            }
        }
    }
    return countClosedIsland;
    }
    //helper magician sinkIsland for keeping surrounding 4 direction in check
    void sinkIsland(int[][] grid, int r, int c){
        int row = grid.length;
        int col = grid[0].length;
        if(r < 0 || r >= row || c < 0|| c >= col){
            return ;
        }
        if(grid[r][c] == 1){
            return;
        }
        grid[r][c] = 1;
        sinkIsland(grid, r-1, c); // up
        sinkIsland(grid, r+1, c); //down
        sinkIsland(grid, r, c + 1);//right
        sinkIsland(grid, r, c-1 ); //left
    }
    public static void main(String[] args){
        Solution sc = new Solution();
        System.out.println(sc.closedIsland(new int[][] {{1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0}, {1,0,1,0,1,1,1,0}, {1,0,0,0,0,1,0,1}, {1,1,1,1,1,1,1,0}}));

    }
}
