import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//음계
public class BJ_2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int first = Integer.parseInt(st.nextToken());
		int result=0;		//0 - ascending, 1-descending, 2-mixed
		
		if(first == 1)	//ascending, mix만 판별
			result = 0;
		else if(first==8) //descending, mix만 판별
			result  = 1;
		else
			result = 2;
		
		while(st.hasMoreTokens()) {
			int value = Integer.parseInt(st.nextToken());
			
			switch(result) {
			case 0:
				if(value != first+1) {	//mixed
					result = 2;
					break;
				}
				else
					first++;			//ascending 유지
				break;
			case 1:
				if(value!=first-1) {
					result = 2;
				}
				else {
					first--;
				}
				break;
			}
		}
		
		switch(result) {
		case 0:
			bw.write("ascending"); break;
		case 1:
			bw.write("descending"); break;
		case 2:
			bw.write("mixed"); break;
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
