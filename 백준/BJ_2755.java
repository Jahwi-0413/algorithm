import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이번학기 평점은 몇점?
public class BJ_2755 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int gradeSum = 0;			//학점
		double res = 0;		//성적
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			
			int grade = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			double score = 0;
			switch(str) {
			case "A+" : score += 4.3; break;
			case "A0" : score += 4.0; break;
			case "A-" : score += 3.7; break;
			
			case "B+" : score += 3.3; break;
			case "B0" : score += 3.0; break;
			case "B-" : score += 2.7; break;
			
			case "C+" : score += 2.3; break;
			case "C0" : score += 2.0; break;
			case "C-" : score += 1.7; break;
			
			case "D+" : score += 1.3; break;
			case "D0" : score += 1.0; break;
			case "D-" : score += 0.7; break;
			}
			
			gradeSum += grade;
			res += grade * score;
		}
		bw.write(String.format("%.2f", res/gradeSum));
		bw.flush();
		br.close();
	}
}
