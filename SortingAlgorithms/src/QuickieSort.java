package SortingAlgorithms.src;

public class QuickieSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end)
            return;

        // Partition
        int boundary =  partition(array, start, end);
        // Sort left
        sort(array, start, boundary - 1);
        // Sort right
        sort(array, boundary + 1, end);
    }

    private int partition(int[] array, int start, int end) { // The int we return is the index of the pivot
        int pivot = array[end];
        int boundary = start - 1;

        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                swap(array, i, ++boundary);
            }
        }

        return boundary;
    }

    private void swap(int[] array, int i, int boundary) {
        int temp = array[i];
        array[i] = array[boundary];
        array[boundary] = temp;
    }
}
