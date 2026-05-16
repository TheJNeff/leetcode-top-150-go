/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

    Ok, we need to reverse a linked list? Seems simple enough. 

    We could make a reversed copy pretty easily, or, if we really care about optimizing the memory, maybe we could try to reverse it in place. 

    Time complexity will likely not need a lot of optimizations. Let's think about how to do this. 

    Solved. I just iterated thorugh the list and kept track of the previous node.

    Before advancing the iteration, 
    1. assign next to current.next, 
    2. assign current.next to prev. 
    3. assign prev to current 
    4. assign current to next
    5. The loop stops when current is null. Since current is prev.next, we know prev is the end of the original list. Return it. 
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}