package school_Project;

import java.util.Scanner;

public class Quiz7_1 {
	public static void main(String[] args) {
		// 문자열 배열의 크기
		final int MAX_SIZE = 30;

		// 키보드로부터 입력 받은 문자열 저장
		String inputValues = null;

		// 키보드로 입력 받은 문자열을 Char형 배열로 저장
		// 찾아/바꾸기 기능 구현시 사용
		char charArray[] = new char[MAX_SIZE];

		// 키보드로부터 문자열을 입력받아 String형 저장
		Scanner scn = new Scanner(System.in);
		System.out.print("입력:");
		inputValues = scn.nextLine();

		// 저장된 문자열을 Char형 array 변수 charArray에 복사
		inputValues.getChars(0, inputValues.length(), charArray, 0);

		// 복사된 문자값 출력
		System.out.print("입력 문장:");
		for (int i = 0; i < inputValues.length(); i++) {
			System.out.print(charArray[i]);
		}

		boolean find_Excess = false;
		// 찾을 문장 입력 받은 후 - > char 배열에 저장
		System.out.println();
		System.out.print("찾을 문자열:");
		String findValues	= scn.nextLine();
		char findArray[]	= new char[findValues.length()];
		findValues.getChars(0, findValues.length(), findArray, 0);

		// save 배열안에 몇번째부터 찾을 int값 넣기
		int[] save = new int[MAX_SIZE];
		// char요소 카운트값
		int char_Count = 0;
		// 같은 문자열이 몇번 있는지?
		int save_Count = 0;
		for (int iCount = 0; iCount < charArray.length; iCount++) {
			char_Count = 0;
			for (int jCount = 0; jCount < findArray.length; jCount++) {
				if (charArray[iCount + jCount] == findArray[jCount]) {
					char_Count++;
					// 입력 문장의 개수가 일치할 경우
					if (char_Count == findArray.length) {
						find_Excess = true;
						save[save_Count] = iCount;
						save_Count++;
					}
					// 첫번째 char값과 같지 않으면 jCount 탈출
				} else break;
			}
		}

		// 찾은 문자열이 있을 때
		String changeValues = null;
		int last_Count = 0;
		if (find_Excess) {
			System.out.print("바꿀 문자열:");
			changeValues = scn.nextLine();
			// 출력
			System.out.print("결과:");
			for (int iCount = 0; iCount < charArray.length; iCount++) {
				if (iCount == save[last_Count]) {
					System.out.print(changeValues);
					iCount += findValues.length() - 1;
					last_Count++;
				} else {
					System.out.print(charArray[iCount]);
				}
			}
		} else {
			System.out.print("해당 문자열이 존재하지 않습니다.");
		}
		
		System.out.println("\n프로그램을 종료합니다.");
		scn.close();
	}
}

