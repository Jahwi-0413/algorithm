import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//AC
public class BJ_5430 {
	static Deque<Integer> deq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			deq = new ArrayDeque<>();
			
			boolean isError = false;
			boolean reverse = false;
			String cmd = br.readLine();

			int arrSize = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			
			for(int i=0; i<arrSize; i++) {		//배열 입력
				int value = Integer.parseInt(st.nextToken());
				deq.addLast(value);
			}
			
			for(int i=0, size = cmd.length(); i<size; i++) {	//명령어 처리
				if(cmd.charAt(i)=='R') {
					reverse = !reverse;
				}
				else {
					if(deq.isEmpty()) {
						isError = true;
						break;
					}
					if(reverse) {
						deq.pollLast();
					}
					else {
						deq.pollFirst();
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			if(isError) {
				bw.write("error\n");
			}
			else {
				for(int i=0, size=deq.size(); i<size; i++) {
					int value = reverse ? deq.pollLast() : deq.pollFirst();
					sb.append(value);
					if(i!=size-1) sb.append(',');
				}
				bw.write("[" + sb.toString() + "]" + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
