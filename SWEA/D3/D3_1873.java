import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//상호의 배틀필드
class Tank {
	int r, c;		
	int stateIndex = 0;
	char[][] map;
	
	public Tank(int mapRSize, int mapCSize) {
		super();
		map = new char[mapRSize][mapCSize];
	}

	public void changeState(char m) {		//m 명령어
		switch(m) {
		case 'U': stateIndex = 0; break;	//Up
		case 'D': stateIndex = 1; break;	//Down
		case 'L': stateIndex = 2; break;	//Left
		case 'R': stateIndex = 3; break;	//Right
		
		case '^': stateIndex = 0; break;
		case 'v': stateIndex = 1; break;
		case '<': stateIndex = 2; break;
		case '>': stateIndex = 3; break;
		}
	}
	
	public void move(char m) {
		changeState(m);
		char tmp = TankState.states[stateIndex];
		map[r][c] = tmp;
		
		int nr = r + TankState.dr[stateIndex];
		int nc = c + TankState.dc[stateIndex];
		
		if(nr>=0 && nc>=0 && nr<map.length && nc<map[0].length) { //범위를 벗어나지 않는 경우에만
			if(map[nr][nc]=='.') {	//평지만 이동
				map[r][c] = map[nr][nc];
				map[nr][nc] = tmp;
				r = nr; c = nc;
			}
				
		}
		
	}
	void shoot() {	//포탄을 쏴서 일어나는 일
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += TankState.dr[stateIndex]; nc += TankState.dc[stateIndex];
			if(nr>=0 && nc>=0 && nr< map.length && nc < map[0].length) {
				char c = map[nr][nc];
				if(c == '#') {	//물이나 강철
					return;
				}
				if(c == '*') {	//벽돌
					map[nr][nc] = '.';
					return;
				}
			}
			else
				return;
		}
	}
}

class TankState{
	static final char[] states = { '^', 'v', '<', '>' };
	static final char[] changeS = {'U', 'D', 'L', 'R'};
	static final int[] dr = {-1, +1, 0, 0};		//상하좌우
	static final int[] dc = {0, 0, -1, +1};
}

public class D3_1873_상호의_배틀필드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < testCase; t++) {
			String[] s = br.readLine().split(" ");
			int[] size = {Integer.parseInt(s[0]), Integer.parseInt(s[1])};	//map size
			Tank tank = new Tank(size[0], size[1]);
			
			
			for(int i=0; i<size[0]; i++) {	//map input
				char[] tmp = br.readLine().toCharArray();
				for(int j=0; j<size[1]; j++) {
					tank.map[i][j] = tmp[j];
					if(tmp[j]=='^' || tmp[j]=='v' || tmp[j]=='<' || tmp[j]=='>') {		//탱크의 위치를 찾으면 객체 생성
						tank.r = i; tank.c = j; 
						tank.changeState(tmp[j]);
					}
				}
			}
			
			Queue<Character> commands = new LinkedList<>();	//명령어 input 처리
			int qSize = Integer.parseInt(br.readLine());
			char[] c = br.readLine().toCharArray();
			
			for(int i=0; i<c.length; i++) {
				commands.add(c[i]);
			}
			
			int i=0;
			while(i<commands.size()) {
				//명령어를 하나씩 꺼내서 처리
				char cmd = commands.poll();
				if(cmd!='S') {
					tank.move(cmd);
				}
				else {
					tank.shoot();
				}
			}
			
			bw.write("#" + (t+1) + " ");		//결과 출력
			for(int x=0; x<tank.map.length; x++) {
				for(int y=0; y<tank.map[0].length; y++) {
					bw.write(tank.map[x][y]);
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

/*
. 평지 벽돌 -> 부서짐
# 강철 -> 안부서짐
- 물 -> 이동 X 
^ v < >
U D L R S

1
2 2
<.
..
12
DDSRRSUUSLLS

#1 **....v
.-..#..
#......

*/

