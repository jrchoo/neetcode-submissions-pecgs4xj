class Solution {
    public int leastInterval(char[] tasks, int n) {
        // int array of size 26 to act as frequency map
        int[] frequency = new int[26];
        for (char task : tasks) {
            int index = task - 'A';
            frequency[index]++;
        }
        // one queue for the tasks sorted according to frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        // one to manage the cooldowns
        Queue<int[]> cooldown = new LinkedList<>();

        for (int freq : frequency) { // only store freq
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }

        // represent number of CPU cycles
        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;
            // process the first task, decrease frequency and add to cooldown
            if (!maxHeap.isEmpty()) {
                int currTask = maxHeap.poll();
                int processed = currTask - 1;
                if (processed > 0) {
                    int availableAt = time + n;
                    cooldown.add(new int[]{processed, availableAt});
                }
            }

            // tasks that are off cooldown can be added back to the queue
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                int[] nextTask = cooldown.poll();
                maxHeap.offer(nextTask[0]);
            }
        }

        return time;
    }
}
