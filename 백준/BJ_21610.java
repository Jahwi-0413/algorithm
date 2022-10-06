import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//마법사 상어와 비바라기
public class BJ_21610 {
	static class Cloud {
		int c, r, cnt; 	//cnt -> 대각선에 물이 있는 개수

		public Cloud(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int N, M; // N 맵 크기, M 명령어 개수
	static int[][] map;
	static boolean[][] visited;
	static List<Cloud> rainyCloud;
	static int answer;

	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }; // 0번째 index는 사용 X
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		
		rainyCloud = new ArrayList<>();
		rainyCloud.add(new Cloud(N-2, 0));
		rainyCloud.add(new Cloud(N-2, 1));
		rainyCloud.add(new Cloud(N-1, 0));
		rainyCloud.add(new Cloud(N-1, 1));

		for (int i = 0; i < N; i++) { // 맵 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) { // 명령어 처리
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			visited = new boolean[N][N];
			moveCloud(d, s);
			copyWater();
			removeAllCloud();
			makeNewCloud();
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += map[i][j];
			}
		}
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}

	static void moveCloud(int d, int s) {		//1. 구름 이동
		int size = rainyCloud.size();
		s = s%N;            //N 이상은 어차피 한바퀴 도는거니 나머지만 계산
		
		for (int i = 0; i < size; i++) {
			Cloud now = rainyCloud.get(i);
			int r = now.r + s*dr[d];
			int c = now.c + s*dc[d];

			now.r = changeRange(now.r, r, d, s);
			now.c = changeRange(now.c, c, d, s);
			
			map[now.r][now.c]++;		//2. 구름이 이동한 곳에 비
			visited[now.r][now.c] = true;
		}

	}
	
	static void copyWater() {
		int size = rainyCloud.size();
		for (int i = 0; i < size; i++) {	//4. 대각선에 물이 있는만큼 복사
			Cloud now = rainyCloud.get(i);
			int cnt = checkAroundWater(now);
			map[now.r][now.c] += cnt;
		}
	}

	static int changeRange(int initial, int num, int d, int s) {
		if (num < 0)
			return N - s + initial;
		else if (num >= N)
			return num % N;
		return num;
	}

	static int checkAroundWater(Cloud now) {	//물 복사 버그는 범위 체크 필요
		int cnt = 0;
		for(int d=2; d<9; d+=2) {
			int nr = now.r + dr[d];
			int nc = now.c + dc[d];
			
			if(!isValidPosition(nr, nc)) continue;
			if(map[nr][nc] > 0) cnt++;
		}
		return cnt;
	}
	
	static boolean isValidPosition(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
	
	static void removeAllCloud() {  	//3. 구름 모두 삭제
		rainyCloud = new ArrayList<>();
	}
	
	static void makeNewCloud() {		//5. 물의 양 2이상인 칸에 구름
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j]>=2) {
					rainyCloud.add(new Cloud(i,j));
					map[i][j] -= 2;
				}
			}
		}
	}
}