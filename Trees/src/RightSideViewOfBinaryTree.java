import java.util.ArrayList;
import java.util.List;

public class RightSideViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightView(root, 0, list);

        return list;
    }

    private void rightView(TreeNode node, int level, List<Integer> list) {
        if (node == null)
            return;

        if (level == list.size())
            list.add(node.val);

        rightView(node.right, level + 1, list);
        rightView(node.left, level + 1, list);
    }
}
