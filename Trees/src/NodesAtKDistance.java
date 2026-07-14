import java.util.*;

public class NodesAtKDistance {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMapping(root, parentMap);

        Map<TreeNode, Boolean> visited = new HashMap<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(target);
        visited.put(target, true);

        int distance = 0;

        while (!queue.isEmpty()) {
            int level = queue.size();
            if (distance == k)
                break;

            distance++;

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
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty())
            list.add(queue.remove().val);

        return list;
    }

    private void parentMapping(TreeNode root, HashMap<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            if (curr.left != null) {
                queue.add(curr.left);
                parentMap.put(curr.left, curr);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                parentMap.put(curr.right, curr);
            }

        }
    }
}
