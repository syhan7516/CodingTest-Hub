import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 물건 개수, 쌍 개수 입력
        int count = Integer.parseInt(br.readLine());
        int pairCount = Integer.parseInt(br.readLine());

        // 물건 정보 배열 생성
        boolean information[][] = new boolean[count+1][count+1];

        // 물건 정보 반대 배열 생성
        boolean reverseInformation[][] = new boolean[count+1][count+1];

        // 물건 쌍 정보 입력
        for (int i=0; i<pairCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            information[a][b] = true;
            reverseInformation[b][a] = true;
        }

        // 플로이드 워셜 수행
        for (int k=1; k<=count; k++) {
            for (int i=1; i<=count; i++) {
                for (int j=1; j<=count; j++) {

                    if(information[i][k] && information[k][j])
                        information[i][j] = true;

                    if(reverseInformation[i][k] && reverseInformation[k][j])
                        reverseInformation[i][j] = true;
                }
            }
        }

        // 물건 비교
        for (int i=1; i<=count; i++) {
            for (int j=1; j<=count; j++)
                information[i][j] |= reverseInformation[i][j];
        }

        for (int i = 1; i <= count; i++) {
            int cnt = 0;
            for (int j = 1; j <= count; j++) {
                
                if (i == j) continue;
                
                if (!information[i][j])
                    cnt++;
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb.toString());
    }
}