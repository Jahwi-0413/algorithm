import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//N과 M(4)
public class BJ_15652 {
	static int N, M;
	static int[] selected;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M];
		sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			selected[0] = i;
			perm(1);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(selected[cnt-1] <= i) {
				selected[cnt] = i;
				perm(cnt + 1);
			}
		}
	}
}