package school_Project;

import java.util.Scanner;

public class Quiz11_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 컴퓨터로부터 0 ~ 9 사이 값 입력받음(중복값 없이) 
		int random_Value[] = new int[3];
		for(int iCount = 0; iCount < random_Value.length; iCount++) {
			random_Value[iCount] = (int)(Math.random()*9);
			for(int jCount = 0; jCount < iCount; jCount++)
				if(random_Value[iCount] == random_Value[jCount])	iCount--;
		}

		int start_Count = 1;
		int out_Count	= 0;

		while(true) {
			int ball_Count	 = 0;
			int strike_Count = 0;

			System.out.println("시도횟수 :" + start_Count);

			int input_Value[] = new int[3];
			System.out.println("정수 3개를 입력하세용~~^^");
			for(int iCount = 0; iCount < input_Value.length; iCount++) {
				input_Value[iCount] = scan.nextInt();
			}

			// 스크라이크 or 볼 카운트
			for(int iCount = 0; iCount < input_Value.length; iCount++) {
				for(int jCount = 0; jCount < input_Value.length; jCount++) {
					if(random_Value[iCount] == input_Value[iCount]) {
						strike_Count++;
					}else if(random_Value[iCount] == input_Value[jCount]) {
						ball_Count++;
					}
				}
			}

			if(9 > strike_Count && strike_Count > 0) {
				System.out.print("\n" + strike_Count / 3 + " Strike ");
				if(ball_Count == 0) System.out.println();
			}
			if(ball_Count > 0) {
				System.out.println(ball_Count + " ball");
			}
			if(strike_Count == 0 && ball_Count == 0) { 
				out_Count++;
				System.out.print("\n" + "out : 아웃" + out_Count + "번\n");
			}
			System.out.println();
			start_Count++;

			// 플레이어 WIN
			if(strike_Count == 9) {
				System.out.println("축하합니당~~!! win~!");
				break;
			}
			
			// 플레이어 LOSE
			if(start_Count >= 5 || out_Count == 2) {
				System.out.print("게임 회수 초과\n"
								+ "아까비~~ 졌네용..\n"
								+ "정답은 : ");
				for(int iCount = 0; iCount < 3; iCount++) {
					System.out.print(random_Value[iCount] + " ");
				}
				System.out.println("입니다.");
				break;
			}
		}
		scan.close();
	}
}
