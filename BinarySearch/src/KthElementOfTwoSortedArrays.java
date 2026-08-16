package BinarySearch.src;

public class KthElementOfTwoSortedArrays {
    public int kthElement(int[] a, int[] b, int k) {
        int n = a.length;
        int m = b.length;
        int len = n + m;

        if (n > m)
            return kthElement(b, a, k);

        int low = Math.max(k - m, 0), high = Math.min(k, n);
        int left = k;

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n)
                r1 = a[mid1];
            if (mid2 < m)
                r2 = b[mid2];
            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid2 - 1];

            if (l1 <= r2 && l2 <= r1)
                return Math.max(l1, l2);

            else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }

        return 0;
    }
}
