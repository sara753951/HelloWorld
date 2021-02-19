//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 449 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id203RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new Id203RemoveLinkedListElements().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        solution.removeElements(head, 2);
        System.out.println();
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
        public ListNode removeElements(ListNode head, int val) {

            while (null != head && head.val == val) {
                head = head.next;
            }
            ListNode node = head;
            while (node != null && node.next != null) {
                if (node.next.val == val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }

            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}