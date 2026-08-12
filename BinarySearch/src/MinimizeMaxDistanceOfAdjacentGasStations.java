package BinarySearch.src;

import java.util.PriorityQueue;

public class MinimizeMaxDistanceOfAdjacentGasStations {
    public double minMaxDist(int[] stations, int k) {
        if (stations.length == 1)
            return 0.00;

        double low = 0, high = -1;

        for (int i = 0; i < stations.length - 1; i++)
            high = Math.max(high, stations[i + 1] - stations[i]);

        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;

            int countGS = (int) countGasStations(stations, mid);
            if (countGS > k)
                low = mid;
            else
                high = mid;
        }

        return high;
    }

    private double countGasStations(int[] stations, double dist) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            int numberInBetween = (int) ((stations[i] - stations[i - 1]) / dist);
            if ((stations[i] - stations[i - 1]) / dist == numberInBetween * dist)
                numberInBetween--;
            count += numberInBetween;
        }

        return count;
    }
}
