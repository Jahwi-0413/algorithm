import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//N과 M(3)
//System.out.println -> bufferedWriter, stringbuilder로 바꾸니까 시간 통과
public class BJ_15651 {
	static int[] selectedNum;
	static int N, M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selectedNum = new int[M];
		sb = new StringBuilder();
		
		comb(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void comb(int cnt) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(selectedNum[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			selectedNum[cnt] = i+1;
			comb(cnt+1);
		}
	}
}
