import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    // 막대, 색깔
    public static String stick, leftColor, rightColor;

    // 막대 저장 인덱스, 색깔 인덱스
    public static int colorIndex, leftColorIndex, rightColorIndex;

    // 막대 인덱스 저장 해시
    public static HashMap<String, Integer> stickIndexes;

    // 막대 저장 리스트
    public static ArrayList<String> sticks;

    // 차수 저장 배열
    public static int[] degrees;

    // 집합 배열
    public static int[] groups;

    // 그룹 종류 저장 셋
    public static HashSet<Integer> kinds;

    // 차수 확인 메서드
    public static String canConnectStick() {
        int oddCount = 0;
        for (int index = 0; index < degrees.length; index++) {
            if (degrees[index] % 2 == 1) {
                oddCount++;
            }
        }
        if (oddCount == 0 || oddCount == 2) return "Possible";
        else return "Impossible";
    }

    // find
    public static int find(int color) {
        if (groups[color] == color) {
            return color;
        }
        return groups[color] = find(groups[color]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) groups[b] = a;
        else groups[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        stickIndexes = new HashMap<>();
        sticks = new ArrayList<>();

        // 막대 입력
        colorIndex = 1;
        while ((stick = br.readLine()) != null && !stick.isEmpty()) {
            sticks.add(stick);

            st = new StringTokenizer(stick);
            leftColor = st.nextToken();
            rightColor = st.nextToken();

            if (!stickIndexes.containsKey(leftColor)) {
                stickIndexes.put(leftColor, colorIndex++);
            }
            if (!stickIndexes.containsKey(rightColor)) {
                stickIndexes.put(rightColor, colorIndex++);
            }
        }

        // 색이 하나도 없는 경우
        if (stickIndexes.isEmpty()) {
            System.out.println("Possible");
            return;
        }

        degrees = new int[stickIndexes.size() + 1];
        groups = new int[stickIndexes.size() + 1];
        for (int index = 1; index < groups.length; index++) {
            groups[index] = index;
        }

        // 막대 확인
        for (int index = 0; index < sticks.size(); index++) {
            st = new StringTokenizer(sticks.get(index));
            leftColor = st.nextToken();
            rightColor = st.nextToken();

            leftColorIndex = stickIndexes.get(leftColor);
            rightColorIndex = stickIndexes.get(rightColor);

            degrees[leftColorIndex]++;
            degrees[rightColorIndex]++;

            union(leftColorIndex, rightColorIndex);
        }

        // 연결성 확인 (간선이 있는 색만 체크)
        kinds = new HashSet<>();
        for (int idx = 1; idx < groups.length; idx++) {
            if (degrees[idx] > 0) {
                kinds.add(find(idx));
            }
        }

        if (kinds.isEmpty()) { 
            // 간선이 아예 없는 경우
            System.out.println("Possible");
        } else if (kinds.size() == 1) {
            System.out.println(canConnectStick());
        } else {
            System.out.println("Impossible");
        }
    }
}
