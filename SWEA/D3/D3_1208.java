import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//정렬해서 풀기
class Box{
	boolean[] yellowBoxes = new boolean[100];
	int h;
	
	public Box(int h) {
		super();
		this.h = h;
		boxInitial();
	}

	public void boxInitial() {
		for(int i=0; i<100; i++) {
			if(i<h) {
				yellowBoxes[i] = true;
			}
			else {
				yellowBoxes[i] = false;
			}
		}
	}
	
	public void getIn() {		//상자를 하나 쌓음
		yellowBoxes[h-1] = true;
		h++;
	}
	
	public void getOff() {		//상자를 하나 뺌
		yellowBoxes[h-1] = false;
		h--;
	}
	
}
//Flatten
public class D3_1208 {
	static int jobCnt = 0;
	static int cnt = 0;		//작업의 횟수 카운트
	static Box[] boxes;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = 10;
//		int testCase = 1;
		for(int t=0; t<testCase; ++t) {
			jobCnt = Integer.parseInt(br.readLine());
			cnt = 0;
			
			String[] cnts = br.readLine().split(" ");
			boxes = inputBox(cnts);
			
			int max = findHigh();
			int min = findLow();
			int result = flatten(max, min);

			bw.write("#" + (t+1) + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static Box[] inputBox(String[] input) {
		Box[] tmp = new Box[100];
		for(int i=0; i<input.length; i++) {
			int h = Integer.parseInt(input[i]);
			tmp[i] = new Box(h);
		}
		return tmp;
	}
	
	//가장 높은곳 index, 가장 낮은곳 index
	//기저조건 -> cnt < jobCnt
	private static int flatten(int h, int l) {
		if(cnt >= jobCnt) {
			return boxes[h].h - boxes[l].h;
		}
		boxes[h].getOff();
		boxes[l].getIn();
		cnt++;
		
		int h2 = findHigh();
		int l2 = findLow();
//		System.out.println("high index : " + h2 + "\thigh value : " + boxes[h2].h);
//		System.out.println("low index : " + l2 + "\tlow value : " + boxes[l2].h + "\n");
		
		
		return flatten(h2, l2);
	}
	
	private static int findHigh() {	//가장 높은곳의 index 반환
		if(boxes == null) return -1;
		
		int max = 0;
		
		for(int i=1; i<100; i++) {
			if(boxes[i].h > boxes[max].h) {
				max = i;
			}
		}
		return max;
	}
	
	private static int findLow() {	//가장 낮은곳의 index 반환
		if(boxes == null) return -1;
		
		int min = 0;
		
		for(int i=1; i<100; i++) {
			if(boxes[i].h < boxes[min].h) {
				min = i;
			}
		}
		return min;
	}
}
