package school_Project;

import java.util.Scanner;

public class Quiz11_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// ��ǻ�ͷκ��� 0 ~ 9 ���� �� �Է¹���(�ߺ��� ����) 
		int random_Value[] = new int[3];
		for(int iCount = 0; iCount < random_Value.length; iCount++) {
			random_Value[iCount] = (int)(Math.random()*9);
			for(int jCount = 0; jCount < iCount; jCount++)
				if(random_Value[iCount] == random_Value[jCount])	iCount--;
		}

		int start_Count = 1;
		int out_Count	= 0;

		while(true) {
			int ball_Count	 = 0;
			int strike_Count = 0;

			System.out.println("�õ�Ƚ�� :" + start_Count);

			int input_Value[] = new int[3];
			System.out.println("���� 3���� �Է��ϼ���~~^^");
			for(int iCount = 0; iCount < input_Value.length; iCount++) {
				input_Value[iCount] = scan.nextInt();
			}

			// ��ũ����ũ or �� ī��Ʈ
			for(int iCount = 0; iCount < input_Value.length; iCount++) {
				for(int jCount = 0; jCount < input_Value.length; jCount++) {
					if(random_Value[iCount] == input_Value[iCount]) {
						strike_Count++;
					}else if(random_Value[iCount] == input_Value[jCount]) {
						ball_Count++;
					}
				}
			}

			if(9 > strike_Count && strike_Count > 0) {
				System.out.print("\n" + strike_Count / 3 + " Strike ");
				if(ball_Count == 0) System.out.println();
			}
			if(ball_Count > 0) {
				System.out.println(ball_Count + " ball");
			}
			if(strike_Count == 0 && ball_Count == 0) { 
				out_Count++;
				System.out.print("\n" + "out : �ƿ�" + out_Count + "��\n");
			}
			System.out.println();
			start_Count++;

			// �÷��̾� WIN
			if(strike_Count == 9) {
				System.out.println("�����մϴ�~~!! win~!");
				break;
			}
			
			// �÷��̾� LOSE
			if(start_Count >= 5 || out_Count == 2) {
				System.out.print("���� ȸ�� �ʰ�\n"
								+ "�Ʊ��~~ ���׿�..\n"
								+ "������ : ");
				for(int iCount = 0; iCount < 3; iCount++) {
					System.out.print(random_Value[iCount] + " ");
				}
				System.out.println("�Դϴ�.");
				break;
			}
		}
		scan.close();
	}
}
