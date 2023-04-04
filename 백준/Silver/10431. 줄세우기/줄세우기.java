import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 각 반의 줄 정보 리스트
            ArrayList<Integer> height = new ArrayList<>();

            // 학생들의 키 정보 입력
            st = new StringTokenizer(br.readLine());

            // 반 입력
            int classNum = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int idx=0; idx<20; idx++) {
                boolean flag = false;
                int h = Integer.parseInt(st.nextToken());
                for(int s=0; s<height.size(); s++) {

                    // 학생 줄 세우기 조건 확인
                    if(height.get(s)>h) {
                        height.add(s,h);
                        count += height.size()-s-1;
                        flag = true;
                        break;
                    }
                }

                // 현재 자신이 제일 클 경우
                if(!flag)
                    height.add(h);
            }

            // 결과 출력
            System.out.println(classNum+" "+count);
        }
    }
}