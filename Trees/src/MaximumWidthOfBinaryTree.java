import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int ans = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int level = queue.size();
            int first = 0, last = 0;

            for (int i = 0; i < level; i++) {
                int currIndex = queue.peek().index;
                TreeNode node = queue.peek().node;

                queue.remove();

                if (i == 0)
                    first = currIndex;
                if (i == level - 1)
                    last = currIndex;

                if (node.left != null)
                    queue.add(new Pair(node.left, currIndex * 2 + 1));
                if (node.right != null)
                    queue.add(new Pair(node.right, currIndex * 2 + 2));
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}
