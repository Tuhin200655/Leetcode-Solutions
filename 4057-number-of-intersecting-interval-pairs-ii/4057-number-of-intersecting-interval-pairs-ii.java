import java.util.Arrays;

class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        int n = intervals.length;
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
        }
        
        long totalPairs = 0;
        for (int i = 0; i < n; i++) {
            int end1 = intervals[i][1];
            
            int idx = upperBound(starts, i + 1, n, end1);
            totalPairs += (idx - (i + 1));
        }
        
        return totalPairs;
    }
    
    private int upperBound(int[] arr, int low, int high, int target) {
        int l = low, r = high;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}