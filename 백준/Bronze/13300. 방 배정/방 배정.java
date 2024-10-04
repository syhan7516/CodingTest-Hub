import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 결과, 학생 수, 최대 인원
    public static int answer, studentCnt, maxSize;

    // 방 배열
    public static int room[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 학생 수, 최대 인원 입력
        st = new StringTokenizer(br.readLine());
        studentCnt = Integer.parseInt(st.nextToken());
        maxSize = Integer.parseInt(st.nextToken());

        // 방 배열 생성
        room = new int[2][7];

        // 방 초기화
        for(int i=0; i<2; i++)
            Arrays.fill(room[i],maxSize);

        // 학생 정보 입력
        for(int i=0; i<studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 방 확인
            if(room[a][b]==maxSize) {
                answer++;
                room[a][b] = 1;
            }

            else room[a][b]++;
        }

        // 결과 출력
        System.out.println(answer);
    }
}