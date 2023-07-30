package LinkedList;

public class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head) {
        // initialize prev and next pointer to NULL
        LinkedListNode prev = null;
        LinkedListNode next = null;
        // set current pointer to the head node
        LinkedListNode curr = head;
        // while the current pointer is not NULL
        while (curr != null) {
            // set the next pointer to the next node in the list
            next = curr.next;
            // reverse the current node's pointer to point to the previous node
            curr.next = prev;
            // set the previous pointer to the current node
            prev = curr;
            // move the current pointer to the next node
            curr = next;
        }
        // set the head pointer to the last node, which is the new first node after reversal
        head = prev;
        // return the new head pointer
        return head;
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // LinkedListNode() will be used to make a LinkedListNode type object.
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
