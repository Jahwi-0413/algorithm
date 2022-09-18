import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//로봇 청소기
public class BJ_14503 {
	static int N,M,res;
	static int[][] map;
	static int r, c, direction;
	
	static int[] dr = {-1,0,1,0};		//북, 동, 남, 서
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());	//내가 정의한 방향으로 값을 바꿔줌
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
			}
		}
		
		dfs();
		
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static public void clean() {
		map[r][c] = 2;
	}
	
	static public int checkDirty() {
		int d = direction;
		
		for(int i=0; i<4; i++) {
			int nd = (d + 3)%4;		//돌린 방향 기준 왼쪽부터 청소할 공간 검사
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			
			if(0 <= nr && nr<N && 0<=nc && nc<M) {
				if(map[nr][nc]==0)
					return nd;		//청소할 곳 있음
			}
			d = nd;		//청소를 못하더라도 방향을 돌림
		}
		return -1;
	}
	
	static public void move() {
		if(map[r][c]==0) {
			res++;
			clean();
		}
		
		int dirtyD = checkDirty();
		if(dirtyD!=-1) {		//청소할 곳이 있으면 그 방향으로 전진
			direction = dirtyD;
			r += dr[direction];
			c += dc[direction];
			
			move();
			return;
		}
		else {			//청소할 곳이 없으면 뒤로 후진
			int d = (direction + 2)%4;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(0 <= nr && nr<N && 0<=nc && nc<M) {
				if(map[nr][nc]!=1) {
					r = nr;
					c = nc;
					move();
				}
			}
		}
	}
}
