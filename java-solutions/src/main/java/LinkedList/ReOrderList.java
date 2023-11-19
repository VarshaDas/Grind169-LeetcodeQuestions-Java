package LinkedList;

public class ReOrderList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public void reorderList(ListNode head) {
        //1. find the middle of the linked list
        //2. reverse the linked list in half
        //3. merge the head with new reversed head

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow.next);
        slow.next = null;

        mergeLists(head, newHead); // Corrected the order of parameters

        // Print the modified list for debugging
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public void mergeLists(ListNode first, ListNode second) {
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;

            if (firstNext == null) {
                break;
            }

            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ReOrderList reOrderList = new ReOrderList();
        reOrderList.reorderList(head);
    }
}


