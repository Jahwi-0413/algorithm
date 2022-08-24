import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//ACM 호텔
public class BJ_10250 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			bw.write(getRoom(H,W,N) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static String getRoom(int H, int W, int N) {
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<W; j++) {
			for(int i=0; i<H; i++) {
				cnt++;
				if(cnt==N) {
					sb.append(i+1);
					if(j+1<10)
						sb.append(0);
					sb.append(j+1);
					return sb.toString();
				}
			}
		}
		return "";
	}
}
