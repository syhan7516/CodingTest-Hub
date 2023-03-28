import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 유클리드호제법 함수
    static long mathFunction(long firNum, long secNum) {
        
        // 종료 조건
        if(firNum%secNum==0)
            return secNum;

        // b와 a%b의 최대공약수 구하기
        return mathFunction(secNum, firNum%secNum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 심어져있는 나무 수
        int treeCnt = Integer.parseInt(br.readLine());

        // 나무 거리 정보 입력
        long treePoint[] = new long[treeCnt];
        for(int t=0; t<treeCnt; t++) {
            treePoint[t] = Integer.parseInt(br.readLine());
        }

        // 각 나무 사이 거리 확인
        long treeDist[] = new long[treeCnt-1];
        for(int d=0; d<treeCnt-1; d++) {
            treeDist[d] = treePoint[d+1] - treePoint[d];
        }

        // 심을 나무 수 구하기
        long curGcd = treeDist[0];
        for(int idx=1; idx<treeDist.length; idx++) {
            curGcd = mathFunction(curGcd,treeDist[idx]);
        }

        long result = 0;
        int treePointIdx = 0;
        long start = treePoint[0];
        for(long idx=start; idx<treePoint[treeCnt-1]; idx=idx+curGcd) {

            // 해당 위치에 나무가 이미있는 경우
            if(treePoint[treePointIdx]==idx) {
                treePointIdx++;
                continue;
            }

            // 해당 위치에 나무가 없는 경우
            result += 1;
        }

        // 결과 출력
        System.out.println(result);
    }
}