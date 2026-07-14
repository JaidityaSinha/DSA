public class FloorInABst {
    public int findMaxFork(TreeNode root, int k) {
        int ans = -1;

        while (root != null) {
            if (root.val == k)
                return root.val;

            else if (root.val < k) {
                ans = root.val;
                root = root.right;
            }

            else {
                root = root.left;
            }
        }

        return ans;
    }
}
