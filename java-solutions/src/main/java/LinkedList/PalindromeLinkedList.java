package LinkedList;

public class PalindromeLinkedList {
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
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode secondhalf = reverse(slow);
            ListNode p1 = head;
            ListNode p2 = secondhalf;
            while(p2 != null){
                if(p1.val != p2.val){
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            return true;


        }

        public ListNode reverse(ListNode head){
            ListNode prev  = null;
            ListNode curr = head;
            while(curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }
    }
}
