# 141. Linked List Cycle

**Difficulty:** Easy ⭐  
**Category:** linked-lists  
**Language:** golang  
**Problem:** [LeetCode #141](https://leetcode.com/problems/linked-list-cycle/)  
**Solved:** May 5, 2026

## Performance

| Metric  | Result |
|---------|--------|
| Runtime | 23 s (beats 54.3% of submissions) |
| Memory  | 5 MB (beats 54.3% of submissions) |

## Solution

```golang
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
        Map<ListNode, Integer> visitedNodes = new 
HashMap();
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

```
