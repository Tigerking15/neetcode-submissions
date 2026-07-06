class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        if(root == null)
            return inorder;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while(!st.isEmpty()) {

            Pair it = st.pop();

            if(it.num == 1) {

                preorder.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.left != null)
                    st.push(new Pair(it.node.left, 1));

            }
            else if(it.num == 2) {

                inorder.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.right != null)
                    st.push(new Pair(it.node.right, 1));

            }
            else {

                postorder.add(it.node.val);
            }
        }

        return preorder;
    }
}