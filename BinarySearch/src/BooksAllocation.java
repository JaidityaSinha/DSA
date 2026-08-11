package BinarySearch.src;

public class BooksAllocation {
    public int findPages(int[] arr, int k) {
        if (k > arr.length)
            return -1;

        long low = -1;
        long high = 0;

        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;

            int countStudents = countStuds(arr, mid);

            if (countStudents <= k) {
                high = mid - 1;
            }
            else
                low = mid + 1;
        }

        return (int)low;
    }

    private int countStuds(int[] arr, long pages) {
        int students = 1;
        int pagesStudent = 0;

        for (int book : arr) {
            if (pagesStudent + book <= pages)
                pagesStudent += book;
            else {
                students++;
                pagesStudent = book;
            }
        }

        return students;
    }
}
