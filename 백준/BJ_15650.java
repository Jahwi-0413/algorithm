import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N과 M(2)
public class BJ_15650 {
	static int[] selectedNum;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");;
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		selectedNum = new int[M];
		
		comb(0, 0);
	}
	
	static void comb(int cnt, int start) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				System.out.print(selectedNum[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<N; i++) {
			selectedNum[cnt] = i+1;
			comb(cnt+1, i+1);
		}
	}
}
