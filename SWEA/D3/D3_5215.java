import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Ingredient{
	int taste;		//민기의 점수
	int calorie;	//재료 칼로리
	public Ingredient(int taste, int calorie) {
		super();
		this.taste = taste;
		this.calorie = calorie;
	}
}
//햄버거 다이어트
public class D3_5215 {
	static int N;		//재료 수
	static int L;		//제한 칼로리
	static Ingredient[] ingredients;
	static int maxTaste;	//최고 점수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			maxTaste = Integer.MIN_VALUE;
			
			ingredients = new Ingredient[N];
			
			for(int n=0; n<N; n++) {					//재료 입력받기
				input = br.readLine();
				st = new StringTokenizer(input, " ");
				
				int taste = Integer.parseInt(st.nextToken());
				int calorie = Integer.parseInt(st.nextToken());
				
				ingredients[n] = new Ingredient(taste, calorie);
			}
			subset(0, 0, 0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(maxTaste).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
	
	public static void subset(int cnt, int taste, int calorie) {
		if(calorie > L) return;
		if(cnt==N) {
			maxTaste = Math.max(taste, maxTaste);
			return;
		}
		
		int tasteSum = taste + ingredients[cnt].taste;
		int calorieSum = calorie + ingredients[cnt].calorie;
		subset(cnt+1, tasteSum, calorieSum);		//고른 경우
		
		subset(cnt+1, taste, calorie);		//안 고른 경우
	}
}

/*
1
5 1000
100 200
300 500
250 300
500 1000
400 400

#1 750
*/
