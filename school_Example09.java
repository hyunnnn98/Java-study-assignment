package school_Project;

import java.util.Scanner;

public class school_Example09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] personal_Address  = new int[13];		// 주민번호 저장 배열
		int[] check_Adderss		= { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int result = 0;
		boolean check = true;

		do {
			System.out.println("주민번호를 입력하시오. 입력시 \"-\"는 생략");
			System.out.print(">>");

			//배열에 주민번호 String값 넣기			
			String Address = scan.next();
			
			//입력한 수가 13자리가 아닌 경우 return.
			if(Address.length() != 13) 	continue;
				
			//personal_Address[]에 각 숫자값 넣기
			for(int iCount=0; iCount<13; iCount++) {
				personal_Address[iCount] = Address.charAt(iCount) - '0';
			}

			//number result
			for(int result_Count=0; result_Count<12; result_Count++) {
				result += personal_Address[result_Count] * check_Adderss[result_Count];
			}

			//check
			if(11-(result%11) == personal_Address[12]) {
				System.out.println("올바른 주민번호입니다.");
				check = false;
			}else	System.out.println("잘못된 주민번호입니다!!\n");
			
		}while(check);

		scan.close();
	}
}
