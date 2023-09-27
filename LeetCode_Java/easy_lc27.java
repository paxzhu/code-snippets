//Note: 快慢同向双指针
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 1;
        
        while(fast < nums.length) {
            if(nums[slow] == val) {
                while(fast < nums.length && nums[fast] == val) {
                    fast += 1;
                }
                if(fast == nums.length) {
                    break;
                }
                nums[slow] = nums[fast];
                nums[fast] = val;
            }
            slow += 1;
            fast += 1;
        }
        if(nums[slow] == val) {
            return slow;
        }
        return slow + 1;
    }
}
