package school_Project;

import java.util.Scanner;

public class school_2_Example002 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int six_Count	  = 0;		// 6이 나온 횟수 저장
		int result_Count  = 0;		// 시도한 카운트 값 저장
		double percentage = 0.0;	// 확률 값
		boolean result    = true;	// 6이 나오지 않았을 때 반복하기 위한 boolean값
		
		System.out.println("N번 -100 ~ 100 사이의 난수 발생. 이때 6이 나올 확률 구하기 ");
		int inputNumber  = scan.nextInt();
		
		do {
			for(int i = 0; i < inputNumber; i++) {
				result_Count++;										// n번 시도하는 카운트
				int random = (int)(Math.random()*201)-100;			// -100 ~ 100 사이의 랜덤값 출력
				if(random == 6) six_Count++;						// random값이 6일 경우 six_Count값 증가
				// six_Count가 나왔을 경우
				if(six_Count > 0) {
					percentage = (1.0 / result_Count) * six_Count;
					System.out.println(result_Count + "번 시도, 6이 나온 횟수 :" + six_Count);
					System.out.printf("확률은%.4f %n",percentage);	// 소수점 4째자리까지 출력
					result = false;									// do-while문 종료
					break;											// for문 종료
				}// if문 종료
			}// for문 종료
		}while(result);
		
		scan.close();
	}
}
