package school_Project;

import java.util.Scanner;

public class Quiz8_1 {
	public static void main(String[] args) {
		// 문자열 배열의 크기
		final int MAX_SIZE = 50;

		// int형 정수 50개 배열 선언
		int	randomValues[] = new int[MAX_SIZE];

		Scanner scn = new Scanner(System.in);
		// 1 ~ 200 사이의 정수형 난수를 발생하여 배열에 저장 : 50개
		// Math.random() 호출 시 0이상 1미만의 실수형 값 반환
		for(int iCount = 0; iCount < MAX_SIZE; iCount++) {
			randomValues[iCount] = (int)((Math.random() * 200 + 1));
			for(int jCount = 0; jCount < iCount; jCount++) {
				if(randomValues[iCount] == randomValues[jCount]) {
					iCount--;
					break;
				}
			}
		}

		// 발생된 난수 값 화면에 출력
		for(int jCount = 0; jCount < MAX_SIZE; jCount++) {
			System.out.print( "\t" + randomValues[jCount]);
			if((jCount + 1) % 7 == 0) System.out.println();
		}
		System.out.println();

		// 배수 값 검색 용 정수를 입력
		int search_Count = 0, search_Value = 0;

		do {
			System.out.print("\n배수 값 검색 용 정수를 입력하세요(1이상 정수): ");
			search_Value = scn.nextInt();
		}while(search_Value < 1);

		System.out.println("\n\n" + search_Value + "배수 값");
		for(int iCount = 0; iCount < MAX_SIZE; iCount++) {
			if(randomValues[iCount] % search_Value == 0) {
				System.out.print("\t" + randomValues[iCount]);
				search_Count++;
				if(search_Count % 5 == 0) System.out.println();
			}
		}
		System.out.println("\n\n" + search_Value + "배수 값 갯수 : " + search_Count);
		scn.close();
	}
}
