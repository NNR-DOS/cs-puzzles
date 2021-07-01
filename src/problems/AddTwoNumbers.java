package problems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder number1 = new StringBuilder("");
        StringBuilder number2 = new StringBuilder("");

        if (l1.next == null) {
            number1.append(l1.val);
        } else {
            while (l1.next != null) {
                number1.append(l1.val);
                l1 = l1.next;
                if (l1.next == null) {
                    number1.append(l1.val);
                }
            }
        }

        if (l2.next == null) {
            number2.append(l2.val);
        } else {
            while (l2.next != null) {
                number2.append(l2.val);
                l2 = l2.next;
                if (l2.next == null) {
                    number2.append(l2.val);
                }
            }
        }

        String string1 = new String(number1);
        String string2 = new String(number2);


        char[] ch1 = string1.toCharArray();
        char[] temp1 = new char[ch1.length];
        for (int i = 0; i < ch1.length; i++) {
            temp1[temp1.length - i - 1] = ch1[i];
        }

        char[] ch2 = string2.toCharArray();
        char[] temp2 = new char[ch2.length];
        for (int i = 0; i < ch2.length; i++) {
            temp2[temp2.length - i - 1] = ch2[i];
        }

        String finalString1 = String.copyValueOf(temp1);

        String finalString2 = String.copyValueOf(temp2);

        BigDecimal parsedInteger0;
        BigDecimal parsedInteger1;

        if (finalString1.isEmpty()) {
            parsedInteger0 = new BigDecimal(0);
        } else {
            parsedInteger0 = new BigDecimal(finalString1);
        }

        if (finalString2.isEmpty()) {
            parsedInteger1 = new BigDecimal(0);
        } else {
            parsedInteger1 = new BigDecimal(finalString2);
        }

        BigDecimal sum = parsedInteger0.add(parsedInteger1);

        String finalDigits = sum.toString();

        char[] ch3 = finalDigits.toCharArray();
        char[] temp3 = new char[ch3.length];
        for (int i = 0; i < ch3.length; i++) {
            temp3[temp3.length - i - 1] = ch3[i];
        }

        ListNode returnListNode = new ListNode(temp3[0]);

        List<ListNode> listOfListNodes = new ArrayList<ListNode>();

        for (char c : temp3) {
            ListNode newNode = new ListNode(Integer.parseInt(Character.toString(c)));
            listOfListNodes.add(newNode);
        }

        for (int i = 0; i < listOfListNodes.size() - 1; i++) {
            listOfListNodes.get(i).next = listOfListNodes.get(i + 1);
        }

        System.out.print(sum);

        return listOfListNodes.get(0);
    }

    public static void main(String[] args) {
        ListNode nine = new ListNode(2);
        ListNode nine1 = new ListNode(9);
        ListNode nine2 = new ListNode(9);
        ListNode nine3 = new ListNode(9);
        ListNode nine4 = new ListNode(9);
        ListNode nine5 = new ListNode(9);
        ListNode nine6 = new ListNode(9);
        ListNode nine7 = new ListNode(9);
        ListNode three = new ListNode(3);

        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        ListNode six = new ListNode(4);
//
//        two.next = four1;
//        four1.next = three;
//
//        four.next = five;
//        five.next = six;

        ListNode one = new ListNode(0);
        ListNode two = new ListNode(1);

        System.out.println(addTwoNumbers(one, two));
    }
}
