import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

//점화식
public class BJ_13699 {
	static int N;
	static BigInteger[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp = new BigInteger[36];
		dp[0] = BigInteger.ONE;
		
		for(int i=1; i<=N; i++) {
			func(i);
		}
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void func(int n) {
		BigInteger res = BigInteger.ZERO;
		for(int i=0; i<n; i++) {
			BigInteger multiply = dp[i].multiply(dp[n-i-1]);
			res = res.add(multiply);
		}
		dp[n] = res;
	}
}
