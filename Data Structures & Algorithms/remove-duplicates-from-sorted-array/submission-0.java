class Solution {
    public int removeDuplicates(int[] nums) {
        // write pointer to insert elements where a duplicate was removed
        int write = 1; // initialised to 1 as the first element is always unique

        for (int i = 1; i < nums.length; i++) {
            // compare current element to the previous element
            if (nums[i] != nums[i - 1]) {// unique element, move to the write position
                nums[write] = nums[i];
                write++;
            }

            // otherwise, write stays at the duplicate to be overwritten in the future
        }

        // the index of the write pointer's final position is just after the first k
        // elements, which is k
        return write;
    }
}