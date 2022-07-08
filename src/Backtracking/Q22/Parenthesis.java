package Backtracking.Q22;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 车一晗
 * @Date 2022/07/07
 **/
public class Parenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String track = "";
        backtrack(n, n, track, res);
        return res;
    }

    //可用得左括号数量为left，可用得右括号数量为right
    void backtrack(int left, int right, String track, List<String> res) {
        if (left < 0 || right < 0) {
            return;
        }
        //左括号剩得多，说明左括号用的少了，不合法
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(track);
            return;
        }
        track += "(";
        backtrack(left - 1, right, track, res);
        track = track.substring(0, track.length() - 1);

        track += ")";
        backtrack(left, right - 1, track, res);
        track = track.substring(0, track.length() - 1);  //这行注释掉也行，因为根本走不到这里
    }
}
