import java.util.Arrays;

public class EvaluateBooleanExpressionToTrue {
    public int countWays(String s) {
        int n = s.length();

        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'T')
                dp[i][i][1] = 1;
            else
                dp[i][i][1] = 0;

            if (s.charAt(i) == 'F')
                dp[i][i][0] = 1;
            else
                dp[i][i][0] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    int ways = 0;

                    for (int index = i + 1; index <= j - 1; index += 2) {
                        int leftTrue = dp[i][index - 1][1];
                        int leftFalse = dp[i][index - 1][0];

                        int rightTrue = dp[index + 1][j][1];
                        int rightFalse = dp[index + 1][j][0];

                        if (s.charAt(index) == '&')
                            if (isTrue == 1)
                                ways += leftTrue * rightTrue;
                            else
                                ways += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);

                        else if (s.charAt(index) == '|') {
                            if (isTrue == 1)
                                ways += (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                            else
                                ways += leftFalse * rightFalse;
                        }

                        else if (s.charAt(index) == '^')
                            if (isTrue == 1)
                                ways += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                            else
                                ways += (leftTrue * rightTrue) + (leftFalse * rightFalse);

                    }

                    dp[i][j][isTrue] = ways;
                }
            }
        }

        return dp[0][n - 1][1];
    }


}
