import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//숫자판 점프
public class BJ_2210 {
	static int[][] map;
	static Set<String> result;
	static int[] selected;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		map = new int[5][5];
		result = new HashSet<>();
		selected = new int[6];
		
		for (int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
			}
		}
		
		for (int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				dfs(0, i, j);
			}
		}
		bw.write(result.size() + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int depth, int r, int c) {
		if(depth==6) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<6; i++) {
				sb.append(selected[i]);
			}
			result.add(sb.toString());
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isValidPosition(nr, nc)) {
				selected[depth] = map[nr][nc];
				dfs(depth+1, nr, nc);
			}
		}
	}
	
	static boolean isValidPosition(int r, int c) {
		return 0<=r && r<5 && 0<=c && c<5;
	}
}
