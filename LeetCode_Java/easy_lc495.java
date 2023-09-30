class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int cnt = duration;
        for(int i = 0; i < timeSeries.length - 1; i ++) {
            int expand_to = timeSeries[i] + duration;
            int overlap = expand_to - timeSeries[i+1];
            if(overlap > 0) {
                cnt += duration - overlap;
            }
            else {
                cnt += duration;
            }
        }
        return cnt;
    }
}