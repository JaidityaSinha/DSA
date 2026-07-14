import java.util.ArrayList;
import java.util.List;

public class RootToLeavesPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        getPaths(root, new ArrayList<>(), list);

        return list;
    }

    private void getPaths(TreeNode root, List<Integer> path, List<String> list) {
        if (root == null)
            return;

        path.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < path.size(); i++) {
                if (i != path.size() - 1)
                    sb.append(path.get(i)).append("->");
                else
                    sb.append(path.get(i));
            }

            list.add(sb.toString());
        }

        getPaths(root.left, path, list);
        getPaths(root.right, path, list);

        path.removeLast(); // backtrack
    }
}
