//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 946 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new Id19RemoveNthNodeFromEndOfList().new Solution();
        ListNode head = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        head = solution.removeNthFromEnd(head, 1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = head;
            int len = 0;
            while (node != null) {
                len++;
                node = node.next;
            }
            if (len < n + 1) {
                return head.next;
            }
            node = head;
            for (int i = 0; i < len - n - 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}