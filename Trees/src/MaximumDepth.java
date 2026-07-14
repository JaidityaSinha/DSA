import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);


        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int maxDepthItr(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int level = queue.size();
            height++;

            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.remove();

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }


        return height;
    }
}
