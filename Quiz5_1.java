package school_Project;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz5_1 {
	public static void main(String[] args) {
		int[] save_Array = new int[5];
		boolean loop	 = true;
		
		Scanner scan = new Scanner(System.in);
		do {
			boolean value_test_pass = true;
			System.out.println("���� 5���� �Է��Ͻÿ�.");
			System.out.print("Inserted values:");
			try {
				for(int iCount = 0; iCount < 5; iCount++) {
					save_Array[iCount] = scan.nextInt();
						if(save_Array[iCount] < 1) {
							System.out.println("1�̻��� ������ �Է��Ͻÿ�.");
							value_test_pass = false;
							break;
						}
				}
			}catch (Exception e) {
				System.out.println("������ �Է°����մϴ�.");
				continue;
			}
			if(value_test_pass) {
				//������������ ����
				Arrays.sort(save_Array);
				System.out.println();
				System.out.println("Maximum Values : " + save_Array[save_Array.length-1]);
				System.out.println("Minimum Values : " + save_Array[0]);
				System.out.println("Median value : "   + save_Array[save_Array.length/2]);
				loop = false;
			}
		}while(loop);
		scan.close();
	}
}
