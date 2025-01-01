import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
// remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
// check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
// toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
// all: S를 {1, 2, ..., 20} 으로 바꾼다.
// empty: S를 공집합으로 바꾼다.

public class Main {

    // 존재 여부 배열
    public static boolean exist[];

    // add
    private static void add(int number) {
        exist[number] = true;
    }

    // remove
    private static void remove(int number) {
        exist[number] = false;
    }

    // check
    private static int check(int number) {
        return exist[number] ? 1 : 0;
    }

    // toggle
    private static void toggle(int number) {
        if(exist[number]) exist[number] = false;
        else exist[number] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 명령 개수 입력
        int orderCount = Integer.parseInt(br.readLine());

        // 존재 여부 배열 생성
        exist = new boolean[21];

        // 명령 확인
        for(int index=0; index<orderCount; index++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            // add
            if("add".equals(order)) {
                add(Integer.parseInt(st.nextToken()));
            }

            // remove
            else if("remove".equals(order)) {
                remove(Integer.parseInt(st.nextToken()));
            }

            // check
            else if("check".equals(order)) {
                sb.append(check(Integer.parseInt(st.nextToken()))).append("\n");
            }

            // toggle
            else if("toggle".equals(order)) {
                toggle(Integer.parseInt(st.nextToken()));
            }

            // all
            else if("all".equals(order)) {
                Arrays.fill(exist,true);
            }

            // empty
            else {
                exist = new boolean[21];
            }
        }

        // 결과
        System.out.println(sb.toString());
    }
}