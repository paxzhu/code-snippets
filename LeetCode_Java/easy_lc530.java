/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min_abs = Integer.MAX_VALUE;
    int pre = -(Integer.MAX_VALUE);
    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return -1;
        }
        getMinimumDifference(root.left);
        if(pre == -(Integer.MAX_VALUE)) {
            pre = root.val;
        }
        else {
            min_abs = Math.min(min_abs, root.val - pre);
            pre = root.val;
        }
        getMinimumDifference(root.right);
        return min_abs;
    }
}