//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 864 👎 0

package program.learning.leetcode.leetcode.editor.cn;
public class Id148SortList {
    public static void main(String[] args) {
        Solution solution = new Id148SortList().new Solution();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        solution.sortList(head);
        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    class Solution {
        public ListNode sortList(ListNode head) {
            if (null == head || null == head.next) {
                return head;
            }

            ListNode s = head;
            ListNode f = head;
            ListNode c = head;
            while (f != null && f.next != null) {
                c = s;
                s = s.next;
                f = f.next.next;
            }
            c.next = null;
            ListNode h1 = sortList(head);
            ListNode h2 = sortList(s);

            return merge(h1, h2);
        }

        private ListNode merge(ListNode h1, ListNode h2) {
            if (null == h1) {
                return h2;
            }
            if (null == h2) {
                return h1;
            }
            ListNode head = null;
            if (h1.val < h2.val) {
                head = h1;
                h1 = h1.next;
            } else {
                head = h2;
                h2 = h2.next;
            }
            ListNode newHead = head;
            while (h1 != null && h2 != null) {
                if (h1.val < h2.val) {
                    newHead.next = h1;
                    h1 = h1.next;
                } else {
                    newHead.next = h2;
                    h2 = h2.next;
                }
                newHead = newHead.next;
            }
            if (null != h1) {
                newHead.next = h1;
            }
            if (null != h2) {
                newHead.next = h2;
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}