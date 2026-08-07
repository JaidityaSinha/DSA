package BinarySearch.src;

public class FindNthRootOfAnInteger {
    public int nthRoot(int n, int m) {
        int low = 1, high = m;

        if (m == 0)
            return 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midN = pow(mid, n, m);

            if (midN == 1)
                return mid;
            else if (midN == 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    private int pow(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m)
                return 2;
        }

        if (ans == m)
            return 1;
        return 0;
    }
}
