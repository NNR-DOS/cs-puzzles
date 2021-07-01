package problems;

public class InsertionSortList {

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

    public static ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode headOfSortedList = new ListNode(head.val);
        ListNode pointerToUnsortedList = head.next;

        // loop through each element in the list
        while (pointerToUnsortedList != null) {
            // insert this element to the new list
            ListNode pointerToSortedList = headOfSortedList;
            ListNode nextInUnsortedList = pointerToUnsortedList.next;

            if (pointerToUnsortedList.val <= headOfSortedList.val) {
                ListNode oldHeadOfSortedList = headOfSortedList;
                headOfSortedList = pointerToUnsortedList;
                headOfSortedList.next = oldHeadOfSortedList;
            } else {
                while (pointerToSortedList.next != null) {
                    if (pointerToUnsortedList.val > pointerToSortedList.val && pointerToUnsortedList.val <= pointerToSortedList.next.val) {
                        ListNode oldNext = pointerToSortedList.next;
                        pointerToSortedList.next = pointerToUnsortedList;
                        pointerToUnsortedList.next = oldNext;
                    }
                    pointerToSortedList = pointerToSortedList.next;
                }

                if (pointerToUnsortedList.val > pointerToSortedList.val) {
                    pointerToSortedList.next = pointerToUnsortedList;
                    pointerToUnsortedList.next = null;
                }
            }

            // finally
            pointerToUnsortedList = nextInUnsortedList;
        }

        return headOfSortedList;
    }


    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);

        four.next = two;
        two.next = eight;
        eight.next = three;
        three.next = seven;
        seven.next = one;

        //4->2->1->3
        System.out.println(insertionSortList(four));
    }
}
