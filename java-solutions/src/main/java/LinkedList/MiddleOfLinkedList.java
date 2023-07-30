package LinkedList;

public class MiddleOfLinkedList {

        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;

        }
}
/**
 * <p>Given a non-empty linked list, find the middle node of the list. If there are two middle nodes,
 * return the second middle node.
 *
 * <p>Brute Force Approach:
 * One way to find the middle node of a linked list is to traverse the entire list and count the
 * number of nodes. Then, traverse the list again to find the middle node by moving halfway from the
 * head based on the count. This approach requires two passes over the linked list.
 *
 * <p>Optimal Approach:
 * An optimal approach to find the middle node of a linked list is to use the "two pointers" technique.
 * We can initialize two pointers, slow and fast, both pointing to the head of the linked list.
 * The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
 * By the time the fast pointer reaches the end of the list, the slow pointer will be at the middle node.
 *
 * <p>Time complexity: O(n) - The optimal approach requires only one pass over the linked list, resulting
 * in a linear time complexity.
 *
 * <p>Space complexity: O(1) - The optimal approach uses constant extra space since it only requires two pointers.
 */

public class MiddleOfLinkedList {

    /**
     * Finds the middle node of a non-empty linked list.
     *
     * @param head The head node of the linked list.
     * @return The middle node of the linked list.
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static void main(String[] args) {
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();

//            // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
//            ListNode node1 = new ListNode(1);
//            ListNode node2 = new ListNode(2);
//            ListNode node3 = new ListNode(3);
//            ListNode node4 = new ListNode(4);
//            ListNode node5 = new ListNode(5);
//
//            node1.next = node2;
//            node2.next = node3;
//            node3.next = node4;
//            node4.next = node5;

        // Create a linked list: 1 -> 2 -> 3 -> 4
        //If there are two middle nodes, return the second middle node.
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode middleNode = middleOfLinkedList.middleNode(node1);

        System.out.println("Middle node value: " + middleNode.val);
    }
}



