import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이항 계수
public class BJ_11050 {
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int result = biominal(N, K);
		
		bw.write(result + "");
		bw.close();
		br.close();
	}
	
	static int biominal(int n, int k) {
		if(k==0 || k==n) {
			return 1;
		}
		return biominal(n-1, k-1) + biominal(n-1, k);
	}
}
