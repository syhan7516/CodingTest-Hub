import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 직사각형 좌표 입력
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 점의 수 입력
            int pointCnt = Integer.parseInt(br.readLine());
            // 점의 정보 입력
            int points[][] = new int[pointCnt][2];
            for(int p=0; p<pointCnt; p++) {
                st = new StringTokenizer(br.readLine());
                points[p][0] = Integer.parseInt(st.nextToken());
                points[p][1] = Integer.parseInt(st.nextToken());
            }

            // 점 확인
            int count[] = new int[3];
            for(int p=0; p<pointCnt; p++) {
                int x = points[p][0];
                int y = points[p][1];

                // 직사각형 내부에 있을 경우
                if(x>x1 && x<x2 && y>y1 && y<y2) {
                    count[0] += 1;
                }
                // 직사각형 변에 위치할 경우
                else if(x>=x1 && x<=x2 && y>=y1 && y<=y2) {
                    count[1] += 1;
                }
                // 직사각형 외부에 위치할 경우
                else {
                    count[2] += 1;
                }
            }

            // 결과 출력
            System.out.print("#"+(caseIdx+1)+" ");
            for(int element: count)
                System.out.print(element+" ");
            System.out.println();
        }
    }
}