class Solution {
    public int openLock(String[] deadends, String target) {
        // set to store visited combinations
        Set<String> visited = new HashSet<>();
        for (String s : deadends) {
            visited.add(s);
        }

        if (visited.contains("0000")) {
            return -1;
        }

        // queue to process combinations
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                String curr = queue.poll();

                if (curr.equals(target)) {
                    return moves;
                }

                List<String> neighbours = generateNeighbours(curr);
                for (String neighbour : neighbours) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            
            moves++;
        }

        return -1;
    }

    private List<String> generateNeighbours(String curr) {
        List<String> neighbours = new ArrayList<>();

        char[] chars = curr.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];

            // turn the wheel up
            if (original == '9') {
                chars[i] = '0';
            } else {
                chars[i] = (char) (original + 1);
            }

            neighbours.add(new String(chars));

            // turn the wheel down
            if (original == '0') {
                chars[i] = '9';
            } else {
                chars[i] = (char) (original - 1);
            }

            neighbours.add(new String(chars));

            // restore the character to the original
            chars[i] = original;
        }

        return neighbours;
    }
}