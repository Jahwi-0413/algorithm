package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//알고리즘 수업-피보나치 수 1
public class BJ_24416 {
	static int N, recursiveCnt, dpCnt;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		fibo(N);
		fibonacci(N);
		
		bw.write(recursiveCnt+1 + " " + dpCnt);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int fibo(int n) {
		if(n==1 || n==2) return 1;
		
		recursiveCnt++;
		return fibo(n-1) + fibo(n-2);
	}
	
	static void fibonacci(int n) {
		dp[1] = 1; dp[2] = 1;
		for(int i=3; i<=N; i++) {
			dpCnt++;
			dp[i] = dp[i-1] + dp[i-2];
		}
	}
}
