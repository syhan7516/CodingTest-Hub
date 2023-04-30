import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<10; caseIdx++) {

            // 덤프 수 입력
            int dumpCnt = Integer.parseInt(br.readLine());

            // 상자들 정보 입력
            int boxs[] = new int[101];
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<100; b++) {
                int height = Integer.parseInt(st.nextToken());
                boxs[height] += 1;
            }

            // 박스 덤프 수행
            int left = 1;
            int right = 100;

            while(true) {

                // 종료 조건
                if(dumpCnt==0)
                    break;

                // 최저점 찾기
                while(boxs[left]==0)
                    left++;
                // 최고점 찾기
                while(boxs[right]==0)
                    right--;

                if(left==right)
                    break;

                // 덤프 수행
                boxs[right] -= 1;
                boxs[right-1] += 1;
                if(boxs[right]==0)
                    right--;

                boxs[left] -= 1;
                boxs[left+1] += 1;
                if(boxs[left]==0)
                    left++;

                dumpCnt--;
            }

            int result = right-left;
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}