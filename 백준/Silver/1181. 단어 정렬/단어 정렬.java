import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    // 단어 개수
    public static int wordCount;

    // 단어 저장 리스트
    public static ArrayList<String> words;

    // 정렬 수행 메서드
    public static void solve() {

        words.sort((a,b) -> {
            if(a.length()==b.length()) {
                return a.compareTo(b);
            }

            return a.length()-b.length();
        });
    }

    // 결과 저장 메서드
    public static String saveResult() {
        StringBuilder sb = new StringBuilder();

        for(int wordIndex=0; wordIndex<words.size(); wordIndex++) {
            sb.append(words.get(wordIndex)).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 개수 입력
        wordCount = Integer.parseInt(br.readLine());

        // 단어 저장 배열 생성
        words = new ArrayList<>();

        // 단어 입력
        for(int wordIndex=0; wordIndex<wordCount; wordIndex++) {
            String word = br.readLine();

            // 이전에 포함되지 않은 경우
            if(!words.contains(word)) {
                words.add(word);
            }
        }

        // 정렬 수행
        solve();

        // 결과 출력
        System.out.println(saveResult());
    }
}