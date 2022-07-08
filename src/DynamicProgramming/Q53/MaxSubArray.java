package DynamicProgramming.Q53;

/**
 * @Author 车一晗
 * @Date 2022/06/16
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        //dp[i]含义为以nums[i]结尾的最大子数组和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
