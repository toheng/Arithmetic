package java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 用容量为K的最小堆优先队列，把链表的头结点都放进去，然后出队当前优先队列中最小的，挂上链表，
 * 然后让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空。
 *
 * @author hengo
 * @date 2019/4/15
 **/
public class Solution32 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            if (lists.length == 0) {
                return null;
            }

            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

            for (ListNode list : lists) {
                if (list == null) {
                    continue;
                }
                pq.add(list);
            }

            while (!pq.isEmpty()) {
                ListNode nextNode = pq.poll();
                curr.next = nextNode;
                curr = curr.next;
                if (nextNode.next != null) {
                    pq.add(nextNode.next);
                }
            }
            return dummyHead.next;
        }
    }

}
