import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	
	// 카드 찾기 메서드
	static boolean solve(int arr[], int target, int start, int end) {
		
		// 위치 찾기
		while(start<=end) {
			
			// 중간 값
			int mid = (start+end)/2;
			
			// 찾은 경우
			if(arr[mid]==target)
				return true;
			
			// 값이 작은 경우
			else if(arr[mid]<target)
				start = mid+1;
			
			// 값이 큰 경우
			else 
				end = mid-1;
		}
		
		// 없는 경우
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 상근이의 숫자 카드의 개수 입력
		int firCardCnt = Integer.parseInt(br.readLine());
		
		// 상근이 카드 덱 생성
		int firCard[] = new int[firCardCnt];
		
		// 상근이의 숫자 카드 정보 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<firCardCnt; i++) {
			firCard[i] = Integer.parseInt(st.nextToken());
		}
		
		// 상대방 카드 개수
		int secCardCnt = Integer.parseInt(br.readLine());
		
		// 상대방 카드 덱 생성
		int secCard[] = new int[secCardCnt];
		
		// 상대방 카드 정보 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<secCardCnt; i++) {
			secCard[i] = Integer.parseInt(st.nextToken());
		}
		
		// 상근이 카드 정렬
		Arrays.sort(firCard);
		
		// 카드 확인
		for(int i=0; i<secCardCnt; i++) {
			
			// 카드 찾기
			boolean flag = solve(firCard,secCard[i],0,firCard.length-1);
			
			// 결과 저장
			if(flag) sb.append(1+" ");
			else sb.append(0+" ");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}
