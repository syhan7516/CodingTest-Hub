import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	// 접시의 수, 가지 수, 연속 수, 쿠폰 번호, 결과
	public static int dishCnt, kindCnt, sNum, cNum, result;
	// 벨트
	public static int belt[];
	// 중복 여부 확인 해시셋
	public static HashSet<Integer> set;
	// 초밥 개수 배열
	public static int nums[];
	
	// 벨트 위 초밥 확인 메서드
	static void solve() {
		
		// 초기 시작 벨트 설정
		for(int i=0; i<sNum; i++) {
			set.add(belt[i]);
			nums[belt[i]]++;
		}
		
		// 쿠폰 초밥 추가
		if(nums[cNum]==0) result = Math.max(result, set.size()+1);
		else result = Math.max(result, set.size());
		
		// 포인터 설정
		int firPoint = 0;
		int secPoint = sNum;
		
		// 벨트를 옮기며 확인
		for(int i=0; i<dishCnt; i++) {
			
			// 이전 초밥 제거
			nums[belt[firPoint]]--;
			if(nums[belt[firPoint]]==0) 
				set.remove(belt[firPoint]);
				
			// 이후 초밥 추가
			nums[belt[secPoint%dishCnt]]++;
			set.add(belt[secPoint%dishCnt]);
			
			// 쿠폰 초밥 추가
			if(nums[cNum]==0) result = Math.max(result, set.size()+1);
			else result = Math.max(result, set.size());
			
			// 포인터 이동
			firPoint++;
			secPoint++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 접시의 수, 가지 수, 연속 수, 쿠폰 번호 입력
		st = new StringTokenizer(br.readLine());
		dishCnt = Integer.parseInt(st.nextToken());
		kindCnt = Integer.parseInt(st.nextToken());
		sNum = Integer.parseInt(st.nextToken());
		cNum = Integer.parseInt(st.nextToken());
		
		// 벨트 생성
		belt = new int[dishCnt];
		
		// 초밥 정보 입력
		for(int i=0; i<dishCnt; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		// 해시셋 생성
		set = new HashSet<>();
		
		// 초밥 개수 배열 생성
		nums = new int[kindCnt+1];
		
		// 벨트 위 초밥 확인
		result = 0;
		solve();
		
		// 결과 출력
		System.out.println(result);
	}
}