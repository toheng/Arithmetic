/**
 * 删除链表中重复的节点
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author: Hengo
 * @date: 2018/8/31 22:47
 */
public class Solution29 {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode result;
        ListNode temp = pHead;
        ListNode index = new ListNode(1);
        index.next = pHead;
        result = index;
        while (temp != null) {
            if (temp.next != null && temp.next.val == temp.val) {
                while (temp.next != null && temp.next.val == temp.val) {
                    temp = temp.next;
                }
                temp = temp.next;
                index.next = temp;
            } else {
                index = index.next;
                temp = temp.next;
            }
        }
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
