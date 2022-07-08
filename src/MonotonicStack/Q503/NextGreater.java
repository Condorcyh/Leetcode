package MonotonicStack.Q503;

import java.util.Stack;

/**
 * @Author 车一晗
 * @Date 2022/06/27
 **/
public class NextGreater {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            res[i % n] = s.empty()? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }
}
