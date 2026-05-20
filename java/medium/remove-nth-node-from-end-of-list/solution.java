/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
    Key observation here: there is no way to know which node is n positions from the end without traversing the whole list. 

    Easy way: just iterate twice. Once to figure out where the node is relative to the head, then another time to remove that node. 

    Ok, that works fine and it's pretty fast. Memory usage is not great. 
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return easyWay(head, n);
    }

    public ListNode easyWay(ListNode head, int n) {
        // to find the position of the node relative to the start, simply do list.size - n
        // we know n, so let's find the list size
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        // now we have the size and can calculate the position. Next we simply go to that node and then remove it. 
        // need special logic if position == 0, we just remove the head
        int position = size - n;
        if (position == 0) {
            return head.next;
        }
        else {
            // reset curr
            curr = head;
            ListNode prev = null;
            for (int i = 0; i < position; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
        }
        return head;
    }
}