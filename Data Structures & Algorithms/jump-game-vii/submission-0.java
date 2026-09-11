class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        // always start at index 0 and only allowed to land on a '0'
        // can jump a distance of minJump <= maxJump as long as
        // the end of the string has not been reached
        // keep track of a farthest variable
        // start processing jumps from the farthest point at
        // each iteration to prevent duplicated computations

        // base case: string is null or does not end in '0' 
        if (s == null || s.charAt(s.length() - 1) != '0') {
            return false;
        }

        // queue to store the next index of the string
        Queue<Integer> indexQueue = new LinkedList<>();
        // farthest variable
        int farthest = 0;

        indexQueue.offer(0);

        while (!indexQueue.isEmpty()) {
            int currentIndex = indexQueue.poll();
            // if the current index is '0', we are done
            if (currentIndex == s.length() - 1) {
                return true;
            }
            // able to jump to [current + min, current + max]
            int nextIndex = Math.max(currentIndex + minJump, 
                farthest + 1);
            // can jump a distance of maxJump if not exceeded
            int end = Math.min(currentIndex + maxJump, s.length() - 1);

            for (int i = nextIndex; i <= end; i++) {
                if (s.charAt(i) == '0') {
                    indexQueue.offer(i);
                }
            }
            // update farthest variable
            farthest = Math.max(farthest, end);
        }
        // all indices processed and unable to find a viable path
        return false;
    }
}