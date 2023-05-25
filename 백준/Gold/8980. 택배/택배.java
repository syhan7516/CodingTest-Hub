import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 박스 클래스
class Box implements Comparable<Box> {
    private int from;
    private int to;
    private int cnt;

    public Box(int from, int to, int cnt) {
        this.from = from;
        this.to = to;
        this.cnt = cnt;
    }

    public int getFrom() {
        return this.from;
    }

    public int getTo() {
        return this.to;
    }

    public int getCnt() {
        return this.cnt;
    }

    public int compareTo(Box other) {
        if(this.to<other.to)
            return -1;

        else if(this.to==other.to) {
            if(this.from<other.from)
                return -1;
        }

        return 1;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 마을 수, 트럭 용량 입력
        st = new StringTokenizer(br.readLine());
        int townCnt = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        // 박스 정보 개수 입력
        int boxCnt = Integer.parseInt(br.readLine());

        // 박스 정보 입력
        PriorityQueue<Box> priQ = new PriorityQueue<>();
        for(int b=0; b<boxCnt; b++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            priQ.offer(new Box(start,end,cnt));
        }

        // 각 마을 트럭 용량 정보
        int truck[] = new int[townCnt+1];
        Arrays.fill(truck,capacity);

        // 박스 배송
        int result = 0;
        while(!priQ.isEmpty()) {
            // 택배 정보 가져오기
            Box curBox = priQ.poll();
            int curStart = curBox.getFrom();
            int curEnd = curBox.getTo();
            int curCnt = curBox.getCnt();

            // 최대 용량
            int maxBox = Integer.MAX_VALUE;

            // 경로 중 보내기 가능한 최대 한도 구하기
            for(int p=curStart; p<curEnd; p++) {
                maxBox = Math.min(maxBox,truck[p]);
            }

            // 최대 한도가 보내려는 개수보다 큰 경우
            if(maxBox>=curCnt) {
                for(int p=curStart; p<curEnd; p++) {
                    truck[p] -= curCnt;
                }

                result += curCnt;
            }

            // 최대 한도가 보내려는 개수보다 작은 경우
            else {
                for(int p=curStart; p<curEnd; p++) {
                    truck[p] -= maxBox;
                }

                result += maxBox;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}