package problems;

public class RemoveNthNodeFromEndOfList {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val + (next == null ? "" : ", " + next.toString());
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
//
//        int counter = 1;
//        ListNode dummyHead = head;
//
//        ListNode start = head;
//        ListNode startTwo = start.next;
//
//        while(dummyHead.next != null) {
//            counter++;
//            dummyHead = dummyHead.next;
//        }
//
//        if (startTwo == null) {
//            return null;
//        }
//
//        if (startTwo.next == null) {
//            if (n == 1) {
//                start.next = null;
//                return start;
//            }
//            if (n == 2) {
//                return start.next;
//            }
//
//        }
//
//        if (startTwo.next.next == null) {
//            if (n == 1) {
//                start.next.next = null;
//                return start;
//            }
//            if (n == 2) {
//                start.next = start.next.next;
//                return start;
//            } else {
//                return start.next;
//            }
//        }
//
//        if (counter == n) {
//            return start.next;
//        }
//
//        while(true) {
//            ListNode temp;
//            if (startTwo == null || startTwo.next == null) {
//                temp = null;
//            } else {
//                temp = startTwo.next;
//            }
//            if (counter == n) {
//                start.next = temp;
//                break;
//            }
//            counter--;
//            start = startTwo;
//            startTwo = start.next;
//        }
//        return head;
        int counter = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;

        while (first.next != null) {
            counter++;
            first = first.next;
        }

        first = dummy;
        int length = (counter -= n);

        while (length > 0) {
            length--;
            first = first.next;
        }

        first.next = first.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        //[9,0,3,8,7,3,8,6,3,1]
        ListNode one = new ListNode(9);
        ListNode two = new ListNode(0);
        ListNode three = new ListNode(3);
        ListNode one1 = new ListNode(8);
        ListNode two2 = new ListNode(7);
        ListNode three3 = new ListNode(3);
        ListNode one4 = new ListNode(8);
        ListNode two5 = new ListNode(6);
        ListNode three6 = new ListNode(3);
        ListNode four = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = one1;
        one1.next = two2;
        two2.next = three3;
        three3.next = one4;
        one4.next = two5;
        two5.next = three6;
        three6.next = four;

//        ListNode one = new ListNode(1);
//        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(5);
//
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;

        System.out.println(removeNthFromEnd(one, 2));
    }
}
