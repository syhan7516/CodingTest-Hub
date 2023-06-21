import java.util.Scanner;

public class Main {

    // 계단 개수
    public static int stageCnt;
    // 계단별 누적 점수 배열
    public static int score[];
    // 계단 배열
    public static int stage[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 계단 수 입력
        stageCnt = scanner.nextInt();

        // 계단 & 점수 배열 만들기
        score = new int[stageCnt+1];
        stage = new int[stageCnt+1];

        // 점수 정보 입력
        for(int s=1; s<=stageCnt; s++) {
            stage[s] = scanner.nextInt();
        }

        // 계단 누적 점수 배열 셋팅
        score[1] = stage[1];

        // 1에 대한 예외
        if(stageCnt>=2) {
            score[2] = stage[1]+stage[2];
        }
        
        for(int s=3; s<=stageCnt; s++) {
            score[s] = Math.max(score[s-2],score[s-3]+stage[s-1])+stage[s];
        }
        
        // 결과 출력
        System.out.println(score[stageCnt]);
    }
}