import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//셀프 넘버
public class BJ_4673 {
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		visited = new boolean[10001];
		
		for(int i=1; i<=10000; i++) {
			if(visited[i]) continue;
			int start = i;
			
			while(true) {
				start =selfNumber(start);
				if(start>=10000) break;
				visited[start] = true;
			}
		}
		
		for(int i=1; i<10000; i++) {
			if(visited[i]) continue;
			bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	static int selfNumber(int start) {
		String str = Integer.toString(start);
		for(int i=0, size=str.length(); i<size; i++) {
			start += str.charAt(i)-'0';
		}
		return start;
	}
	
}
