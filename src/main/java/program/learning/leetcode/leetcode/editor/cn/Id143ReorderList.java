//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 295 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Id143ReorderList {
    public static void main(String[] args) {
        Solution solution = new Id143ReorderList().new Solution();
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode node = head;
        List<ListNode> nodeList = new ArrayList<>();
        while (node != null) {
            nodeList.add(node);
            node = node.next;
        }
        for (int i = nodeList.size() - 1; i >= nodeList.size() / 2; i--) {
            int index = nodeList.size() - 1 - i;
            ListNode node1 = nodeList.get(index);
            ListNode node2 = nodeList.get(i);
            node2.next = node1.next;
            node1.next = node2;
        }
        nodeList.get(nodeList.size() / 2).next = null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}