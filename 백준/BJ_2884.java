import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//알람 시계
public class BJ_2884 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int hour = Integer.parseInt(st.nextToken());
		int minutes = Integer.parseInt(st.nextToken());
		
		minutes -=45;
		if(minutes < 0) {
			hour--;
			minutes = 60+minutes;
		}
		else if(minutes > 60){
			hour++;
			minutes -=60;
		}
		
		if(hour >=24) {
			hour = 0;
		}
		else if(hour < 0) {
			hour = 23;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(hour).append(" ").append(minutes);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
}
