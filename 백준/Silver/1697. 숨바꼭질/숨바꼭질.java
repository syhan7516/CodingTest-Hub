import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수빈, 동생 위치 입력
        st = new StringTokenizer(br.readLine());
        int firPoint = Integer.parseInt(st.nextToken());
        int secPoint = Integer.parseInt(st.nextToken());

        // 장소
        int house[] = new int[100001];

        // 이동
        int result = 0;
        Queue<Integer> nodes = new LinkedList<>();
        nodes.offer(firPoint);

        while(!nodes.isEmpty()) {
            int curNode = nodes.poll();

            // 찾은 경우
            if(curNode==secPoint) {
                result = house[curNode];
                break;
            }

            int dir[] = {curNode+1,curNode-1,curNode*2};

            for(int d=0; d<3; d++) {
                // 진행할 방향
                int nextDir = dir[d];

                // 범위 확인
                if(nextDir<0 || nextDir>100000 || house[nextDir]!=0)
                    continue;

                // 경로 추가
                house[nextDir] = house[curNode]+1;
                nodes.offer(nextDir);
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}