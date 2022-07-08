package DynamicProgramming.Q198;

/**
 * @Author 车一晗
 * @Date 2022/06/17
 **/
public class Rob {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        //dp[i]表示到第i间房子最多能取出的钱
        int[] dp = new int[n + 1];
        //base case
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}
