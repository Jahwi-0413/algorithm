import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//피보나치 수 2
public class BJ_2748 {
	static int N;
	static long[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		dp = new long[N+1];
		fibo(N);
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long fibo(int n) {
		if(n==0) return dp[0] = 0;
		if(n==1) return dp[1] = 1;
		
		if(dp[n]!=0) return dp[n];
		return dp[n] = fibo(n-1) + fibo(n-2);
	}
}
