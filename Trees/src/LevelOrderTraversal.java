import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.remove();

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);

                subList.add(curr.val);
            }

            result.add(subList);
        }

        return result;
    }
}
