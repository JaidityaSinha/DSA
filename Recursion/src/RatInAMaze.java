import java.util.ArrayList;
import java.util.Collections;

public class RatInAMaze {
    ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> ratInMaze(int[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze.length];
        StringBuilder sb = new StringBuilder();
        if (maze[0][0] == 1)
            dfs(0, 0, maze, sb, visited);

        Collections.sort(result);

        return result;
    }

    private void dfs(int x, int y, int[][] maze, StringBuilder sb, boolean[][] visited) {

        if (x == maze.length - 1 && y == maze.length - 1) {
            result.add(sb.toString());
            return;
        }

        visited[x][y] = true;

        if (x + 1 < maze.length && !visited[x + 1][y] && maze[x + 1][y] == 1) {
            sb.append("D");
            dfs(x + 1, y, maze, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (x - 1 >= 0 && !visited[x-1][y] && maze[x-1][y] == 1) {
            sb.append("U");
            dfs(x - 1, y, maze, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (y-1 >= 0 && !visited[x][y-1] && maze[x][y-1] == 1) {
            sb.append("L");
            dfs(x, y - 1, maze, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (y+1 < maze.length && !visited[x][y+1] && maze[x][y+1] == 1) {
            sb.append("R");
            dfs(x, y + 1, maze, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
        }

        visited[x][y] = false;
    }
}
