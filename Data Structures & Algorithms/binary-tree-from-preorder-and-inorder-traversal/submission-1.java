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
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
       if(inorder==null || preorder==null || inorder.length!=preorder.length)
       {
        return null;
       } 

       HashMap<Integer,Integer> hm = new HashMap<>();

       for(int i=0;i<inorder.length;i++)
       {
        hm.put(inorder[i],i);
       }

       return buildprein(inorder,0,inorder.length-1,preorder,0,preorder.length-1,hm);
    }

    private TreeNode buildprein(int []inorder,int is,int ie,int [] preorder, int ps, int pe, HashMap<Integer,Integer> hm)
    {
        if(ps>pe || is>ie)
        {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);

        int inRoot= hm.get(preorder[ps]);
        int numsleft= inRoot-is;

        root.left= buildprein(inorder,is,inRoot-1,preorder,ps+1,ps+numsleft,hm);
        root.right= buildprein(inorder,inRoot+1,ie,preorder,ps+numsleft+1,pe,hm);

        return root;
    }
}
