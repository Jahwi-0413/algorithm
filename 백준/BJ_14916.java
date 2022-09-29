import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//거스름돈
public class BJ_14916 {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp = new int [N+1];
		
		if(N>=2) dp[2] = 1;
		if(N>=5) dp[5] = 1;
		
		for(int i=1; i<=N; i++) {
			if(dp[i]==0) continue;
			if(i+2<= N) {
				if(dp[i+2] > dp[i] + 1) dp[i+2] = dp[i] + 1;		//2원짜리를 더하는게 더 최소일 경우
				else if(dp[i+2]==0) dp[i+2]= dp[i]+1;				
			}
			if(i+5 <= N) {
				if(dp[i+5] > dp[i] + 5) dp[i+5] = dp[i] + 1;		//5원짜리를 더하는게 더 최소일 경우
				else if(dp[i+5]==0) dp[i+5]=dp[i]+1;				
			}
		}
		
		if(dp[N]==0)
			bw.write("-1");
		else
			bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
