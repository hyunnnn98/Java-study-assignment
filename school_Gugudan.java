package school_Project;

import java.util.Scanner;

public class school_Gugudan {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("�÷��� ������ �Է��Ͻÿ�.");
		int calumm   = scan.nextInt();

		int dan      = 0;		//���� ��Ÿ���� ���� ����
		int count    = 0;		//�÷��� ���� ��� �� �� �ٲ����� ���� ��Ÿ���� ���� ���� 

		//2~9�����
		while (true) {
			//�����ܿ��� �ܿ� ���ϴ� ���� ���
			for (int i = 0; i < 9; i++) {
				//�÷� ���� ����ߴ��� ���ߴ��� �����ϰ� ���� ��Ÿ���� ����
				if (count == 0)	 dan = 2;
				else        	 dan = (calumm * count) + 2;
				//�������� �÷���� ���
				for (int j = 0; j < calumm; j++) {
					System.out.printf("%d * %d = %d \t", dan, i+1, dan*(i+1));
					dan++;
					//���� 10�� �Ǹ� for�� Ż��(�ᱹ 9������ ���)
					if (dan == 10) break; 
				}
				System.out.println();
			}

			//���� 10�� �Ǹ� while�� Ż��(�ᱹ ���� 9���� ���)
			if (dan == 10) break;

			System.out.print("=====================================");
			System.out.println();

			count++;
		}
		scan.close();
	}
}

