package school_Project;

import java.util.Scanner;

public class Quiz8_1 {
	public static void main(String[] args) {
		// ���ڿ� �迭�� ũ��
		final int MAX_SIZE = 50;

		// int�� ���� 50�� �迭 ����
		int	randomValues[] = new int[MAX_SIZE];

		Scanner scn = new Scanner(System.in);
		// 1 ~ 200 ������ ������ ������ �߻��Ͽ� �迭�� ���� : 50��
		// Math.random() ȣ�� �� 0�̻� 1�̸��� �Ǽ��� �� ��ȯ
		for(int iCount = 0; iCount < MAX_SIZE; iCount++) {
			randomValues[iCount] = (int)((Math.random() * 200 + 1));
			for(int jCount = 0; jCount < iCount; jCount++) {
				if(randomValues[iCount] == randomValues[jCount]) {
					iCount--;
					break;
				}
			}
		}

		// �߻��� ���� �� ȭ�鿡 ���
		for(int jCount = 0; jCount < MAX_SIZE; jCount++) {
			System.out.print( "\t" + randomValues[jCount]);
			if((jCount + 1) % 7 == 0) System.out.println();
		}
		System.out.println();

		// ��� �� �˻� �� ������ �Է�
		int search_Count = 0, search_Value = 0;

		do {
			System.out.print("\n��� �� �˻� �� ������ �Է��ϼ���(1�̻� ����): ");
			search_Value = scn.nextInt();
		}while(search_Value < 1);

		System.out.println("\n\n" + search_Value + "��� ��");
		for(int iCount = 0; iCount < MAX_SIZE; iCount++) {
			if(randomValues[iCount] % search_Value == 0) {
				System.out.print("\t" + randomValues[iCount]);
				search_Count++;
				if(search_Count % 5 == 0) System.out.println();
			}
		}
		System.out.println("\n\n" + search_Value + "��� �� ���� : " + search_Count);
		scn.close();
	}
}
