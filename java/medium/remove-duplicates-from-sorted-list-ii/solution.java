/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 This seems fairly easy... the list being sorted helps because the duplicates will be next to one another. 

 First thought: just walk through the list and keep track of the previous node. If the current node's value matches that of the previous node, 
 delete the current node. 

 I don't see what's wrong with that, let's try it. 

 Ah, I misunderstood the question! Don't just remove duplicates so that there is one of each, if a value has dupes, remove ALL instances of the value; 

 I managed to hack my way through it. I simply iterated through the list with two pointers, one to prev and one to current. 

 Each iteration, I would check if current is followed by a duplicate. If so, advance it. This advances current to the last duplicate of the current number. 

 Upon reaching the last duplicate of the current number, point prev to curr.next, removing the duplicates. 

 In the non-duplicate case, simply advance prev and curr normally. 

 Special handling is needed if the duplicates are at the front (there is no prev so just point head to the first non-duplicate)

 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        boolean duplicates = false;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                duplicates = true;
                curr = curr.next;
            } else {
                if (duplicates) {
                    curr = curr.next;
                    if (prev != null) {
                        prev.next = curr;
                    } else {
                        head = curr;
                    }
                    duplicates = false;
                } else {
                    prev = curr;
                    curr = curr.next;
                }

            }
        }
        return head;
    }
}