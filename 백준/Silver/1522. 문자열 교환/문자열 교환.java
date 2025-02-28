import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        int answer = 1001;

        // 문자열 입력
        String letters = br.readLine();

        // a개수 확인
        int aCount = 0;
        for(int index=0; index<letters.length(); index++) {
            if(letters.charAt(index)=='a') aCount++;
        }

        // b개수 확인
        for(int index=0; index<letters.length(); index++) {
            int bCount = 0;
            for(int point=index; point<index+aCount; point++) {
                if(letters.charAt(point%letters.length())=='b') bCount++;
            }

            // 결과 갱신
            answer = Math.min(answer,bCount);
        }

        // 결과 출력
        answer = answer==1001 ? 0 : answer;
        System.out.println(answer);
    }
}