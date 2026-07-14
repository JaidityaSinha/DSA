public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;

        prev[0] = 1;

        for(int i = 0; i < m; i++) {
            int[] temp = new int[n];
            temp[0] = 1;

            for(int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (obstacleGrid[i][j] == 1){
                    temp[j] = 0;
                    continue;
                }

                int up = 0, left = 0;

                if (i > 0)  up = prev[j];
                if (j > 0)  left = temp[j - 1];

                temp[j] = up + left;
            }

            prev = temp;
        }

        return prev[n-1];
    }
}
