import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 단어 개수
    public static int wordCount;

    // 결과, 시작 단어
    public static String answer, startWord;

    // 단어 저장 리스트
    public static ArrayList<ArrayList<String>> words;

    // 탐색 엽

    // 단어 확인 메서드
    public static void solve() {

        // 단어 탐색 큐 생성
        Queue<String> queue = new LinkedList<>();

        // 방문 여부 해시 생성
        HashMap<String, Boolean> map = new HashMap<>();

        // 시작 단어 처리
        queue.offer(startWord);
        map.put(startWord, true);

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 기준 단어
            String word = queue.poll();

            // 조건: 기준 단어 길이보다 1긴 단어 확인
            for(int index=0; index<words.get(word.length()+1).size(); index++) {
                String compareWord = words.get(word.length()+1).get(index);

                // 이미 확인한 경우
                if(map.containsKey(compareWord)) continue;

                // 비교 단어 확인
                int wordIndex = 0;
                int differentCount = 0;
                for(int alphaIndex=0; alphaIndex<compareWord.length(); alphaIndex++) {

                    // 기준 단어 길이의 범위를 벗어난 경우
                    if(wordIndex == word.length()) break;

                    // 알파벳이 같은 경우
                    if(compareWord.charAt(alphaIndex) == word.charAt(wordIndex)) {
                        wordIndex++;
                    }

                    // 알파벳이 다른 경우
                    else {
                        differentCount++;

                        // 알파벳이 2개 다른 경우
                        if(differentCount == 2) break;
                    }
                }

                // 순서가 맞으면서 알파벳 하나만 다른 경우
                if(differentCount <= 1 && !map.containsKey(compareWord)) {
                    queue.offer(compareWord);
                    map.put(compareWord, true);
                    answer = answer.length() < compareWord.length() ? compareWord : answer;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 단어 개수, 시작 단어 입력
        st = new StringTokenizer(br.readLine());
        wordCount = Integer.parseInt(st.nextToken());
        startWord = st.nextToken();

        // 단어 저장 리스트 생성
        words = new ArrayList<>();
        for(int index=0; index<=80; index++) {
            words.add(new ArrayList<>());
        }

        // 단어 정보 입력
        for(int index=0; index<wordCount; index++) {
            String word = br.readLine();

            // 길이가 3이하인 경우 - 조건: 기본 길이 3
            if(word.length() <= 3) continue;
            words.get(word.length()).add(word);
        }

        // 단어 확인
        answer = startWord;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}