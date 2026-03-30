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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return true;
        }
        // sort intervals based on start times in ascending order
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        int prevEnd = intervals.get(0).end;
        // loop intervals and compare current start time with previous end time
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            // if there is an overlap, return false
            if (current.start < prevEnd) {
                return false;
            }
            prevEnd = current.end;
        }
        // otherwise, return true
        return true;
    }
}
