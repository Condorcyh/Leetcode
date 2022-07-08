package DynamicProgramming.Q518;

/**
 * @Author 车一晗
 * @Date 2022/06/17
 **/
public class Change {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        //dp[i][j]表示使用前i枚硬币凑出金额j的方法数
        int[][] dp = new int[n + 1][amount + 1];

        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}
