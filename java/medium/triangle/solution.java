class Solution {
    /*
        The first thing that comes to mind is to simply walk the triangle and figure out the min path to each position by storing it in a structure. 

        Let's do that first. 

        We can store the min path as a map Pair(i, j) -> min, where i is the row in the triangle, and j is the position of the number in that row. 

        That sovled it, but the metrics are not great. I think it was a mistake to use Map<Pair, Integer> because it forces me to make a whole bunch of Pair objects. Would be faster and more memory efficient to just use a List<List<Integer>> or int[][].

        Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

        Interesting... so before im using O(N) space where N is the total number of elements in the triangle. Now we need to limit that space to the size of the number of rows. 

        Well, the number of rows is equal to the size of the largest row. 

        Maybe if we start from the largest row and walk UP the triangle, we can save some space and just keep track of the shortest possible path from each element in that largest row. 

        Let's think about this with Example 1: 

        Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        Output: 11
        Explanation: The triangle looks like:
        2
        3 4
        6 5 7
        4 1 8 3
        The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

        Let's start from [4, 1, 8, 3]

        We can allocate an array of the same size, so let's do int[4]

        In the beginning, the array will be the same as the row: [4, 1, 8, 3]

        Then, we can look at the row above [6, 5, 7], and we can decide the shortest possible path to each. 

        Since we only care about the sum, not the path, we can overwrite our array with these new values. 

        So the new array would see that the shortest path to 6 is from 1, the shortest path to 5 is from 1, and the shortest path from 7 is from 3. 

        We end up with 
        [7, 6, 10, 3]

        We have a dangling element that we no longer need in that final 3, which no longer represents anything meaningful. 

        Now we go to the next row and our result is:

        [9, 10, 10, 3] and now the last 2 elements are meaningless

        Next row we get [11, 10, 10, 3]

        We can simply use the first element of the resulting array. 

        And it's solved! Let's try it. 

        It worked. I decided to try to optimize it a bit more. Much better metrics using primitive int array than a List
    */

    public int minimumTotal(List<List<Integer>> triangle) {
        int numRows = triangle.size();
        int[] tracker = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            tracker[i] = triangle.get(numRows - 1).get(i);
        }
        for (int i = numRows - 2; i >= 0; i--) {
            List<Integer> current = triangle.get(i);
            for (int j = 0; j < current.size(); j++) {
                tracker[j] = current.get(j) + Math.min(tracker[j], tracker[j + 1]);
            }
        }
        return tracker[0];    
    }

    
    public int minimumTotalFirstAttempt(List<List<Integer>> triangle) {
        Map<Pair<Integer, Integer>, Integer> minPathByPosition = new HashMap();
        minPathByPosition.put(new Pair(0, 0), triangle.get(0).get(0));

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size() - 1; j++) {
                Pair<Integer, Integer> left = new Pair(i, j);
                Pair<Integer, Integer> right = new Pair(i, j + 1);
                Integer currentMin = minPathByPosition.get(new Pair(i - 1, j));
                Integer minLeft = minPathByPosition.get(left);
                Integer minRight = minPathByPosition.get(right);
                if (minLeft == null || minLeft > triangle.get(i).get(j) + currentMin) {
                    minPathByPosition.put(left, triangle.get(i).get(j) + currentMin);
                } 
                if (minRight == null || minRight > triangle.get(i).get(j + 1) + currentMin) {
                    minPathByPosition.put(right, triangle.get(i).get(j + 1) + currentMin);
                }
            }
        }

        Integer result = null;
        for (int j = 0; j < triangle.get(triangle.size() - 1).size(); j++) {
            Pair<Integer, Integer> pair = new Pair(triangle.size() - 1, j);
            if (result == null || minPathByPosition.get(pair) < result) {
                result = minPathByPosition.get(pair);
            }
        }

        return result;
    }
}