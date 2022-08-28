import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M(5)
public class BJ_15654 {
	static int N, M;
	static int[] arr;
	static int[] selectedNums;
	static boolean[] selected;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		selectedNums = new int[M];
		selected = new boolean[N];
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(st.nextToken());
			arr[i] = value;
		}
		Arrays.sort(arr);
		perm(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(selectedNums[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(selected[i]) continue;
			selectedNums[cnt] = arr[i];
			selected[i] = true;
			perm(cnt+1);
			selected[i] = false;
		}
	}
}
