package school_Project;

import java.util.Scanner;

public class school_2_Example005 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean result_class = true;			// 받은 돈이 부족할때의 참 거짓 판별 boolean값

		System.out.print("상품 총액 :");
		int input_Product = scan.nextInt();

		while(result_class) {
			System.out.print("받은 돈:");
			int input_Money = scan.nextInt();
			double plus_Result = input_Product / 10.0;	
			//부가세 설정 10.0 이라는 값을 final float값으로 선언해서 더 깔끔하게 선언할 수 있다.
 
			if(input_Product + (int)(plus_Result) <= input_Money) {
				
				System.out.println("부가세:" + (int)(plus_Result));
				int result = input_Money - (input_Product + (int)(plus_Result));
				
				System.out.print("거스름돈 :" + result);
				result_class = false;
				
			}else {
				System.out.println("받은 돈이 부족합니다. 다시 입력하세요!!");
			}
		}
		scan.close();

	}
}
