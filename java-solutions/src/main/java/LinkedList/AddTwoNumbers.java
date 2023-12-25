package LinkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;


        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(sum % 10);
            current.next = newNode;
            current = current.next;
            carry = sum / 10;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }

        return dummy.next;
    }
}
