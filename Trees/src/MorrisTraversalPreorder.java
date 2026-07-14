import java.util.ArrayList;
import java.util.List;

public class MorrisTraversalPreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            }

            else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                if (prev.right == null) {
                    prev.right = curr;
                    list.add(curr.val);
                    curr = curr.left;
                }

                else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }

        return list;
    }
}
