public class ChildrenSumProperty {
    public boolean isSumProperty(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return true;

        int left = 0;
        int right = 0;

        if (root.left != null)
            left = root.left.val;
        if (root.right != null)
            right = root.right.val;


        if (root.val != left + right)
            return false;

        return isSumProperty(root.left) && isSumProperty(root.right);
    }
}
