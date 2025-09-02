import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] tree;           // 1-based
    static int X;
    static ArrayList<Integer> inorderIdx;
    static int missingIndexOriginal = -1;

    static void buildInorder(int idx, int n) {
        if (idx > n) return;
        buildInorder(idx * 2, n);
        inorderIdx.add(idx);
        buildInorder(idx * 2 + 1, n);
    }

    static void postOrder(int idx, StringBuilder sb) {
        if (idx > N) return;
        postOrder(idx * 2, sb);
        postOrder(idx * 2 + 1, sb);
        sb.append(tree[idx]).append(' ');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        tree = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int v = Integer.parseInt(st.nextToken());
            tree[i] = v;
            if (v == -1 && missingIndexOriginal == -1) {
                missingIndexOriginal = i; // 원래 -1 자리 기록
            }
        }

        X = Integer.parseInt(br.readLine().trim());

        // 1) 비어있는 노드 복구 (부모 기준 ±1)
        for (int i = 2; i <= N; i++) {
            if (tree[i] == -1) {
                int parentVal = tree[i / 2];
                if (i % 2 == 0) tree[i] = parentVal - 1;
                else tree[i] = parentVal + 1;
            }
        }

        // 2) 현재 값들 정렬 후 inorder 순서로 채워 완전 BST 구성
        inorderIdx = new ArrayList<>();
        buildInorder(1, N);

        List<Integer> values = new ArrayList<>();
        for (int i = 1; i <= N; i++) values.add(tree[i]);
        Collections.sort(values);

        for (int i = 0; i < N; i++) {
            int idx = inorderIdx.get(i);
            tree[idx] = values.get(i);
        }

        // 3) 원래 -1 자리(복구했던)의 값 제거
        int removedValue = tree[missingIndexOriginal];
        // remove one occurrence of removedValue from values
        // we will rebuild values list: take current assigned values in inorder order, remove value at that position
        List<Integer> valuesAfterDelete = new ArrayList<>();
        for (int i = 0; i < N; i++) valuesAfterDelete.add(values.get(i));
        // find and remove the removedValue (first occurrence)
        for (int i = 0; i < valuesAfterDelete.size(); i++) {
            if (valuesAfterDelete.get(i) == removedValue) {
                valuesAfterDelete.remove(i);
                break;
            }
        }

        // 4) 새 값 X 추가
        valuesAfterDelete.add(X);
        Collections.sort(valuesAfterDelete); // 다시 정렬; size == N now

        // 5) 재구성: inorder 순서로 재할당
        for (int i = 0; i < N; i++) {
            int idx = inorderIdx.get(i);
            tree[idx] = valuesAfterDelete.get(i);
        }

        // 6) 후위 출력
        StringBuilder sb = new StringBuilder();
        postOrder(1, sb);
        System.out.println(sb.toString().trim());
    }
}
