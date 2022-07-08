package nSum.Q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 车一晗
 * @Date 2022/07/07
 **/
public class Three {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }

    List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuple = twoSum(nums, i + 1, target - nums[i]);
            if (tuple.size() > 0) {
                for (List<Integer> list : tuple) {
                    list.add(nums[i]);
                    res.add(list);
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo];
            int right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(left);
                tmp.add(right);
                res.add(tmp);
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res;
    }
}
