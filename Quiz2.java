package school_Project;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		boolean loop 	= true;			// do - while �ݺ��� ���� ���� ��
		boolean access  = false;		// �Է��� String�� ��ȿ�� �˻� ��
		int NumberCount = 0;			// ��ȿ�� �˻� ��� �� ���� ī��Ʈ
		
		// Ű����κ��� ���� �� �Է�
		Scanner scan = new Scanner(System.in);
		
		// *����ڿ�* ��Ʈ������ �޾Ƽ� ������ ��ȯ�� �� 'q'�Է� �� ����� �ۼ�
		do {
			System.out.println("�Է��ض�");
			String input_String_Number = scan.nextLine();
			// "q" or "20000" �Է� �� ����
			if(input_String_Number.equals("q") || input_String_Number.equals("20000")) {
				System.out.println("�̿����ּż� �����մϴ�");	
				break;
			}

			// ��Ʈ���� �����ؼ� �ƽ�Ű�ڵ�� ��ȿ�� �˻�
			for(int i = 0; i < input_String_Number.length(); i++) {
				char k = input_String_Number.charAt(i);
				if(!(0 <= k - '0' && k - '0' <= 9)) {
						System.out.println("1�̻��� ����� �Է����ּ���");
						access = false; // ��ȿ�� �˻� ���� case
						break;
				}else   access = true; 	// ��ȿ�� �˻� ��� case
			}

			// ��ȿ�� �˻� ����� ����
			if(access) {
				int input_Number = Integer.parseInt(input_String_Number);
				NumberCount++;
				System.out.println(NumberCount + "��° �Է� ���� = " + input_Number);
				// Ȧ ¦ ��󳻱�
				if(input_Number % 2 == 0)	System.out.println("\t¦���Դϴ�.");
				else						System.out.println("\tȦ���Դϴ�.");
				// 3 7 ��� ��󳻱�
				if(input_Number % 3 == 0)	System.out.println("\t3�� ����Դϴ�.");
				if(input_Number % 7 == 0)	System.out.println("\t7�� ����Դϴ�.");
			}
			// ��ȿ�� �˻� �ʱ�ȭ.
			access = false;
		} while(loop);
		
		scan.close();
	}
}
