import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

//피보나치 수 4
public class BJ_10826 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		BigInteger[] dp = new BigInteger[N+1];
		dp[0] = BigInteger.ZERO;
		if(N > 0)
			dp[1] = BigInteger.ONE;
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
