import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 결과
    public static int answer;

    // 변경 단어 저장 배열
    public static String[] changedWords = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

    // 단어
    public static String word;

    // 단어 확인 메서드
    public static void solve() {

        // 각 변경 문자 확인
        for(int changedWordIndex=0; changedWordIndex<changedWords.length; changedWordIndex++) {

            // 변경 여부
            boolean isChanged = true;

            // 변경
            while(isChanged) {

                // 크로아티아 알파벳이 포함된 경우
                if(word.contains(changedWords[changedWordIndex])) {
                    word = word.replaceFirst(changedWords[changedWordIndex]," ");
                    answer++;
                }

                // 아닌 경우
                else isChanged = false;
            }
        }

        // 남은 문자 반영
        answer += word.replace(" ", "").length();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 입력
        word = br.readLine();

        // 단어 확인
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}