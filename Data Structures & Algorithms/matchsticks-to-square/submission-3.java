class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        // check if the length of matchsticks can form a square
        for (int stick : matchsticks) {
            sum += stick;
        }
        // if sum of lengths is not divisible by 4, unable to form a square
        if (sum == 0 || sum % 4 != 0) {
            return false;
        }

        // buckets to hold the sides of the square
        int[] sides = new int[4];
        int target = sum / 4;
        Arrays.sort(matchsticks);

        return backtrack(matchsticks, matchsticks.length - 1, sides, target);
    }

    private boolean backtrack(int[] matchsticks, int index, int[] sides, int target) {
        // successfully placed all matchsticks if end of the array reached
        if (index == -1) {
            return true;
        }

        int current = matchsticks[index];
        // check whether the current matchstick can be placed at this side
        for (int i = 0; i < 4; i++) {
            if (sides[i] + current > target) { // exceeded the limit, move on to the next side
                continue;
            }
            // choose
            sides[i] += current;
            // explore, iterate backwards to choose the longer sticks first
            if (backtrack(matchsticks, index - 1, sides, target)) {
                return true;
            }
            // unchoose
            sides[i] -= current;
        }

        return false;
    }
}