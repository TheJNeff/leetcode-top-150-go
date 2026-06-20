class Solution {
    /*
        So looking at the elements of nums, and being allowed to rearrange them, what is the longest sequence of consecutive integers that you can find? 

        My gut approach is to store the numbers we encounter, as well as how long their current sequence is. 

        However, this presents a problem. How do you relate the length of the sequence to all numbers in the sequence? 

        I think in order to track this, you need to keep track of both the start and end of the sequences.

        Here's an idea: 

        Say we have a map<int, int>. What if the key was the num from the array, and the value was the other end of its sequence? 

        There are 3 ways to add to a sequence. 
        1. Adding to the end of the sequence
        2. Adding to the beginning of the sequence
        3. Joining two sequences together

        Let's say we run into "5". We then check the value of "4" and "6" in the map. 

        For situation 1, 4 points to a value and 6 does not. 
        Let's say 4 points to 1. Then we know we have 1, 2, 3, 4 already. We can point 5 to 1, point 1 to 5, and check if there is a longer sequence than 5. If not, store the result. 
        For situation 2, 6 points to 10, and 4 is null. Do the same thing as above. 
        For situation 3, 4 points to 1 and 6 points to 10. In this case, point 1 to 10, and 10 to 1, and check for longer sequence than 10. 

        The values in the middle of the sequence will now be garbage, but we will not need them anymore since they are no longer relevant to finding the longest sequence. Only the ends are. 

        Let's give this a try. 

        Brilliant, that works. Runtime and memory are quite bad. Let's push this to github and then see if we can optimize. 
    */
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> endToEnd = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // if we already have encountered this number, there is no point processing it again. 
            if (endToEnd.get(num) != null) {
                continue;
            }
            if (endToEnd.get(num - 1) == null && endToEnd.get(num + 1) == null) {
                endToEnd.put(num, num);
                if (max < 1) {
                    max = 1;
                }
                continue;
            }
            if (endToEnd.get(num - 1) == null) {
                // end to end num + 1 != null
                int end = endToEnd.get(num + 1); 
                endToEnd.put(end, num);
                endToEnd.put(num, end);
                if (max < (end - num + 1)) {
                    max = (end - num + 1);
                }
                continue;
            }
            if (endToEnd.get(num + 1) == null) {
                // end to end num + 1 != null
                int end = endToEnd.get(num - 1); 
                endToEnd.put(end, num);
                endToEnd.put(num, end);
                if (max < (num - end + 1)) {
                    max = (num - end + 1);
                }
                continue;
            }
            int left = endToEnd.get(num - 1); 
            int right = endToEnd.get(num + 1); 
            endToEnd.put(left, right);
            endToEnd.put(right, left);
            endToEnd.put(num, 1);
            if (max < (right - left + 1)) {
                max = right - left + 1;
            }
        }
        return max;
    }
}