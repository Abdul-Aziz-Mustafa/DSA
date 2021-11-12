import java.util.ArrayDeque;

public class bfs_grid {
    static class co_ordinates {
        int x, y;

        co_ordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void bsf_grid(co_ordinates start, co_ordinates end, int[][] grid) {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };
        ArrayDeque<co_ordinates> dq = new ArrayDeque<>();
        boolean[][] is_visited = new boolean[grid[0].length][grid.length];
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                is_visited[i][j] = false;
            }

        }
        dq.add(start);

        while (!dq.isEmpty()) {

            co_ordinates cc = dq.removeFirst();
            // System.out.println(is_visited[cc.x][cc.y]);

            if (is_visited[cc.x][cc.y] == false) {
                System.out.print(grid[cc.x][cc.y] + " ");
                
                is_visited[cc.x][cc.y] = true;
                for (int i = 0; i < 4; i++) {
                    int x_c = cc.x + dr[i];
                    int y_c = cc.y + dc[i];

                    if (x_c < 0 || y_c < 0 ) {

                        continue;
                    }
                    if (x_c >= grid[0].length || y_c >= grid.length ) {

                        continue;
                    }
                    if( is_visited[x_c][y_c] == true){
                        continue;
                    }
                    dq.add(new co_ordinates(x_c, y_c));

                }

            }

        }

    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        bsf_grid(new co_ordinates(0, 0), new co_ordinates(0, 0), grid);

    }
}
