import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//평범한 배낭
public class BJ_12865 {
	static class Knapsack{
		int k, v;

		public Knapsack(int k, int v) {
			super();
			this.k = k;
			this.v = v;
		}
	}
	
	static int N, K;
	static Knapsack[] list;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new Knapsack[N+1];
		dp = new int[N+1][K+1];
		
		list[0] = new Knapsack(0, 0);
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[i] = new Knapsack(k, v); 
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(list[i].k <= j) {
					//현재거를 빼는것 + 현재거를 넣고 남는 kg의 최적해를 우겨넣는게 낫냐 비교
					dp[i][j] = Math.max(dp[i-1][j], list[i].v + dp[i-1][j-list[i].k]);						
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		bw.write(dp[N][K] + "");
		bw.close();
		br.close();
	}
}
