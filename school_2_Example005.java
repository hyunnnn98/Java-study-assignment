package school_Project;

import java.util.Scanner;

public class school_2_Example005 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean result_class = true;			// ���� ���� �����Ҷ��� �� ���� �Ǻ� boolean��

		System.out.print("��ǰ �Ѿ� :");
		int input_Product = scan.nextInt();

		while(result_class) {
			System.out.print("���� ��:");
			int input_Money = scan.nextInt();
			double plus_Result = input_Product / 10.0;	
			//�ΰ��� ���� 10.0 �̶�� ���� final float������ �����ؼ� �� ����ϰ� ������ �� �ִ�.
 
			if(input_Product + (int)(plus_Result) <= input_Money) {
				
				System.out.println("�ΰ���:" + (int)(plus_Result));
				int result = input_Money - (input_Product + (int)(plus_Result));
				
				System.out.print("�Ž����� :" + result);
				result_class = false;
				
			}else {
				System.out.println("���� ���� �����մϴ�. �ٽ� �Է��ϼ���!!");
			}
		}
		scan.close();

	}
}
