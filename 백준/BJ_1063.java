import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//킹
public class BJ_1063 {
	static class Thing{
		int r, c;
		public Thing(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static Thing king, stone;
	static int N;
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};		//L, LT, T, RT, R, RB, B, LB
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		king = indexToThing(st.nextToken());
		stone = indexToThing(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String cmd = br.readLine();
			int direction = getDirection(cmd);
			boolean withStone = isThereStone(direction);
			move(direction, withStone);
		}
		
		String k = thingToIndex(king);
		String s = thingToIndex(stone);
		bw.write(k + "\n" + s);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static Thing indexToThing(String index) {
		int c = index.charAt(0) - 'A';
		int r = 8 - (index.charAt(1) - '0');
		
		return new Thing(r, c);
	}
	static String thingToIndex(Thing thing) {		//r,c -> H1
		char c = (char)(thing.c + 'A');
		char r = (char)(8-thing.r + '0');
		
		StringBuilder sb = new StringBuilder();
		sb.append(c); sb.append(r);
		return sb.toString();
	}
	
	static int getDirection(String cmd) {
		switch(cmd) {
		case "L"	: return 0;
		case "LT" 	: return 1;
		case "T"	: return 2;
		case "RT"	: return 3;
		case "R"	: return 4;
		case "RB"	: return 5;
		case "B"	: return 6;
		default		: return 7;
		}
	}
	
	static boolean isThereStone(int direction) {	//가려는 방향에 돌이 있는지
		int nr = king.r + dr[direction];
		int nc = king.c + dc[direction];
		
		if(stone.r == nr && stone.c == nc) return true;		//가려는 방향에 돌이 있음
		return false;
	}
	
	//withStone->돌도 움직여야하나, direction -> 방향
	static void move(int direction, boolean withStone) {
		if(withStone) {		//돌도 움직여야 하는 경우
			int nr = stone.r + dr[direction];
			int nc = stone.c + dc[direction];
			
			if(nr<0 || 8<=nr || nc<0 || 8<=nc) {		//돌이 범위가 벗어남
				return;
			}
			stone.r = nr;
			stone.c = nc;
		}
		int nr = king.r + dr[direction];
		int nc = king.c + dc[direction];
		if(nr<0 || 8<=nr || nc<0 || 8<=nc) {		//킹이 범위가 벗어남
			return;
		}
		king.r = nr;
		king.c = nc;
	}
}