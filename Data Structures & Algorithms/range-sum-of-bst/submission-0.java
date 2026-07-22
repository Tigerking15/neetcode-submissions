class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list);

        int sum = 0;

        for (int val : list) {
            if (val >= low && val <= high) {
                sum += val;
            }
        }

        return sum;
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}