import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//회의실 배정
public class BJ_1931 {
	static class Meeting implements Comparable<Meeting>{
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.end!=o.end)
				return this.end - o.end;
			else
				return this.start - o.start;
		}
	}
	
	static int N, res;
	static Meeting[] meetingArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		res = 1;
		meetingArr = new Meeting[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meetingArr[i] = new Meeting(start, end);
		}
		
		Arrays.sort(meetingArr);
		Meeting current = meetingArr[0];
		for(int j=1; j<N; j++) {
			if(current.end > meetingArr[j].start) continue;
			current = meetingArr[j];
			res++;
		}
		
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
