package problems;

import java.util.Collections;
import java.util.Vector;

public class SortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return next != null ? "" + val + "," + next.toString() : "" + val;
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head == null) {
            return head;
        }

        Vector<Integer> list = new Vector<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);

        ListNode newList = new ListNode(list.get(0));

        ListNode dummy = newList;

        for (Integer value : list) {
            newList.next = new ListNode(value);
            newList = newList.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        four.next = two;
        two.next = one;
        one.next = three;

        System.out.println(sortList(four));
    }
}
