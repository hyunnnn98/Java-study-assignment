package school_Project;

import java.util.Scanner;

public class school_2_Example001 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int sum	= 0;
		int saveNumber = 0;			// sum이 100을 넘기는 배수를 저장하기 위한 변수.
		boolean All_result = true;

		System.out.println("1~N까지 7의 배수합 구하기");
		do {
			System.out.print("양수 N 값을 입력하시오:");
			int inputNumber = scan.nextInt();		// N 값 입력
			// inputNumber값이 1 이상일 경우 if문 실행
			if(inputNumber >= 1) {
				for(int start = 0; start < inputNumber / 7 + 1; start++) {
					sum += start * 7;					// 7의 배수만큼 더하기
					if(sum >= 100 && saveNumber == 0) {
						saveNumber = start * 7;			// 100을 넘겼을 때 값 저장
					}
					All_result = false;
				}
				if(inputNumber < 7) 	sum = 0;		// inputNumber값이 7 미만일 경우 결과 값 0으로 출력

				System.out.printf("0~%d까지의 7의 배수 합은 : %d %n", inputNumber, sum);
				
				// sum이 100 이상일 경우 
				if (sum > 100) {
					System.out.printf("누적된 합의 값이 첨으로 100을 넘기는 7의 배수는 %d %n", saveNumber);
				}
			}
		}while(All_result);
		scan.close();
	}
}
