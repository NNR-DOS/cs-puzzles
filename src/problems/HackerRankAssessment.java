package problems;

public class HackerRankAssessment {

    public static void main(String[] args) {
        SwapNodeInPairs.ListNode one = new SwapNodeInPairs.ListNode(1);
        SwapNodeInPairs.ListNode two = new SwapNodeInPairs.ListNode(2);
        SwapNodeInPairs.ListNode three = new SwapNodeInPairs.ListNode(3);
        SwapNodeInPairs.ListNode four = new SwapNodeInPairs.ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        System.out.println();
    }
}
