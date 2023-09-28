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

/**
cur_layer --> nxt_layer
get cur_vals and update nxt_layer in cur-layer
time complexity(depends on the number of nodes): O(n)
space complexity: O(n)
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> cur_vals = new ArrayList<>();
            List<TreeNode> nxt_layer = new ArrayList<>();
            for(TreeNode node: queue) {
                cur_vals.add(node.val);
                if(node.left != null) {
                    nxt_layer.add(node.left);
                }
                if(node.right != null) {
                    nxt_layer.add(node.right);
                }
            }
            ans.add(cur_vals);
            queue = nxt_layer;
        }
        return ans;
    }
}