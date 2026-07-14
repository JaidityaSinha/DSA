import java.util.*;

public class TopViewOfBinaryTree {
    static class Duo {
        TreeNode treeNode;
        int vertical;

        public Duo(TreeNode treeNode, int vertical) {
            this.treeNode = treeNode;
            this.vertical = vertical;
        }
    }
    public ArrayList<Integer> topView(TreeNode root) {
        Queue<Duo> queue = new ArrayDeque<>();
        TreeMap<Integer, TreeNode> map = new TreeMap<>();

        queue.add(new Duo(root, 0));

        while (!queue.isEmpty()) {
            Duo curr = queue.remove();

            if (!map.containsKey(curr.vertical))
                map.put(curr.vertical, curr.treeNode);

            if (curr.treeNode.left != null)
                queue.add(new Duo(curr.treeNode.left, curr.vertical - 1));

            if (curr.treeNode.right != null)
                queue.add(new Duo(curr.treeNode.right, curr.vertical + 1));
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (TreeNode node : map.values())
                if (node != null)
                    list.addLast(node.val);

        return list;
    }
}
