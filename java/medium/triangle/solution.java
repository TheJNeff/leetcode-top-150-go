class Solution {
    /*
        The first thing that comes to mind is to simply walk the triangle and figure out the min path to each position by storing it in a structure. 

        Let's do that first. 

        We can store the min path as a map Pair(i, j) -> min, where i is the row in the triangle, and j is the position of the number in that row. 
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<Pair<Integer, Integer>, Integer> minPathByPosition = new HashMap();
        minPathByPosition.put(new Pair(0, 0), triangle.get(0).get(0));

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size() - 1; j++) {
                Pair<Integer, Integer> left = new Pair(i, j);
                Pair<Integer, Integer> right = new Pair(i, j + 1);
                Integer currentMin = minPathByPosition.get(new Pair(i - 1, j));
                System.out.println(currentMin);
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