package program.learning.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yanxinming on 2019/6/19
 */
public class Id23 {

    public static void main(String[] args) {
        ListNode[] lists = produceList();
        ListNode sortedList = mergeLists(lists);
        ListNode.print(sortedList);
    }

    private static ListNode mergeLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                priorityQueue.add(lists[i]);
            }
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (priorityQueue.size() > 0) {
            ListNode min = priorityQueue.poll();
            if (min.next != null) {
                priorityQueue.add(min.next);
            }
            cur.next = min;
            cur = cur.next;
        }

        return head.next;
    }

    private static ListNode[] produceList() {
        ListNode list1 = produceListNode(new int[]{1,3,5,7,9});
        ListNode list2 = produceListNode(new int[]{2,4,6,8,10});
        ListNode list3 = produceListNode(new int[]{});
        return new ListNode[]{list1, list2, list3};
    }

    private static ListNode produceListNode(int[] array) {
        if (array.length < 1) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;

        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        ListNode.print(head);

        return head;
    }
}
