public class CeilInABst {
    int findCeil(TreeNode root, int x) {
        int ceil = -1;

        while (root != null) {
            if (root.val == x) {
                ceil = root.val;
                return ceil;
            }
            if (x > root.val) {
                root = root.right;
            }

            if (x < root.val) {
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;
    }
}
