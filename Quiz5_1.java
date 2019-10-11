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
			System.out.println("정수 5개를 입력하시오.");
			System.out.print("Inserted values:");
			try {
				for(int iCount = 0; iCount < 5; iCount++) {
					save_Array[iCount] = scan.nextInt();
						if(save_Array[iCount] < 1) {
							System.out.println("1이상의 정수를 입력하시오.");
							value_test_pass = false;
							break;
						}
				}
			}catch (Exception e) {
				System.out.println("정수만 입력가능합니다.");
				continue;
			}
			if(value_test_pass) {
				//오름차순으로 정렬
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
