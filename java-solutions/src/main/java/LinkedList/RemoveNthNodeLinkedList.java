package LinkedList;

/*
The intuition behind the "Remove Nth Node From End of List" problem is to identify the node that
needs to be removed from the end of the linked list.

To solve this problem, we use two pointers - slow and fast.
The fast pointer is moved n steps ahead of the slow pointer.
 By doing this, we create a gap of n nodes between the slow and fast pointers.

Next, we move both pointers simultaneously until the fast pointer reaches the
end of the list. As the pointers move together, the gap between them remains constant.
When the fast pointer reaches the end, the slow pointer will be pointing to the node
that is n steps from the end of the list.

To remove the nth node from the end, we update the pointers by setting slow.next to slow.next.next.
This effectively removes the desired node from the list.

By using this approach, we are able to remove the nth node from the end of the linked list efficiently with a single pass through the list.

Overall, the intuition is to create a gap of n nodes between the slow and fast pointers
and then move them together until the desired position is reached.

The time complexity of the solution for the "Remove Nth Node From End of List" problem is O(N),
 where N is the number of nodes in the linked list. This is because we need to traverse the entire linked
 list once to find the node to be removed.

The space complexity of the solution is O(1). We are using a constant amount of extra space to store
the two pointers (slow and fast) and some additional variables. The space required does not depend on the size of the input linked list, making it a constant space solution.
 */
public class RemoveNthNodeLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;

        int count = 1;
        while(count <= n){
            fast = fast.next;
            count++;
        }
        if(fast == null){

            return head.next;
        }
        ListNode slow = head;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;

    }
}
