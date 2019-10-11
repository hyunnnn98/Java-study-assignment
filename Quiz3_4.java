package school_Project;

import java.util.Scanner;

public class Quiz3_4 {
	public static void main(String[] args) {
		// (1). 11row ������ >> For, if ���
		// (2). ����ڿ� ��ȿ�� �˻�, ���� �Է¹޾� ������ ���
		String star  = "*";
		String space = " ";
		int all_Line = 0;

		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Ȧ���� �Է����ּ���");
			all_Line = scan.nextInt();

			for (int row = 0; row < all_Line; row++){
				if(all_Line % 2 == 0) {
					System.out.println("�ٽ� �Է����ּ���. Ȧ���� �����մϴ�.");
					break;
				}
				for (int col = 0; col < all_Line; col++) {
					//up
					if (row < all_Line / 2 + 1) {
						//up (left space)
						if (row + col < all_Line/2)
							System.out.print(space);
						//up (right space)
						else if (col - row > all_Line/2)		
							System.out.print(space);
						//up (star)
						else System.out.print(star);	
					}
					//down
					else if (row > all_Line / 2) {
						//down (left space)
						if (row - col > all_Line/2)	
							System.out.print(space);
						//down (right space)
						else if (row + col > all_Line/2 * 3)
							System.out.print(space);
						//down (star)
						else System.out.print(star);
					}
				}
				//line change
				System.out.println();
			}
		}while(all_Line % 2 == 0);
		scan.close();
	}
}
