import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    public List<Integer> binaryTreePaths(TreeNode root, int x) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        getPath(root, list, x);

        return list;
    }

    private boolean getPath(TreeNode root, List<Integer> list, int x) {
        if (root == null)
            return false;

        list.add(root.val);
        if (root.val == x)
            return true;

        if (getPath(root.left, list, x) || getPath(root.right, list, x))
            return true;

        list.removeLast();

        return false;
    }

}
