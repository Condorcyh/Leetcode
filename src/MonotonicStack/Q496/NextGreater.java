package MonotonicStack.Q496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author 车一晗
 * @Date 2022/06/24
 **/
public class NextGreater {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            map.put(nums2[i], s.empty() ? -1 : s.peek());
            s.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
