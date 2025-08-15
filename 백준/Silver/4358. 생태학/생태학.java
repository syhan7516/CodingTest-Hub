import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 총 개수
        int totalCount = 0;

        // 나무 저장 해시 맵 생성
        HashMap<String, Integer> trees = new HashMap<>();

        // 사전 순 저장 트리 셋 생성
        TreeSet<String> treeNames = new TreeSet<>();

        // 종 입력
        String treeName;
        while((treeName = br.readLine()) != null) {
            trees.put(treeName, trees.getOrDefault(treeName, 0) + 1);
            treeNames.add(treeName);
            totalCount++;
        }

        // 결과 저장
        for(String tree: treeNames) {
            double value = (int)Math.round((double)trees.get(tree)/totalCount * 1000000) * 0.0001;
            sb.append(tree).append(" ");
            sb.append(String.format("%.4f",value)).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}