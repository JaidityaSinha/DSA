import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintLCS {
    public String lcs( String str1, String str2) {
        int n = str1.length(); int m = str2.length();
        // right shift by 1
        int[][] dp = new int[n + 1][m + 1];

    /*	for (int i = 0; i < n + 1; i++)
            dp[i][0] = 0;

        for (int i = 0; i < m + 1; i++)
            dp[0][i] = 0;   */

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = n; int j = m;
        while (i > 0 && j > 0){
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1])
                i = i - 1;
            else
                j = j - 1;
        }

        return sb.reverse().toString();

    }
}
