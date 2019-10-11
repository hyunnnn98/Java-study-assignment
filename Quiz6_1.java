package school_Project;

import java.util.Scanner;

public class Quiz6_1 {
	public static void main(String[] args) {
		// 정수 저장 배열 생성 1~9사이의 수 10개 저장
		int[] array_Save = new int[10];
		char[][] histo_Array = 
			   //  0	1	 2	  3	   4    5    6    7    8    9    10   11
			  { { ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ' ,' ', ' ', ' ', ' '},  // 0
				{ ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ' ,' ', ' ', ' ', ' '},  // 1
				{ '8', '|', ' ', ' ', ' ', ' ', ' ', ' ' ,' ', ' ', ' ', ' '},  // 2
				{ ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ' ,' ', ' ', ' ', ' '},  // 3
				{ '6', '|', ' ', ' ', ' ', ' ', ' ', ' ' ,' ', ' ', ' ', ' '},  // 4
				{ ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ' ,' ', ' ', ' ', ' '},  // 5
				{ '4', '|', ' ', ' ', ' ', ' ', ' ', ' ' ,' ', ' ', ' ', ' '},  // 6
				{ ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ' ,' ', ' ', ' ', ' '},  // 7
				{ '2', '|', ' ', ' ', ' ', ' ', ' ', ' ' ,' ', ' ', ' ', ' '},  // 8
				{ ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ' ,' ', ' ', ' ', ' '},  // 9
				{ '-', '-', '-', '-', '-', '-', '-', '-' ,'-', '-', '-', '-'},  // 10
				{ ' ', '|', '1', '2', '3', '4', '5', '6' ,'7', '8', '9', ' '} };// 11
		
		Scanner scan = new Scanner(System.in);
		// 정수값 10개 입력받기
		System.out.println("정수 10개를 입력하시오.");
		for(int iCount = 0; iCount < 10; iCount++) {
			System.out.print(iCount+1 + "번쨰 숫자 : ");
			array_Save[iCount] = scan.nextInt();
			if(!(0 < array_Save[iCount] && array_Save[iCount] < 10)) {
				System.out.println("1~9사이의 정수를 입력하시오.");
				iCount--;
			}
		}

		// 저장받은 정수 값으로 입력빈도 산출
		// 0번이 숫자 1, 9번이 숫자 10
		int[] array_Count = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		// 숫자 1~9 
		for(int equals_Count = 0; equals_Count < 9; equals_Count++) {
			// 배열 length 0~9
			for(int jCount = 0; jCount < 10; jCount++) {
				if(equals_Count + 1 == array_Save[jCount]) {
					array_Count[equals_Count]++;
				}
			}
		}
		System.out.println();
		
		// 입력빈도 산출
		System.out.println("입력 빈도");
		for(int input_Count = 1, loop_Count = 1; input_Count < 10; input_Count++, loop_Count++) {
			if(array_Count[input_Count - 1] > 0) {
				System.out.printf("%d) %d : %d회\n", loop_Count, input_Count, array_Count[input_Count-1]);
			}else loop_Count--;
		}
		System.out.println();
		
		// 히스토그램 배열에 '$' 넣기
		for(int number_length = 2; number_length < 11; number_length++) {
			int count = 0;
			for(int iCount = 9; iCount >= 0; iCount--) {
				if(array_Count[number_length-2] > 0) {
					histo_Array[iCount][number_length] = '$';
					count++;
					if(count == array_Count[number_length-2]) {
						break;
					}
				}else {
					break;
				}
			}
		}
		
		System.out.println("히스토그램");
		for(int iCount = 0; iCount < 12; iCount++) {
			for(int jCount = 0; jCount < 12; jCount++) {
				System.out.print(histo_Array[iCount][jCount] + "  ");
			}
			System.out.println();
		}
		
		scan.close();
	}
}
