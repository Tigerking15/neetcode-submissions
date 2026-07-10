/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int data) { this.data = data; }
 *     TreeNode(int data, TreeNode left, TreeNode right) {
 *         this.data = data;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) 
    {
        if(root == null) return new TreeNode(val);

        TreeNode node = root;

        while(true)
        {
            if(node.val <= val)
            {
                if(node.right != null)
                {
                    node = node.right;
                }
                else
                {
                    node.right = new TreeNode(val);
                    break;
                }
            }
            else
            {
                if(node.left != null)
                {
                    node = node.left;
                }
                else
                {
                    node.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}