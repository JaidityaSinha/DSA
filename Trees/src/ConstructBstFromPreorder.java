public class ConstructBstFromPreorder {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int maxValue) {
        if (i == preorder.length || preorder[i] > maxValue)
            return null;

        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, maxValue);

        return root;
    }

}
