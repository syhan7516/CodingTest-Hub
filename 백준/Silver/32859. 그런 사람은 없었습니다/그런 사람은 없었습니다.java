import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 정산 클래스
class Adjustment {
    boolean isDeposit;
    boolean isSubmit;
    int time;

    public Adjustment(boolean isDeposit, boolean isSubmit, int time) {
        this.isDeposit = isDeposit;
        this.isSubmit = isSubmit;
        this.time = time;
    }

    public boolean isAdjustment() {
        return isDeposit && isSubmit;
    }
}

public class Main {

    // 회원 수, 사건 수, 기간
    public static int memberCount, caseCount, term;

    // 정산 여부 배열
    public static boolean[] visited;

    // 정산 정보 배열
    public static Adjustment[] adjustments;

    // 결과 리스트
    public static ArrayList<Integer> answer;

    // 미정산 회원 확인 메서드
    public static void checkIsNotAdjustmentMember() {
        for(int member=1; member<=memberCount; member++) {

            // 정산이 완료된 회원인 경우
            if(visited[member]) continue;

            // 입금이 완료된 회원인 경우
            if(adjustments[member].isDeposit) {
                adjustments[member].time++;

                // 제한 기간이 넘은 경우
                if(adjustments[member].time == term) {
                    visited[member] = true;
                    answer.add(member);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 회원 수, 사건 수 입력
        st = new StringTokenizer(br.readLine());
        memberCount = Integer.parseInt(st.nextToken());
        caseCount = Integer.parseInt(st.nextToken());

        // 기간 입력
        term = Integer.parseInt(br.readLine());

        // 정산 정보 배열 생성
        adjustments = new Adjustment[memberCount+1];
        for(int index=1; index<adjustments.length; index++) {
            adjustments[index] = new Adjustment(false, false, 0);
        }

        // 정산 여부 배열 생성
        visited = new boolean[memberCount+1];

        // 결과 리스트 생성
        answer = new ArrayList<>();

        // 사건 정보 입력
        for(int index=0; index<caseCount; index++) {
            st = new StringTokenizer(br.readLine());
            int memberNum = Integer.parseInt(st.nextToken());
            int caseType = Integer.parseInt(st.nextToken());

            // 입금인 경우
            if(caseType == 1) {

                // 입금 완료 처리
                adjustments[memberNum].isDeposit = true;

                // 정산 완료 여부 확인
                if(adjustments[memberNum].isAdjustment()) {
                    visited[memberNum] = true;
                }
            }

            // 폼 제출인 경우
            else {

                // 폼 제출 완료 처리
                adjustments[memberNum].isSubmit = true;

                // 정산 완료 여부 확인
                if(adjustments[memberNum].isAdjustment()) {
                    visited[memberNum] = true;
                }

                // 미정산 회원 확인
                checkIsNotAdjustmentMember();
            }
        }

        // 모든 회원의 정산이 완료된 경우
        if(answer.isEmpty()) {
            System.out.println(-1);
        }

        // 아닌 경우
        else {

            // 오름차순 정렬
            Collections.sort(answer);

            // 결과 저장 및 출력
            for(int member: answer) {
                sb.append(member).append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}