import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//잃어버린 괄호
public class BJ_1541 {
	static int opCnt = 0;
	static int minResult = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] input = br.readLine().toCharArray();
		List<Integer> numbers = new ArrayList<>();
		List<Character> operations = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0,size = input.length; i<size; i++) {
			if(input[i]!='+' & input[i]!='-') {		//피연산자인 경우
				sb.append(input[i]);
			}
			else {		//연산자인 경우
				numbers.add(makeInt(sb.toString()));	//연산자 앞자리까지 숫자
				sb = new StringBuilder();
				operations.add(input[i]);
				opCnt++;
			}
		}
		numbers.add(makeInt(sb.toString()));
		int sum = 0;
		for(int i=0; i< operations.size(); i++) {
			if(operations.get(i)=='+') {
				sum = numbers.get(i) + numbers.get(i+1);
				numbers.remove(i+1);		// 연산 기호 뒤의 피연산자 삭제
				numbers.set(i, sum);		// 연산 결과 앞의 피연산자에 업데이트
				
				operations.remove(i);		//연산자 삭제
				i--;						//삭제시 배열이 한칸씩 당겨지므로
			}
		}
		
		int sub = 0;
		for(int i=0; i< operations.size(); i++) {
			if(operations.get(i)=='-') {
				sub = numbers.get(i) - numbers.get(i+1);
				numbers.remove(i+1);
				numbers.set(i, sub);
				
				operations.remove(i);
				i--;
			}
		}
		
		if(sub==0 & sum==0)		bw.write(numbers.get(0)+"");
		else if(sub==0) 		bw.write(sum +"");
		else 					bw.write(sub +"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int makeInt(String input) {
		int result = 0;
		for(int i=0, size=input.length(); i<size; i++) {
			result = result + (input.charAt(i) - '0') * (int)Math.pow(10, size-i-1);
		}
		return result;
	}
}
