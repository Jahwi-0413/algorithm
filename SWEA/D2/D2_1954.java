import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//달팽이 숫자
public class D2_1954 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			int size =  Integer.parseInt(br.readLine());
			int[][] arr = new int[size][size];
			
			int cnt = size*size;
			int i=0;
			int nr = 0, nc = 0;			//now row, now column
			
			while(i<cnt) {
				while(nc<size && arr[nr][nc]==0) {	// 오른쪽으로 이동
					arr[nr][nc++] = ++i;
				}
				nc--;
				nr++;	//한줄 밑으로 이동
				
				while(nr<size && arr[nr][nc]==0) {	//밑으로 이동
					arr[nr++][nc] = ++i;
				}
				nr--;
				nc--;	//한줄 왼쪽으로 이동
				
				while(nc >=0 && arr[nr][nc]==0) {	//왼쪽으로 이동
					arr[nr][nc--] = ++i;
				}
				nc++;
				nr--;
				
				while(nr>=0 && arr[nr][nc]==0) {	//위로 이동
					arr[nr--][nc] = ++i;
				}
				nr++;
				nc++;
			}
			bw.write("#" + (t+1) + "\n");
			
			for(int x=0; x<size; x++) {
				for(int y=0; y<size; y++) {
					bw.write(arr[x][y] + " ");
				}
				bw.write('\n');
			}
		}
		bw.flush();
		bw.close();
	}
}
/*
1
4

1 2 3 4
12 13 14 5
11 16 15 6
10 9 8 7


 */