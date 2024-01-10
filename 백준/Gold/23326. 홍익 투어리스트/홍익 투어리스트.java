import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 구역 수, 쿼리 수 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 명소 표시 배열 생성
        boolean place[] = new boolean[N+1];

        // 명소 관리 트리 셋 생성
        TreeSet<Integer> set = new TreeSet<>();

        // 명소 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            if(st.nextToken().charAt(0)=='1') {
                place[i] = true;
                set.add(i);
            }
        }

        // 시작 위치
        int current = 1;

        // 쿼리 입력
        for(int i=0; i<Q; i++) {

            st = new StringTokenizer(br.readLine());

            // 명령
            int order = Integer.parseInt(st.nextToken());

            // 1
            if(order==1) {
                // 확인 구역
                int number = Integer.parseInt(st.nextToken());

                if(place[number]) {
                    place[number] = false;
                    set.remove(number);
                }
                else {
                    place[number] = true;
                    set.add(number);
                }
            }

            // 2
            else if(order==2) {
                    // 이동 범위
                    int number = Integer.parseInt(st.nextToken()) % N;
                    current += number;
                    if(current>N) current %= N;
            }

            // 3
            else {

                // 명소가 없는 경우
                if(set.size()==0) sb.append(-1).append("\n");

                // 존재하지만 자신의 위치인 경우
                else if(place[current])
                    sb.append(0).append("\n");

                // 명소가 존재하는 경우
                else {
                    Integer h = set.higher(current);
                    Integer l = set.higher(0);

                    if(h==null) sb.append(N-current+l).append("\n");
                    else sb.append(h-current).append("\n");
                }
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}