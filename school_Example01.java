package school_Project;

import java.util.Scanner;

public class school_Example01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for(;;) {
			System.out.print("������ �Է��Ͻÿ�:");
			int input_Number = scan.nextInt();
			
			switch(input_Number) {
			case 1 :
				System.out.println("abcdefghijklmnopqrstuvwxyz");
				break;
			case 2 :
				System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
				break;
			default :
				System.out.println("1~2 ������ ���� �Է��Ͻÿ�.");
			}
		}
	}
}
