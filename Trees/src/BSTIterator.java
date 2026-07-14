import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {
    private final Stack<TreeNode> stack = new Stack<>();
    private boolean reverse = true;
    
    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if (!reverse)
            pushAll(node.right);
        else
            pushAll(node.left);

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);

            if (reverse)
                root = root.right;
            else
                root = root.left;
        }
    }
}
