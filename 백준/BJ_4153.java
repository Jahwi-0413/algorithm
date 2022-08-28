import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//직각삼각형
public class BJ_4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		while(!input.equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(input, " ");
			int a = (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
			int b = (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
			int c = (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
			
			if(a!=b+c && b!=a+c && c!=a+b) {
				bw.write("wrong\n");
			}
			else {
				bw.write("right\n");
			}
			
			input = br.readLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
