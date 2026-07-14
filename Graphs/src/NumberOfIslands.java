import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(new Node(i,j), visited, m, n, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(Node node, boolean[][] visited, int m, int n, char[][] grid) {
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);
        visited[node.x][node.y] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.remove();

            if (curr.x > 0) {
                if (grid[curr.x - 1][curr.y] == '1' && !visited[curr.x - 1][curr.y]) {
                    visited[curr.x - 1][curr.y] = true;
                    queue.add(new Node(curr.x - 1, curr.y));
                }
            }


            if (curr.x < m - 1) {
                if (grid[curr.x + 1][curr.y] == '1' && !visited[curr.x + 1][curr.y]) {
                    visited[curr.x + 1][curr.y] = true;
                    queue.add(new Node(curr.x + 1, curr.y));
                }
            }


            if (curr.y > 0) {
                if (grid[curr.x][curr.y - 1] == '1' && !visited[curr.x][curr.y - 1]) {
                    visited[curr.x][curr.y - 1] = true;
                    queue.add(new Node(curr.x, curr.y - 1));
                }
            }


            if (curr.y < n - 1) {
                if (grid[curr.x][curr.y + 1] == '1' && !visited[curr.x][curr.y + 1]) {
                    visited[curr.x][curr.y + 1] = true;
                    queue.add(new Node(curr.x, curr.y + 1));
                }
            }
        }
    }
}
