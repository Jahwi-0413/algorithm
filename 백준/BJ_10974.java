import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//모든 순열
public class BJ_10974 {
	static int N;
	static int[] arr;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		selected = new boolean[N+1];
		
		perm(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void perm(int depth) {
		if(depth==N) {
			for(int i=0; i<N; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(selected[i]) continue;
			arr[depth] = i;
			
			selected[i] = true;
			perm(depth+1);
			selected[i] = false;
		}
	}
}
