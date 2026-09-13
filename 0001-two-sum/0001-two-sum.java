class Solution {
    public int[] twoSum(int[] nums, int target) {
        // create Hashmap to store number and their indices
        Map<Integer , Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0 ; i< nums.length ; i++){
            int remainder = target - nums[i];

            // Check if the remainder is already in the map
            if (map.containsKey(remainder)){
                return new int[] { map.get(remainder) , i};
            }

            // Otherwise add the remainder in the hashmap
            map.put(nums[i], i);
        }
        // Return an empty array
        return new int[] {};
    }
}