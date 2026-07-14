public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);

        return max;
    }

    private int getMaxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        int ls = Math.max(0, getMaxPathSum(root.left));
        int rs = Math.max(0, getMaxPathSum(root.right));

        max = Math.max(max, ls + rs + root.val);

        return root.val + Math.max(ls, rs);
    }
}
