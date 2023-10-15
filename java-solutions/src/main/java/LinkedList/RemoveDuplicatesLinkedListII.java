package LinkedList;

/*
The problem requires removing duplicates from a sorted linked list, but unlike the "Remove Duplicates from Sorted List" problem, here we need to remove all occurrences of duplicate elements. We can achieve this by using two pointers, a `prev` pointer and a `current` pointer, to traverse the linked list while considering the possibility of duplicates.

1. Initialize a `dummy` node to simplify the handling of edge cases and initialize `prev` and `current` pointers to the `dummy` node.
2. Traverse the linked list from the beginning while checking for duplicate values.
3. If a duplicate is found, continue moving the `current` pointer until it reaches a non-duplicate element or the end of the list.
4. Update the `prev.next` pointer to skip the duplicates and point to the first non-duplicate element.
5. Repeat this process until you reach the end of the list.

Time Complexity:
The time complexity of this algorithm is O(n), where n is the number of nodes in the linked list. We traverse the entire linked list once, and in the worst case, we visit each node once.

Space Complexity:
The space complexity of this algorithm is O(1) because we use a constant amount of extra space to maintain the `dummy`, `prev`, and `current` pointers. The space used is independent of the size of the input linked list.

 */
public class RemoveDuplicatesLinkedListII {
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

        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode curr = head;

            while(curr != null){
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }

                if(prev.next == curr){
                    prev = prev.next;
                } else {
                    //curr would now be at last duplicate node which should be removed
                    prev.next = curr.next;
                }

                curr = curr.next;
            }

            return dummy.next;

        }
    }

