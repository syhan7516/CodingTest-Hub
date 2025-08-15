import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 손님 수, 초밥 수 입력
        st = new StringTokenizer(br.readLine());
        int clientCount = Integer.parseInt(st.nextToken());
        int sushiCount = Integer.parseInt(st.nextToken());

        // 주문 목록 리스트 생성
        ArrayList<ArrayList<Integer>> orderList = new ArrayList<>();
        for(int client=0; client<=clientCount; client++) {
            orderList.add(new ArrayList<>());
        }

        // 초밥 개수 배열 생성
        int[] suhi = new int[200001];

        // 메뉴 입력
        for(int client=1; client<=clientCount; client++) {
            st = new StringTokenizer(br.readLine());
            int suhiCount = Integer.parseInt(st.nextToken());
            for(int index=0; index<suhiCount; index++) {
                orderList.get(client).add(Integer.parseInt(st.nextToken()));
            }
        }

        // 초밥 순서 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=sushiCount; index++) {
            suhi[Integer.parseInt(st.nextToken())]++;
        }

        // 먹은 초밥 개수 확인
        for(int client=1; client<=clientCount; client++) {
            int count = 0;
            for(int index=0; index<orderList.get(client).size(); index++) {
                int kinds = orderList.get(client).get(index);
                if(suhi[kinds] > 0) {
                    suhi[kinds]--;
                    count++;
                }
            }
            sb.append(count).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}