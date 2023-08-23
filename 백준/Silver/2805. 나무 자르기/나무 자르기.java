import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 나무의 수, 가져갈 나무 길이, 결과
	public static int treeCnt,getLen,result;
	// 나무 길이 배열
	public static int tree[];
	// 절단기 높이 조절 범위
	public static int left, right;
	
	// 나무 자르기 메서드
	static void solve() {
		
		while(left<=right) {
			
			// 절단기 높이 설정
			int mid = (left+right)/2;
			
			// 잘려 나온 나무 길이
			long cutLen = 0;
			
			// 나무 자르기
			for(int t: tree) {
				
				// 자른 후 양수인 경우만 더하기
				if((t-mid)>=0) cutLen += t-mid;
				
			}
			
			// 자른 나무가 길이가 부족한 경우
			if(cutLen<getLen) {
				right = mid-1;
			}
			
			// 자른 나무가 길이가 충부한 경우
			else {
				result = mid;
				left = mid+1;
			}		
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 나무의 수, 가져갈 나무 길이 입력
		st = new StringTokenizer(br.readLine());
		treeCnt = Integer.parseInt(st.nextToken());
		getLen = Integer.parseInt(st.nextToken());
		
		// 나무 길이 배열 생성
		tree = new int[treeCnt];
		
		// 나무 길이 정보 입력
		left = 0;
		right = -1;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<treeCnt; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right,tree[i]);
		}
		
		// 나무 자르기
		solve();
		
		// 결과 출력
		System.out.println(result);
	}
}