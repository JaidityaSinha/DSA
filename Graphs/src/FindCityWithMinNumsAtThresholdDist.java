import java.util.Arrays;

public class FindCityWithMinNumsAtThresholdDist {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            int weight = edge[2];
            dist[i][j] = weight;
            dist[j][i] = weight; // Bidirectional graph
        }

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] != (int) 1e9 && dist[k][j] != (int) 1e9)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);


        int cityCountMax = n + 1;
        int city = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold)
                    count++;
            }

            if (count <= cityCountMax) {
                cityCountMax = count;
                city = i;
            }
        }

        return city;
    }
}
