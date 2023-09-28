class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_len = 0, range_len = 0;
        for(int num : nums) {
            if(num == 1) {
                range_len += 1;
                max_len = Math.max(max_len, range_len);
            }
            else {
                range_len = 0;
            }
        }
        return max_len;
    }
}