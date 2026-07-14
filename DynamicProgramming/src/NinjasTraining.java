public class NinjasTraining {
    public int maximumPoints(int[][] mat) {
        int[] prev = new int[4];

        prev[0] = Math.max(mat[0][1], mat[0][2]);
        prev[1] = Math.max(mat[0][0], mat[0][2]);
        prev[2] = Math.max(mat[0][0], mat[0][1]);
        prev[3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));

        for (int day = 1; day < mat.length; day++) {
            int[] temp = new int[4];
            for (int last = 0; last <= 3; last++) {
                temp[last] = 0;
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = mat[day][task] + prev[task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }

            }

            prev = temp;
        }

        return prev[3];
    }
}
