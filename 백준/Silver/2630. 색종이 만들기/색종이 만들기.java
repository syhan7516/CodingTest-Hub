import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	
	// 색종이 크기, 전제 영역, 흰색 영역, 파란색 영역
	public static int size, area, white, blue;
	// 색종이
	public static int paper[][];

	// 공간 나누기 메서드
	static void solve(int row, int col, int size) {
		
		// 헤당 영역 확인하기
		int sum = 0;
		
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				sum += paper[i][j];
			}
		}
		
		// 흰색 영역만 있을 경우
		if(sum==0) {
			white++;
			area++;
		}
		
		// 파란색 영역만 있을 경우
		else if(sum==size*size) {
			blue++;
			area++;
		}
		
		// 흰색, 파란색 영역 모두 있을 경우
		else {
			int half = size/2;
			solve(row,col,half);
			solve(row,col+half,half);
			solve(row+half,col,half);
			solve(row+half,col+half,half);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 크기 입력
		size = Integer.parseInt(br.readLine());
		
		// 색종이 생성
		paper = new int[size][size];
		
		// 색종이 정보 입력
		for(int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 공간 나누기
		solve(0,0,size);
		
		// 결과 출력
		System.out.println(white+"\n"+blue);
	}
}
