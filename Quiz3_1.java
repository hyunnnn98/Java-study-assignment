package school_Project;

import java.util.Scanner;

public class Quiz3_1 {
	public static void main(String[] args) {
		int input_Number	= 0;
		int hap		 		= 0;
		int changed_Num		= 0;

		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("다섯자리 정수를 입력하시오!!");
			input_Number = scan.nextInt();
			// 다섯자리 정수 유효성 검사
			if(10000 <= input_Number && input_Number < 100000) {
				for(int i = 10000; i >= 1; i/=10) {
					// 각 자리 수 계산
					changed_Num = input_Number / i;
					hap += changed_Num;
					System.out.print(changed_Num);

					// 다음자리 수로 넘어갈 때 최고 높은 수 빼기
					input_Number -= (changed_Num*i);

					// + 기호 - 기호 출력
					if(i>1) System.out.print(" + ");
					else 	System.out.print(" = " + hap);
				}
			}else	System.out.println("다섯자리 수가 아닙니다.");
		}while(hap < 1);
		scan.close();
	}
}

