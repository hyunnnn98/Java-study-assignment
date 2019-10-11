package school_Project;

import java.util.Scanner;

public class Quiz3_2 {
	public static void main(String[] args) {
		int Gender = 0;
		int Weight = 0;

		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("성별을 입력하세요: <남성 1, 여성2>:");
			Gender = scan.nextInt();

			switch(Gender) {
			case 1:
				System.out.print("체중을 입력하세요: ");
				Weight = scan.nextInt();
				if(Weight >= 85) {
					System.out.println("과체중입니다 운동하세요.");
				}else if(50 <= Weight && Weight < 85) {
					System.out.println("표준체중 입니다 현 페이스를 유지하세요.");
				}else if(0 < Weight && Weight < 50) {
					System.out.println("표준체중 이하입니다 고기드세요.");
				}else {
					System.out.println("잘못된 입력입니다.");
				}
				break;
			case 2:
				System.out.print("체중을 입력하세요: ");
				Weight = scan.nextInt();
				if(Weight >= 68) {
					System.out.println("과체중입니다 운동하세요.");
				}else if(40 <= Weight && Weight < 68) {
					System.out.println("표준체중 입니다 현 페이스를 유지하세요.");
				}else if(0 < Weight && Weight < 40) {
					System.out.println("표준체중 이하입니다 고기드세요.");
				}else {
					System.out.println("잘못된 입력입니다.");
				}
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				continue;
			}
		}while(Weight < 1);
		
		scan.close();
	}
}
