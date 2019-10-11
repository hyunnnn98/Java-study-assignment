package school_Project;

import java.util.Scanner;

public class Quiz9_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			char start_ALPHA = 'A';

			System.out.print("시작 값을 입력하세요 : ");
			int input_Start_Value	= scan.nextInt();
			if(!(0 < input_Start_Value && input_Start_Value < 53)) {
				System.out.println("잘못 입력 하셨습니다. 다시 입력하세요!");
				continue;
			}
			if(input_Start_Value > 26) start_ALPHA += 6;

			System.out.print("끝 값을 입력하세요 : ");
			int input_Last_Value	= scan.nextInt();
			
			if(input_Start_Value + input_Last_Value < 54) {
				start_ALPHA += input_Start_Value - 1;
				System.out.print("결과 값 : ");
				for(int iCount = 0; iCount < input_Last_Value; iCount++) {
					System.out.print(start_ALPHA);
					if(iCount < input_Last_Value - 1)	System.out.print(",");
					start_ALPHA ++;
					if(start_ALPHA == 'Z' + 1) start_ALPHA += 6;
				}
				break;
			}else	System.out.println("출력 값 범위를 초과하였습니다. 다시 입력하세요.");
		}
		scan.close();
	}
}
