import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 재료 개수
    public static int answer, ingredientCount;

    // 재료 배열
    public static int ingredients[][];

    // 재료 선택하기 메서드
    public static void solve(int index, int selectedCount, int s, int ss) {

        // 재료 선택이 완료된 경우
        if(index==ingredientCount) {

            // 재료 선택이 하나도 안된 경우
            if(selectedCount==0) return;

            // 결과 갱신
            answer = Math.min(answer,Math.abs(s-ss));
            return;
        }

        // 재료 선택, 미선택
        solve(index+1,selectedCount+1,s*ingredients[index][0],ss+ingredients[index][1]);
        solve(index+1,selectedCount,s,ss);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 재료 개수 입력
        ingredientCount = Integer.parseInt(br.readLine());

        // 재료 배열 생성
        ingredients = new int[ingredientCount][2];

        // 재료 정보 입력
        for(int ingredient=0; ingredient<ingredientCount; ingredient++) {
            st = new StringTokenizer(br.readLine());
            ingredients[ingredient][0] = Integer.parseInt(st.nextToken());
            ingredients[ingredient][1] = Integer.parseInt(st.nextToken());
        }

        // 재료 선택하기
        answer = (int)1e9;
        solve(0,0,1,0);

        // 결과 출력
        System.out.println(answer);
    }
}