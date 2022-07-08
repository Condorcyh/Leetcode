package BFSandDFS.Q103;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author 车一晗
 * @Date 2022/06/15
 **/
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        List<Integer> tmp;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            tmp = new ArrayList<>();
            for (int i = 0; i < q.size(); i++) {
                TreeNode cur = q.poll();
                tmp.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
