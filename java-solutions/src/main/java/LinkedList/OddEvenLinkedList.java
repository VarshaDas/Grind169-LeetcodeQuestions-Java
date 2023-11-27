package LinkedList;

public class OddEvenLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // Initialize pointers for odd and even nodes
            ListNode oddCurrent = head; // Pointer to the last odd node
            ListNode evenCurrent = head.next; // Pointer to the last even node
            ListNode evenHead = evenCurrent; // Save the head of even nodes

            // Traverse the original list and insert nodes into the appropriate lists
            while (evenCurrent != null && evenCurrent.next != null) {
                oddCurrent.next = evenCurrent.next; // Connect odd node to the next odd node
                oddCurrent = oddCurrent.next; // Move the odd pointer

                evenCurrent.next = oddCurrent.next; // Connect even node to the next even node
                evenCurrent = evenCurrent.next; // Move the even pointer
            }

            // Connect the end of the odd list to the beginning of the even list
            oddCurrent.next = evenHead;

            return head;
        }
    }
}
