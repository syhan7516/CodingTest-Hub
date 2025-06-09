import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    // 문자열
    public static String letter;

    // 접미사 저장 리스트
    public static ArrayList<String> suffix;

    // 접미사 확인 메서드
    public static void solve() {

        for(int letterIndex=0; letterIndex<letter.length(); letterIndex++) {
            suffix.add(letter.substring(letterIndex));
        }
    }

    // 결과 저장 메서드
    public static String saveResult() {
        StringBuilder sb = new StringBuilder();

        for(String word: suffix) {
            sb.append(word).append("\n");
        }
        
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        letter = br.readLine();

        // 접미사 저장 리스트 생성
        suffix = new ArrayList<>();

        // 접미사 확인
        solve();

        // 정렬
        Collections.sort(suffix);

        // 결과 출력
        System.out.println(saveResult());
    }
}