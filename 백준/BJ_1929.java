import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//소수 구하기
//에스테라토스테네스의 체 알고리즘
public class BJ_1929 {
	static int M, N;
	static boolean[] isPrime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		isPrime = new boolean[N+1];
		isPrime[1] = true;		//1은 소수가 아님
		
		for(int i=2; i<=N; i++) {
			if(i==1) continue;
			checkNotPrime(i, 2);
		}
	
		
		for(int i=M; i<=N; i++) {
			if(isPrime[i]) continue;	//소수가 아닌 경우
			bw.write(i+"\n");
		}
	
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void checkNotPrime(int num, int cnt) {		//num * cnt는 배수이므로 true 체크
		if(num*cnt > N) {
			return;
		}
		isPrime[num*cnt] = true;
		checkNotPrime(num, cnt+1);
	}
}
