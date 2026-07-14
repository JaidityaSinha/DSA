import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.size();

        int[] prev = new int[n];

        for (int j = 0; j < n; j++) {
            prev[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = i; j >= 0; j--) {
                int up = triangle.get(i).get(j) + prev[j];
                int leftDiag = triangle.get(i).get(j) + prev[j + 1];

                curr[j] = Math.min(up, leftDiag);
            }

            prev = curr;
        }

        return prev[0];
    }

    private int solve(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);

        if (dp[i][j] != null)
            return dp[i][j];

        int down = triangle.get(i).get(j) + solve(i + 1, j, triangle, dp);
        int leftDiag = triangle.get(i).get(j) + solve(i + 1, j + 1, triangle, dp);

        return dp[i][j] = Math.min(down, leftDiag);
    }
}
