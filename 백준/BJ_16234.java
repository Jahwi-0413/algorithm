import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//인구 이동
public class BJ_16234 {
	static class Country{
		int r,c;

		public Country() {
			super();
		}

		public Country(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
			}
		}
		int cnt = 0;
		boolean flag = false;
		
		while(true) {
			visited = new boolean[N][N];
			flag = false;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					
					for(int d=0; d<4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc]) {
							int diff = Math.abs(map[i][j] - map[nr][nc]);
							if(L<=diff && diff<=R) {
								flag = true;
								bfs(i, j);		//연합국이 될 수 있는 지점을 시작으로 bfs
								break;
							}
						}
						
					}
				}
			}
			if(!flag) break;	//연합국이 없음
			cnt++;
		}//end of while
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(int r, int c) {
		Queue<Country> q = new LinkedList<>();
		List<Country> list = new ArrayList<>();
		Country country = new Country(r, c);
		
		q.add(country);
		list.add(country);
		visited[r][c] = true;
		int sum = map[r][c];
		
		while(!q.isEmpty()) {
			Country now = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				
				if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc]) {
					int diff = Math.abs(map[now.r][now.c] - map[nr][nc]);
					if(L<=diff && diff<=R) {
						Country newC = new Country(nr, nc);
						q.add(newC);
						list.add(newC);
						visited[nr][nc] = true;
						sum += map[nr][nc];
					}
				}
			}
		}
		
		int size = list.size();
		int newPeopleCnt = sum/size;		
		for(int i=0; i<size; i++) {			//연합국의 인구 수를 다시 계산
			int countryR = list.get(i).r;
			int countryC = list.get(i).c;
		
			map[countryR][countryC] = newPeopleCnt;
		}
	}
}
