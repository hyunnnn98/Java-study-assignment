package school_Project;

import java.util.Scanner;

public class school_Example02 {			
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		// a�� 10������ 97 z�� 122 		a~z 26
		// A�� 10������ 65 Z�� 90  		A~Z 26
		System.out.println("(1)�ҹ��� ���ĺ�  (2)�빮�� ���ĺ�");
		for(;;) {

			System.out.print("������ �Է��Ͻÿ�:");
			int input_Number = scan.nextInt();

			switch(input_Number) {
			case 1 :
				System.out.print("����� ���ĺ� ������ �Է��Ͻÿ�:");
				int input_alpha_Number = scan.nextInt();
				char alpha = 'a';
				for(int i = 0; i < input_alpha_Number ; i++) {
					System.out.print(alpha++);
					if(alpha > 'z') alpha = 'a';
				}
				System.out.println();
				break;
			case 2 :
				System.out.print("����� ���ĺ� ������ �Է��Ͻÿ�:");
				int input_ALPHA_Number = scan.nextInt();
				char ALPHA = 'A';
				for(int i = 0; i < input_ALPHA_Number ; i++) {
					System.out.print(ALPHA++);
					if(ALPHA > 'Z') ALPHA = 'A';
				}
				System.out.println();
				break;
			default :
				System.out.println("1~2 ������ ���� �Է��Ͻÿ�.");
			}
		}
	}
}
