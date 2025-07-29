import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 정점 수, 질의 수
    public static int nodeCount, orderCount;

    // 정점 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 정점 수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 정점 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        for(int index=0; index<nodeCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relations.get(from).add(to);
            relations.get(to).add(from);
        }

        // 질의 입력
        orderCount = Integer.parseInt(br.readLine());
        for(int index=0; index<orderCount; index++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int order = Integer.parseInt(st.nextToken());

            if(type == 1) {
                if(relations.get(order).size() > 1) {
                    sb.append("yes").append("\n");
                }
                else sb.append("no").append("\n");
            }

            else sb.append("yes").append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}