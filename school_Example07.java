package school_Project;

public class school_Example07 {
	public static void main(String[] args) {
		int input_Line	= 52; 				// all line
		int copy_Line	= input_Line/2 - 1; // copy half line

		//전체라인
		for(int i = 0; i < input_Line; i++) {
			char ALPHA = 'A';
			//위 공간 출력
			if(i <= input_Line/2) {
				// 윗 알파벳 출력
				for(int j = 0; j < i; j++) {
					System.out.print(ALPHA++);
				}		
				
			//아래 공간 출력
			}else {
				// 아래 알파벳 출력
				for(int k = 0; k < copy_Line; k++) {
					System.out.print(ALPHA++);
				}
				copy_Line--;
				
			}// if문 종료
			
			System.out.println();
		}// for문 종료
	}
}
