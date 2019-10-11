package school_Project;

public class school_Example08 {
	public static void main(String[] args) {
		int input_Line		= 52; 				// all line
		int up_copy_Line	= input_Line/2 - 1; // copy half line
		int down_copy_Line  = input_Line/2 - 1;
		int middle_Count	= 2;

		//전체라인
		for(int i = 0; i < input_Line; i++) {
			char ALPHA = 'A';	// 'A'는 전체 라인이 돌때마다 초기화
			char ALPHA_Copy = ' ';
//			위 space 출력
			if(i < input_Line/2) {
				//왼쪽 삼각형
				for(int j = 0; j <= i; j++) {
					ALPHA_Copy = ALPHA;
					System.out.print(ALPHA++);
				}
				//중간 공백
				for(int middle_Space = 0; middle_Space < input_Line-2*(i+1); middle_Space++) {
					System.out.print(" ");
				}
				//오른쪽 삼각형
				for(int k = 0; k <=i; k++) {
					System.out.print(ALPHA_Copy--);
				}
//			아래 space 출력
			}else {
				//왼쪽 삼각형
				for(int j = 0; j < up_copy_Line ; j++) {
					ALPHA_Copy = ALPHA;
					System.out.print(ALPHA++);
				}
				up_copy_Line--;
				//중간 공백
				for(int under_Space = 0; under_Space < middle_Count ; under_Space++) {
					System.out.print(" ");
				}
				middle_Count+=2;
				//오른쪽 삼각형
				for(int k = 0; k < down_copy_Line; k++) {
					System.out.print(ALPHA_Copy--);
				}
				down_copy_Line-=1;
			}// if문 종료
			System.out.println();
		}// for문 종료
	}
}


