class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a Hashset to store elements from array
        HashSet<Integer> seenNumbers = new HashSet<>();

        // Iterates through each element in the array
        for (int num : nums) {
            // Check if the element is already in the Hashset
            if (seenNumbers.contains(num)) {
                return true;
            }
            // Add element to the Hashset
            seenNumbers.add(num);
        }

        return false; // No Duplicates found
    }
}