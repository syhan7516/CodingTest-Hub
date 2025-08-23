import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    // 재료 개수
    public static int materialCount;

    // 재료 질량 배열
    public static int[] mass;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 최소 공배수 메서드
    public static int getGcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return getGcd(b, a % b);
    }

    // 재료 질량 갱신 메서드
    public static void updateMaterialMass(int material, int value) {

        // 방문 처리
        visited[material] = true;
        mass[material] *= value;

        for(int materialIndex=0; materialIndex<relations.get(material).size(); materialIndex++) {

            // 연결된 재료
            int connectedMaterial = relations.get(material).get(materialIndex);

            // 이미 확인한 경우
            if(visited[connectedMaterial]) continue;

            // 질량 갱신
            updateMaterialMass(connectedMaterial, value);
        }
    }

    // 연산 수행 메서드
    public static void checkMaterial(int fromMaterial, int toMaterial, int fromRate, int toRate) {

        // 비교 재료
        int fromMaterialMassMock = mass[fromMaterial];
        int toMaterialMassMock = mass[toMaterial];

        //

        // 연결된 재료 확인
        updateMaterialMass(fromMaterial, toMaterialMassMock * fromRate);
        updateMaterialMass(toMaterial, fromMaterialMassMock * toRate);

        // 연결 정보 저장
        relations.get(fromMaterial).add(toMaterial);
        relations.get(toMaterial).add(fromMaterial);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 재료 개수 입력
        materialCount = Integer.parseInt(br.readLine());

        // 재료 질량 배열 생성
        mass = new int[materialCount];
        Arrays.fill(mass, 1);

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<materialCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        for(int index=0; index<materialCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            int fromMaterial = Integer.parseInt(st.nextToken());
            int toMaterial = Integer.parseInt(st.nextToken());
            int fromRate = Integer.parseInt(st.nextToken());
            int toRate = Integer.parseInt(st.nextToken());

            // 최소 공배수 구하기
            int gcd = getGcd(Math.max(fromRate, toRate), Math.min(fromRate, toRate));

            // 연산 수행
            visited = new boolean[materialCount];
            checkMaterial(fromMaterial, toMaterial, fromRate/gcd, toRate/gcd);
        }

        // 모든 재료를 대상으로 최소 공배수 구하기
        int commonGcd = getGcd(Math.max(mass[0], mass[1]), Math.min(mass[0], mass[1]));
        for(int materialIndex=0; materialIndex<materialCount; materialIndex++) {
            commonGcd = getGcd(Math.max(commonGcd, mass[materialIndex]), Math.min(commonGcd, mass[materialIndex]));
        }

        // 최소 공배수 적용
        for(int materialIndex=0; materialIndex<materialCount; materialIndex++) {
            mass[materialIndex] /= commonGcd;
        }

        // 결과 저장, 출력
        for(int materialIndex=0; materialIndex<materialCount; materialIndex++) {
            sb.append(mass[materialIndex]).append(" ");
        }
        System.out.println(sb.toString());
    }
}