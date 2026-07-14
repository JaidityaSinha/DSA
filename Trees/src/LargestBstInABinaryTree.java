import org.w3c.dom.Node;

public class LargestBstInABinaryTree {
    static class NodeValue {
        int minNode, maxNode, maxSize;

        public NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }
    public int largestBst(TreeNode root) {
        return largestBSTHelper(root).maxSize;
    }

    private NodeValue largestBSTHelper(TreeNode root) {
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);

        if (left.maxNode < root.val && root.val < right.minNode)
            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        else
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,
                    Math.max(left.maxSize, right.maxSize));
    }
}
