import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//영화감독 숀
public class BJ_1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int num = 666;
		List<Integer> arr = new ArrayList<>();
		arr.add(num);
		
		while(cnt<=10000) {
			num++;
			if(isWorldEndNum(num)) {
				arr.add(num);
				cnt++;
			}
			if(cnt==N) {
				break;
			}
		}
		bw.write(arr.get(N-1) + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isWorldEndNum(int num) {
		String numToStr = Integer.toString(num);
		
		int sixCnt=0;
		boolean isSequence = false;
		
		for(int i=0, size = numToStr.length(); i<size; i++) {
			char c = numToStr.charAt(i);
			
			if(!isSequence) {
				if(c=='6') {			//6이 처음 나오는 경우
					isSequence = true;
					sixCnt++;
					continue;
				}
			}
			else {	
				if(c=='6') {
					sixCnt++;
				}
				else {
					if(sixCnt<3) {				//아직 종말의 숫자가 아닌 경우
						isSequence = false;
						sixCnt = 0;
					}
					else {						//종말의 숫자인 경우		
						return true;
					}
				}
			}
		}
		if(sixCnt>=3) {
			return true;
		}
		return false;
	}
}
