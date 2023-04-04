import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 학생 수 입력
        int studentCnt = Integer.parseInt(br.readLine());

        // 학생이 뽑은 번호표 정보 입력
        ArrayList<Integer> order = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<studentCnt; idx++) {
            int numPaper = Integer.parseInt(st.nextToken());
            
            // 0을 뽑은 학생의 경우
            if(numPaper==0) {
                order.add(idx+1);
            }
            
            // 0이 아닌 수를 뽑은 학생의 경우
            else {
                order.add(idx-numPaper,idx+1);
            }
        }

        // 결과 출력
        for(int element : order)
            System.out.print((element)+" ");
    }
}