import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Ingredient2{
	int s;		//신맛
	int b;		//쓴맛
	public Ingredient2(int s, int b) {
		super();
		this.s = s;
		this.b = b;
	}
}

//도영이가 만든 맛있는 음식
public class BJ_2961 {
	static int N;
	static Ingredient2[] ingredients;
	static int minDiff = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		ingredients = new Ingredient2[N];
		
		for(int n=0; n<N; n++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			ingredients[n] = new Ingredient2(s,b);
		}
		
		subset(0, 1, 0);
		
		bw.write(minDiff + "");
		bw.flush();
		bw.close();
	}
	
	private static void subset(int cnt, int s, int b) {
		if(cnt==N) {
			if(s==1 && b == 0) return;	//재료를 하나도 안 고른 경우
			int nowDiff = Math.abs(s-b);
			minDiff = Math.min(nowDiff, minDiff);
			return;
		}
		int sour = s * ingredients[cnt].s;
		int bitter = b + ingredients[cnt].b;
		
		subset(cnt+1, sour, bitter);
		subset(cnt+1, s, b);
	}
}
