import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//적록색약
public class BJ_10026 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int resultRgb, resultNotRgb;
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					seeRGB(i, j, map[i][j]);
					resultRgb++;
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					seeRB(i, j, map[i][j]);
					resultNotRgb++;
				}
			}
		}
		
		System.out.println(resultRgb + " " + resultNotRgb);
	}

	static void seeRGB(int r, int c, char rgb) {
		int tmpR = r, tmpC = c;

		for (int i = 0; i < 4; i++) {
			int nr = tmpR + dr[i];
			int nc = tmpC + dc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (!visited[nr][nc] && map[nr][nc] == rgb) { // 방문하지 않은 같은 색깔 영역에
					visited[nr][nc] = true;
					seeRGB(nr, nc, rgb);
				}
			}
		}
	}

	static void seeRB(int r, int c, char rgb) {
		int tmpR = r, tmpC = c;

		for (int i = 0; i < 4; i++) {
			int nr = tmpR + dr[i];
			int nc = tmpC + dc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if((rgb=='R' || rgb=='G') & map[nr][nc]=='B') continue;			//R-G와 B는 다른 영역
				if(rgb=='B' & (map[nr][nc]=='R' || map[nr][nc]=='G')) continue;
				
				if (!visited[nr][nc]) { // 방문하지 않은 같은 색깔 영역에
					visited[nr][nc] = true;
					seeRB(nr, nc, rgb);
				}
			}
		}
	}
}
