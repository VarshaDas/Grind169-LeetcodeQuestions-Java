package LinkedList;

/*
Approach:
The given approach uses a two-pointer technique to remove duplicates from a linked list.
 It iterates through the linked list, comparing each node's value with its adjacent node.
 If a duplicate is found, it skips the duplicate node by updating the next reference of the
 current node. This process continues until the end of the linked list is reached.

Time Complexity:
The time complexity of this approach is O(n), where n is the number of nodes in the linked list.
 The algorithm needs to traverse the entire linked list once to remove the duplicates.
 Each comparison and node update operation takes constant time.

Space Complexity:
The space complexity of this approach is O(1) because it uses a constant amount of extra space.
It only requires a fixed number of pointers to keep track of the current and adjacent nodes in the
linked list. No additional data structures are used, resulting in constant space usage regardless
of the size of the input linked list.


 */
public class RemoveDuplicatesFromLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;

    }
}

