import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidateABst {
    public boolean isValidBST(TreeNode root) {
        return checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkValid(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        return checkValid(root.left, min, root.val) && checkValid(root.right, root.val, max);
    }
}
