package testPkg;

import java.util.Scanner;

public class Quiz21_1 {
	public static void main(String[] args) {
		int number_Count = 0;
		int input_Select = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("�Է��� ���ڿ��� ����?");
		number_Count = scan.nextInt();

		//		System.out.println("���� ��� ����? (1)����, (2)����");
		//		input_Select= scan.nextInt();

		String[] user_Input = new String[number_Count];
		System.out.println("���ڿ� �Է�");
		for(int iCount = 0; iCount < number_Count; iCount++) {
			user_Input[iCount] = scan.next();
		}

		//�������� && ��������
		for(int i = 0; i < user_Input.length - 1; i++) {
			// i ī��Ʈ + 1 �̻� ���ڿ� ��ȯ�ϱ�
			for(int jCount = i + 1; jCount < user_Input.length; jCount++) {
				// ù��° �ڸ� ���� �� .. ù��° ���� ���̰� �ȳ��� �׳� ���
				if(user_Input[i].charAt(0) >= user_Input[jCount].charAt(0)) {
					int compareLength = 0;
					// �� ���ڿ� �� �� �ʿ��� for�� �ݺ� Count ���ϱ�
					if(user_Input[i].length() > user_Input[i + 1].length()) compareLength = user_Input[i + 1].length();
					else 													compareLength = user_Input[i].length();
					// ���ڿ� ���� ��
					Main : for(int k = 0; k < compareLength; k++) {
						for(int j = k, n_Count = 1; j < compareLength; j++, n_Count++) {
							// ���⸸ �����ϸ� ������
							if(user_Input[i].charAt(k) > user_Input[i + n_Count].charAt(j)) {
								String temp			= user_Input[i];
								user_Input[i]		= user_Input[jCount];
								user_Input[jCount]	= temp;
								break Main;
							}
						}
					}
				}// ù��° �ڸ� �� �� �˰��� ��
			}// jCount �˰��� ��
		}// �������� �˰��� ��
		
		// ����ϱ�
		System.out.println("===����մϴ�===");
		for(int iCount = 0; iCount < user_Input.length; iCount++) {
			System.out.println(user_Input[iCount]);
		}

		// �������
		/*	
		C, A, F ,B �� �ִ�
		���⼭ ó���� C���� �����ؼ� ��ĭ�� �񱳸� �ϰ���?
		C�� A�� ������ �� A�� �� ������ A�� �迭 0��° �ڸ��� ����
		�׷�
		A, C, F, B �� �ȴ�
		���⼭ ���� A�� F�� ���ϰ� ���� �տ� ���� �� ũ�� �׳� �Ѿ��
		�׷� ���� A�� B�� ���Ѵ� ���ص� �տ� ���� �� ũ�� ������ �׳� �Ѿ��
		���� �� ���ڸ� ���ĺ��� ���� �Ϸ�
		�׷�
		�ι�° �ڸ��� ���ĺ� ���� ����
		C�� F�� >> �׳� �Ѿ
		C�� B�� >> B�� �� �۾Ƽ� B�� C�ڸ��� ��.
		�׷�
		A, B, F, C�� �ȴ�.
		���� ����° �ڸ��� ���ĺ� ���� ����
		F�� C�� �� >> C�� �� �۾Ƽ� C�� �迭 2�� �ڸ��� ���� F�� �������ڸ��� ����.
		���� ��.
		====================================================
		C, AC, A, B, AB�� ���� ��
		�ϴ� ù��° �ڸ��� ���ϱ� Charat
		1. C�� A�� �� A�� �� �۳�? �׷� �ٷ� �ڸ� ��ü
		>> AC, C, A, B, AB
		2. AC�� A �� ���ڸ��� ���� �� �˰��� ����.
		A == A >> ���⼭ if���� �ϳ� �Ἥ lengh�� 1�ΰ� ������ �̵��ϱ�.
		���� �Ѵ� length�� 2 �̻��� �� >> ù��° �ڸ��� �����ϰ� 2��° �ڸ����� ���� ��
		���� ���⼭ 2��° �ڸ��� ���� ���� �� �ݺ��ؼ� 3��° �ڸ� ��, 4��° �ڸ� ��.. �ݺ��ϸ鼭
		���� �� ������ �� �ϰ� >> �� �ϰ� ���� ���� ���� ������ ����Ī�Ѵ�.
		 */		
	}
}

//		for(int iCount = 0; iCount < number_Count - 1; iCount++) {
//			int min_Index = iCount;
//			for(int i = 0; iCount < user_Input[iCount].length(); i++) {
//				for(int jCount = iCount + 1; jCount < number_Count; jCount++) {
//					for(int k = 0; k < user_Input[jCount].length(); k++) {
//						// ��������
//						if(input_Select == 1 && user_Input[jCount].charAt(k) < user_Input[min_Index].charAt(i)) {
//							min_Index = jCount;
//						}
//						// ��������
////						if(input_Select == 2 && user_Input[jCount].charAt(k) > user_Input[min_Index].charAt(i)) {
////							min_Index = jCount;
////						}
//					}
//				}
//			}
//			String temp = user_Input[iCount];
//			user_Input[iCount] = user_Input[min_Index];
//			user_Input[min_Index] = temp;
//		}
//		if(input_Select == 1)	System.out.println("�������� ���� ���");
//		else					System.out.println("�������� ���� ���");
//		for(int iCount = 0; iCount < number_Count; iCount++) {
//			System.out.print(user_Input[iCount] + " ");
//		}