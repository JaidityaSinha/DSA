public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];

        for(int i = 0; i < m; i++) {
            int[] temp = new int[n];
            temp[0] = 1;

            for(int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;

                int up = 0, left = 0;

                if (i > 0)
                    up = prev[j];

                if (j > 0)
                    left = temp[j - 1];


                temp[j] = up + left;
            }

            prev = temp;
        }

        return prev[n-1];
    }
}
