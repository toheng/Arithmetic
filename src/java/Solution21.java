/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author: Hengo
 * @date: 2018/8/19 23:55
 */
public class Solution21 {

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    public class TreeNode {
        int val = 0;
        Solution21.TreeNode left = null;
        Solution21.TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
