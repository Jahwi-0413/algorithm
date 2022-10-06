import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//완전제곱수
public class BJ_1977 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());	//M 이상 N 이하
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		int num = 1;
		while(true) {
			int square = num * num; 
			if(M <= square && square <=N) {
				sum += square;
				min = Math.min(min, square);
			}
			if(square>N) break;
			num++;
		}
		
		if(min > N) {
			bw.write("-1");
		}
		else {
			bw.write(sum + "\n");
			bw.write(min + "");			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
