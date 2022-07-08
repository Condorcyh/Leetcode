package DynamicProgramming.Q1312;

/**
 * @Author 车一晗
 * @Date 2022/06/16
 **/
public class MinInsertions {
    public int minInsertions(String s) {
        int len = s.length();
        //dp[i][j]表示将s[i...j]变成回文串的最少操作次数
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 0;
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][len - 1];
    }
}
