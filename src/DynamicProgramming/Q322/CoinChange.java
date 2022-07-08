package DynamicProgramming.Q322;

import java.util.Arrays;

/**
 * @Author 车一晗
 * @Date 2022/06/16
 **/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //当目标金额为i时，最多需要dp[i]枚硬币凑出
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
