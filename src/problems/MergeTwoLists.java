package problems;

public class MergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode one, ListNode two) {
        if (one == null || two == null) {
            return one != null ? one : two;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (one != null && two != null) {
            if (one.val < two.val) {
                current.next = one;
                one = one.next;
            } else {
                current.next = two;
                two = two.next;
            }
            current = current.next;
        }
        current.next = one != null ? one : two;
        return dummy.next;
    }
}
