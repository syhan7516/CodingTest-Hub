import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 문자열
    public static String word;

    // 문자열 저장 빌더
    public static StringBuilder sb;

    // 문자 저장 여부 배열
    public static boolean[] visited;

    // ZOAC 수행 메서드
    public static void solve(int startIndex, int endIndex) {

        // 범위 확인
        if(startIndex>endIndex) return;

        // 가장 작은 알파벳 위치
        int minAlphabetIndex = startIndex;

        // 문자열 확인
        for(int wordIndex=startIndex; wordIndex<=endIndex; wordIndex++) {

            // 기준보다 작은 알파벳을 찾은 경우
            if(word.charAt(minAlphabetIndex)>word.charAt(wordIndex)) {
                minAlphabetIndex = wordIndex;
            }
        }

        // 문자 저장
        visited[minAlphabetIndex] = true;

        // 현재까지 만든 문자열 저장
        for(int index=0; index<word.length(); index++) {
            if(visited[index]) sb.append(word.charAt(index));
        }
        sb.append("\n");

        // 가장 작은 알파벳 기준으로 분리해서 재탐색
        solve(minAlphabetIndex+1,endIndex);
        solve(startIndex,minAlphabetIndex-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 문자열 입력
        word = br.readLine();

        // 문자 저장 여부 배열 생성
        visited = new boolean[word.length()];

        // ZOAC 수행
        solve(0,word.length()-1);

        // 결과 출력
        System.out.println(sb.toString());
    }
}