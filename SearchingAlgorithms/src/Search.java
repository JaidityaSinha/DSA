public class Search {
    public int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == target)
                return i;

        return -1;
    }

    public int binarySearchRec(int[] array, int target) {
       return binarySearchRec(array, target, 0, array.length - 1);
    }

    private int binarySearchRec(int[] array, int target, int left, int right) {

        if (right < left)
            return -1;

        int middle = (left + right) / 2;

        if (array[middle] == target)
            return middle;

        if (array[middle] > target)
            binarySearchRec(array, target, left, middle - 1);

        return binarySearchRec(array, target, middle + 1, right);

    }

    public int binarySearchItr(int[] array, int target) {
        int left =  0;
        int right = array.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (array[middle] == target)
                return middle;

            if (array[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }

    public int ternarySearch(int[] array, int target) {
        return ternarySearch(array, target, 0, array.length - 1);
    }

    private int ternarySearch(int[] array, int target, int left, int right) {
        if (right < left)
            return -1;

        int middle1 = left + (right - left) / 3;
        int middle2 = right - (right - left) / 3;

        if (array[middle1] == target)
            return middle1;
        if (array[middle2] == target)
            return middle2;

        if (target < array[middle1])
            return ternarySearch(array, target, left, middle1 - 1);

        if (target > array[middle2])
            return ternarySearch(array, target, middle2 + 1, right);

        return ternarySearch(array, target, middle1 + 1, middle2 - 1);

    }

    public int jumpSearch(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;

        while (start < array.length && array[next - 1] < target) {
            start = next;

            next += blockSize;
            if (next > array.length)
                next = array.length;
        }

        for (int i = start; i < next; i++)
            if (array[i] == target)
                return i;

        return -1;
    }

    public int exponentialSearch(int[] array, int target) {
        var bound = 1;
        while (bound < array.length && target > array[bound]) {
            bound *= 2;  // double bound everytime
        }

        // run binary search from bound/2 to bound
        return binarySearchRec(array, target, bound / 2, Math.min(bound, array.length - 1));
    }
}
