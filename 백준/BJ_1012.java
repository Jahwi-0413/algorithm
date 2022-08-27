import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//유기농 배추
public class BJ_1012 {
	
	static class Insect{
		int x, y;

		public Insect(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};	//상하좌우
	static int[] dx = {0, 0, 1, -1};
	static int res;
	static List<Insect> insects;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			res = 0;
			insects = new ArrayList<>();
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
				insects.add(new Insect(x,y));
			}
			
			for(Insect i : insects) {		
				if(!visited[i.y][i.x]) {	//무리에 포함되지 않은 벌레만 기준으로 dfs
					dfs(i.x, i.y);
					res++;
				}
			}
			bw.write(res + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int x, int y) {	//인접한 배추들은 모두 visited true
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<=nx && nx<M && 0<=ny && ny<N) {
				if(!visited[ny][nx] && map[ny][nx]==1) {
					visited[ny][nx] = true;
					dfs(nx, ny);
				}
			}
		}
	}
}
