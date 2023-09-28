class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_len = 0, range_len = 0;
        for(int num : nums) {
            if(num == 1) {
                range_len += 1;
            }
            else {
                max_len = Math.max(max_len, range_len);
                range_len = 0;
            }
        }
        max_len = Math.max(max_len, range_len);
        return max_len;
    }
}