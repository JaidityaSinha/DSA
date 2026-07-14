import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {
    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        boolean[][] visited = new boolean[m][n];
        int startColor = image[sr][sc];

        bfs(new Node(sr, sc), visited, startColor, m, n, image, color);

        return image;
    }

    private void bfs(Node node, boolean[][] visited, int startColor,
                     int m, int n, int[][] image, int color) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node.x][node.y] = true;
        image[node.x][node.y] = color;

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            image[curr.x][curr.y] = color;

            if (curr.x > 0) {
                if (image[curr.x - 1][curr.y] == startColor && !visited[curr.x - 1][curr.y]) {
                    visited[curr.x - 1][curr.y] = true;
                    queue.add(new Node(curr.x - 1, curr.y));
                }
            }

            if (curr.x < m - 1) {
                if (image[curr.x + 1][curr.y] == startColor && !visited[curr.x + 1][curr.y]) {
                    visited[curr.x + 1][curr.y] = true;
                    queue.add(new Node(curr.x + 1, curr.y));
                }
            }

            if (curr.y > 0) {
                if (image[curr.x][curr.y - 1] == startColor && !visited[curr.x][curr.y - 1]) {
                    visited[curr.x][curr.y - 1] = true;
                    queue.add(new Node(curr.x, curr.y - 1));
                }
            }


            if (curr.y < n - 1) {
                if (image[curr.x][curr.y + 1] == startColor && !visited[curr.x][curr.y + 1]) {
                    visited[curr.x][curr.y + 1] = true;
                    queue.add(new Node(curr.x, curr.y + 1));
                }
            }
        }
    }
}
