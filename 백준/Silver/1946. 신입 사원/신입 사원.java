import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 성적 클래스
class Score {

    int document;
    int interview;

    public Score(int document, int interview) {
        this.document = document;
        this.interview = interview;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseIndex=0; caseIndex<caseNum; caseIndex++) {

            // 인원 입력
            int count = Integer.parseInt(br.readLine());

            // 배열 생성
            Score socres[] = new Score[count];
            int DP[] = new int[count];

            // 시험 정보 입력
            for(int exam=0; exam<count; exam++) {
                st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                socres[exam] = new Score(document, interview);
            }

            // 성적 정렬
            Arrays.sort(socres, (a,b) -> a.document - b.document);

            // 성적 확인
            int answer = 1;
            int interviewScore = socres[0].interview;

            for(int index=1; index<count; index++) {
                if(interviewScore>socres[index].interview) {
                    answer++;
                    interviewScore = socres[index].interview;
                }
            }

            // 결과 저장
            sb.append(answer).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}