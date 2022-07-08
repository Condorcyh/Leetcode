package DynamicProgramming.Q416;

/**
 * @Author 车一晗
 * @Date 2022/06/16
 **/
public class Partition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;

        //dp[i][j]含义为用nums中的前i个物品，能否把容量为sum的背包装满
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j- nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
