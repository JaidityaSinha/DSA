package Greedy;

public class Candy {
    public int candy(int[] ratings) {
        int candy = 1;
        int i = 1;

        int n = ratings.length;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                candy++;
                i++;
                continue;
            }

            int peak = 1;

            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                candy += peak;
                i++;
            }

            int down = 1;

            while (i < n && ratings[i] < ratings[i - 1]) {
                candy += down;
                i++;
                down++;
            }

            if (down > peak)
                candy += down - peak;
        }
        
        return candy;
    }
}
