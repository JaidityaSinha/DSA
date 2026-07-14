import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class TimeTakenToBurnABinaryTreeFromANode {
    static class Pair {
        TreeNode targetNode;
        int numOfNodes;

        public Pair(TreeNode targetNode, int numOfNodes) {
            this.targetNode = targetNode;
            this.numOfNodes = numOfNodes;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Pair pair = parentMapping(root, parentMap, start);

        TreeNode targetNode = pair.targetNode;
        int numOfNodes = pair.numOfNodes;

        int time = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();

        queue.add(targetNode);
        visited.put(targetNode, true);

        while (!queue.isEmpty()) {
            int level = queue.size();
            if (visited.size() == numOfNodes)
                break;

            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.remove();

                if (curr.left != null && !visited.containsKey(curr.left)) {
                    queue.add(curr.left);
                    visited.put(curr.left, true);
                }

                if (curr.right != null && !visited.containsKey(curr.right)) {
                    queue.add(curr.right);
                    visited.put(curr.right, true);
                }

                if (parentMap.containsKey(curr) && !visited.containsKey(parentMap.get(curr)))  {
                    queue.add(parentMap.get(curr));
                    visited.put(parentMap.get(curr), true);
                }
            }
            time++;
        }


        return time;
    }

    private Pair parentMapping(TreeNode root, Map<TreeNode, TreeNode> parentMap, int target) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        TreeNode targetNode = null;
        int numOfNodes = 0;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            numOfNodes++;

            if (curr.val == target)
                targetNode = curr;

            if (curr.left != null) {
                queue.add(curr.left);
                parentMap.put(curr.left, curr);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                parentMap.put(curr.right, curr);
            }

        }

        return new Pair(targetNode, numOfNodes);
    }
}
