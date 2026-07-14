import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder1Stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode node = stack.peek();

            if (node.right != null && lastVisited != node.right) {
                curr = node.right;
            }
            else {
                list.add(node.val);
                lastVisited = stack.pop();
            }
        }

        return list;
    }
}
