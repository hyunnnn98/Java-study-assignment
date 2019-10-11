package school_Project;

public class school_Example05 {
	public static void main(String[] args) {

		
		for(int i = 0; i < 26; i++) {
			char alpha_a = 'a';
			for(int j = 0; j<=i; j++, alpha_a++) {
				System.out.print(alpha_a);
			}
			System.out.println();
		}
	}
}
