import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//RGB 거리
public class BJ_1149 {
	static int N;
	static int [][] dp;
	
	static int red=1, green=2, blue=3; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j=1; j<=3; j++) {
				int value = Integer.parseInt(st.nextToken());
				dp[i][j] = value;
			}
		}
		
		for(int i=2; i<=N; i++) {
			dp[i][red] += Math.min(dp[i-1][green], dp[i-1][blue]);
			dp[i][green] += Math.min(dp[i-1][red], dp[i-1][blue]);
			dp[i][blue] += Math.min(dp[i-1][red], dp[i-1][green]);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=3;i++) {
			if(dp[N][i] < min) {
				min = dp[N][i];
			}
		}
		
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
