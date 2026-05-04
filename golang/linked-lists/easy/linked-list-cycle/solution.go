/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Map<ListNode, Integer> visitedNodes = new HashMap();
        ListNode current = head;
        while(visitedNodes.get(current) == null) {
            visitedNodes.put(current, 1);
            if (current.next == null) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
}
