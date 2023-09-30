class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = bisect(nums, x -> x < target);
        int right = bisect(nums, x -> x <= target) - 1;

        if (left <= right) {
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }

    private int bisect(int[] nums, Predicate<Integer> predicate) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(predicate.test(nums[mid])) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}
