import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABst {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list, 0, k);

        return list.getFirst();
    }

    private void inorder(TreeNode root, List<Integer> list, int count, int k) {
        if (root == null)
            return;

        inorder(root.left, list, count, k);
        count++;
        if (count == k){
            list.add(root.val);
        }
        inorder(root.right, list, count, k);
    }
}
