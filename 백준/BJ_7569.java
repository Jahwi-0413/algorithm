import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토
public class BJ_7569 {
	static class Tomato{
		int r, c, h;

		public Tomato(int r, int c, int h) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}
	static int N, M, H;
	static int[][][] map;
	static Queue<Tomato> q;
	static int[] dr = {-1, 1, 0, 0, 0, 0};		//위,아래,좌,우,앞,뒤
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	static int days;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H+1][N+1][M+1];
		q = new LinkedList<>();
		
		boolean allDone = true;
		
		for(int h=1; h<=H; h++) {			//맵 입력
			for(int n=1; n<=N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int m=1; m<=M; m++) {
					int value = Integer.parseInt(st.nextToken());
					map[h][n][m] = value;
					if(value==1) {
						q.add(new Tomato(n,m,h));
						continue;
					}
					else if(value==0)
						allDone = false;
				}
			}
		}

		if(allDone) bw.write("0");
		else {
			bfs();
			if(!checkDone()) bw.write("-1");
			else 			bw.write((days-1)+ "");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			days++;
			for(int i=0, size=q.size(); i<size; i++) {		//level 탐색
				Tomato now = q.poll();
				for(int d=0, dSize=dr.length; d<dSize; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					int nh = now.h + dh[d];
					
					if(1<=nr && nr<=N && 1<=nc && nc<=M && 1<=nh && nh<=H) {		//범위를 넘어가지 않는 경우
						if(map[nh][nr][nc]!=0) continue;
						
						map[nh][nr][nc] = 1;
						q.add(new Tomato(nr, nc, nh));
					}
				}
			}
		}
	}
	
	static boolean checkDone() {
		for(int h=1; h<=H; h++) {			//맵 입력
			for(int n=1; n<=N; n++) {
				for(int m=1; m<=M; m++) {
					if(map[h][n][m]==0)return false;
				}
			}
		}
		return true;
	}
}
