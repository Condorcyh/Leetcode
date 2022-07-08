package BFSandDFS.Q100;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 车一晗
 * @Date 2022/06/15
 **/
public class SameTree {
    public boolean isSameTreeDFS(TreeNode p, TreeNode q) {
        if (p == null & q == null) {
            return true;
        }
        if (p == null ||  q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTreeDFS(p.left, q.left) && isSameTreeDFS(p.right, q.right);
        } else {
            return false;
        }
    }

    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        if (p == null & q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;
            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;
            if ((left1 == null && left2 != null) || (left1 != null && left2 == null)) {
                return false;
            }
            if ((right1 == null && right2 != null) || (right1 != null && right2 == null)) {
                return false;
            }

            if (left1 != null) {
                q1.offer(left1);
            }
            if (right1 != null) {
                q1.offer(right1);
            }
            if (left2 != null) {
                q2.offer(left2);
            }
            if (right2 != null) {
                q2.offer(right2);
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }

}
