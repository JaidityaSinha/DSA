import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPostInOneTraversal {
    static class Pair {
        TreeNode node;
        int frequency;

        public Pair(TreeNode node, int frequency) {
            this.node = node;
            this.frequency = frequency;
        }
    }

    public void preInPostTraversal(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null)
            return;

        while (!stack.isEmpty()) {
            Pair it = stack.pop();

            if (it.frequency == 1) {
                pre.add(it.node.val);
                it.frequency++;
                stack.push(it);

                if (it.node.left != null)
                    stack.push(new Pair(it.node.left, 1));
            }

            else if (it.frequency == 2) {
                in.add(it.node.val);
                it.frequency++;
                stack.push(it);

                if (it.node.right != null)
                    stack.push(new Pair(it.node.right, 1));
            }

            else {
                post.add(it.node.val);
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
}
