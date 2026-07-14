import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeAndDeSerialiseTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr == null) {
                sb.append("n ");
                continue;
            }

            sb.append(curr.val).append(" ");
            queue.add(curr.left);
            queue.add(curr.right);

        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (Objects.equals(data, ""))
            return null;

        Queue<TreeNode> queue = new ArrayDeque<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        queue.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.remove();

            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }

            i++;

            if (!values[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }

        }

        return root;
    }
}
