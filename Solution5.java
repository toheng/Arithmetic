/**
 * 把二叉树打印成多行
 * 题目描述：
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution5 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null)
            return list;
        int countLevel = 0;     // 二叉树的层数
        int countNodeToBePrinted = 1;   // 当前层尚未打印的节点数
        int countNodeNextLevel = 0;     // 下一层的节点数
        // 队列记录节点的左右子树节点
        // LinkedList实现了Queue和Stack接口
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            // list的size小于层数，需要增加新的list，保存下一层
            if (list.size() <= countLevel)
                list.add(new ArrayList<Integer>());
            ArrayList<Integer> curList = list.get(countLevel);
            TreeNode pNode = queue.poll();
            curList.add(pNode.val);     // 相当于打印，则尚未打印的节点数减去1
            countNodeToBePrinted--;
            // 左右子节点不为空，则入队
            if (pNode.left != null) {
                queue.offer(pNode.left);
                countNodeNextLevel++;
            }
            if (pNode.right != null) {
                queue.offer(pNode.right);
                countNodeNextLevel++;
            }
            // 当前层全部打印完毕，转到下一层，更新变量
            if (countNodeToBePrinted == 0) {
                countLevel++;
                countNodeToBePrinted = countNodeNextLevel;
                countNodeNextLevel = 0;
            }
        }
        return list;
    }
}