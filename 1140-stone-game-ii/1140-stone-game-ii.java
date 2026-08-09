class Solution {
    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        return solve(0, 1, piles);
    }

    int solve(int i, int m, int[] piles) {
        if (i >= n) {
            return 0;
        }

        if (2 * m >= n - i) {
            return suffix[i];
        }

        if (dp[i][m] != 0) {
            return dp[i][m];
        }

        int best = 0;

        for (int x = 1; x <= 2 * m; x++) {
            int opponent = solve(i + x, Math.max(m, x), piles);

            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }

        dp[i][m] = best;

        return best;
    }
}