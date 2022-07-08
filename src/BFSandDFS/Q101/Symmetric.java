package BFSandDFS.Q101;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 车一晗
 * @Date 2022/06/15
 **/
public class Symmetric {
    public boolean isSymmetricDFS(TreeNode root) {
        if (root == null) {
            return false;
        }
        return compare(root.left, root.right);
    }

    public static boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return compare(p.left, q.right) && compare(p.right, q.left);
        } else {
            return false;
        }
    }

    public boolean isSymmetricBFS(TreeNode root) {
        return check(root.left, root.right);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
