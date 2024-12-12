import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // 결과, 크레인 개수, 박스 개수
    public static int answer, craneCount, boxCount;

    // 무게 제한 리스트
    public static ArrayList<Integer> craneWeights, boxWeights;

    // 박스 옮기기 메서드
    public static int solve() {

        // 일
        int day = 0;

        // 박스 옮기기
        while(!boxWeights.isEmpty()) {

            // 옮겨야하는 박스 개수
            int moveBoxCount = boxWeights.size();

            // 위치 설정
            int boxIndex = 0;
            int craneIndex = 0;

            // 크레인 확인
            while(craneIndex<craneCount) {

                // 박스를 다 확인한 경우
                if(boxIndex==boxWeights.size()) {

                    // 이동 불가능한 경우
                    if(moveBoxCount==boxWeights.size()) {
                        return -1;
                    }

                    break;
                }

                // 박스 옮기기
                else if(boxWeights.get(boxIndex)<=craneWeights.get(craneIndex)) {
                    boxWeights.remove(boxIndex);
                    craneIndex++;
                }

                // 다음 박스
                else boxIndex++;
            }

            // 일 수 증가
            day++;
        }

        return day;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크레인 개수 입력
        craneCount = Integer.parseInt(br.readLine());

        // 크레인 무게 제한 리스트 생성
        craneWeights = new ArrayList<>();

        // 크레인 무게 제한 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int weight=0; weight<craneCount; weight++) {
            craneWeights.add(Integer.parseInt(st.nextToken()));
        }

        // 박스 개수 입력
        boxCount = Integer.parseInt(br.readLine());

        // 박스 무게 리스트 생성
        boxWeights = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int weight=0; weight<boxCount; weight++) {
            boxWeights.add(Integer.parseInt(st.nextToken()));
        }

        // 모든 무게 리스트 내림차순 정렬
        craneWeights.sort(Collections.reverseOrder());
        boxWeights.sort(Collections.reverseOrder());

        // 결과
        answer = solve();

        // 결과 출력
        System.out.println(answer);
    }
}