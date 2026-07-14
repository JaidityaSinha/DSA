import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder2Stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if (root == null)
            return list;

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);

            if (curr.left != null)
                stack1.push(curr.left);
            if (curr.right != null)
                stack1.push(curr.right);
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }

        return list;
    }
}
