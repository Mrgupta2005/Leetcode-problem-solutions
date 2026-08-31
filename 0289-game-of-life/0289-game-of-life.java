class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] dir = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},           {0,1},
            {1,-1},  {1,0},  {1,1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int live = 0;

                for (int[] d : dir) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x >= 0 && x < m && y >= 0 && y < n &&
                        (board[x][y] == 1 || board[x][y] == 3)) {
                        live++;
                    }
                }

                if (board[i][j] == 0 && live == 3)
                    board[i][j] = 2;

                else if (board[i][j] == 1 && (live < 2 || live > 3))
                    board[i][j] = 3;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 2)
                    board[i][j] = 1;

                else if (board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }
}