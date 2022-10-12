import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//한조 서열정리하고옴ㅋㅋ
public class BJ_14659 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int cnt=0, maxValue=0, maxCnt = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if(maxValue < value) {
				maxCnt = Math.max(cnt, maxCnt);
				maxValue = value;
				cnt = 0;
				continue;
			}
			cnt++;
		}
		
		maxCnt = Math.max(maxCnt, cnt);
		
		bw.write(maxCnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
