package school_Project;

import java.util.Scanner;

public class school_Example02 {			
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		// a의 10진수는 97 z는 122 		a~z 26
		// A의 10진수는 65 Z는 90  		A~Z 26
		System.out.println("(1)소문자 알파벳  (2)대문자 알파벳");
		for(;;) {

			System.out.print("정수를 입력하시오:");
			int input_Number = scan.nextInt();

			switch(input_Number) {
			case 1 :
				System.out.print("출력할 알파벳 개수를 입력하시오:");
				int input_alpha_Number = scan.nextInt();
				char alpha = 'a';
				for(int i = 0; i < input_alpha_Number ; i++) {
					System.out.print(alpha++);
					if(alpha > 'z') alpha = 'a';
				}
				System.out.println();
				break;
			case 2 :
				System.out.print("출력할 알파벳 개수를 입력하시오:");
				int input_ALPHA_Number = scan.nextInt();
				char ALPHA = 'A';
				for(int i = 0; i < input_ALPHA_Number ; i++) {
					System.out.print(ALPHA++);
					if(ALPHA > 'Z') ALPHA = 'A';
				}
				System.out.println();
				break;
			default :
				System.out.println("1~2 사이의 값을 입력하시오.");
			}
		}
	}
}
