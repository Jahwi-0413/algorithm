import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//부녀회장이 될거야
public class BJ_2775 {
	static int a, b;
	static int map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			a = Integer.parseInt(br.readLine());
			b = Integer.parseInt(br.readLine());
			
			map = new int[a+1][b+1];		//a는 0~a, b는 1~b
			for(int c=1; c<=b; c++) {
				map[0][c] = c;
			}
			
			for(int r=1; r<=a; r++) {
				for(int c=1; c<=b; c++) {
					map[r][c] = map[r][c-1] + map[r-1][c];
				}
			}
			
			bw.write(map[a][b] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
