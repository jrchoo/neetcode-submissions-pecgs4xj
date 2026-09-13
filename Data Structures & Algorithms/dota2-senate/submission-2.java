class Solution {
    public String predictPartyVictory(String senate) {
        // keep track of two queues, one radiant one dire
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();
        // initial pass to populate the queues
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            // add to respective queues
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            // compare the two senators at the front of the queues
            int radiant = radiantQueue.poll();
            int dire = direQueue.poll();
            // greedy choice would be to ban the closest senator
            // the senator with the smaller index gets to act first
            if (radiant < dire) {
                // senator that remains unbanned is 
                // readded to the end of the queue
                radiantQueue.offer(radiant + n);
            } else {
                direQueue.offer(dire + n);
            }
        }
        // at the end, queue with remaining is the winner
        if (!radiantQueue.isEmpty()) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
}