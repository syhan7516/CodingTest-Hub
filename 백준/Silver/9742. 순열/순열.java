import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 문제 문자열
    public static String letters;
    // 차례, 현재 차례
    public static int order, curOrder;
    // 결과 문자열 배열
    public static char result[];
    // 문자 방문 표시 배열
    public static boolean visited[];
    // 찾기 결과
    public static boolean isFind;

    // 순열 함수
    static void permutation(int depth) {

        // 종료 조건 (다 섞은 경우)
        if(depth==letters.length()) {
            curOrder += 1;
            if(order==curOrder) {
                String res = "";
                for(char element: result) res += element;
                System.out.println(letters+" "+order+" = "+res);
                isFind = true;
                return ;
            }
        }

        // 덜 섞은 경우
        for(int p=0; p<letters.length(); p++) {
            if(visited[p]==false) {
                visited[p] = true;
                result[depth] = letters.charAt(p);
                permutation(depth+1);
                visited[p] = false;

                // 이미 다 찾은 경우
                if(isFind==true)
                    return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while((line=br.readLine())!=null) {
            // 문자열, 차례 입력
            st = new StringTokenizer(line);
            letters = st.nextToken();
            order = Integer.parseInt(st.nextToken());

            // 기본 셋팅
            result = new char[letters.length()];
            visited = new boolean[letters.length()];

            // 문자 섞기
            isFind = false;
            curOrder = 0;
            permutation(0);

            // 못찾은 경우
            if(!isFind)
                System.out.println(letters+" "+order+" = No permutation");
        }
    }
}