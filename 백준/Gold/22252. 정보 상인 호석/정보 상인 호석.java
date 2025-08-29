import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 결과
    public static long answer;

    // 정보 개수, 정보 인덱스
    public static int informationCount, informationIndex;

    // 인덱스 저장 해시
    public static HashMap<String, Integer> indexes;

    // 우선 순위 큐 리스트
    public static ArrayList<PriorityQueue<Integer>> gorillas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 인덱스 저장 해시 생성
        indexes = new HashMap<>();

        // 우선 순위 큐 리스트 생성
        gorillas = new ArrayList<>();

        // 정보 개수 입력
        informationCount = Integer.parseInt(br.readLine());

        // 정보 입력
        for(int index=0; index<informationCount; index++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            // 이름이 없는 경우
            if(!indexes.containsKey(name)) {
                indexes.put(name, informationIndex++);
                gorillas.add(new PriorityQueue<>(Collections.reverseOrder()));
            }

            // 유형 확인
            if(type == 1) {
                for(int item=0; item<count; item++) {
                    int currentInformationIndex = indexes.get(name);
                    int value = Integer.parseInt(st.nextToken());
                    gorillas.get(currentInformationIndex).offer(value);
                }
            }

            else {
                int currentInformationIndex = indexes.get(name);
                PriorityQueue<Integer> currentGorilla = gorillas.get(currentInformationIndex);
                while(!currentGorilla.isEmpty() && count-- > 0) {
                    answer += currentGorilla.poll();
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}