package Backtracking.Q78;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 车一晗
 * @Date 2022/07/07
 **/
public class SubSets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        //记录走过的路程
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track);
        return res;
    }

    void backtrack(int[] nums, int start, List<Integer> track) {
        //前序遍历的位置
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }

}
