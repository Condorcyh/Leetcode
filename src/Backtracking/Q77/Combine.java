package Backtracking.Q77;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 车一晗
 * @Date 2022/07/07
 **/
public class Combine {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new ArrayList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    void backtrack(int n, int k, int start, List<Integer> track) {
        //到达叶子节点，更新res
        if (k == track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
