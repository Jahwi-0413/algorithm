import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//윤년
public class BJ_2753 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Y = Integer.parseInt(br.readLine());
		
		if(Y%4==0 && (Y%100!=0 | Y%400==0)) {		//윤년인 경우
			bw.write("1");
		}
		else 
			bw.write("0");
		bw.flush();
		bw.close();
		br.close();
	}
}
