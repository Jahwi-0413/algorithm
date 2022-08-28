import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
	int index;
	int high;

	public Top(int index, int high) {
		super();
		this.index = index;
		this.high = high;
	}

	public Top(Top t) {
		this.index = t.index;
		this.high = t.high;
	}
}

//탑
public class BJ_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		Stack<Top> tops = new Stack<>();
		
		for (int i = 1; i <= N; i++) {
			int high = Integer.parseInt(st.nextToken());
			
			while(!tops.isEmpty()) {
				if(tops.peek().high >= high) {	//새로운 높은 탑 갱신
					bw.write(tops.peek().index + " ");
					tops.push(new Top(i, high));
					break;
				}
				tops.pop();
			}
			if(tops.isEmpty()) {
				tops.push(new Top(i, high));
				bw.write(0 + " ");
			}
		}
		bw.flush();
		bw.close();
	}
}