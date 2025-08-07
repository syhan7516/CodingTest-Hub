import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 땅 개수 입력
        int groundCount = Integer.parseInt(br.readLine());

        // 땅 정보 입력
        for(int index=0; index<groundCount; index++) {
            st = new StringTokenizer(br.readLine());

            // 전쟁 여부
            long winner = 0;

            // 해시 맵 생성
            HashMap<Long,Integer> map = new HashMap<>();

            // 병사 수 입력
            int armyCount = Integer.parseInt(st.nextToken());

            // 병사 절반 수
            int armyHalfCount = armyCount / 2;

            // 병사 정보 입력
            for(int army=0; army<armyCount; army++) {
                long armyNum = Long.parseLong(st.nextToken());
                map.put(armyNum, map.getOrDefault(armyNum, 0) + 1);
            }

            // 군대 번호 수 확인
            for(long armyNum: map.keySet()) {
                if(map.get(armyNum) > armyHalfCount) {
                    winner = armyNum;
                    break;
                }
            }

            // 군대 확인
            if(winner == 0) sb.append("SYJKGW").append("\n");
            else sb.append(winner).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}