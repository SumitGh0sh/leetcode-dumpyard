class Solution {
    private static final int INF = 1000000000;
    private Integer[][] memoCost;
    private Integer[][] memoDp;
    private String str;
    private int n;

    public int minimumChanges(String s, int k) {
        this.str = s;
        this.n = s.length();
        this.memoCost = new Integer[n][n];
        this.memoDp = new Integer[n][k + 1];
        
        return solveDp(0, k);
    }

    // Returns min changes to make s[i...j] a semi-palindrome
    private int getCost(int i, int j) {
        if (i >= j) return INF; // Semi-palindrome length must be at least 2
        if (memoCost[i][j] != null) return memoCost[i][j];

        int minChanges = INF;
        int len = j - i + 1;

        // Try all proper divisors of len
        for (int d = 1; d * d <= len; d++) {
            if (len % d == 0) {
                if (d < len) {
                    minChanges = Math.min(minChanges, getChangesForDivisor(i, j, d));
                }
                int d2 = len / d;
                if (d2 < len) {
                    minChanges = Math.min(minChanges, getChangesForDivisor(i, j, d2));
                }
            }
        }

        return memoCost[i][j] = minChanges;
    }

    // Calculate changes needed for a specific divisor d
    private int getChangesForDivisor(int i, int j, int d) {
        int totalChanges = 0;
        for (int start = 0; start < d; start++) {
            int left = i + start;
            int right = i + (j - i) / d * d + start; // last element in group
            // Adjust right if it exceeds j
            while (right > j) right -= d;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    totalChanges++;
                }
                left += d;
                right -= d;
            }
        }
        return totalChanges;
    }

    // DP to partition s[i...] into k parts
    private int solveDp(int i, int partsLeft) {
        if (partsLeft == 1) {
            return getCost(i, n - 1);
        }
        if (n - i < partsLeft) {
            return INF;
        }
        if (memoDp[i][partsLeft] != null) return memoDp[i][partsLeft];

        int res = INF;
        // Try ending the current substring at index j
        for (int j = i; j <= n - partsLeft; j++) {
            int currentCost = getCost(i, j);
            int nextCost = solveDp(j + 1, partsLeft - 1);
            res = Math.min(res, currentCost + nextCost);
        }

        return memoDp[i][partsLeft] = res;
    }
}