import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 과제 클래스
class Report {
    int time;
    int score;

    public Report(int time, int score) {
        this.time = time;
        this.score = score;
    }
}

public class Main {

    // 결과, 학기 시간
    public static int answer, totalTime;

    // 과제 스택
    public static Stack<Report> reports;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 과제 스택 생성
        reports = new Stack<>();

        // 학기 시간 입력
        totalTime = Integer.parseInt(br.readLine());

        // 초기 설정
        answer = 0;
        Report report = null;

        // 과제 정보 입력
        for(int i=1; i<=totalTime; i++) {

            st = new StringTokenizer(br.readLine());
            int exist = Integer.parseInt(st.nextToken());

            // 과제가 없는 경우
            if(exist==0) {

                // 수행 중인 과제가 있는 경우
                if(report!=null) {

                    // 과제 수행
                    report.time--;

                    // 과제를 다한 경우
                    if(report.time==0) {
                        answer += report.score;
                        report = reports.isEmpty() ? null : reports.pop();
                    }
                }
            }

            // 과제가 있는 경우
            else {

                // 과제 목록에 저장
                if(report!=null)
                    reports.push(new Report(report.time, report.score));

                // 최근 과제 수행
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                report = new Report(time,score);
                report.time--;

                // 과제를 다한 경우
                if(report.time==0) {
                    answer += report.score;
                    report = reports.isEmpty() ? null : reports.pop();
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}