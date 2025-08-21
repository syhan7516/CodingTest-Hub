import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    // 빌더
    public static StringBuilder sb;

    // 단어 저장 리스트
    public static ArrayList<int[]> words;

    // 알파벳 개수 확인 메서드
    public static int[] saveAlphabetCount(String word) {

        // 알파벳 개수 저장 배열 생성
        int[] alphabets = new int[26];

        // 알파벳 개수 확인
        for(int index = 0; index<word.length(); index++) {
            alphabets[word.charAt(index) - 'A']++;
        }

        return alphabets;
    }

    // 단어 제작 가능 여부 확인 메서드
    public static boolean canMakeWord(int[] alphabetCount, int[] alphabets) {
        for(int index=0; index<alphabetCount.length; index++) {
            if(alphabetCount[index] > alphabets[index]) {
                return false;
            }
        }

        return true;
    }

    // 결과 저장 메서드
    public static void saveResult(int[] sum, int[] alphabets, int count) {
        for(int index=0; index<sum.length; index++) {
            if(alphabets[index] > 0 && sum[index] == count) {
                sb.append((char)(index + 'A'));
            }
        }
        sb.append(" ").append(count).append(" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 단어 저장 해시 생성
        words = new ArrayList<>();

        // 단어 입력
        String word;
        while(!"-".equals(word = br.readLine())) {

            // 단어 저장
            words.add(saveAlphabetCount(word));
        }

        // 퍼즐 입력
        while(!"#".equals(word = br.readLine())) {
            int[] alphabets = saveAlphabetCount(word);

            // 제작 가능한 단어의 알파벳 개수 저장 배열 생성
            int[] sum = new int[26];

            // 단어 제작 가능 여부 확인
            for(int[] alphabetCount: words) {

                // 단어 제작이 불가능한 경우
                if(!canMakeWord(alphabetCount, alphabets)) continue;

                // 단어 개수 더하기 - 해당 알파벳으로 단어 제작 가능
                for(int index=0; index<alphabetCount.length; index++) {
                    if(alphabetCount[index] > 0) {
                        sum[index]++;
                    }
                }
            }

            // 알파벳별 제작 가능한 최대, 최소 개수
            int maxCount = Integer.MIN_VALUE;
            int minCount = Integer.MAX_VALUE;

            // 확인
            for(int index=0; index<sum.length; index++) {

                // 퍼즐에 포함되면서 최소, 최대 개수 갱신
                if(alphabets[index] > 0) {
                    minCount = Math.min(minCount, sum[index]);
                    maxCount = Math.max(maxCount, sum[index]);
                }
            }

            // 결과 저장
            saveResult(sum, alphabets, minCount);
            saveResult(sum, alphabets, maxCount);
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}