import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 문자 선택 수, 문자 개수
    public static int selectCount, wordCount;

    // 문자 저장 배열
    public static char[] words;

    // 선택된 문자 저장 리스트
    public static ArrayList<Character> selectedWords;

    // 최소 모음 확인 메서드
    public static boolean isNotMoCount(int count) {
        return count<1;
    }

    // 최소 자음 확인 메서드
    public static boolean isNotJaCount(int count) {
        return count<2;
    }

    // 모음 확인 메서드
    public static boolean isMo(char word) {
        return word == 'a' || word == 'e' || word == 'i' || word == 'o' || word == 'u';
    }

    // 선택된 문자 개수 확인 메서드
    public static boolean isNotSelectCount(int count) {
        return count!=selectCount;
    }

    // 문자 조합하기 메서드
    public static void solve(int count, int selectedCount) {

        // 문자가 모두 선택된 경우
        if(count==wordCount) {

            StringBuilder sb = new StringBuilder();

            // 선택된 문자 개수 확인
            if(isNotSelectCount(selectedCount)) return;

            // 문자 확인
            int moCount = 0;
            int jaCount = 0;
            for(int index=0; index<selectedWords.size(); index++) {
                char word = selectedWords.get(index);
                if(isMo(word)) moCount++;
                else jaCount++;
                sb.append(word);
            }

            // 최소 모음, 자음 개수 확인
            if(isNotMoCount(moCount) || isNotJaCount(jaCount)) return;

            // 결과 출력
            System.out.println(sb.toString());
            return;
        }

        // 문자 선택하기
        selectedWords.add(words[count]);
        solve(count+1, selectedCount+1);
        selectedWords.remove(selectedWords.size()-1);
        solve(count+1,selectedCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 문자 선택 수, 문자 개수 입력
        st = new StringTokenizer(br.readLine());
        selectCount = Integer.parseInt(st.nextToken());
        wordCount = Integer.parseInt(st.nextToken());

        // 문자 저장 배열 생성
        words = new char[wordCount];

        // 문자 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<wordCount; index++) {
            words[index] = st.nextToken().charAt(0);
        }

        // 정렬
        Arrays.sort(words);

        // 문자 조합하기
        selectedWords = new ArrayList<>();
        solve(0,0);
    }
}