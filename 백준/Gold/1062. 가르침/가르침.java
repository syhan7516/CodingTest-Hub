
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 존재 단어 수, 학습 단어 수, 결과
    public static int existCnt, studyCnt, result;
    // 단어 종류 배열
    public static String word[];
    // 알파벳 존재 여부 배열
    public static boolean visited[];

    // 학습 단어 확인 함수
    static void getStudy(int idx, int depth) {

        // 단어를 다 찾은 경우
        if(depth==studyCnt-5) {
            // 해당 알파벳으로 학습 가능한 단어 수
            int count = 0;
            // 단어 가져오기
            for(int a=0; a<existCnt; a++) {
                // 단어 학습 가능 여부
                boolean check = true;
                // 단어 알파벳 가져오기
                for(int b = 0; b< word[a].length(); b++) {
                    // 해당 알파벳이 존재하지 않은 경우
                    if(!visited[word[a].charAt(b)-'a']) {
                        check = false;
                        break;
                    }
                }

                // 학습 가능한 경우
                if(check) count++;
            }

            // 학습 가능한 최대 단어 수 갱신
            result = Math.max(result,count);
            return;
        }

        // 단어 찾기
        for(int v=idx; v<26; v++) {
            // 미방문 알파벳인 경우
            if(!visited[v]) {
                visited[v] = true;
                getStudy(v+1,depth+1);
                visited[v] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 존재 단어 수, 학습 단어 수 입력
        st = new StringTokenizer(br.readLine());
        existCnt = Integer.parseInt(st.nextToken());
        studyCnt = Integer.parseInt(st.nextToken());

        // 단어 입력
        word = new String[existCnt];
        for(int v=0; v<existCnt; v++) {
            String reStr = br.readLine();
            reStr = reStr.replace("anta","");
            reStr = reStr.replace("tica","");
            word[v] = reStr;
        }

        // 기본 단어 학습 불가인 경우
        if(studyCnt<5) {
            System.out.println(0);
        }

        // 모든 알파벳을 학습이 가능한 경우
        else if(studyCnt==26) {
            System.out.println(existCnt);
        }

        // 그 외
        else {
            // 기본 셋팅
            result = 0;
            visited = new boolean[26];
            visited['a'-'a'] = true;
            visited['n'-'a'] = true;
            visited['t'-'a'] = true;
            visited['c'-'a'] = true;
            visited['i'-'a'] = true;

            // 학습 단어 확인
            getStudy(0,0);

            // 결과 출력
            System.out.println(result);
        }
    }
}