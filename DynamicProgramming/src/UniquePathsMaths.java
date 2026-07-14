public class UniquePathsMaths {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int r = Math.min(m - 1, n - 1);

        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (N - r + i) / i;
        }

        return (int) ans;
    }
}
