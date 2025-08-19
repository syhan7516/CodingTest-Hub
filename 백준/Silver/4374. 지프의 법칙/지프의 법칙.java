import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 문자열
        String letters;

        // 문자열이 없거나, 비어있을 때까지 반복
        while((letters=br.readLine()) != null && !letters.isEmpty()) {

            // 목표 빈도 수
            int targetCount = Integer.parseInt(letters.trim());

            // 단어 개수 저장 해시 맵 생성
            Map<String, Integer> wordCounts = new HashMap<>();

            // 문장이 없을 때까지 반복
            while((letters=br.readLine()) != null) {

                // 공백 제거
                letters = letters.trim();

                // 문단의 끝인 경우
                if (letters.equals("EndOfText")) break;

                // 단어 분리 - 알파벳 아닌 것 제거
                String[] words = letters.toLowerCase().split("[^a-z]+");

                // 분리된 단어 확인
                for(String word: words) {
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }

            // 빈도 수에 맞는 단어 확인
            ArrayList<String> result = new ArrayList<>();
            for(String key : wordCounts.keySet()) {
                if(wordCounts.get(key) == targetCount) {
                    result.add(key);
                }
            }

            // 단어가 없는 경우
            if(result.isEmpty()) {
                sb.append("There is no such word.").append("\n");
            }

            // 단어가 존재하는 경우
            else {

                // 정렬
                Collections.sort(result);

                // 결과 저장
                for(String word: result) {
                    sb.append(word).append("\n");
                }
            }

            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}