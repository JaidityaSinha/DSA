public class InorderSuccessorOfBst {
    public int inOrderSuccessor(TreeNode root, TreeNode k) {
        TreeNode suck = null;

        while (root != null) {
            if (root.val <= k.val)
                root = root.right;
            else {
                suck = root;
                root = root.left;
            }
        }

        return suck != null ? suck.val : -1;
    }
}
