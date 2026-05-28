class Solution {
    public int findMin(int[] nums) {
        /*
            Start with sorted array.

            Rotate between 1 and n times

            To rotate means to move all elements up one index, and the last element moves to the front. 

            Need O(log n) time

            Ok, well, finding the minimum of a sorted array is trivial. Just array[0]

            If it's been rotated, it's no longer sorted. Although the array consists of two sorted arrays. 

            O(log n) seems to hint towards binary search, but how can we do binary search if the array isn't sorted? 

            Can we just sort it again? No, even the fastest sorting algos are O(n * log n)

            What properties can we use to find the min? Well, the min number will always be the only number that is smaller than the previous number. 

            [0, 1, 2, 3]
            [3, 0, 1, 2]
            [2, 3, 0, 1]

            If we split the array, can we determine which half contains the minimum? 

            I think if we compare the first and last elements of the arrays, we should be able to. 

            But we need a larger example 

            [0, 1, 2, 3, 4, 5]
                Splits to [0, 1, 2] and [3, 4, 5]

            [5, 0, 1, 2, 3, 4]
                Splits to [5, 0, 1] and [2, 3, 4]

            [2, 3, 4, 5, 0, 1]
                Splits to [2, 3, 4] and [5, 0, 1]    
        
            I think we split the arrays and compare the first and last elements of each to one another. If first > last, mid is in there. 

            Otherwise, take the first subarray because the array may be sorted. 

            It worked! We use the two pointer strategy. If the middle of the array is larger than the right pointer, set the left pointer to the mid. Otherwise, set the right pointer to the mid. Do this until left and right pointers are adjacent, then select the smaller value. 
        */

        int length = nums.length;
        int mid = length / 2;
        int left = 0;
        int right = length - 1;

        while(right - left > 1) {
            // check first subArray
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}