package school_Project;

import java.util.Scanner;

public class Quiz4_1 {
	public static void main(String[] args) {
		System.out.println("역 피라미드의 높이를 입력하시오.");
		
		Scanner scan = new Scanner(System.in);
		
		int input_Value = scan.nextInt();
		int count		= 0;
		int length		= (input_Value * 2) - 1;
		
		for(int i = input_Value; i > 0; i--, count++, length -= 2) {
			for(int input_Space = input_Value; i < input_Space ; input_Space--) {
				System.out.print(" ");
			}
			switch(count) {
			// 대문자 알파벳
			case 0 :
				char ALPHA_Start = 'A';
				for(int ALPHA = length; ALPHA > 0; ALPHA--) {
					System.out.print(ALPHA_Start);
					ALPHA_Start += 1;
					if(ALPHA_Start == 'Z') {
						ALPHA_Start = 'A';
					}
				}
				break;
			// 숫자
			case 1 :
				char NUMBER_Start = '1';
				for(int NUMBER = length; NUMBER > 0; NUMBER--) {
					System.out.print(NUMBER_Start);
					NUMBER_Start += 1;
					if(NUMBER_Start == '9') {
						NUMBER_Start = '0';
					}
				}
				break;
			//소문자 알파벳
			case 2 :
				char alpha_Start = 'a';
				for(int alpha = length; alpha > 0; alpha--) {
					System.out.print(alpha_Start);
					alpha_Start += 1;
					if(alpha_Start == 'z') {
						alpha_Start = 'a';
					}
				}
				// 0으로 초기화 시 'A'로 진입하지 않고 '1'로 진입하여 -1값 부여 
				count = -1;
				break;
			}
			System.out.println();
		}
		
		scan.close();
	}
}
