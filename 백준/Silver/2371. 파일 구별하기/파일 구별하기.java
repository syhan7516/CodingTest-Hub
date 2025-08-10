import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    // 구분 여부 메서드
    public static boolean canDivide(ArrayList<ArrayList<Integer>> files, int dataIndex) {

        // 중복 여부 확인 셋 생성
        HashSet<Integer> set = new HashSet<>();

        for(int index=0; index<files.size(); index++) {
            if(files.get(index).size()-1 < dataIndex) continue;

            // 데이터
            int data = files.get(index).get(dataIndex);

            // 포함 여부 확인
            if(set.contains(data)) {
                return false;
            }

            // 포함시키기
            set.add(files.get(index).get(dataIndex));
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 파일 개수 입력
        int fileCount = Integer.parseInt(br.readLine());

        // 파일 저장 리스트 생성
        ArrayList<ArrayList<Integer>> files = new ArrayList<>();
        for(int index=0; index<fileCount; index++) {
            files.add(new ArrayList<>());
        }

        // 파일 정보 입력
        for(int file=0; file<fileCount; file++) {
            st = new StringTokenizer(br.readLine());
            while(true) {
                int data = Integer.parseInt(st.nextToken());
                if(data == -1) break;
                files.get(file).add(data);
            }
        }

        // 구분
        int dataIndex = 0;
        while(true) {
            if(canDivide(files,dataIndex)) {
                System.out.println(dataIndex+1);
                break;
            }

            dataIndex++;
        }
    }
}