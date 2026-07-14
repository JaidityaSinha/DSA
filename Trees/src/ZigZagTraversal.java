import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null)
            return list;

        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<>();
            int level = queue.size();
            height++;

            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.remove();

                if (height % 2 != 0)
                    subList.add(curr.val);
                if (height % 2 == 0)
                    subList.addFirst(curr.val);


                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }

            list.add(subList);
        }

        return list;
    }
}
