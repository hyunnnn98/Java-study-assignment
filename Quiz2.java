package school_Project;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		boolean loop 	= true;			// do - while 반복문 루프 조건 값
		boolean access  = false;		// 입력한 String값 유효성 검사 값
		int NumberCount = 0;			// 유효성 검사 통과 시 숫자 카운트
		
		// 키보드로부터 정수 값 입력
		Scanner scan = new Scanner(System.in);
		
		// *상급자용* 스트링으로 받아서 정수로 변환한 후 'q'입력 시 종료로 작성
		do {
			System.out.println("입력해라");
			String input_String_Number = scan.nextLine();
			// "q" or "20000" 입력 시 종료
			if(input_String_Number.equals("q") || input_String_Number.equals("20000")) {
				System.out.println("이용해주셔서 감사합니다");	
				break;
			}

			// 스트링값 분해해서 아스키코드로 유효성 검사
			for(int i = 0; i < input_String_Number.length(); i++) {
				char k = input_String_Number.charAt(i);
				if(!(0 <= k - '0' && k - '0' <= 9)) {
						System.out.println("1이상의 양수를 입력해주세요");
						access = false; // 유효성 검사 실패 case
						break;
				}else   access = true; 	// 유효성 검사 통과 case
			}

			// 유효성 검사 통과시 진입
			if(access) {
				int input_Number = Integer.parseInt(input_String_Number);
				NumberCount++;
				System.out.println(NumberCount + "번째 입력 값은 = " + input_Number);
				// 홀 짝 골라내기
				if(input_Number % 2 == 0)	System.out.println("\t짝수입니다.");
				else						System.out.println("\t홀수입니다.");
				// 3 7 배수 골라내기
				if(input_Number % 3 == 0)	System.out.println("\t3의 배수입니다.");
				if(input_Number % 7 == 0)	System.out.println("\t7의 배수입니다.");
			}
			// 유효성 검사 초기화.
			access = false;
		} while(loop);
		
		scan.close();
	}
}
