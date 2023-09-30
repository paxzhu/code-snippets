class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{intervals[0][0], intervals[0][1]});
        for(int i = 1; i < intervals.length; i++) {
            int expand_to = ans.get(ans.size()-1)[1];
            int l = intervals[i][0], r = intervals[i][1];

            if(l <= expand_to && expand_to < r){
                ans.get(ans.size()-1)[1] = r;
            }
            else if(l > expand_to) {
                ans.add(new int[]{l, r});
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}