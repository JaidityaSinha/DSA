public class BubbleSort {
    public void sort(int[] array) {

        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++)
                if (array[j - 1] > array[j]) {
                    swap(array, j);
                    isSorted = false;
                }
            if (isSorted)
                return;
        }
    }

    private void swap(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
    }
}
