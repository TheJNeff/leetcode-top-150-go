class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> neededForTarget = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if (neededForTarget.containsKey(nums[i])) {
                result[0] = i;
                result[1] = neededForTarget.get(nums[i]);
                return result;
            }
            neededForTarget.put(target - nums[i], i);
        }
        return result;
    }
}