package school_Project;

import java.util.Scanner;

public class school_2_Example002 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int six_Count	  = 0;		// 6�� ���� Ƚ�� ����
		int result_Count  = 0;		// �õ��� ī��Ʈ �� ����
		double percentage = 0.0;	// Ȯ�� ��
		boolean result    = true;	// 6�� ������ �ʾ��� �� �ݺ��ϱ� ���� boolean��
		
		System.out.println("N�� -100 ~ 100 ������ ���� �߻�. �̶� 6�� ���� Ȯ�� ���ϱ� ");
		int inputNumber  = scan.nextInt();
		
		do {
			for(int i = 0; i < inputNumber; i++) {
				result_Count++;										// n�� �õ��ϴ� ī��Ʈ
				int random = (int)(Math.random()*201)-100;			// -100 ~ 100 ������ ������ ���
				if(random == 6) six_Count++;						// random���� 6�� ��� six_Count�� ����
				// six_Count�� ������ ���
				if(six_Count > 0) {
					percentage = (1.0 / result_Count) * six_Count;
					System.out.println(result_Count + "�� �õ�, 6�� ���� Ƚ�� :" + six_Count);
					System.out.printf("Ȯ����%.4f %n",percentage);	// �Ҽ��� 4°�ڸ����� ���
					result = false;									// do-while�� ����
					break;											// for�� ����
				}// if�� ����
			}// for�� ����
		}while(result);
		
		scan.close();
	}
}
