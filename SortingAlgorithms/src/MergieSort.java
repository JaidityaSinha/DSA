package SortingAlgorithms.src;

public class MergieSort {
    public void sort(int[] arr) {
        if (arr.length < 2)
            return;

        // Divide this array into half
        var middle = arr.length/2;

        int[] left = new int[middle];
        for (int i = 0; i < middle; i++)
            left[i] = arr[i];

        int[] right = new int[arr.length - middle];
        for (int i = middle; i < arr.length ; i++) {
            right[i-middle] = arr[i];
        }

        // Sort each half
        sort(left);
        sort(right);

        // Merge result
        merge(left, right, arr);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0; // i for iterating over left partition; j for right and k to iterate over the result array.

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }
}
