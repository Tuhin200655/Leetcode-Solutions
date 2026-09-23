class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int s1 = intervals[i][0], e1 = intervals[i][1];
                int s2 = intervals[j][0], e2 = intervals[j][1];

                if (s1 <= e2 && s2 <= e1) {
                    count++;
                }
            }
        }

        return count;
    }
}