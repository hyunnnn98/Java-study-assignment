package school_Project;

import java.util.Scanner;

public class Quiz10_1 {
	public static void main(String[] args) {
		String inputValue	= null;
		char start_ALPHA	= 'A';

		Scanner scan = new Scanner(System.in);

		// Ű����κ��� ���ڿ� �Է�
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		inputValue = scan.nextLine();

		// �Է¹��� ���ڿ��� ���� ����
		int sizeOfString = inputValue.length();

		// �Է¹��� ���ڿ��� ���� ��ŭ char �� �迭 ����
		char charArray[] = new char[sizeOfString];

		// inputValue�� ����� ���ڿ��� charArray �迭�� ���� : String -> char�� ���ڿ� ����
		inputValue.getChars(0, sizeOfString, charArray, 0);

		// charArray�� ���� ���ڸ� ���ĺ� �� ���� ī��Ʈ
		int alpha_Count[] = new int[52];

		for(int jCount = 0; jCount < inputValue.length(); jCount++) {
			start_ALPHA = 'A';
			for(int iCount = 0; iCount < 52; iCount++) {
				if(charArray[jCount] == start_ALPHA) {
					alpha_Count[iCount]++;
					break;
				}
				start_ALPHA++;
				if(start_ALPHA == 'Z' + 1) start_ALPHA += 6;
			}
		}
		// �Էµ� ���ڿ� �� ���
		start_ALPHA		 = 'A';
		int output_Count = 0;
		for(int iCount = 0; iCount < 52; iCount++) {
			for(int i = 0; i < sizeOfString; i++) {
				if(alpha_Count[iCount] > 0) {
					if(!(output_Count == 0))	System.out.print(", ");
					System.out.print(start_ALPHA + " : " + alpha_Count[iCount]);
					output_Count++;
					break;
				}
			}
			start_ALPHA++;
			if(start_ALPHA == 'Z' + 1) start_ALPHA += 6;
		}
		scan.close();
	}
}
