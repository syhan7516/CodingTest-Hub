import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    // 결과, 찾을 문자열 개수, 비교 문자열 개수
    public static int answer, findLetterCount, compareLetterCount;

    // 찾을 문자열 저장 해시
    public static Map<String,Boolean> words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 찾을 문자열 개수, 비교 문자열 개수 입력
        st = new StringTokenizer(br.readLine());
        findLetterCount = Integer.parseInt(st.nextToken());
        compareLetterCount = Integer.parseInt(st.nextToken());

        // 찾을 문자열 저장 해시 생성
        words = new HashMap<>();

        // 찾을 문자열 입력
        for(int letterIndex=0; letterIndex<findLetterCount; letterIndex++) {
            words.put(br.readLine(),true);
        }

        // 비교 문자열 입력
        for(int letterIndex=0; letterIndex<compareLetterCount; letterIndex++) {
            
            // 동일한 경우
            if(words.containsKey(br.readLine())) {
                answer++;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}