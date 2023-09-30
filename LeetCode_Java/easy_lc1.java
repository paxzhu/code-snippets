class Solution {
    private int bisect(int[][] nums, IntPredicate predicate) {
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(predicate.test(nums[mid][0])) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (int[] a, int[] b) -> a[0] - b[0]);
        for(int i = 0; i < nums.length; i++) {
            int another = target-nums[i];
            int left = bisect(arr, x -> x < another);
            if(left < nums.length && arr[left][1] != i && arr[left][0] == another) {
                return new int[]{i, arr[left][1]};
            }
        }
        return new int[]{-1, -1};
    }
}