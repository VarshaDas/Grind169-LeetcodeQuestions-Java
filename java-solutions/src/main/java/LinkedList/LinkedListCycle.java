package LinkedList;
/*
/**

Given a linked list, determine if it has a cycle in it.
Approach:


We can use the Floyd's Tortoise and Hare algorithm to detect a cycle in a linked list.
This algorithm uses two pointers, slow and fast, which start at the head of the linked list.
The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
If there is a cycle in the linked list, the fast pointer will eventually catch up to the slow pointer.
If there is no cycle, the fast pointer will reach the end of the linked list.
To implement this algorithm, we initialize both pointers to the head of the linked list.
Then, we iterate through the linked list until either the fast pointer reaches the end (indicating no cycle)
or the fast pointer meets the slow pointer (indicating a cycle).
Time Complexity: O(N), where N is the number of nodes in the linked list.
In the worst case, we may need to traverse the entire linked list.
Space Complexity: O(1). We are using a constant amount of extra space for the two pointers.
The space required does not depend on the size of the input linked list.

 */



public class LinkedListCycle {

        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }

            return true;
        }
}
