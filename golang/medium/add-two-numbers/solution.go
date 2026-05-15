/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        int result = 0;
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        ListNode next = null;
        System.out.println("Make a change");
        do {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int newVal = l1Val + l2Val;
            if (carry) {
                newVal = newVal + 1;
            }
            if (newVal > 9) {
                newVal = newVal - 10;
                carry = true;
            } else {
                carry = false;
            }
            current.next = new ListNode(newVal, null);
            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        } while(l1 != null || l2 != null);
        if (carry) {
