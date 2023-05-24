package LinkedList;

public class MergeTwoSortedLists {
    /**
     * The Solution class provides a method to merge two sorted linked lists into a single sorted linked list.
     * The approach is to use recursive merging. We compare the values of the head nodes of the two lists.
     * If the value of the first list's head node is smaller, we set its next pointer to the result of merging
     * the remaining nodes of the first list with the second list. Otherwise, we set the next pointer of the second list's head
     * to the result of merging the first list with the remaining nodes of the second list.
     * This process continues recursively until one of the lists becomes empty.
     * Finally, we return the head of the merged list.
     *
     * Leetcode Link - https://leetcode.com/problems/merge-two-sorted-lists/description/
     */

    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        // Base cases: If one of the lists is null, return the other list
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // Compare the values of the head nodes of the two lists
        if (list1.val < list2.val) {
            // Set the next pointer of the first list's head to the result of merging
            // the remaining nodes of the first list with the second list
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            // Set the next pointer of the second list's head to the result of merging
            // the first list with the remaining nodes of the second list
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes of the non-empty list
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        // Create example lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(9);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(5);

        // Merge the two lists
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        // Output: 1 1 2 3 4 4
    }
}
