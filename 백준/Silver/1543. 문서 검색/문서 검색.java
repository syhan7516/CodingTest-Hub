import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 개수 체크
        int count = 0;
        // 문자열, 찾을 문자열 입력
        String letters = br.readLine();
        String findLetter = br.readLine();

        // 찾을 문자열을 변경한 문자열
        String temp = letters.replaceAll(findLetter,"1");
        // 단어 찾기
        for(int idx=0; idx<temp.length(); idx++)
            if(temp.charAt(idx)=='1')
                count += 1;

        System.out.println(count);
    }
}
