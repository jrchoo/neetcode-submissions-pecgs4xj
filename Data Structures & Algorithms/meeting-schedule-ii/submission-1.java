/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
        
        PriorityQueue<Interval> rooms = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));
        // sort the intervals according to start time
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        Interval firstInt = intervals.get(0);
        rooms.offer(firstInt);
        int numRooms = rooms.size();
        int prevEnd = firstInt.end;
        
        // allocate the meeting room to the interval with an earlier end time
        for (int i = 1; i < intervals.size(); i++) {
            Interval currInterval = intervals.get(i);
            int start = currInterval.start;
            // when a meeting has concluded, free up the meeting room
            if (start >= rooms.peek().end) {
                rooms.poll();
            }
            // when there is an overlap, open up a new meeting room
            rooms.offer(currInterval);
            numRooms = rooms.size();
        }
        
        return numRooms;
    }
}
