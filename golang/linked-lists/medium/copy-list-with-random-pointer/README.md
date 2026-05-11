# 138. Copy List with Random Pointer

**Difficulty:** Medium ⭐⭐  
**Category:** linked-lists  
**Language:** golang  
**Problem:** [LeetCode #138](https://leetcode.com/problems/copy-list-with-random-pointer/)  
**Solved:** May 11, 2026

## Performance

| Metric  | Result |
|---------|--------|
| Runtime | 23 s (beats 62.8% of submissions) |
| Memory  | 5 MB (beats 62.8% of submissions) |

## Solution

```golang
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        /*
            We can do this in 2 passes. The first, we ignore the random 
pointer and we just focus on the list. 

            We will iterate over the original list, and then construct a copy. 

            Next, we will iterator over the copy list, and assign the random 
pointers. 

            In order to do so, we will construct a hash map mapping the nodes 
of the original list to the nodes of the new list. 

            We will use this map to assign the random pointers correctly. 

            Done. There's another way we can do this. We can interweave the 
lists together. 
        */
        if (head == null) {

```
