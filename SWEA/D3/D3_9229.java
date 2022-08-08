package ws0808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//한빈이와 Spot Mart
public class D3_9229 {
	static boolean[] isSelected;		//어느 과자를 골랐는지 저장
	static int[] selectedSnacks;		//선택한 과자
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			max = -1;
			
			input = br.readLine().split(" ");
			int[] inputSnacks = new int[N];
			for(int i=0; i<input.length; i++) {
				inputSnacks[i] = Integer.parseInt(input[i]);
			}
			
			selectedSnacks = new int[2];
			isSelected = new boolean[N];
			
			subset(0, M, inputSnacks);
			
			bw.write("#" + t + " " + max + "\n");
			
		}//end of testCase for
		bw.flush();
		bw.close();
	}
	
	public static void subset(int cnt, int M, int[] snacks) {
		if(cnt==2) {
			int sum = selectedSnacks[0] + selectedSnacks[1];
			if(sum <= M && sum >max) {
				max = sum;
			}
			return;
		}
		
		for(int i=0; i<isSelected.length; i++) {
			if(isSelected[i]==true) {
				continue;
			}
			isSelected[i] = true;
			selectedSnacks[cnt] = snacks[i];
			subset(cnt+1, M, snacks);
			
			isSelected[i] = false;
		}
	}
}
