package school_Project;

import java.util.Scanner;

public class school_Gugudan {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("컬럼의 갯수를 입력하시오.");
		int calumm   = scan.nextInt();

		int dan      = 0;		//단을 나타내기 위한 변수
		int count    = 0;		//컬럼을 전부 출력 후 줄 바뀜후의 단을 나타내기 위한 변수 

		//2~9단출력
		while (true) {
			//구구단에서 단에 곱하는 수를 출력
			for (int i = 0; i < 9; i++) {
				//컬럼 전부 출력했는지 안했는지 구분하고 단을 나타내는 조건
				if (count == 0)	 dan = 2;
				else        	 dan = (calumm * count) + 2;
				//구구단을 컬럼대로 출력
				for (int j = 0; j < calumm; j++) {
					System.out.printf("%d * %d = %d \t", dan, i+1, dan*(i+1));
					dan++;
					//단이 10이 되면 for문 탈출(결국 9까지만 출력)
					if (dan == 10) break; 
				}
				System.out.println();
			}

			//단이 10이 되면 while문 탈출(결국 단은 9까지 출력)
			if (dan == 10) break;

			System.out.print("=====================================");
			System.out.println();

			count++;
		}
		scan.close();
	}
}

