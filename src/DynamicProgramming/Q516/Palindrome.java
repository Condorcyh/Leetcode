package DynamicProgramming.Q516;

/**
 * @Author 车一晗
 * @Date 2022/06/16
 **/
public class Palindrome {
    public int longestPalindromeSubsequence(String s) {
        int len = s.length();
        //dp[i][j]表示s[i...j]的最长回文子序列长度
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
