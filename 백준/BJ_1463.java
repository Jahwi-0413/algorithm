import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1로 만들기
public class BJ_1463 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(br.readLine());
		int[] dp = new int[X + 1];

		for (int i = 2; i < X + 1; i++) {
			dp[i] += dp[i - 1] + 1;
			if (i % 2 == 0)
				dp[i] = dp[i] > dp[i / 2] + 1 ? dp[i / 2] + 1 : dp[i];
			if (i % 3 == 0)
				dp[i] = dp[i] > dp[i / 3] + 1 ? dp[i / 3] + 1 : dp[i];
		}

		bw.write(dp[X] + "");
		bw.flush();
		bw.close();
	}
}
