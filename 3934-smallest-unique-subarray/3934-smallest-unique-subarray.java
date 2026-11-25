import java.util.*;

class Solution {

    static final long MOD1 = 1000000007;
    static final long MOD2 = 1000000009;
    static final long BASE1 = 100019;
    static final long BASE2 = 100043;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        int left = 1;
        int right = n;

        long[] h1 = new long[n + 1];
        long[] h2 = new long[n + 1];

        long[] p1 = new long[n + 1];
        long[] p2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        for (int i = 0; i < n; i++) {

            h1[i + 1] = (h1[i] * BASE1 + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + nums[i]) % MOD2;

            p1[i + 1] = p1[i] * BASE1 % MOD1;
            p2[i + 1] = p2[i] * BASE2 % MOD2;
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (check(nums, mid, h1, h2, p1, p2)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    boolean check(int[] nums, int len,
                  long[] h1, long[] h2,
                  long[] p1, long[] p2) {

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= nums.length; i++) {

            int j = i + len;

            long a = (h1[j] - h1[i] * p1[len] % MOD1 + MOD1) % MOD1;
            long b = (h2[j] - h2[i] * p2[len] % MOD2 + MOD2) % MOD2;

            long key = (a << 32) | b;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}