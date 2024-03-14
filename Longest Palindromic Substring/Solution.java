
class Solution {
    public String longestPalindrome(String s) {
        int dp[][] = new int[1001][1001];
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s, dp) == 1) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static int isPalindrome(int i, int j, String s, int[][] dp) {
        if (i >= j) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = isPalindrome(i + 1, j - 1, s, dp);
        } else {
            return dp[i][j] = 0;
        }
    }
}