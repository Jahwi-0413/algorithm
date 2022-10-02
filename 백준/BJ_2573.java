import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//빙산
public class BJ_2573 {
	static class Ice{
		int r, c, high;

		public Ice(int r, int c, int high) {
			super();
			this.r = r;
			this.c = c;
			this.high = high;
		}
	}
	static int N, M;
	static int[][] map;
	static Queue<Ice> ices;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		ices = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(value > 0) ices.add(new Ice(i, j, value));
			}
		}
		
		int time = 0;
		while(true) {		
			int res = bfs();
			if(ices.size()!=res) break;		//빙산이 2갈래로 나눠지는 시점
			
			calculMelting();		//얼음 녹는 양 계산, 업데이트는 안함(녹는 시점이 같아야하기 때문)
			updateMelting();		//실제 업데이트
			
			if(ices.size()==0) {
				time = 0;
				break;
			}
			time++;
		}

		bw.write(time + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void calculMelting() {
		for(int i=0,size=ices.size(); i<size; i++) {
			Ice now = ices.poll();
			int meltCnt = howManyWaterIs(now.r, now.c);
			int newHigh = 0;
			if(map[now.r][now.c] - meltCnt <= 0) newHigh = 0;
			else {
				newHigh = map[now.r][now.c] - meltCnt;
			}
			now.high = newHigh;
			ices.add(now);
		}
	}
	
	static void updateMelting() {
		for(int i=0,size=ices.size(); i<size; i++) {		//얼음 높이 업데이트
			Ice now = ices.poll();
			if(now.high==0) map[now.r][now.c] = 0;
			else {
				map[now.r][now.c] = now.high;
				ices.add(now);
			}
		}
	}
	
	static int bfs() {
		Queue<Ice> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		Ice lastIce = ices.peek();
		q.add(lastIce);
		visited[lastIce.r][lastIce.c] = true;
		
		int iceCnt = 1;
		
		while(!q.isEmpty()) {
			Ice now = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				
				if(isValidPosition(nr, nc) && map[nr][nc] > 0 && !visited[nr][nc]) {
					q.add(new Ice(nr, nc, map[nr][nc]));
					visited[nr][nc] = true;
					iceCnt++;
				}
			}
		}
		return iceCnt;
	}
	
	static boolean isValidPosition(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
	
	static int howManyWaterIs(int r, int c) {
		int cnt = 0;
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isValidPosition(nr, nc)) {
				if(map[nr][nc]==0) cnt++;
			}
		}
		return cnt;
	}
}
