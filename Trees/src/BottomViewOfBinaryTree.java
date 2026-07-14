import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {
    static class Pair {
        TreeNode node;
        int vertical;

        public Pair(TreeNode node, int vertical) {
            this.node = node;
            this.vertical = vertical;
        }
    }
    public ArrayList<Integer> bottomView(TreeNode root) {
        Queue<Pair> queue = new ArrayDeque<>();
        TreeMap<Integer, TreeNode> map = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            var curr = queue.remove();

            if (!map.containsKey(curr.vertical))
                map.put(curr.vertical, curr.node);
            else
                map.replace(curr.vertical, curr.node);

            if (curr.node.left != null)
                queue.add(new Pair(curr.node.left, curr.vertical - 1));
            if (curr.node.right != null)
                queue.add(new Pair(curr.node.right, curr.vertical + 1));
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (var vertical : map.keySet())
            list.add(map.get(vertical).val);

        return list;
    }
}
