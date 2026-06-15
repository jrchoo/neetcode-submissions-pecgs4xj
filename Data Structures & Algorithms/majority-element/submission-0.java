class Solution {
    public int majorityElement(int[] nums) {
        // candidate and count
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) { // assign as new candidate
                candidate = num;
            }

            if (num == candidate) { // found a match
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}