import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BJ_11899 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    List<Character> arr = new ArrayList<Character>();
    String input = br.readLine();

    for(int i=0, size=input.length(); i<size; i++){
      char c = input.charAt(i);

      if(c==')'){
        int lastIndex = arr.size()-1;
        //짝을 맞춘것은 없앤다
        if(!arr.isEmpty()&& arr.get(lastIndex)=='('){
          arr.remove(lastIndex);
          continue;
        }
      }
      arr.add(c);
    }

    //짝을 맞추지 못한것은 최소로 붙여줘야하는 괄호의 수
    bw.write(arr.size() + "");
    bw.flush();
    br.close();
    bw.close();
  }
}
