import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//공주님을 구해라!
public class BJ_17836 {
	static class Point{
		int r, c;
		boolean withSword = false;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, boolean withSword) {
			super();
			this.r = r;
			this.c = c;
			this.withSword = withSword;
		}
	}
	static int N, M, T;
	static int res = Integer.MAX_VALUE, withSwordRes = -1;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];		//배열 크기는 N, M
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
			}
		}
		
		if(!bfs() && res==Integer.MAX_VALUE) {
			bw.write("Fail");
		}
		else {
			bw.write(res + "");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static boolean bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		visited[0][0] = true;
		
		int time = 0;
		
		while(!q.isEmpty()) {
			if(time >= T) {
				return false;
			}
			
			for(int i=0, size=q.size(); i<size; i++) {
				Point now = q.poll();
				
				for(int d=0; d<4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					
					if(nr==N-1 && nc==M-1) {
						res = Math.min(res, time+1);
					}
					
					if(isValidPosition(nr, nc)) {
						if(map[nr][nc]==2) {		//그람을 찾으면 
							int distance = getManhattanD(nr, nc);
							visited[nr][nc] = true;
							if(distance + time + 1 <= T)	//시간안에 갈 수 있는지
								res =  Math.min(res, time + 1 + distance);
							continue;
						}
						if(!now.withSword) {		//검이 없으면 0만 갈수있음
							if(map[nr][nc]==0 && !visited[nr][nc]) {
								visited[nr][nc] = true;
								q.add(new Point(nr, nc, false));
							} 
						}
					}
				}
			}
			time++;
		}//end of while
		return false;
	}
	
	static boolean isValidPosition(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
	
	static int getManhattanD(int r, int c) {		//그람부터 공주 위치까지 맨해튼 거리
		return Math.abs(N-1 - r) + Math.abs(M-1 - c);
	}
}