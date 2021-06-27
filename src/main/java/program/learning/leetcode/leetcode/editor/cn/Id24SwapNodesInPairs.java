//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 604 👎 0

//题解
/*
循环遍历链表，指针index记录当前索引(从1开始)，记录奇数节点和偶数节点，
遍历到偶数节点时交换奇偶节点，并记录原偶数节点为pre指针(pre指针始终指向上一次交换的原偶数节点)，防止交换后链表断开
头结点特殊处理
 */

package program.learning.leetcode.leetcode.editor.cn;
public class Id24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new Id24SwapNodesInPairs().new Solution();
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node = solution.swapPairs(head);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
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
        public ListNode swapPairs(ListNode head) {
            ListNode node = head;
            int index = 0;
            ListNode pre = new ListNode();
            ListNode node1 = new ListNode();
            ListNode node2 = new ListNode();
            while (node != null) {
                index++;
                if (index % 2 != 0) {
                    node1 = node;
                } else {
                    node2 = node;
                }
                node = node.next;
                if (index % 2 == 0) {
                    node1.next = node2.next;
                    node2.next = node1;
                    pre.next = node2;
                    pre = node1;
                    if (index == 2) {
                        head = node2;
                    }
                }
            }
            return head;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    
}