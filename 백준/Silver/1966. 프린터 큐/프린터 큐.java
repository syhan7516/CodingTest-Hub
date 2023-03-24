import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Paper {
    private int value;
    private int point;

    public Paper(int value, int point) {
        this.value = value;
        this.point = point;
    }

    public int getValue() {
        return this.value;
    }

    public int getPoint() {
        return this.point;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 문서의 수, 문서 위치 입력
            st = new StringTokenizer(br.readLine());
            int paperCnt = Integer.parseInt(st.nextToken());
            int paperPoint = Integer.parseInt(st.nextToken());

            // 큐, 배열 생성
            Queue<Paper> queue = new LinkedList<>();
            int values[] = new int[paperCnt];

            // 종이 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int p=0; p<paperCnt; p++) {
                int value = Integer.parseInt(st.nextToken());
                values[p] = value;
                queue.offer(new Paper(value,p));
            }

            // 정렬
            Arrays.sort(values);

            // 인쇄하기
            int count = 1;
            int result = 0;
            int num = values.length-1;
            int checkNum = values[num];
            while(!queue.isEmpty()) {
                Paper curPaper = queue.poll();
                // 우선 순위를 찾은 경우
                if(checkNum == curPaper.getValue()) {
                    // 찾았는데 원하는 위치였을 경우
                    if(curPaper.getPoint() == paperPoint) {
                        result = count;
                        break;
                    }
                    count += 1;
                    checkNum = values[--num];
                }
                // 못찾은 경우
                else {
                    queue.offer(curPaper);
                }
            }

            // 결과 출력
            System.out.println(result);
        }
    }
}