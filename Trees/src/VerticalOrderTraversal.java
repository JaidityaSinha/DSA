import java.util.*;

public class VerticalOrderTraversal {
static class Triad {
    TreeNode node;
    int vertical;
    int level;

    public Triad(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Triad> queue = new ArrayDeque<>();

        if (root == null)
            return new ArrayList<>();

        queue.add(new Triad(root, 0, 0));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            Triad curr = queue.remove();

            if (!map.containsKey(curr.vertical))
                map.put(curr.vertical, new TreeMap<>());
            if (!map.get(curr.vertical).containsKey(curr.level))
                map.get(curr.vertical).put(curr.level, new PriorityQueue<>());

            map.get(curr.vertical).get(curr.level).add(curr.node.val);


            if (curr.node.left != null) {
                queue.add(new Triad(curr.node.left, curr.vertical - 1, curr.level + 1));
            }
            if (curr.node.right != null) {
                queue.add(new Triad(curr.node.right, curr.vertical + 1, curr.level + 1));
            }

        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> verticals : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : verticals.values()) {
                while (!nodes.isEmpty()) {
                    list.getLast().addLast(nodes.remove());
                }
            }
        }

        return list;

    }
}
