import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//피보나치 함수
public class BJ_1003 {
	static int N;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			N = Integer.parseInt(br.readLine());
			dp = new int[N+2][2];		//행 - 0~N까지, 열 - 0, 1 호출 수, 행의 값이 호출됐을때 0,1이 호출되는 횟수를 열에 저장
			
			dp[0][0] = 1; dp[0][1] = 0;
			dp[1][0] = 0; dp[1][1] = 1;
			
			for(int i=2; i<=N; i++) {
				dp[i][0] = dp[i-1][0] + dp[i-2][0];
				dp[i][1] = dp[i-1][1] + dp[i-2][1];
			}
			
			bw.write(dp[N][0] + " " + dp[N][1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

/*
N==0 -> 1 0
N==1 -> 0 1
N==2 -> 1 1
N==3 -> 1 2
N==4 -> 2 3
dp의 행의 크기가 N+2인 이유는 N의 값이 뭐가 들어오던지 N이 0, 1인 경우는 고정이니
N이 2보다 작은 경우를 검사해주는게 아니라 애초에 0,1의 값을 넣는 공간을 확보해준다는 생각으로 N+2
*/