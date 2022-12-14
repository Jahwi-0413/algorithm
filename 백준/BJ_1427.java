import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//소트인사이드
public class BJ_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] arr = br.readLine().toCharArray();
		int maxIndex = 0;
		
		for(int i=0; i<arr.length; i++) {
			maxIndex = i;
			for(int j=i; j<arr.length; j++) { //가장 큰 값의 인덱스를 기억해
				if(arr[j] > arr[maxIndex]) {	
					maxIndex = j;
				}
			}
			char tmp = arr[i];				  //큰 값을 맨 정렬 안된 배열의 맨 앞으로
			arr[i] = arr[maxIndex];
			arr[maxIndex] = tmp;
		}
		
		bw.write(arr, 0, arr.length);
		bw.flush();
		bw.close();
	}
}

/*
 * 선택정렬 sudo 코드
 * for(배열 크기만큼){
 * 	 for(현재 위치부터 배열 크기만큼){
 *  	if(지금 배열값이 기준보다 크다)
 *   		기준 갱신	
 * 	 }
 *   기준값과 정렬 안된것중 가장 처음 값과 swap
 * }
 */