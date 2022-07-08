package Backtracking.Q46;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 车一晗
 * @Date 2022/07/07
 **/
public class Permute {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return res;
    }

    void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }
}
