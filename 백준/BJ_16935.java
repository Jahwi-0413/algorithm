package ws0810;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//배열 돌리기 3
public class BJ_16935 {
	static int N, M, rotateCnt;
	static int tmpN, tmpM;
	static int arr[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstLine = br.readLine().split(" ");
		N = Integer.parseInt(firstLine[0]); tmpN = N;
		M = Integer.parseInt(firstLine[1]);	tmpM = M;
		rotateCnt = Integer.parseInt(firstLine[2]);
		
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {					//배열 입력
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		String[] rtts = br.readLine().split(" ");
		for(int i=0; i<rotateCnt; i++) {
			switch(rtts[i]) {
			case "1": rotate1(); break;
			case "2": rotate2(); break;
			case "3": rotate3(); break;
			case "4": rotate4(); break;
			case "5": rotate5(); break;
			case "6": rotate6(); break;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
	
	static void rotate1() {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] tmp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tmp[i][j] = arr[n-1-i][j];
			}
		}
		
		arr = tmp.clone();
	}
	
	static void rotate2() {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] tmp = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tmp[i][j] = arr[i][m-1-j];
			}
		}
		
		arr = tmp.clone();
	}
	
	static void rotate3() {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] tmp = new int[m][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tmp[j][n-i-1] = arr[i][j];
			}
		}
		
		arr = tmp.clone();
	}

	static void rotate4() {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] tmp = new int[m][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tmp[m-1-j][i] = arr[i][j];
			}
		}
		
		arr = tmp.clone();
	}

	static void rotate5() {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][][] tmp = new int [4][n/2][m/2];
		
		int[][] group1 = new int[n/2][m/2];
		int[][] group2 = new int[n/2][m/2];
		
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m/2; j++) {
				group1[i][j] = arr[i][j];
				group2[i][j] = arr[i][j + m/2];
			}
		}
		
		int[][] group3 = new int[n/2][m/2];
		int[][] group4 = new int[n/2][m/2];
		
		for(int i=n/2; i<n; i++) {
			for(int j=0; j<m/2; j++) {
				group4[i-n/2][j] = arr[i][j];
				group3[i-n/2][j] = arr[i][j + m/2];
			}
		}
		
		tmp[0] = group1;
		tmp[1] = group2;
		tmp[2] = group3;
		tmp[3] = group4;
		
		
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m/2; j++) {
				arr[i][j] = group4[i][j];
				arr[i][j + m/2] = group1[i][j];
			}
		}

		for(int i=n/2; i<n; i++) {
			for(int j=0; j<m/2; j++) {
				arr[i][j] = group3[i-n/2][j];
				arr[i][j + m/2] = group2[i-n/2][j];
			}
		}
	}

	static void rotate6() {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][][] tmp = new int [4][n][m];
		
		int[][] group1 = new int[n/2][m/2];
		int[][] group2 = new int[n/2][m/2];
		
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m/2; j++) {
				group1[i][j] = arr[i][j];
				group2[i][j] = arr[i][j + m/2];
			}
		}
		
		int[][] group3 = new int[n/2][m/2];
		int[][] group4 = new int[n/2][m/2];
		
		for(int i=n/2; i<n; i++) {
			for(int j=0; j<m/2; j++) {
				group4[i-n/2][j] = arr[i][j];
				group3[i-n/2][j] = arr[i][j + m/2];
			}
		}
		
		tmp[0] = group1;
		tmp[1] = group2;
		tmp[2] = group3;
		tmp[3] = group4;
		
		
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m/2; j++) {
				arr[i][j] = group2[i][j];
				arr[i][j + m/2] = group3[i][j];
			}
		}

		for(int i=n/2; i<n; i++) {
			for(int j=0; j<m/2; j++) {
				arr[i][j] = group1[i-n/2][j];
				arr[i][j + m/2] = group4[i-n/2][j];
			}
		}
	}
}
