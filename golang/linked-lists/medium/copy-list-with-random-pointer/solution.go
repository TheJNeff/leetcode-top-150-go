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
