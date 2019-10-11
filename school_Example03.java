package school_Project;

import java.util.Scanner;

public class school_Example03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for(;;) {
			System.out.print("정수를 입력하시오:");
			int input_Number = scan.nextInt();

			switch(input_Number) {
			case 1 :
				System.out.print("출력할 줄 수를 입력하시오:");
				int input_alpha_Number = scan.nextInt();
				for(int i = 0; i < input_alpha_Number ; i++) {
					System.out.println("abcdefghijklmnopqrstuvwxyz");
				}
				System.out.println();
				break;
			case 2 :
				System.out.print("출력할 줄 수를 입력하시오:");
				int input_ALPHA_Number = scan.nextInt();
				for(int i = 0; i < input_ALPHA_Number ; i++) {
					System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
				}
				System.out.println();
				break;
				
			default :
				System.out.println("1~2 사이의 값을 입력하시오.");
			}
		}
	}
}

