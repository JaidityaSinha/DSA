public class CountingSort {
    public void sort(int[] array) {
        int max = getMax(array);
        int[] countArray = new int[max+1];

        for (int item : array) {
            countArray[item]++;
        }

        int k = 0;
        for (int i = 0; i < countArray.length; i++)
            for (int j = 0; j < countArray[i]; j++)
                array[k++] = i;
    }

    private int getMax(int[] array) {
        int max = 0;
        for (int number : array) {
            if (number > max)
                max = number;
        }

        return max;
    }
}
