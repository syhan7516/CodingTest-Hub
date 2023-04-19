import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int count = 1;

        while(true) {
            // 종료 조건
            if(count==11)
                break;

            // 암호문 저장 리스트
            ArrayList<Integer> sentense = new ArrayList<>();

            // 원본 암호문의 길이 입력
            int sentenstLen = Integer.parseInt(br.readLine());

            // 암호문 입력
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<sentenstLen; n++)
                sentense.add(Integer.parseInt(st.nextToken()));

            // 명령어 개수 입력
            int orderCnt = Integer.parseInt(br.readLine());

            // 명령어 입력
            st = new StringTokenizer(br.readLine());
            for(int o=0; o<orderCnt; o++) {
                char order = st.nextToken().charAt(0);

                // 각 명령어 처리
                switch (order) {
                    case 'I':
                        int insertPoint = Integer.parseInt(st.nextToken());
                        int insertCnt = Integer.parseInt(st.nextToken());
                        for(int i=0; i<insertCnt; i++) {
                            sentense.add(insertPoint+i,Integer.parseInt(st.nextToken()));
                        }
                        break;
                    case 'D':
                        int deletePoint = Integer.parseInt(st.nextToken());
                        int deleteCnt = Integer.parseInt(st.nextToken());
                        for(int d=0; d<deleteCnt; d++) {
                            sentense.remove(deletePoint);
                        }
                        break;
                    case 'A':
                        int addCnt = Integer.parseInt(st.nextToken());
                        for(int a=0; a<addCnt; a++) {
                            sentense.add(sentense.size(),Integer.parseInt(st.nextToken()));
                        }
                        break;
                }
            }

            // 결과 저장
            sb.append("#"+count+" ");
            for(int ans=0; ans<10; ans++)
                sb.append(sentense.get(ans)+" ");
            sb.append("\n");

            // 테스트 케이스 번호 증가
            count++;
        }
        // 결과 출력
        System.out.println(sb.toString());
    }
}