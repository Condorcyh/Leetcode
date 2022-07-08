package BinaryTree.Q222;

import utils.TreeNode;

/**
 * @Author 车一晗
 * @Date 2022/06/24
 **/
public class CountNodes {
    public int countNodes(TreeNode root) {
        TreeNode l = root;
        TreeNode r = root;

        int height_l = 0;
        int height_r = 0;

        while (l != null) {
            l = l.left;
            height_l++;
        }
        while (r != null) {
            r = r.right;
            height_r++;
        }

        if (height_l == height_r) {
            return (int) Math.pow(2, height_l) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
