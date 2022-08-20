import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//알파벳
public class BJ_1987 {
	static int R, C;
	static char[][] map;
	static int maxResult = Integer.MIN_VALUE;
	static boolean[] visited = new boolean[26];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {			//맵 입력
			input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		visited[map[0][0]-'A'] = true;
		move(0, 0, 1);
		
		bw.write(maxResult + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void move(int r, int c, int moveCnt) {
		maxResult = Math.max(moveCnt, maxResult);
		
		for(int i=0; i<4; i++) {
			int tmpR = r + dr[i];
			int tmpC = c + dc[i];
			
			if(tmpR<0 || tmpC<0 || tmpR>=R || tmpC >=C) continue;	//맵을 벗어나는 곳은 안됨
			int index = map[tmpR][tmpC]-'A';
			if(visited[index]) continue;				//이미 쓴 알파벳이면 안됨
			visited[index] = true;
			move(tmpR, tmpC, moveCnt+1);
			visited[index] = false;
		}
	}
}
