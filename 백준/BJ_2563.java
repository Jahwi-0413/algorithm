package ws0809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_2563 {
	static int[][] map = new int[100][100];
	static int result = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int colorPaper = Integer.parseInt(br.readLine());
		
		for(int cp=0; cp<colorPaper; cp++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");

			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			attach(r,c);
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
	
	public static void attach(int r, int c) {
		for(int i=r; i<r+10; i++) {
			for(int j=c; j<c+10; j++) {
				if(map[i][j]==0) {		//색종이 영역이 겹치지 않은 곳
					map[i][j] = 1;
					result++;
				}
			}
		}
	}
}

/*

3
3 7
15 7
5 2



*/