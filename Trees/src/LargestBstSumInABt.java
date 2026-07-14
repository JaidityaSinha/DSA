public class LargestBstSumInABt {
    static class NodeValue {
        int minNode, maxNode, sum;

        public NodeValue(int minNode, int maxNode, int sum) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.sum = sum;
        }
    }

    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        largestBSTHelper(root);
        return maxSum;
    }

    private NodeValue largestBSTHelper(TreeNode root) {
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);

        if (left.maxNode < root.val && root.val < right.minNode) {
            int currSum = left.sum + right.sum + root.val;

            maxSum = Math.max(maxSum, currSum);

            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                    currSum);
        }
        else
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}
