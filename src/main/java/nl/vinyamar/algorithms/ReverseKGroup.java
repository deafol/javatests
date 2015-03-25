package nl.vinyamar.algorithms;

public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode reversed = reverseKGroup(new ListNode(5), 3);
        System.out.print("reversed = " + reversed.val);
        while (reversed.next != null) {
            ListNode next = reversed.next;
            System.out.print("->" + next.val);
            reversed = next;
        }
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode first = head;
        ListNode previous = head;
        for (int i = head.val - 1; i > 0; i--) {
            first = new ListNode(i);
            first.next = previous;
            previous = first;
        }

        ListNode node = first;
        while (node.next != null) {
            if (node.val % k == 0) {
                //TODO reverse the list
            }
        }
        return first;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}