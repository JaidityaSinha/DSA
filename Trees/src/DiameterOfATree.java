public class DiameterOfATree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return max;
    }

    private int findMax(TreeNode node) {
        if (node == null)
            return 0;

        int lh = findMax(node.left);
        int rh = findMax(node.right);

        max = Math.max(max, lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
