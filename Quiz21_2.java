package testPkg;

import java.util.Scanner;

public class Quiz21_2 {
	public static void main(String[] args) {
		int number_Count = 0;
		int input_Select = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("입력할 문자열의 개수?");
		number_Count = scan.nextInt();

		System.out.println("정렬 방식 선택? (1)오름, (2)내림");
		input_Select= scan.nextInt();

		String[] user_Input	 = new String[number_Count];
		int[] stringtoNumber = new int[number_Count];
		System.out.println("문자열 입력");
		for(int i = 0; i < number_Count; i++) {
			user_Input[i] = scan.next();
		}
		// 제일 큰 length찾기
		int max_Length	= 0;
		int max_Value	= 0;
		for(int i = 1; i < number_Count; i++) {
			if(user_Input[max_Length].length() < user_Input[i].length()) {
				max_Length	= i;
				max_Value	= user_Input[i].length();
			}
		}

//		System.out.println("문자열 입력");
		for(int iCount = 0; iCount < number_Count; iCount++) {
//			user_Input[iCount] = scan.next();
			int sum = 0, multiple_Count = max_Value;
			for(int jCount = 0; jCount < user_Input[iCount].length(); jCount++, multiple_Count--) {
				sum += user_Input[iCount].charAt(jCount) * Math.pow(2, multiple_Count);
				if(jCount == 0) multiple_Count--;
				if(jCount == user_Input[iCount].length() - 1)
					stringtoNumber[iCount] = sum;
			}
		}
//		System.out.println("문자열 입력");
//		for(int iCount = 0; iCount < number_Count; iCount++) {
//			user_Input[iCount] = scan.next();
//			int sum = 0, multiple_Count = 0;
//			for(int jCount = user_Input[iCount].length() - 1; jCount >= 0; jCount--, multiple_Count++) {
//				sum += (user_Input[iCount].charAt(multiple_Count) - 0) * Math.pow(10, multiple_Count);
//				if(jCount == 0) stringtoNumber[iCount] = sum;
//			}
//		}

		//오름차순 정렬
		for(int iCount = 0; iCount < number_Count - 1; iCount++) {
			int min_Index = iCount;
			for(int jCount = iCount + 1; jCount < number_Count; jCount++) {
				// 오름차순
				if(input_Select == 1 && stringtoNumber[jCount] < stringtoNumber[min_Index]) {
					min_Index = jCount;
				}
				// 내림차순
				if(input_Select == 2 && stringtoNumber[jCount] > stringtoNumber[min_Index]) {
					min_Index = jCount;
				}
			}
			// 문자열 배열 오름차순
			String temp = user_Input[iCount];
			user_Input[iCount] = user_Input[min_Index];
			user_Input[min_Index] = temp;
			// 숫자 배열 오름차순
			int temp_1 = stringtoNumber[iCount];
			stringtoNumber[iCount] = stringtoNumber[min_Index];
			stringtoNumber[min_Index] = temp_1;
		}

		System.out.println("오름차순으로 정렬한 결과는?");
		for(int iCount = 0; iCount < number_Count; iCount++) {
			System.out.println(user_Input[iCount]);
		}
	}
}
