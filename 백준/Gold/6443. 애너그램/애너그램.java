import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    // 단어 개수
    public static int wordCount;

    // 문자 배열
    public static char[] alphabet;

    // 방문 여부 배열
    public static int[] visited;

    // 단어 저장 셋
    public static TreeSet<String> set;

    // 애너그램 구하기 메서드
    public static void solve(int len, StringBuilder sb) {

        // 애너그램이 완성된 경우
        if(len == alphabet.length) {
            set.add(sb.toString());
            return;
        }

        // 미완성된 경우
        for(int index=0; index<26; index++) {

            // 알파벳 사용
            if(visited[index] > 0) {
                visited[index]--;
                sb.append((char)(index+'a'));
                solve(len+1, sb);
                visited[index]++;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 개수 입력
        wordCount = Integer.parseInt(br.readLine());

        // 케이스 확인
        for(int word=1; word<=wordCount; word++) {

            // 단어 입력 및 정렬, 배열 초기화
            alphabet = br.readLine().toCharArray();
            set = new TreeSet<>();
            visited = new int[26];
            for(int index=0; index<alphabet.length; index++) {
                visited[alphabet[index]-'a']++;
            }

            // 애너그램 구하기
            solve(0,new StringBuilder());

            // 결과 저장
            StringBuilder sb = new StringBuilder();
            for(String letter: set) sb.append(letter).append("\n");

            // 결과 출력
            System.out.println(sb.deleteCharAt(sb.length()-1).toString());
        }
    }
}