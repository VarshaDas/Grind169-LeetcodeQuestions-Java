package LinkedList;

public class LinkedListCycleII {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
        public ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null){
                return null;
            }

            //find cycle

            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;

                if(fast == slow){
                    break;
                }
            }


            if(fast == null || fast.next == null){
                return null;
            }

            slow = head;

            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }

