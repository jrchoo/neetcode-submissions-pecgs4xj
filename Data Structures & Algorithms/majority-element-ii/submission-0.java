class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // list to hold the majority elements
        List<Integer> result = new ArrayList<>();
        // maintain two candidates and two associated counts
        int candidate1 = 0;
        int count1 = 0;
        int candidate2 = 0;
        int count2 = 0;

        for (int num : nums) {
            // try to match the current number
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) { // assign candidate number
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else { // matches neither candidates, eliminate this triplet
                count1--;
                count2--;
            }
        }

        // perform a pass to count the occurences and ensure that the candidate elements are at least n/3
        count1 = 0;
        count2 = 0;
        int threshold = nums.length / 3;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        if (count1 > threshold) {
            result.add(candidate1);
        }

        if (count2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }
}