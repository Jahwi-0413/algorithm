import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Razer {
	int start = -1, end = -1;

	public Razer(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
}

class IronBar {
	int start = -1, end = -1;

	public IronBar(int start) {
		super();
		this.start = start;
	}
}

//쇠막대기
public class BJ_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] input = br.readLine().toCharArray();
		List<IronBar> bars = new ArrayList<>();
		List<Razer> razers = new ArrayList<>();
		Stack<IronBar> inCompleteBars = new Stack<>(); 

		for (int i = 0; i < input.length; i++) {		//razer, ironbar 생성용
			if (input[i] == '(') {
				if (input[i + 1] == ')') { 		// 레이저일경우
					razers.add(new Razer(i, i + 1));
					i++;							// 레이저일 경우 다음칸은 검색 안해도 되니까 한칸 더 건너뜀
					continue;
				} 
				inCompleteBars.add(new IronBar(i));		// 레이저가 아닐 경우 철막대기 생성
			} 
			else { 										// )는 레이저인 경우는 생각 안해도 됨
				IronBar b = inCompleteBars.pop();
				b.end = i;
				bars.add(b);			//완성된 철막대기는 list에 넣어줌
			}
		}//end of for

		int sum = 0;
		for(int i=0; i<bars.size(); i++) {
			IronBar b = bars.get(i);
			int cnt = 1;
			for(int j=0; j<razers.size(); j++) {
				Razer r = razers.get(j);
				if(b.start <= r.start && b.end >= r.end) {
					cnt++;
				}
			}
			sum += cnt;
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}

/*
()(((()())(())()))(())

17

(((()(()()))(())()))(()())

24
ironbars
20 25
12 15
5 10
2 11
1 18
0 19
----------------
razers
3 4
6 7
8 9
13 14
16 17
21 22
23 24
*/
