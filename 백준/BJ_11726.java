import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2xn 타일링
public class BJ_11726 {
	static int N;
	static long[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dp = new long[N+2];		//1, 2 index는 값을 넣어둘것이기 때문
		
		dp[1] = 1; dp[2] = 2;
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		bw.write((dp[N]) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
