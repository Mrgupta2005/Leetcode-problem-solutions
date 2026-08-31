class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];

        int r = 0, c = 0, k = 0;

        while (k < ans.length) {
            ans[k++] = mat[r][c];

            if ((r + c) % 2 == 0) {
                if (c == n - 1) r++;
                else if (r == 0) c++;
                else {
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) c++;
                else if (c == 0) r++;
                else {
                    r++;
                    c--;
                }
            }
        }

        return ans;
    }
}