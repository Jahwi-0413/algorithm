import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//빵집
public class BJ_3109 {
	static int R, C;
	static char map[][];
	static int result; // 연결 가능 빵집

	static int[] dr = { -1, 0, 1 }; // right-up, right, right-down
	static int dc = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for(int i=0; i<R; i++) {
			dfs(i, 0, map);
		}
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();

	}

	static boolean dfs(int nr, int nc, char[][] map) {
		map[nr][nc] = '-';
		
		if (nc == C - 1) {
			result++;
			return true;
		}

		for (int j = 0; j < 3; j++) {
			int r = nr + dr[j];
			int c = nc + dc;
			
			if (r >= 0 && c >= 0 && r < R && c < C) {
				if (map[r][c] == '.') { // 건물이거나 이미 파이프를 연결했다면 연결 다른 방법 시도
					boolean res = dfs(r, c, map);
					if(res) return true;
				}
			}
		}
		return false;
	}// end of method
}
