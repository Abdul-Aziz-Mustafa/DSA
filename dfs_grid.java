public class dfs_grid {
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static void dfs(int[][] grid,int srcx,int srcy,boolean [][] is_visited ){

        if(srcx < 0 || srcy < 0 || srcx >= grid[0].length || srcy >= grid.length ||  is_visited[srcx][srcy] == true ){
            return;
        }
        is_visited[srcx][srcy] = true;

        System.out.println(grid[srcx][srcy]);
        for (int i = 0; i < 4; i++) {
            int x_c = srcx + dr[i];
            int y_c = srcy + dc[i];
            dfs(grid, x_c, y_c,is_visited);
        }
         
        

    }
    public static void main(String[] args) {
       
        int[][] grid = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        boolean[][] is_visited = new boolean[grid[0].length][grid.length];
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                is_visited[i][j] = false;
            }

        }
        dfs(grid,0,0,is_visited);

    }
    
}
