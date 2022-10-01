import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//벌집
public class BJ_2292 {
	static long N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Long.parseLong(br.readLine());
		
		int cnt = 1;
		long start = 1;
		long end = 1;
		
		while(true) {
			if(N >= start & N <= end) {
				break;
			}
			start = end+1;
			end = start + 6*cnt-1;
			cnt++;
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
