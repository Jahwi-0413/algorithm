import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BJ_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int N = Integer.parseInt(input);
        int goodWordCnt = 0;

        for(int i=0; i<N; i++){
            input = br.readLine();
            if(isGoodWord(input)) goodWordCnt++;
        }
        bw.write(goodWordCnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isGoodWord(String s){
        int stringLength = s.length();
        //bad
        if(stringLength%2!=0) return false;

        List<Character> arrList = new ArrayList<Character>();
        arrList.add(s.charAt(0));
        for(int i=1; i<stringLength; i++){
            char c = s.charAt(i);

            //쌍을 찾으면
            int arrLastIndex = arrList.size()-1;
            if(!arrList.isEmpty() && arrList.get(arrLastIndex).equals(c)){
                arrList.remove(arrLastIndex);
                continue;
            }
            arrList.add(c);
        }
        if(arrList.size()>0) return false;
        return true;
    }
}

/*
회고

js로 알고리즘 풀다가 java 재활하려고 푼 문젠데 
선이 겹치지 않는다는거를 풀어내는게 제일 헷갈렸었다.
 */