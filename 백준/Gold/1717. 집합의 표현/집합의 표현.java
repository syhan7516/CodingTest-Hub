import java.util.Scanner;

public class Main {

    static int find(int group[], int node) {
        if(group[node]==node) {
            return node;
        }
        else {
            return group[node] = find(group,group[node]);
        }
    }

    static void union(int group[], int firNode, int secNode) {
        int firNodeRoot = find(group,firNode);
        int secNodeRoot = find(group,secNode);
        group[firNodeRoot] = secNodeRoot;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 숫자 수 & 연산 수 입력
        int numbers = scanner.nextInt();
        int opCount = scanner.nextInt();

        // 각 집합 초기화
        int group[] = new int[numbers+1];
        for(int idx=0; idx<numbers+1; idx++) {
            group[idx] = idx;
        }

        // 연산 수행
        for(int idx=0; idx<opCount; idx++) {
            int op = scanner.nextInt();
            int firNode = scanner.nextInt();
            int secNode = scanner.nextInt();
            // 합집합
            if(op==0) {
                union(group,firNode,secNode);
            }
            // 집합 확인
            else {
                int firGroup = find(group,firNode);
                int secGroup = find(group,secNode);
                if(firGroup==secGroup)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}