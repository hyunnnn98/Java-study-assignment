package school_Project;

import java.util.Scanner;

public class school_2_Example001 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int sum	= 0;
		int saveNumber = 0;			// sum�� 100�� �ѱ�� ����� �����ϱ� ���� ����.
		boolean All_result = true;

		System.out.println("1~N���� 7�� ����� ���ϱ�");
		do {
			System.out.print("��� N ���� �Է��Ͻÿ�:");
			int inputNumber = scan.nextInt();		// N �� �Է�
			// inputNumber���� 1 �̻��� ��� if�� ����
			if(inputNumber >= 1) {
				for(int start = 0; start < inputNumber / 7 + 1; start++) {
					sum += start * 7;					// 7�� �����ŭ ���ϱ�
					if(sum >= 100 && saveNumber == 0) {
						saveNumber = start * 7;			// 100�� �Ѱ��� �� �� ����
					}
					All_result = false;
				}
				if(inputNumber < 7) 	sum = 0;		// inputNumber���� 7 �̸��� ��� ��� �� 0���� ���

				System.out.printf("0~%d������ 7�� ��� ���� : %d %n", inputNumber, sum);
				
				// sum�� 100 �̻��� ��� 
				if (sum > 100) {
					System.out.printf("������ ���� ���� ÷���� 100�� �ѱ�� 7�� ����� %d %n", saveNumber);
				}
			}
		}while(All_result);
		scan.close();
	}
}
