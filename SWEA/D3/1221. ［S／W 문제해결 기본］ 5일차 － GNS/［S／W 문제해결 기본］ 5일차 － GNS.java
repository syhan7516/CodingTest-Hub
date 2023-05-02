import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 요일 수 배열
    public static String dayName[] = {
            "ZRO", "ONE", "TWO", "THR", "FOR",
            "FIV", "SIX", "SVN", "EGT", "NIN"
    };
    public static int days[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 케이스 번호, 길이 입력
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()+"\n");
            int caseLen = Integer.parseInt(st.nextToken());

            // 케이스 길이만큼 정보 입력
            days = new int[10];
            st = new StringTokenizer(br.readLine());
            for(int l=0; l<caseLen; l++) {
                String day = st.nextToken();

                switch (day) {
                    case "ZRO":
                        days[0]++;
                        break;
                    case "ONE":
                        days[1]++;
                        break;
                    case "TWO":
                        days[2]++;
                        break;
                    case "THR":
                        days[3]++;
                        break;
                    case "FOR":
                        days[4]++;
                        break;
                    case "FIV":
                        days[5]++;
                        break;
                    case "SIX":
                        days[6]++;
                        break;
                    case "SVN":
                        days[7]++;
                        break;
                    case "EGT":
                        days[8]++;
                        break;
                    case "NIN":
                        days[9]++;
                        break;
                    default:
                        break;
                }
            }

            // 요일 정렬
            for(int d=0; d<10; d++) {
                while(true) {
                    // 종료 조건
                    if(days[d]==0)
                        break;

                    // 결과 저장
                    sb.append(dayName[d]+" ");
                    days[d]--;
                }
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}