import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
 
        // 테스트 케이스 수 입력
		int caseNum = scanner.nextInt();	
 
        // 케이스 수만큼 수행
		for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
			
            // 입력
			int H = scanner.nextInt();
			int W = scanner.nextInt();
			int N = scanner.nextInt();
			
            // 층 구하기
			if(N%H==0) {
				System.out.println((H*100)+(N/H));
 
			} 
            else {
				System.out.println(((N%H)*100)+((N/H)+1));
			}
		}
	}
}