package school_Project;

import java.util.Scanner;

public class Quiz7_1 {
	public static void main(String[] args) {
		// ���ڿ� �迭�� ũ��
		final int MAX_SIZE = 30;

		// Ű����κ��� �Է� ���� ���ڿ� ����
		String inputValues = null;

		// Ű����� �Է� ���� ���ڿ��� Char�� �迭�� ����
		// ã��/�ٲٱ� ��� ������ ���
		char charArray[] = new char[MAX_SIZE];

		// Ű����κ��� ���ڿ��� �Է¹޾� String�� ����
		Scanner scn = new Scanner(System.in);
		System.out.print("�Է�:");
		inputValues = scn.nextLine();

		// ����� ���ڿ��� Char�� array ���� charArray�� ����
		inputValues.getChars(0, inputValues.length(), charArray, 0);

		// ����� ���ڰ� ���
		System.out.print("�Է� ����:");
		for (int i = 0; i < inputValues.length(); i++) {
			System.out.print(charArray[i]);
		}

		boolean find_Excess = false;
		// ã�� ���� �Է� ���� �� - > char �迭�� ����
		System.out.println();
		System.out.print("ã�� ���ڿ�:");
		String findValues	= scn.nextLine();
		char findArray[]	= new char[findValues.length()];
		findValues.getChars(0, findValues.length(), findArray, 0);

		// save �迭�ȿ� ���°���� ã�� int�� �ֱ�
		int[] save = new int[MAX_SIZE];
		// char��� ī��Ʈ��
		int char_Count = 0;
		// ���� ���ڿ��� ��� �ִ���?
		int save_Count = 0;
		for (int iCount = 0; iCount < charArray.length; iCount++) {
			char_Count = 0;
			for (int jCount = 0; jCount < findArray.length; jCount++) {
				if (charArray[iCount + jCount] == findArray[jCount]) {
					char_Count++;
					// �Է� ������ ������ ��ġ�� ���
					if (char_Count == findArray.length) {
						find_Excess = true;
						save[save_Count] = iCount;
						save_Count++;
					}
					// ù��° char���� ���� ������ jCount Ż��
				} else break;
			}
		}

		// ã�� ���ڿ��� ���� ��
		String changeValues = null;
		int last_Count = 0;
		if (find_Excess) {
			System.out.print("�ٲ� ���ڿ�:");
			changeValues = scn.nextLine();
			// ���
			System.out.print("���:");
			for (int iCount = 0; iCount < charArray.length; iCount++) {
				if (iCount == save[last_Count]) {
					System.out.print(changeValues);
					iCount += findValues.length() - 1;
					last_Count++;
				} else {
					System.out.print(charArray[iCount]);
				}
			}
		} else {
			System.out.print("�ش� ���ڿ��� �������� �ʽ��ϴ�.");
		}
		
		System.out.println("\n���α׷��� �����մϴ�.");
		scn.close();
	}
}

