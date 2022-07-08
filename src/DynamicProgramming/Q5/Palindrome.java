package DynamicProgramming.Q5;

/**
 * @Author 车一晗
 * @Date 2022/06/17
 **/
public class Palindrome {

    public String longestPalindrome(String s) {
        int n = s.length();
        //dp[i][j]表示s[i...j]是否为回文串，i<=j
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i + 1 <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int max = 0;
        int start = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] && (j - i + 1 >= max)) {
                    start = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(start, start + max);
    }
}
