package Greedy.Q45;

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
}
