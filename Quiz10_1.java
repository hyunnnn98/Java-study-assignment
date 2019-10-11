package school_Project;

import java.util.Scanner;

public class Quiz10_1 {
	public static void main(String[] args) {
		String inputValue	= null;
		char start_ALPHA	= 'A';

		Scanner scan = new Scanner(System.in);

		// 키보드로부터 문자열 입력
		System.out.print("문자열을 입력하세오 : ");
		inputValue = scan.nextLine();

		// 입력받은 문자열의 문자 길이
		int sizeOfString = inputValue.length();

		// 입력받은 문자열의 길이 만큼 char 형 배열 생성
		char charArray[] = new char[sizeOfString];

		// inputValue에 저장된 문자열을 charArray 배열에 복사 : String -> char로 문자열 복사
		inputValue.getChars(0, sizeOfString, charArray, 0);

		// charArray에 넣은 문자를 알파벳 별 개수 카운트
		int alpha_Count[] = new int[52];

		for(int jCount = 0; jCount < inputValue.length(); jCount++) {
			start_ALPHA = 'A';
			for(int iCount = 0; iCount < 52; iCount++) {
				if(charArray[jCount] == start_ALPHA) {
					alpha_Count[iCount]++;
					break;
				}
				start_ALPHA++;
				if(start_ALPHA == 'Z' + 1) start_ALPHA += 6;
			}
		}
		// 입력된 문자열 값 출력
		start_ALPHA		 = 'A';
		int output_Count = 0;
		for(int iCount = 0; iCount < 52; iCount++) {
			for(int i = 0; i < sizeOfString; i++) {
				if(alpha_Count[iCount] > 0) {
					if(!(output_Count == 0))	System.out.print(", ");
					System.out.print(start_ALPHA + " : " + alpha_Count[iCount]);
					output_Count++;
					break;
				}
			}
			start_ALPHA++;
			if(start_ALPHA == 'Z' + 1) start_ALPHA += 6;
		}
		scan.close();
	}
}
