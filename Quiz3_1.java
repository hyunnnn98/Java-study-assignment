package school_Project;

import java.util.Scanner;

public class Quiz3_1 {
	public static void main(String[] args) {
		int input_Number	= 0;
		int hap		 		= 0;
		int changed_Num		= 0;

		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("�ټ��ڸ� ������ �Է��Ͻÿ�!!");
			input_Number = scan.nextInt();
			// �ټ��ڸ� ���� ��ȿ�� �˻�
			if(10000 <= input_Number && input_Number < 100000) {
				for(int i = 10000; i >= 1; i/=10) {
					// �� �ڸ� �� ���
					changed_Num = input_Number / i;
					hap += changed_Num;
					System.out.print(changed_Num);

					// �����ڸ� ���� �Ѿ �� �ְ� ���� �� ����
					input_Number -= (changed_Num*i);

					// + ��ȣ - ��ȣ ���
					if(i>1) System.out.print(" + ");
					else 	System.out.print(" = " + hap);
				}
			}else	System.out.println("�ټ��ڸ� ���� �ƴմϴ�.");
		}while(hap < 1);
		scan.close();
	}
}

