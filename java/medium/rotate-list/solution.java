/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 What does it mean to rotate the list to the right by k places? 

 It means the last k nodes of the list should be moved to the front, with the new head being the node that started k places from the end. 

 Hmm... this definition doesn't really fit if k > list.size. 

 Maybe it's better to define a single rotation

 This means moving the last node to the front. 

 So basically do that k times. 

 Thinking of solutions, is it possible to just have a pointer to the start and the end of the list, and perform k rotations? 

 Not so fast! If you only have the start and the end, how do you point the node before the end to null? You don't know which one it is!

 Maybe instead of actually removing the node on the end, you can add nodes to the end and move the head forward. 

 If we point end.next to start, move the head to start.next, then set start.next to null, that should work. Now start.next = start and end.next = end

 This type of rotation is possible, but it is important to note that it is a different kind of rotation than the one we defined earlier!
 
 type 1, moving the last node to the front:

 [0, 1, 2] -> [2, 0, 1]

 type 2. moving the first node to the end

 [0, 1, 2] -> [1, 2, 0]
 [1, 2, 0] -> [2, 0, 1]
 
 We can get the same result, but it takes size - k rotations, not k rotations, since we are effectively rotating the opposite direction. 
 
 Problem with this is that if k > size, the number of rotations is negative. 

 Realizing that rotating the list fully produces the original list, we can infer that the number of rotations can be defined as size - (size % k).

 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }        

        // now we have the head and the tail. Let's rotate!
        for(int i = 0; i < size - (k % size); i++) {
            tail.next = head;
            head = head.next;
            tail = tail.next;
            tail.next = null;
        }
        return head;
    }
}