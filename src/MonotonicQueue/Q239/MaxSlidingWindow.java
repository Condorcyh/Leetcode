package MonotonicQueue.Q239;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 车一晗
 * @Date 2022/06/27
 **/
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //填满窗口的前k-1个元素
                window.push(nums[i]);
            } else {
                //窗口向前滑动，加入新元素
                window.push(nums[i]);
                //记录当前窗口最大值
                res.add(window.max());
                //移出最后的元素
                window.pop(nums[i - k + 1]);
            }
        }
        //将结果转成int数组返回
        int n = res.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    static class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();

        public void push(int n) {
            //将前面小于自己的都删除
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.addLast(n);
        }

        public int max() {
            return q.getFirst();
        }

        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }
}
