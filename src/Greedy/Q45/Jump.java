package Greedy.Q45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author 车一晗
 * @Date 2022/07/07
 **/
public class Jump {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int farthest = 0;
        int jumps = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

    //动态规划
    public int jump2(int[] nums) {
        int n = nums.length;

        //dp[i]表示跳到i处所需要的最小步数
        int[] dp = new int[n];
        Arrays.fill(dp, n);

        //base case
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //从j处能否跳到i处
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    //测试一下数组排序
    public static void sort(Integer[] nums) {
        //Arrays.sort(nums, (o1, o2) -> o2.compareTo(o1));

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[10];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        nums[4] = 4;
        nums[5] = 5;
        nums[6] = 6;
        nums[7] = 7;
        nums[8] = 8;
        nums[9] = 9;

        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
