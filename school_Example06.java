package school_Project;

public class school_Example06 {
	public static void main(String[] args) {
		final int alpha_Count = 26;
		int alpha_Number = 26;
		
		//전체 라인 출력
		for(int i = 0; i < alpha_Count; i++) {
			char alpha_a = 'A';
			
			// 빈공간
			for(int j = 0; j < i; j++) {
				System.out.print("*");		
			}
			// 알파벳
			for(int k = 0; k < alpha_Number; k++) {
				System.out.print(alpha_a++);
			}
			alpha_Number--;

			System.out.println();
		}
	}
}
