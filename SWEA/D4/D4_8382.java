import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//방향 전환
public class D4_8382 {
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			res = 0;

			int xDiff = Math.abs(x2 - x1);
			int yDiff = Math.abs(y2 - y1);
			
			int diff = Math.abs(xDiff - yDiff);
			if(diff==0)		//가로 세로 움직어야 하는 횟수가 같은경우
				res = xDiff + yDiff;
			else {
				res = Math.min(xDiff, yDiff) * 2;	//상쇄할 수 있는 최대
				
				if((diff)%2==0)			//상쇄되고 남은것이 짝수 -> *2만 해주면 됨
					res += diff*2;
				else
					res += diff*2-1;
			}
			bw.write("#" + t + " " + res + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
