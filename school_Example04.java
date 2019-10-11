package school_Project;

import java.util.Scanner;

public class school_Example04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for(;;) {
			System.out.print("정수를 입력하시오:");
			int input_Number = scan.nextInt();

			switch(input_Number) {
			case 1 :
				System.out.print("출력할 행 수를 입력하시오:");
				int input_alpha_Number = scan.nextInt();
				char alpha = 'a';
				for(int i = 0; i < 26 ; i++, alpha++) {
					for(int j = 0; j<input_alpha_Number; j++) {
						System.out.print(alpha);
					}
					System.out.println();
				}
				System.out.println();
				break;
			case 2 :
				System.out.print("출력할 행 수를 입력하시오:");
				int input_ALPHA_Number = scan.nextInt();
				char ALPHA = 'A';
				for(int i = 0; i < 26 ; i++, ALPHA++) {
					for(int j = 0; j<input_ALPHA_Number; j++) {
						System.out.print(ALPHA);
					}
					System.out.println();
				}
				System.out.println();
				break;
			default :
				System.out.println("1~2 사이의 값을 입력하시오.");
			}
		}
	}
}
