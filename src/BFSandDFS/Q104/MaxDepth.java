package BFSandDFS.Q104;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 车一晗
 * @Date 2022/06/15
 **/
public class MaxDepth {
    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_height = maxDepthDFS(root.left);
        int right_height = maxDepthDFS(root.right);
        return Math.max(left_height, right_height) + 1;
    }

    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
