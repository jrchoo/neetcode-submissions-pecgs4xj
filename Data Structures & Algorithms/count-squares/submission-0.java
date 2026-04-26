class CountSquares {

    List<int[]> points;
    HashMap<String, Integer> pointCounts;

    public CountSquares() {
        points = new ArrayList<>();
        pointCounts = new HashMap<>();    
    }
    
    public void add(int[] point) {
        // add the point to the list
        points.add(point);
        
        int x = point[0];
        int y = point[1];
        String key = x + "," + y;
        // increment its frequency in the map
        pointCounts.put(key, pointCounts.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int total = 0;
        int x1 = point[0];
        int y1 = point[1];

        // search for a valid diagonal
        for (int[] next : points) {
            int x2 = next[0];
            int y2 = next[1];

            if (Math.abs(x1 - x2) == Math.abs(y1 - y2) && x1 != x2) { // valid point to form diagonal of a square
                String p3 = x1 + "," + y2;
                String p4 = x2 + "," + y1;
                if (pointCounts.containsKey(p3) && pointCounts.containsKey(p4)) {
                    total += pointCounts.get(p3) * pointCounts.get(p4);
                }
            }
        }

        return total;
    }
}
