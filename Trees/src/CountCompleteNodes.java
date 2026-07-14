public class CountCompleteNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if (left == right)
            return (int) (Math.pow(2, left + 1) - 1);

        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }

        return count;
    }

    private int getRightHeight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }

        return count;
    }
}
