package school_Project;

public class Quiz5_2 {
	public static void main(String[] args) {
		for(int iCount = 0, length = 0; iCount < 52 ; iCount++, length++) {
			char ALPHA = 'A';			
			if(iCount > 25) {
				length-=2;
			}
			for(int ALPHA_plus = 0; ALPHA_plus <= length; ALPHA_plus++) {
				System.out.print(ALPHA);
				ALPHA += 1;
			}
			System.out.println();
		}
	}
}
