import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점 개수
        int nodeCount = Integer.parseInt(br.readLine());

        // 거리 배열 생성
        int road[][] = new int[nodeCount][nodeCount];

        // 거리 정보 입력
        for(int rowIndex=0; rowIndex<nodeCount; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<nodeCount; colIndex++) {
                road[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        // 이동 가능 여부 확인
        for(int k=0; k<nodeCount; k++) {
            for(int i=0; i<nodeCount; i++) {
                for(int j=0; j<nodeCount; j++) {
                    if(road[i][k]==1 && road[k][j]==1)
                        road[i][j] = 1;
                }
            }
        }

        // 결과 출력
        for(int rowIndex=0; rowIndex<nodeCount; rowIndex++) {
            for(int colIndex=0; colIndex<nodeCount; colIndex++) {
                System.out.print(road[rowIndex][colIndex]+" ");
            }
            System.out.println();
        }
    }
}