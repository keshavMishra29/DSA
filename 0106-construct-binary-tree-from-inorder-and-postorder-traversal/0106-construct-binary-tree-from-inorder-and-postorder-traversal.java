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
    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        // Store inorder indices
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        // start form last postorder
        postIndex = n - 1;
        return helper(inorder, postorder, 0, n - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
        // base case
        if (left > right) {
            return null;
        }
        // Create root
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Inorder position 
        int index = map.get(rootVal);

        // Right first
        root.right = helper(inorder, postorder, index + 1, right);

        // Right last
        root.left = helper(inorder, postorder, left, index - 1);

        return root;
    }
}