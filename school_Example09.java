package school_Project;

import java.util.Scanner;

public class school_Example09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] personal_Address  = new int[13];		// �ֹι�ȣ ���� �迭
		int[] check_Adderss		= { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int result = 0;
		boolean check = true;

		do {
			System.out.println("�ֹι�ȣ�� �Է��Ͻÿ�. �Է½� \"-\"�� ����");
			System.out.print(">>");

			//�迭�� �ֹι�ȣ String�� �ֱ�			
			String Address = scan.next();
			
			//�Է��� ���� 13�ڸ��� �ƴ� ��� return.
			if(Address.length() != 13) 	continue;
				
			//personal_Address[]�� �� ���ڰ� �ֱ�
			for(int iCount=0; iCount<13; iCount++) {
				personal_Address[iCount] = Address.charAt(iCount) - '0';
			}

			//number result
			for(int result_Count=0; result_Count<12; result_Count++) {
				result += personal_Address[result_Count] * check_Adderss[result_Count];
			}

			//check
			if(11-(result%11) == personal_Address[12]) {
				System.out.println("�ùٸ� �ֹι�ȣ�Դϴ�.");
				check = false;
			}else	System.out.println("�߸��� �ֹι�ȣ�Դϴ�!!\n");
			
		}while(check);

		scan.close();
	}
}
