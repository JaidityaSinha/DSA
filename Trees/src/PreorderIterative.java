import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return list;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);

            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }

        return list;
    }
}
