class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        ArrayList<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        int start = newInterval[0];
        int end = newInterval[1];

        // intervals before newInterval
        while (i < n && intervals[i][1] < start) {
            result.add(intervals[i]);
            i++;
        }

        // merge overlaps
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[]{start, end});

        // intervals after newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}