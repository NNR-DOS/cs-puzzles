package problems;

public class SwapNodeInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + (next == null ? "" : "," + next.toString());
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode start = head;
        ListNode returnHead = start.next;
        while(true) {
            ListNode nextStart = start.next;
            ListNode temp = nextStart.next;
            nextStart.next = start;
            if (temp == null || temp.next == null) {
                start.next = temp;
                break;
            }
            start.next = temp.next;
            start = temp;
        }
        return returnHead;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        System.out.println(swapPairs(one));
    }
}




/*

 */
