class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        // one queue for index (ordered by enqueue time)
        int[][] orderedTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            orderedTasks[i][0] = tasks[i][0];
            orderedTasks[i][1] = tasks[i][1];
            orderedTasks[i][2] = i;
        }

        // sort according to enqueue time
        Arrays.sort(orderedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        // one queue for processing time (tie broken by index)
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        int[] result = new int[n];
        int resultId = 0;
        int taskId = 0;
        int time = 0;

        while (resultId < n) {
            // choose task with the shortest processing time and smallest index
            while (taskId < n && orderedTasks[taskId][0] <= time) {
                queue.offer(orderedTasks[taskId++]);
            }

            // process tasks
            if (!queue.isEmpty()) {
                int[] current = queue.poll();
                int duration = current[1];
                time += duration;
                result[resultId++] = current[2];
            } else { // fast forward to the enqueue time of the first task
                time = orderedTasks[taskId][0];
            }
        }

        return result;
    }
}