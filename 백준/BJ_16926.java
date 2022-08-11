package ws0810;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//배열 돌리기 1
public class BJ_16926 {
	static int N, M, rotateCnt;
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstLine = br.readLine().split(" ");
		N = Integer.parseInt(firstLine[0]);
		M = Integer.parseInt(firstLine[1]);
		rotateCnt = Integer.parseInt(firstLine[2]);

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for(int i=0; i<rotateCnt; i++) {
			rotateArr();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		
	}//end of main

	static void rotateArr() {
		int[] dr = {0, 1, 0, -1};
		int[] dc = {-1, 0, 1, 0};
		int dIndex = 0;
		
		boolean[][] isRotated = new boolean[N][M];
		int[][] tmpArr = new int[N][M];

		int nr = 0, nc = M-1;
		int cnt = 0;
		
		while(true) {
			if(cnt >= N*M) {		//회전 할 필요가 없어질때 탈출
				break;
			}		
				
			nr += dr[dIndex]; nc += dc[dIndex];
			if(nr >= 0 && nc >= 0 && nr < N && nc < M && !isRotated[nr][nc]) {		//범위 내에서
				tmpArr[nr][nc] = arr[nr-dr[dIndex]][nc-dc[dIndex]];
				isRotated[nr][nc] = true;
				cnt++;
			}
			else { //해당 방향으로 rotate가 끝났다면
				nr -= dr[dIndex]; nc -= dc[dIndex];		//범위 내에서 범위를 바꾸기 위해
				dIndex++;
				if(dIndex>=dr.length) {
					dIndex = 0;
					nr++; nc--;
				}
			}
		}//end of while
		
		for(int i=0; i< N; i++) {
			for(int j=0; j<M; j++) {
				if(tmpArr[i][j]==0)
					tmpArr[i][j] = arr[i][j];
			}
		}
		arr = tmpArr.clone();
	}
}
