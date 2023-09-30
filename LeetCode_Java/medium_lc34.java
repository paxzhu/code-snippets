class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = bisect(nums, target, true);
        int right = bisect(nums, target, false) - 1;

        if (left <= right) {
            return new int[]{left, right};
        } 
        else {
            return new int[]{-1, -1};
        }
    }

    private int bisect(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (isFirst && nums[mid] == target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
