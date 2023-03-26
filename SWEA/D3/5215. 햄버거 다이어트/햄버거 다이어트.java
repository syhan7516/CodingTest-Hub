import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Hamberger {
    private int kcal;
    private int score;

    public Hamberger(int kcal, int score) {
        this.kcal = kcal;
        this.score = score;
    }

    public int getKcal() {
        return this.kcal;
    }

    public int getScore() {
        return this.score;
    }
}

public class Solution {

    // 재료 수, 제한 칼로리
    public static int foodCnt, maxKcal;
    // 결과
    public static int result;

    // 재료들 정보
    public static Hamberger foods[];

    // 햄버거 만들기 함수
    static void makeHamberger(int curIdx, int totalScore, int totalKcal) {

        for(int idx=curIdx; idx<foods.length; idx++) {
            int nextScore = totalScore + foods[idx].getScore();
            int nextKcal = totalKcal + foods[idx].getKcal();

            // 제한 칼로리 보다 큰 경우
            if(nextKcal>maxKcal) {
                result = Math.max(result,totalScore);
            }

            // 제한 칼로리 보다 작은 경우
            else {
                // 확인할 재료가 없는 경우
                if(idx+1==foods.length)
                    result = Math.max(result,nextScore);

                // 확인할 재료가 있는 경우
                else
                    makeHamberger(idx+1,nextScore,nextKcal);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 재료의 수, 제한 칼로리 입력
            st = new StringTokenizer(br.readLine());
            foodCnt = Integer.parseInt(st.nextToken());
            maxKcal = Integer.parseInt(st.nextToken());

            // 재료 점수 및 칼로리 정보 입력
            foods = new Hamberger[foodCnt];
            for(int idx=0; idx<foodCnt; idx++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                foods[idx] = new Hamberger(b,a);
            }

            // 햄거버 만들기
            result = 0;
            int totalScore = 0;
            int totalKcal = 0;
            makeHamberger(0,totalScore,totalKcal);

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}