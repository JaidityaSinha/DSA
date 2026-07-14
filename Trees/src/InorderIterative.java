import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return list;

        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }

            else {
                if (stack.isEmpty())
                    break;

                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }

        return list;
    }
}
