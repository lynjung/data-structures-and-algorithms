import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        List<int[]> res = new ArrayList<>();
        int[] last = intervals[0];
        res.add(last);

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];

            if (cur[0] <= last[1]) {           // overlap
                last[1] = Math.max(last[1], cur[1]);
            } else {                            // no overlap
                res.add(cur);
                last = cur;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
