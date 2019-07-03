package leetcode;

/**
 * Created by yanxinming on 2019/6/19
 */
public class ListNode {
    ListNode next;
    int val;

    ListNode(int x) {
        this.val = x;
    }

    public static void print(ListNode listNode) {
        ListNode cur = listNode;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
