import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 단어 개수, 학습 글자 수
    public static int answer, wordCount, possibleCount;

    // 알파벳 학습 여부 배열
    public static boolean visited[];

    // 단어 배열
    public static String words[];

    // 필수 학습 알파벳
    public static char required[] = {'a','n','t','i','c'};

    // 단어 확인 메서드
    public static void solve(int index, int selectedCount) {

        // 선택이 완료된 경우
        if(selectedCount==possibleCount) {

            // 학습 가능한 단어 수
            int count = 0;

            // 단어 확인
            for(int word=0; word<wordCount; word++) {

                // 통과 여부
                boolean flag = true;

                for(int alpha=0; alpha<words[word].length(); alpha++) {

                    // 확인 문자
                    char letter = words[word].charAt(alpha);

                    // 문자가 없는 경우
                    if(!visited[letter-'a']) {
                        flag = false;
                        break;
                    }
                }

                // 통과한 경우
                if(flag) count++;
            }

            // 결과 갱신
            answer = Math.max(answer,count);
            return;
        }

        // 선택하기
        for(int alpha=index; alpha<26; alpha++) {

            // 미학습한 경우
            if(!visited[alpha]) {
                visited[alpha] = true;
                solve(alpha+1,selectedCount+1);
                visited[alpha] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 단어 개수, 학습 글자 수 입력
        st = new StringTokenizer(br.readLine());
        wordCount = Integer.parseInt(st.nextToken());
        possibleCount = Integer.parseInt(st.nextToken());

        // 단어 배열 생성
        words = new String[wordCount];

        // 단어 저장
        for(int word=0; word<wordCount; word++) {
            st = new StringTokenizer(br.readLine());
            String letter = st.nextToken();
            words[word] = letter.substring(4,letter.length()-4);
        }

        // 알파벳 학습 여부 배열 생성 및 초기화
        visited = new boolean[26];
        for(int index=0; index<required.length; index++)
            visited[required[index]-'a'] = true;

        // 결과
        answer = 0;

        // 알파벳을 5개 미만으로 배운 경우
        if(possibleCount<5) System.out.println(0);

        // 알파벳을 모두 배운 경우
        else if(possibleCount==26) System.out.println(wordCount);

        // 아닌 경우
        else {
            possibleCount -= 5;
            solve(0,0);
            System.out.println(answer);
        }
    }
}