public class SelectionSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = findMinIndex(array, i);
            swap(array, i, minIndex);
        }
    }

    private void swap(int[] array, int i, int minIndex) {
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }


    private int findMinIndex(int[] array, int startingIndex) {
        int minIndex = startingIndex;
        for (int j = startingIndex; j < array.length; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        return minIndex;
    }
}
