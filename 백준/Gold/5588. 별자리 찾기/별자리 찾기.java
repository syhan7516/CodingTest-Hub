import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 별의 개수 입력
        int starCount = Integer.parseInt(br.readLine());

        // 별 위치 저장 배열 생성
        int[][] stars = new int[starCount][2];

        // 별 위치 입력
        for(int index=0; index<starCount; index++) {
            st = new StringTokenizer(br.readLine());
            stars[index][0] = Integer.parseInt(st.nextToken());
            stars[index][1] = Integer.parseInt(st.nextToken());
        }

        // 해시 생성
        HashMap<String, Integer> map = new HashMap<>();

        // 사진의 별 개수 입력
        int starCountInPicture = Integer.parseInt(br.readLine());

        // 별 위치 입력
        for(int index=0; index<starCountInPicture; index++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 위치 비교
            for (int point=0; point<starCount; point++) {
                int nx = x - stars[point][0];
                int ny = y - stars[point][1];

                String key = nx + "," + ny;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        // 해시 확인
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == starCount) {
                String[] arr = entry.getKey().split(",");
                
                // 결과 출력
                System.out.println(arr[0] + " " + arr[1]);
                break;
            }
        }
    }
}