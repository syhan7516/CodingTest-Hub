
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 구멍의 개수, 전기 용품 횟수 입력
        st = new StringTokenizer(br.readLine());
        int holeCnt = Integer.parseInt(st.nextToken());
        int useCnt = Integer.parseInt(st.nextToken());

        // 제품 사용 순서 정보 입력
        int order[] = new int[useCnt];
        st = new StringTokenizer(br.readLine());
        for(int o=0; o<useCnt; o++) {
            order[o] = Integer.parseInt(st.nextToken());
        }

        // 결고
        int result = 0;
        // 제품 사용 여부 배열
        boolean visited[] = new boolean[useCnt+1];
        // 현재 연결 제품 수
        int curCnt = 0;
        // 연결 수행
        for(int o=0; o<useCnt; o++) {
            // 연결하려는 제품
            int num = order[o];

            // 제품이 미연결인 경우
            if(!visited[num]) {

                // 공간이 있는 경우
                if(curCnt<holeCnt) {
                    visited[num] = true;
                    curCnt++;
                }
                // 공간이 없는 경우
                else {
                    // 연결 제품 정보 가져오기
                    ArrayList<Integer> connect = new ArrayList<>();
                    for(int c=o; c<order.length; c++) {
                        // 연결 제품인 경우 추가
                        if(visited[order[c]] && !connect.contains(order[c]))
                            connect.add(order[c]);
                    }

                    // 가장 마지막에 사용되는 제품 확인
                    if(connect.size()==holeCnt) {
                        int rm = connect.get(connect.size()-1);
                        visited[rm] = false;
                    }
                    
                    // 연결 0 제품 확인
                    else {
                        for(int c=1; c<=useCnt; c++) {
                            if(visited[c] && !connect.contains(c)) {
                                visited[c] = false;
                                break;
                            }
                        }
                    }

                    // 제품 연결, 제품 해제 횟수 처리
                    visited[num] = true;
                    result++;
                }
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}